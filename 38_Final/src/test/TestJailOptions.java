package test;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import controllers.*;
import desktop_resources.GUI;
import entities.*;



public class TestJailOptions {

	private Player player;
	private GameBoard gb;
	private DiceCup diceCup;
	private ResourceBundle rb;
	private LanguageSelector ls;
	private GoToJail gtj;
	private String jailedOption;
	private int sum;

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
		
		player.isJailed = true;
		
		int expected1 = 30000;
		int actual1 = player.getBalance(player);
		assertEquals(expected1, actual1);
		
		jailedOption = GUI.getUserButtonPressed(player.getPlayerName()+", "+rb.getString("Jail3"), rb.getString("Jail5"));

		if(jailedOption.equals(rb.getString("Jail5"))) {
			player.getPlayerAccount().adjustBalance(-1000);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			player.isJailed = false;
		}
		
		boolean expected = false;
		boolean actual = player.isJailed;
		assertEquals(expected, actual);
		
		expected1 = 29000;
		actual1 = player.getBalance(player);
		assertEquals(expected1, actual1);

	}
	public void testJailOptionDiceRoll() {
		
		player.isJailed = true;
		
		jailedOption = GUI.getUserButtonPressed(player.getPlayerName()+", "+rb.getString("Jail3"), rb.getString("Jail6"));
		
		if(jailedOption.equals(rb.getString("Jail6"))){
			diceCup.shake();
			GUI.setDice(diceCup.getDiceOne(), diceCup.getDiceTwo());

			if(diceCup.getDiceOne() == diceCup.getDiceTwo()){
				GUI.showMessage(player.getPlayerName()+", "+rb.getString("Jail8"));
				player.isJailed = false;
				player.setJailRoll(0);		
				sum = diceCup.getSumResult();
				GUI.setDice(diceCup.getDiceOne(), diceCup.getDiceTwo());
				GUI.removeAllCars(player.getPlayerName());
				player.setCurrentField(player.getCurrentField()+sum);
				GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
				gb.getlogicFields()[player.getCurrentField()].landOnField(player);
			}

			else GUI.showMessage(player.getPlayerName()+", "+rb.getString("Jail9")); {
				if (player.getJailRoll() == 2) {
					GUI.showMessage(player.getPlayerName()+", "+rb.getString("Jail10"));
					player.adjustBalance(player, -1000);
					GUI.setBalance(player.getPlayerName(), player.getBalance(player));
					player.isJailed = false;
					player.setJailRoll(0);
					GUI.setDice(diceCup.getDiceOne(), diceCup.getDiceTwo());
				}

				else {
					player.addJailRollCounter();
					GUI.setDice(diceCup.getDiceOne(), diceCup.getDiceTwo());
				}
			}
		}
		
		
		
		
	}
}
