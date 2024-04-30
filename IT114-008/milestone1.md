<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Henry Nyame (hn224)</td></tr>
<tr><td> <em>Generated: </em> 4/24/2023 3:43:20 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/hn224" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/234090141-df73888d-b0b8-49a8-851c-56886d920876.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>The server follows the command and then it starts up the client on<br>VS Code<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/234090638-d22a2d3d-ff3e-474f-9c76-4fc40beba62a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Displaying the startup and then the  client comments  between different users<br>and showing what happens<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>#1 How the server side connection works is that it sends packets from<br>a client to a server called SYN packets and it sends and receives<br>information back and fourth.&nbsp;<div>#2 On the server it makes a socket and then<br>the client makes a connection and the port number.</div><div>#3 We wait for the<br>messages from the client to the server by waiting for the client to<br>respond to the localhost and then it sends the information back to display<br>the message</div><div><br></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/234090765-cf25a751-5909-43a2-9899-1913bb5b1dc7.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client is sending messages back to back and showing what happens in server/real<br>time we are getting feedback and the messages that is being shown while<br>it waits for input<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <ol><br><li>When the client connects and sends a message to the server it<br>gets received to the ServerThread<div>2. The ServerThread pushes out the messages to a<br>room and then waits for other messages from the room to push to<br>the room</div><div>3. The room keeps a list of the clients and then displays<br>the message to everyone in the room</div><div>4. When the client receives a message<br>it shows it to the user</div><br></li><br></ol><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/234090494-7cd3290d-3fd2-4d0b-9e6b-fb93b3afebf3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>I am showing the messages and then i disconnect from the message but<br>the other clients is still running in the background<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>When the client becomes disconnected so the socket connection becomes closed from the<br>clients end. The client programs then waits for the Socket to show a<br>error message or completely close the program.<div>To prevent from blocking the client the<br>socket makes another connection thread and then when the client disconnects the server<br>removes the client and all the connections that were connected before completely closing<br>everything down. The server handles and prevents crashes from the socket.<br><div><br></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Hman00/IT114-008/pull/4">https://github.com/Hman00/IT114-008/pull/4</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>The issues I ran into this assignment was not asking Professor Toegel on<br>how to properly do this and causing more confusion and work for myself<br>trying to use Youtube and the internet. While it provided a temporary solution<br>i kept running into more and more errors which piled up but it<br>got fixed when i showed him in a mere matter of minutes thank<br>you professor!<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/hn224" target="_blank">Grading</a></td></tr></table>