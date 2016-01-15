package test;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.GameBoard;
import entities.LanguageSelector;
import entities.Player;
import controllers.DiceCup;
import entities.Territory;

public class TestBuyHouse {

	private Player player;
	private GameBoard gb;
	private DiceCup diceCup;
	private Territory territory1, territory2;
	private ResourceBundle rb;
	private LanguageSelector ls;
	
	@Before
	public void setUp() throws Exception {
		ls = new LanguageSelector("da", "DK");
		gb = new GameBoard(diceCup, ls);
		rb = ls.selectLanguage("da", "DK");
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");
		territory1 = new Territory(1200, "Rødovrevej", gb, rb, "blue",2, 1000, new int[] {50,250,750,2250,4000,6000});
		territory2 = new Territory(1200, "Hvidovrevej", gb, rb, "blue",4, 1000, new int[] {50,250,750,2250,4000,6000});
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuyHouse() {
		int expected = 20000;
		int actual = player.getBalance(player);
		assertEquals(expected, actual);
		
		territory1.setOwner(player);
		territory2.setOwner(player);
		territory1.buyHouse(player);
		
		expected = 19000;
		actual = player.getBalance(player);
		assertEquals(expected, actual);
	}

}
