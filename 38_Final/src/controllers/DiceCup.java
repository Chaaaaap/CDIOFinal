package controllers;

import entities.Dice;

public class DiceCup 
{

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.	
	private Dice diceOne;
	private Dice diceTwo;

	//DiceCup class constructor
	//which takes two class of Dice
	public DiceCup() 
	{
		this.diceOne = new Dice();
		this.diceTwo = new Dice();
	}

	//This Shake method is used for randomly choose
	//a random number between the numbers of the dice.
	//Shake method returns a Dice[] => which is a Dice array.
	public void shake()
	{
		diceOne.roll();
		diceTwo.roll();
	}

	public int getSumResult()
	{
		int sum = diceOne.getValue()+ diceTwo.getValue(); 
		return sum;
	}

	public int getDiceOne() 
	{
		return diceOne.getValue();
	}

	public int getDiceTwo() 
	{
		return diceTwo.getValue();
	}
}