<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Henry Nyame (hn224)</td></tr>
<tr><td> <em>Generated: </em> 5/1/2023 4:21:32 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/hn224" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235508514-3bba2bab-6576-4e89-bc17-b1bd7bdcc86e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the payload code from the terminal<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235509343-d1b8d5f2-c9dd-4249-83db-fd4628e726c6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the roll commands<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235509349-c2e78393-a9a0-477f-bea6-156e729eea83.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the flip commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>The /roll command is a rng based command that generates random numbers from<br>a specific thing. In this case its using dice which starts from 1-6<br>because math.random is used in java to generate random numbers. After /roll is<br>initiated then a loop happens and then it numbers the dice and then<br>rolls a number.<div><br></div><div>How /flip works is that it simulates a coin toss just<br>like how anybody would flip a coin. It will either be heads or<br>tails and it would generate a random number (rng) between 0 and 1.<br>You can either get heads or tails many amount of times and each<br>outcome is random.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235517739-58576256-062d-41e6-b80e-7c747eb5b366.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>In this screenshot i show the command of how bold and italics is<br>processed and how it functions<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235518330-cbe933cd-8496-422b-92be-45790fdcd52e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Adding another screenshot<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235517739-58576256-062d-41e6-b80e-7c747eb5b366.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>In this screenshot i show the command of how bold and italics is<br>processed and how it functions<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98668690/235518330-cbe933cd-8496-422b-92be-45790fdcd52e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Adding on another screenshot to show the commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>How i was able to get each style of the words I used<br>regex then i used the message . message replace all. Once i did<br>that i did //* (gives me bold)&nbsp; //_ (italic) //&amp; (underline) and lastly<br>color (//].<div>This all started when i used&nbsp; String message = p.getMessage<font face="Consolas, Courier<br>New, monospace"><span style="white-space: pre; background-color: rgb(28, 30, 38);">. Once you finally get all<br>the messages and lines you would do </span><span style="white-space: pre;">#[00FF00]hi#[/color] and then you<br>could choose any color in order to get a message and a color<br>change.</span></font></div><div style="background-color: rgb(28, 30, 38); font-family: Consolas, &quot;Courier New&quot;, monospace; line-height: 19px; white-space:<br>pre;"><div></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Hman00/IT114-008/pull/5">https://github.com/Hman00/IT114-008/pull/5</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/hn224" target="_blank">Grading</a></td></tr></table>