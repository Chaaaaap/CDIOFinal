package test;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import controllers.*;
import entities.*;


public class TestJail {
	

	private Player player;
	private GameBoard gb;
	private DiceCup diceCup;
	private ResourceBundle rb;
	private LanguageSelector ls;
	private Dice diceOne, diceTwo;
	
	@Before
	public void setUp() throws Exception {
		diceOne = new Dice();
		diceTwo = diceOne;
		diceCup = new DiceCup();
		ls = new LanguageSelector("da", "DK");
		gb = new GameBoard(diceCup, ls);
		rb = ls.selectLanguage("da", "DK");
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");	
	}

	@Test
	public void test() {
		diceCup.shake();
		diceCup.shake();
		diceCup.shake();
		player.addTurnCounter();
		
		boolean expected = true;
		boolean actual = player.isJailed;
		assertEquals(expected, actual);
	}

}
