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
		if(player.getCurrentField() == 4){
			Tax = GUI.getUserButtonPressed(rb.getString("Rent") +" "+ taxAmount +" "+ rb.getString("Rent1"), rb.getString("Pay")+" "+taxAmount, rb.getString("Pay1"));
			if(Tax.equals(rb.getString("Pay"))){
			Pay = Integer.parseInt(Tax.replaceAll("[\\D]", ""));
			player.getPlayerAccount().adjustBalance(-Pay);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			}
			else {
				player.getPlayerAccount().adjustBalance(-tenPercent(player));
				GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			}
		}
		else {
			Tax = GUI.getUserButtonPressed(rb.getString("Rent2"), rb.getString("Pay")+" "+taxAmount);
			Pay = Integer.parseInt(Tax.replaceAll("[\\D]", ""));
			player.getPlayerAccount().adjustBalance(-Pay);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());	
		}
		

	}

	private int tenPercent(Player player) {
		return player.getPlayerAccount().getBalance()/10;
	}

	@Override
	public String getFeltBesked(Player player) {
		if(player.getCurrentField() == 4)
		return player.getPlayerName()+", "+rb.getString("Tax1");
		else
			return player.getPlayerName()+", "+rb.getString("Tax2");
	}

	//	private int getRent(Player player) {
	//		return rent;
	//	}

}
