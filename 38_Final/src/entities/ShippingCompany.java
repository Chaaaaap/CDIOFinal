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

	public ShippingCompany(int pris, String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(pris, feltNavn, gameBoard);
		this.pris = pris;
		this.feltNavn = feltNavn;
		owner = null;
		this.gameBoard = gameBoard;
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
		buy = GUI.getUserButtonPressed("Do you want to buy this field for "+pris+"$?", "Yes","No");
		if(buy.equals("Yes")) {
			player.getPlayerAccount().adjustBalance(-pris);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addFleetCounter();
			gameBoard.getGUIFields()[player.getCurrentField()].setSubText(player.getPlayerName());
		}
	}



@Override
public String getFeltBesked(Player player) {
	if (owner == null)
		return player.getPlayerName()+" landed on " + feltNavn + ".";

	else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
		return player.getPlayerName()+", you already own this field! Nothing happens.";

	else if (owner.getPlayerAccount().isBankrupt() == true)
		return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+
				", but "+owner.getPlayerName()+" is bankrupt, which means you don't have to pay anything!";

	else 
		return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+
				"\n"+owner.getPlayerName()+" owns "+owner.getFleetCounter(owner)+" fleet fields, therefore you have to pay "+
				getRent(owner)+".";
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
