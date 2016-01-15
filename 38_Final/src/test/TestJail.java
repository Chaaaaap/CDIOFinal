package test;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import controllers.*;
import entities.*;


public class TestJail {
	

	private Player player;
	private DiceCup diceCup;
	private Dice diceOne, diceTwo;
	
	@Before
	public void setUp() throws Exception {
		diceOne = new Dice(1,1);
		diceTwo = new Dice(1,1);
		diceCup = new DiceCup();
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");	
	}

	@Test
	public void test() {
		player.addTurnCounter();
		diceCup.shake();
//		
//		int expected = diceCup.getDiceOne();
//		int expected1 = diceCup.getDiceTwo();
//		
//		assertEquals(expected, expected1);
		
		diceCup.shake();
		diceCup.shake();
		
		
		boolean expected2 = true;
		boolean actual = player.isJailed;
		assertEquals(expected2, actual);
	}

}
