package Project2.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Project2.common.Constants;

public class Room implements AutoCloseable {
	private String name;
	private List<ServerThread> clients = Collections.synchronizedList(new ArrayList<ServerThread>());
	private boolean isRunning = false;
	// Commands
	private final static String COMMAND_TRIGGER = "/";
	private final static String CREATE_ROOM = "createroom";
	private final static String JOIN_ROOM = "joinroom";
	private final static String DISCONNECT = "disconnect";
	private final static String LOGOUT = "logout";
	private final static String LOGOFF = "logoff";
	private static Logger logger = Logger.getLogger(Room.class.getName());

	public Room(String name) {
		this.name = name;
		isRunning = true;
	}

	private void info(String message) {
		logger.log(Level.INFO, String.format("Room[%s]: %s", name, message));
	}

	public String getName() {
		return name;
	}

	public boolean isRunning() {
		return isRunning;
	}

	protected synchronized void addClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		client.setCurrentRoom(this);
		if (clients.indexOf(client) > -1) {
			info("Attempting to add a client that already exists");
		} else {
			clients.add(client);
			sendConnectionStatus(client, true);
			sendRoomJoined(client);
			sendUserListToClient(client);
		}
	}

	protected synchronized void removeClient(ServerThread client) {
		if (!isRunning) {
			return;
		}
		clients.remove(client);
		// we don't need to broadcast it to the server
		// only to our own Room
		if (clients.size() > 0) {
			// sendMessage(client, "left the room");
			sendConnectionStatus(client, false);
		}
		checkClients();
	}

	/***
	 * Checks the number of clients.
	 * If zero, begins the cleanup process to dispose of the room
	 */
	private void checkClients() {
		// Cleanup if room is empty and not lobby
		if (!name.equalsIgnoreCase("lobby") && clients.size() == 0) {
			close();
		}
	}

	/***
	 * Helper function to process messages to trigger different functionality.
	 * 
	 * @param message The original message being sent
	 * @param client  The sender of the message (since they'll be the ones
	 *                triggering the actions)
	 */
	private boolean processCommands(String message, ServerThread client, String sender) {
		boolean wasCommand = false;
		try {
			if (message.startsWith(COMMAND_TRIGGER)) {
				String[] comm = message.split(COMMAND_TRIGGER);
				String part1 = comm[1];
				String[] comm2 = part1.split(" ");
				String command = comm2[0];
				String roomName;
				wasCommand = true;
				switch (command) {
					case CREATE_ROOM:
						roomName = comm2[1];
						Room.createRoom(roomName, client);
						break;
					case JOIN_ROOM:
						roomName = comm2[1];
						Room.joinRoom(roomName, client);
						break;
					case DISCONNECT:
					case LOGOUT:
					case LOGOFF:
						Room.disconnectClient(client, this);
						break;
					case "roll":
						if (comm2.length > 1) {
							String[] rollArgs = comm2[1].split(" ");
							if (rollArgs.length == 1 && rollArgs[0].matches("\\d+")) {
								int maxValue = Integer.parseInt(rollArgs[0]);
								if (maxValue <= 1) {
									sendMessage(client,
											"Invalid roll command format: max value should be greater than 1");
								} else {
									int roll = (int) (Math.random() * maxValue + 1);
									// Hn224 adding html tags
									sendMessage(client, "<b>rolled a " + roll + "</b>");
								}
							} else if (rollArgs.length == 1 && rollArgs[0].matches("\\d+d\\d+")) {
								String[] diceArgs = rollArgs[0].split("d");
								int numDice = Integer.parseInt(diceArgs[0]);
								int dieValue = Integer.parseInt(diceArgs[1]);
								if (numDice <= 0 || dieValue <= 0) {
									sendMessage(client,
											"Invalid roll command format: num dice and die value should be positive integers");
								} else {
									int total = 0;
									for (int i = 0; i < numDice; i++) {
										total += (int) (Math.random() * dieValue + 1);
									}
									// Hn224 adding html tags
									sendMessage(client,
											"<b>rolled a " + total + " on " + numDice + "d" + dieValue + "</b>");
								}
							} else {
								sendMessage(client,
										"Invalid roll command format: expected '<max value>' or '<num dice>d<die value>'");
							}
						} else {
							sendMessage(client,
									"Invalid roll command format: expected '<max value>' or '<num dice>d<die value>'");
						}
						break;

					case "flip":
						// /flip
						String flipResult = (Math.random() < 0.5) ? "heads" : "tails";
						// hn224  5/7/2023 adding html output tags
						sendMessage(client, "<i>flipped a coin and got " + flipResult + "</i>");
						break;
					default:
						wasCommand = false;
						break;
					// hn224 5/7/2023 block function
					case "block":
						String mutee = comm2[1];
						if (client.block(mutee)) {
							sendMessage(null, sender + " blocked " + mutee);
						} else {
							sendMessage(client, mutee + " has already been blocked by " + sender);
						}
						break;
					case "unblock":
						mutee = comm2[1];
						if (client.unblock(mutee)) {
							sendMessage(client, sender + " unblocked " + mutee);
						} else {
							sendMessage(client, mutee + " is already unblocked by " + sender);
						}
						break;
					case "isblocked":
						mutee = comm2[1];
						if (client.isBlocked(mutee)) {
							sendMessage(client, mutee + " is currently blocked by " + sender);
						} else {
							sendMessage(client, mutee + " is not currently blocked by " + sender);
						}
						break;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasCommand;
	}

	// Command helper methods

	protected static void getRooms(String query, ServerThread client) {
		String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
		client.sendRoomsList(rooms,
				(rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
	}

	protected static void createRoom(String roomName, ServerThread client) {
		if (Server.INSTANCE.createNewRoom(roomName)) {
			Room.joinRoom(roomName, client);
		} else {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
			client.sendRoomsList(null, String.format("Room %s already exists", roomName));
		}
	}

	protected static void joinRoom(String roomName, ServerThread client) {
		if (!Server.INSTANCE.joinRoom(roomName, client)) {
			client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
			client.sendRoomsList(null, String.format("Room %s doesn't exist", roomName));
		}
	}

	protected static void disconnectClient(ServerThread client, Room room) {
		client.setCurrentRoom(null);
		client.disconnect();
		room.removeClient(client);
	}
	// end command helper methods

	/***
	 * Takes a sender and a message and broadcasts the message to all clients in
	 * this room. Client is mostly passed for command purposes but we can also use
	 * it to extract other client info.
	 * 
	 * @param sender  The client sending the message
	 * @param message The message to broadcast inside the room
	 */
	protected synchronized void sendMessage(ServerThread sender, String message) {
		if (!isRunning) {
			return;
		}
		info("Sending message to " + clients.size() + " clients");

		// it was a command, don't
		// Hn224 New code here its private message
		if (message.startsWith("@")) {
			int index = message.indexOf(" ");
			if (index > 0) {
				String reciever = message.substring(1, index);
				String privateMessage = message.substring(index + 1);
				privateMessage(sender, reciever, privateMessage);
				return;
			}
		}
		if (sender != null && processCommands(message, sender, sender.getClientName())) {
			return;
		}
		long from = (sender == null) ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				// Hn224 skip sending if they are muted
				if (sender != null && sender.isBlocked(client.getClientName())) {
					continue;
				}
				if (sender != null && client.isBlocked(sender.getClientName())) {
					continue;
				}
				boolean messageSent = client.sendMessage(from, message);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
		}
	}

	protected synchronized void sendUserListToClient(ServerThread receiver) {
		logger.log(Level.INFO, String.format("Room[%s] Syncing client list of %s to %s", getName(), clients.size(),
				receiver.getClientName()));
		synchronized (clients) {
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread clientInRoom = iter.next();
				if (clientInRoom.getClientId() != receiver.getClientId()) {
					boolean messageSent = receiver.sendExistingClient(clientInRoom.getClientId(),
							clientInRoom.getClientName());
					// receiver somehow disconnected mid iteration
					if (!messageSent) {
						handleDisconnect(null, receiver);
						break;
					}
				}
			}
		}
	}

	protected synchronized void sendRoomJoined(ServerThread receiver) {
		boolean messageSent = receiver.sendRoomName(getName());
		if (!messageSent) {
			handleDisconnect(null, receiver);
		}
	}

	protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
		// converted to a backwards loop to help avoid concurrent list modification
		// due to the recursive sendConnectionStatus()
		// this should only be needed in this particular method due to the recusion
		if (clients == null) {
			return;
		}
		synchronized (clients) {
			for (int i = clients.size() - 1; i >= 0; i--) {
				ServerThread client = clients.get(i);
				boolean messageSent = client.sendConnectionStatus(sender.getClientId(), sender.getClientName(),
						isConnected);
				if (!messageSent) {
					clients.remove(i);
					info("Removed client " + client.getClientName());
					checkClients();
					sendConnectionStatus(client, false);
				}
			}
		}
	}

	// Hn224 new code here private message method
	private void privateMessage(ServerThread sender, String reciever, String message) {
		for (ServerThread client : clients) {
			if (client.getClientName().equals(reciever)) {
				client.sendMessage(sender.getClientId(), message);
				sender.sendMessage(sender.getClientId(), message);

				break;
			}
		}
	}

	private synchronized void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
		if (iter != null) {
			iter.remove();
		}
		info("Removed client " + client.getClientName());
		checkClients();
		sendConnectionStatus(client, false);
		// sendMessage(null, client.getClientName() + " disconnected");
	}

	public void close() {
		Server.INSTANCE.removeRoom(this);
		isRunning = false;
		clients = null;
	}
}