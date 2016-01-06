package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;
import entities.Player;

public class Tax extends Felt {
	
	private String Tax, feltNavn;
	private int Pay, taxAmount;
	private Player player;
	private ResourceBundle rb;
	private GameBoard gameBoard;
//	private String[] strings;

	public Tax(int tax, String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		this.feltNavn = feltNavn;
		taxAmount = tax;
		this.gameBoard = gameBoard;
		this.rb = gameBoard.getBundle();
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
		payTax();
		
	}

	private void payTax() {
		Tax = GUI.getUserButtonPressed("Choose between paying "+taxAmount+" or 10% of your assets.", "Pay "+taxAmount, "Pay "+tenPercent(player));
		Pay = Integer.parseInt(Tax.replaceAll("[\\D]", ""));
		player.getPlayerAccount().adjustBalance(-Pay);
		GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
		
	}

	private int tenPercent(Player player) {
		return player.getPlayerAccount().getBalance()/10;
	}

	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", "+rb.getString("Rent")+" "+feltNavn+".";
	}
	
//	private int getRent(Player player) {
//		return rent;
//	}

}
