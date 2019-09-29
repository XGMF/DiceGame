Dice Blackjack.

A console based blackjack game
Initial project Requirements
Your Customer / Project Owner wants you to implement a console based blackjack game with 2 dice. The human player plays against the computer.

REQ-1: The human players starts.
REQ-2: At start, the player gets 2 random numbers.
REQ-3: The random number are summed up.
REQ-4: The player can then choose to hold or roll again the dice.
REQ-5: If they chooses to roll again, numbers are added to the previous sum.
REQ-6: If the player holds, it’s the computer’s turn.
REQ-7: The closest to 21 without going over is the winner.

These initial requirements are inadequate for complete coding of the requested game.
We asked the client for any requirements we were uncertain on. 

Questions

	What kind of dice do you want use, a standard dice or something custom?
		The standard six sided dice will be suitable.
	How should we get the two random numbers?
		Use the two dice needed for the program.
	Once the player holds, it’s the computers turn. How do we decide when the computer 	will hold?
		When within a certain range of the blackjack target (21) 
	This range is?
		Somewhere in the middle of possible outcomes on a dice.
	What will happen if the dice total 21 for one player?
		Nothing as it is not over 21.	
	What will happen if the dice total 21 for both players?
		As both players are as close to the target as possible,
		The game is a draw.
	What will happen if a player goes over the target of 21?
		If any player goes over 21, that is an immediate loss
	What should happen at the end of the game?
		The dice running totals should be displayed.
		The winner or loser should be announced.
		As the program is a console game, the program should be paused until 		a key is pressed.
	
