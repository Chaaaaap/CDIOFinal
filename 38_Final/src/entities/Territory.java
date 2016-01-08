package entities;

import desktop_resources.GUI;

import java.util.ResourceBundle;

import controllers.GameBoard;

public class Territory extends Ownable {

	private TerritoryData td;

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String buy;

	//The Territory constructor takes three parameters, price, rent and feltNavn.
	public Territory(int price, int rent, String feltNavn, GameBoard gb, ResourceBundle rb) {
		super(price, feltNavn, gb);
		this.td = new TerritoryData(rent, feltNavn, owner, rb, price, gb, feltNavn);
	}

	@Override
	public int getRent(Player player) {
		return td.getRent();
	}

	
	//This method makes the text, that are being showed in the GUI
	//when a player lands on the Territory fields.
	@Override
	public String getFeltBesked(Player player) {
		if(owner == null){
			return player.getPlayerName()+", "+td.getResourceBundle().getString("Owned")+" "+td.getFeltNavn()+"."; 
		}
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", "+ td.getResourceBundle().getString("Owned4");
		
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", "+td.getResourceBundle().getString("Owned")+" "+td.getFeltNavn()+", "+td.getResourceBundle().getString("Owned1")+" "+owner.getPlayerName()+
					", "+ td.getResourceBundle().getString("Owned2")+" "+owner.getPlayerName()+" "+ td.getResourceBundle().getString("Bankrupt");
	
		else 
			return player.getPlayerName()+", "+td.getResourceBundle().getString("Owned")+" "+td.getFeltNavn()+", "+td.getResourceBundle().getString("Owned1")+" "+owner.getPlayerName()+"\n"+ td.getResourceBundle().getString("Owned3")+" "+td.getRent()+" kr.";
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
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), td.getRent());	
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
		}
	}

	//This method gives the player the opportunity to buy the Territory field,
	//the given player has landed on.
	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed(td.getResourceBundle().getString("Købe")+" "+td.getPrice()+"$?", td.getResourceBundle().getString("Ja"),td.getResourceBundle().getString("Nej"));
		if(buy.equals(td.getResourceBundle().getString("Ja"))) {
			player.getPlayerAccount().adjustBalance(-td.getPrice());
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addProperty(this);
//			player.getProperty().get(0).getFeltNavn();
			td.getGb().getGUIFields()[player.getCurrentField()].setSubText(player.getPlayerName());
		}
	}

	public void sellHouse(Player player) {
		// TODO Auto-generated method stub
		
	}

	public void buyHouse(Player player) {
		player.adjustBalance(player, -td.getPrice());
		td.addHouseCounter();
		player.addHouseCounter();
		
	}
	
	
	
	TerritoryData getTerritoryData(){
		return  td;
	}
	
	private class TerritoryData {
		
		
		private String getBuy;
		private int rent;
		private int houseCounter;
		private String buy;
		private Player owner;
		private ResourceBundle rb;
		private int price;
		private GameBoard gb;
		private String feltNavn;
		
		private TerritoryData(int rent, String buy, Player owner, ResourceBundle rb, int price, GameBoard gb, String feltNavn) {
			super();
			this.rent = rent;
			this.buy = buy;
			this.owner = owner;
			this.rb = rb;
			this.price = price;
			this.gb = gb;
			this.feltNavn = feltNavn;
		}
		private String getFeltNavn() {
			return feltNavn;
		}
		private Player getOwner() {
			return owner;
		}
		private void setOwner(Player owner) {
			this.owner = owner;
		}
		private int getRent() {
			return rent;
		}
		private int getHouseCounter() {
			return houseCounter;
		}
		
		private int getPrice() {
			return price;
		}
		
		private ResourceBundle getResourceBundle() {
			return rb;
		}
		private GameBoard getGb() {
			return gb;
		}
		
		private void addHouseCounter() {
			houseCounter++;
		}
		
		
		
		
	}
	
}