package controllers;

import desktop_resources.GUI;
import desktop_codebehind.Car;
import java.awt.Color;
import java.util.ResourceBundle;

import entities.Dice;
import entities.LanguageSelector;
import entities.Player;

public class GameManager 
{

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private Player[] players;
	private int startingPlayer, playerCount, sum, bankruptCounter=0;
	private DiceCup diceCup;
	private GameBoard gameBoard;
	private boolean[] bankruptPlayers;
	private String winner;
	private LanguageSelector ls;
	private String language;
	private String country;
//	private String languageChosen;
	private ResourceBundle rb;

	//GameManager constructor
	public GameManager()
	{
		this.ls = new LanguageSelector(language, country);
		this.diceCup = new DiceCup();
		this.gameBoard = new GameBoard(diceCup, ls);
		rb = gameBoard.getBundle();
		
	}

	//StartGameEngine method is a void method, which means 
	//it does not return any value.
	//StartGameEngine is the brain of this game-program
	public void startGameEngine()
	{
		//Setup game
		initPlayers();
		boolean gameIsNotWon = true;

		//Selects starting player
		int i = startingPlayer-1;
		//Take turns until game won
		while (gameIsNotWon)
		{			
			for (;i < playerCount; i++){
				//Runs the gamelogic.
				playerTurn(players[i]);
				//Tests to see how many players are bankrupt.
				isPlayersBankrupt(players);
				//If all but one player is bankrupt, the game has been won.
				if(bankruptCounter == playerCount-1)
					gameIsNotWon = false;

			}
			//Makes sure the forloop starts at index 0 after the first runthrough.
			i=0;
		}
		showWinnerScreen();
	}

	private void showWinnerScreen() 
	{
		//Tests to see which player is NOT bankrupt at the end of the game.
		//Only one player can still have any assets at this point.
		for(int i = 0; i < playerCount; i++) {
			if(players[i].getPlayerAccount().isBankrupt() != true)
				winner = players[i].getPlayerName();
		}
		//Displays the winner at the GUI.
		GUI.showMessage(rb.getString("Vinder")+" "+winner+" "+rb.getString("Vinder2"));
	}

	private void initPlayers() 
	{	
		//Lets the user decide how many players should be in the game.
		String playersCountChoosenByUser = GUI.getUserButtonPressed(rb.getString("AntalSpillere"), "2", "3", "4", "5", "6");
		//Converts the String to an int.
		playerCount = Integer.parseInt(playersCountChoosenByUser);
		//Initializes the Player array with the amount of players
		players = new Player[playerCount];
		//Initializes the Car array with the amount of players
		Car[] car = new Car[playerCount];
		//Initializes a boolean array to keep track of how many players are bankrupt.
		bankruptPlayers = new boolean[playerCount];

		for(int i = 0; i < playerCount; i++)
		{
			//Makes sure the players start at 1 and counts to playerCount.
			int playerNumber = i + 1; 
			//Lets the user decide the name of the player.
			String playerNameTypedInByTheUser = GUI.getUserString(rb.getString("IndtastNavn") + playerNumber);
			Player player = new Player();
			player.setPlayerName(playerNameTypedInByTheUser);
			//Stores the newly created player in the Player array at index i.
			players[i] = player;
			//Creates the car the player needs to travel the board.
			car[i] = new Car.Builder()
					.typeUfo()
					.patternHorizontalDualColor()
					.primaryColor(Color.lightGray)
					.secondaryColor(getChangedColor(playerNumber))
					.build();
			//Adds the player to the GUI.
			GUI.addPlayer(player.getPlayerName(), players[i].getPlayerAccount().getBalance(), car[i]);
			//Puts their car on the Startfield.
			GUI.setCar(1, player.getPlayerName());
			player.setCurrentField(0);
			//Makes sure the game knows that the player is NOT bankrupt.
			bankruptPlayers[i] = false;

		}

		GUI.getUserButtonPressed(rb.getString("HvemStarter"), rb.getString("Kast"));
		
		//Decides who's starting
		//If there's more than 2 players use this method
		if(playerCount > 2) {
			Dice dice = new Dice(playerCount,1);
			int rollResult = dice.roll();
			startingPlayer = rollResult;
		}
		//If there's 2 players use this method.
		else {
			Dice dice = new Dice(2,1);
			int rollResult = dice.roll();
			startingPlayer = rollResult;
		}
		//Prints who's starting on the GUI.
		GUI.showMessage(players[startingPlayer-1].getPlayerName() + " " + rb.getString("Starter"));
	}

	private void playerTurn(Player player) 
	{
		//Tests to see how many players are bankrupt
		isPlayersBankrupt(players);
		//Makes sure bankrupts players are skipped
		if(player.getPlayerAccount().isBankrupt() == false) {
			//Shakes the dies and shows the dies on the GUI.
			GUI.getUserButtonPressed(player.getPlayerName() + rb.getString("Tur"), rb.getString("DiceRoll"));
			diceCup.shake();
			sum = diceCup.getSumResult();
			GUI.setDice(diceCup.getDiceOne(), diceCup.getDiceTwo());
			//gives player 4000 if passing start
			if(player.getCurrentField() > (player.getCurrentField()+sum)%40){
				player.getPlayerAccount().adjustBalance(+4000);
				GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			}
			//Moves the car around the board.
			GUI.removeAllCars(player.getPlayerName());
			player.setCurrentField((player.getCurrentField()+sum)%40);
			GUI.setCar((player.getCurrentField()+1), player.getPlayerName());
			player.setCurrentField((player.getCurrentField()));
			//Gets the landOnField from whatever field the player landed on.
			gameBoard.getlogicFields()[player.getCurrentField()].landOnField(player);
			//Removes the car of any bankrupt player.
			if(player.getPlayerAccount().isBankrupt())
				GUI.removeAllCars(player.getPlayerName());
		}		
	}
	//A simple counter to see how many players are bankrupt.
	private int isPlayersBankrupt(Player[] players) {
		bankruptCounter = 0;
		for(int i = 0; i < playerCount; i++)
			if(players[i].getPlayerAccount().isBankrupt() == true)
				bankruptCounter++;
		return bankruptCounter;
	}
	
	private Color getChangedColor(int playerNumber)
	{
		switch (playerNumber)
		{
		case 1:
			return Color.BLUE;
		case 2:
			return Color.RED;
		case 3:
			return Color.ORANGE;
		case 4:
			return Color.GRAY;
		case 5:
			return Color.YELLOW;
		default:
			return Color.MAGENTA;
		}
	}
}