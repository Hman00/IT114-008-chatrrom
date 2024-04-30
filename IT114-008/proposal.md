IT 114 Project Proposal

Your Name: Henry Nyame
Project Name: Chatroom
Project Summary: Project will be a global chatroom where anyone who joins can communicate in the chat. New joiners will not see the previous chat history. Users can break out into separate rooms.
Github link to project folder in repo: 

Requirements:
A server that can handle multiple simultaneous clients
Handle sending data back and forth more so than just a simple string
Gracefully handle disconnects and server shutdowns
Provide the ability for the users to do something
Milestone 1: https://github.com/Hman00/IT114-008/blob/main/Project/milestone1.md
Server can be started via IDE or command line and listen for connections
Client can be started via IDE or command line and connect to the running server
Client can send messages to the server
Server can broadcast messages to all connected clients of a particular Room
Server will implement the concept of “Rooms”
Clients will have some sort of identifier to show who sent each message
Clients can disconnect and reconnect without crashing the server
The Server terminating should not terminate the clients as well
Clients should receive a disconnected message
Milestone 2: https://github.com/Hman00/IT114-008/blob/main/Project/milestone2.md
Server will have the functionality to switch users between “Rooms”
(i.e., all start in “Lobby”, but can then create or join existing rooms to be with a particular group)
Rooms will not have cross communication
Following the payload concept begin implementing some of the core functionality
Chat system - Wrap messages in payload so extra data can be sent/received
I.e., Payload { message: “text”, sender: “username”} 
Create a server-side function the processes message commands (i.e., /roll, /flip) and broadcasts the result to all clients
/roll will handle two different formats
Format 1: /roll 0 - X or 1 - X
Example: /roll 100
let me know which value you choose to start at
Format 2: /roll #d#
Example: /roll 2d6
/flip will return heads or tails (like a coin toss)
Create a server-side function that processes messages to change text display that’s broadcasted to all clients (for this milestone just show the altered text symbols, we won’t be able to see the effects until Milestone 3)
Bold
Italics
Color (at least Red, Green, Blue options or code to support color hex codes)
Underline
Note: Having the user type out html tags is not valid for this feature, instead treat it like WhatsApp, Discord, Markdown, etc
Note: Each text trigger must wrap the text that you want to affect
Milestone 3: https://github.com/Hman00/IT114-008/blob/Milestone3/milestone3.md
Create a UI Page/Panel for connecting to the server
Username (don’t allow spaces)
Host
Port
Create a UI Page for the chatroom
List of users in the room
Text area for the chat history
Input field for typing messages
Button for sending messages
Pressing enter should also submit the button if the input field isn’t empty
Results from /flip and /roll appear in a different format than regular chat text
Custom text display functions appear correctly in the chat area (i.e., last feature of Milestone 2)
Messages that precede with @username will send the message privately to the user denoted by the username
The writer and the receiver are the only two that will receive the message from the server
It’s not valid to just hide it on the client-side (i.e., data must not be sent from the server)
The following commands will be implemented server-side
mute username
Prevents the user from receiving messages from the target user
unmute username
Allows the user to receive messages from the target user (if they were previously muted)
Milestone 4: 
Client can export the chat history of  their current session (client-side)
Client’s mute list will persist across sessions (server-side)
Based on username match
Clients will receive a message when they get muted/unmuted by another user
(i.e., Bob muted you)
This message should only be sent if muted becomes unmuted or unmuted becomes mute, it’s not an opportunity to create a spam mechanism
The user list should update per the status of each user
Muted users appear grayed out
Last person to send a message gets highlighted


Extra Credit/Honors Students
If doing this for extra credit, this will only be considered if all required features have been attempted, these are not replacement items for required features
Server will be able to run with a UI
UI should show connected clients
UI should let the server disconnect certain clients
UI should show some server related stats
Uptime
Memory usage (estimated)
(TBD)
UI can be used to stop the server
Server will be able to run headless (can be run via the command line without the UI being invoked)
