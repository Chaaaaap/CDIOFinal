package test;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import controllers.*;
import chance.*;
import entities.*;

public class TestMoveThreeFieldsBack {

	private Player player;
	private GameBoard gb;
	private DiceCup diceCup;
	private ResourceBundle rb;
	private LanguageSelector ls;

	private ChanceCard[] cc;
	private ChanceCardController chanceCardController;

	private ChanceField PrøvLykken;


	@Before
	public void setUp() throws Exception {
		ls = new LanguageSelector("da", "DK");
		gb = new GameBoard(diceCup, ls);
		rb = ls.selectLanguage("da", "DK");
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");

		cc = new ChanceCard[1];
		chanceCardController = new ChanceCardController(cc);
		cc[0] = new ChanceMove("ChanceMove", -3, gb, chanceCardController, rb);

		PrøvLykken = new ChanceField("Prøv Lykken");

	}

	@Test
	public void testMoveCard() {


		player.setCurrentField(2);
		PrøvLykken.landOnField(player);
		cc[0].executeCard(player);

		int expected = 39;
		int actual = player.getCurrentField();		

		assertEquals(expected, actual);
	}

}
