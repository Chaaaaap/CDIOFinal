package entities;

import desktop_resources.GUI;
import controllers.GameBoard;

public class Territory extends Ownable {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private int rent;
	private int price;
	private int houseCounter;
	private String feltNavn, buy;
	private Player owner, player;
	private GameBoard gameBoard;

	//The Territory constructor takes three parameters, price, rent and feltNavn.
	public Territory(int price, String feltNavn, GameBoard gb) {
		super(price, feltNavn, gb);
		this.price = price;
		this.feltNavn = feltNavn;
		this.owner = null;
		this.gameBoard = gb;
	}

	@Override
	public int getRent(Player player) {
		return rent;
	}

	
	//This method makes the text, that are being showed in the GUI
	//when a player lands on the Territory fields.
	@Override
	public String getFeltBesked(Player player) {
		if(owner == null)
			return  player.getPlayerName()+", you landed on "+feltNavn+".";
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", you already own this field! Nothing happens.";
		
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+
					", but "+owner.getPlayerName()+" is bankrupt, which means you don't have to pay anything!";
	
		else 
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+"\nYou stay overnight and pay "+rent+" in rent.";
	}

	@Override
	public void setOwner(Player player) {
		owner = player;
	}


	@Override
	public Player getOwner() {	
		return owner;
	}

	//This method is used when a player lands on a Territory field.
	//If the field is not owned by an player, then the player have the buyFieldOption,
	//but if the field is owned, then the player have to pay the rent to the owner.
	@Override
	public void landOnField(Player player) {
		GUI.showMessage(getFeltBesked(player));
		if(owner == null) {
			buyFieldOption(player);
			
		}
		else  if (owner.getPlayerAccount().isBankrupt() == true){
			
		} else {
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), rent);	
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
		}
	}

	//This method gives the player the opportunity to buy the Territory field,
	//the given player has landed on.
	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed("Do you want to buy this field for "+price+"$?", "Yes","No");
		if(buy.equals("Yes")) {
			player.getPlayerAccount().adjustBalance(-price);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			gameBoard.guiFields[player.getCurrentField()].setSubText(player.getPlayerName());
		}
	}
	


}