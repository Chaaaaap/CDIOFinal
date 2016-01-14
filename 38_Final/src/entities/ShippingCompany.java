package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;
import entities.Player;

public class ShippingCompany extends Ownable {

	//The local attributes for this class.
	private final int RENT_1=500, RENT_2=1000, RENT_3=2000, RENT_4=4000;
	private Player owner;
	private String buy, feltNavn;
	private int pris, rent;
	private GameBoard gameBoard;
	private ResourceBundle rb;

	public ShippingCompany(int pris, String feltNavn, GameBoard gb, ResourceBundle rb) {
		super(pris, feltNavn, gb);
		this.pris = pris;
		this.feltNavn = feltNavn;
		this.owner = null;
		this.gameBoard = gb;
		this.rb = gameBoard.getBundle();
	}

	@Override
	public int getRent(Player player) {
		switch(owner.getFleetCounter(owner)) {
		case 1: rent = RENT_1; break;
		case 2: rent = RENT_2; break;
		case 3: rent = RENT_3; break;
		case 4: rent = RENT_4; break;

		}
		return rent;
	}

	@Override
	public void setOwner(Player player) {
		owner = player;
		owner.addFleetCounter();
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed(rb.getString("Købe") + " " + pris + "$?", rb.getString("Ja"), rb.getString("Nej"));
		if(buy.equals(rb.getString("Ja"))) {
			GUI.setOwner(player.getCurrentField()+1, player.getPlayerName());
			player.getPlayerAccount().adjustBalance(-pris);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addFleetCounter();
			player.adjustPropertyValue(player, pris);
			gameBoard.getGUIFields()[player.getCurrentField()].setSubText(player.getPlayerName());
		}
	}



	@Override
	public String getFeltBesked(Player player) {
		if (owner == null)
			return player.getPlayerName()+ " " + rb.getString("LandOnField") + " " + feltNavn + ".";

		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", " + rb.getString("Owned4");

		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", " + rb.getString("Owned") + feltNavn + ", " +rb.getString("Owned1") + " " + owner.getPlayerName()+
					", " + rb.getString("Owned2") + " " + owner.getPlayerName()+ " " + rb.getString("Bankrupt");

		else if (owner.getFleetCounter(owner) > 1)
			return player.getPlayerName()+", " + rb.getString("Owned")+" "+ feltNavn + ", " +rb.getString("Owned1") + " " + owner.getPlayerName()+
					"\n"+owner.getPlayerName() +" "+ rb.getString("Owns") +" "+ owner.getFleetCounter(owner) +" "+ rb.getString("Fleets1") +" "+
					getRent(owner)+" kr.";
		else 
			return player.getPlayerName()+", " + rb.getString("Owned")+" "+ feltNavn + ", " +rb.getString("Owned1") + " " + owner.getPlayerName()+
					"\n"+owner.getPlayerName() +" "+ rb.getString("Owns") +" "+ owner.getFleetCounter(owner) +" "+ rb.getString("Fleets") +" "+
					getRent(owner)+" kr.";
	}	

	public void landOnField(Player player) {
		GUI.showMessage(getFeltBesked(player));
		if(owner == null)
			buyFieldOption(player);
		else if (owner.getPlayerAccount().isBankrupt() == true){

		} else {
			getRent(owner);
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), getRent(owner));
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
		}

	}
}
