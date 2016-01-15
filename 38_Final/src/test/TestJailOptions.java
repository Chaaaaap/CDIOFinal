package test;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import controllers.*;
import entities.*;



public class TestJailOptions {

	private Player player;
	private GameBoard gb;
	private DiceCup diceCup;
	private ResourceBundle rb;
	private LanguageSelector ls;
	private GoToJail gtj;

	@Before
	public void setUp() throws Exception {
		ls = new LanguageSelector("da", "DK");
		gb = new GameBoard(diceCup, ls);
		rb = ls.selectLanguage("da", "DK");
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");
		gtj = new GoToJail("De Fængsles", gb, rb);
	}

	@Test
	public void testGoToJail() {
		boolean expected = false;
		boolean actual = player.isJailed;
		assertEquals(expected, actual);

		gtj.landOnField(player);

		expected = true;
		actual = player.isJailed;
		assertEquals(expected, actual);

	}

	@Test
	public void testJailOptionPay() {
		if()



	}

}
