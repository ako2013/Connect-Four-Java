# Connect-Four-Java

<i>Description</i>: A small program replicate the Connect Four Game using a 2D array. Implemented for PvP and PvE
<hr>
<a href="https://en.wikipedia.org/wiki/Connect_Four">Wiki page</a> for Connect Four</br>
<center><img src="https://upload.wikimedia.org/wikipedia/commons/a/ad/Connect_Four.gif"></img></center>

<h2>Connect Four</h2>

<ul>
<li><h4>How does it decide the winner:</h4></li>
There is 4 process running after the player enter a move. 
<br>
The model gets the index of the move in the arrayUsing that index [x,y], it runs a a test:<br>
<ol>
<li>Horizontal Test<
<li>Vertical Test
<li>Diagonally down
<li>Diagonally up
</ol>
It counts the number of times a number for a player show up and reset when there's an empty space or another player's number
->By default: if the count number reaches 4 the method ends and return the winning value which is 1.<br>
<li><h4>How does A.I works</h4>
<ol>
<li>Initially uses predefined moves
<li>Using the <u>winning condition<u> to check if there's a winning move for computer and for the other player
by temporary insert in each column.
<li>If yes: choose that number of column to be the next move
<li>If no: use the buildt in Random Number Generator to get the next move
</ol>
</ul>
