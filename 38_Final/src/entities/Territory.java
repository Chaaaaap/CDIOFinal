package entities;

import desktop_resources.GUI;

import java.util.ResourceBundle;

import controllers.GameBoard;

public class Territory extends Ownable {

	private territoryData td;

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	

	//The Territory constructor takes three parameters, price, rent and feltNavn.
	public Territory(int price, int rent, String feltNavn, GameBoard gb, ResourceBundle rb) {
		super(price, feltNavn, gb);
		this.td = new territoryData(rent, feltNavn, owner, rb);
	}

	@Override
	public int getRent(Player player) {
		return rent;
	}

	
	//This method makes the text, that are being showed in the GUI
	//when a player lands on the Territory fields.
	@Override
	public String getFeltBesked(Player player) {
		if(owner == null){
			return player.getPlayerName()+", "+rb.getString("Owned")+" "+feltNavn+"."; 
		}
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", "+ rb.getString("Owned4");
		
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", "+rb.getString("Owned")+" "+feltNavn+", "+rb.getString("Owned1")+" "+owner.getPlayerName()+
					", "+ rb.getString("Owned2")+" "+owner.getPlayerName()+" "+ rb.getString("Bankrupt");
	
		else 
			return player.getPlayerName()+", "+rb.getString("Owned")+" "+feltNavn+", "+rb.getString("Owned1")+" "+owner.getPlayerName()+"\n"+ rb.getString("Owned3")+" "+rent+" kr.";
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
		buy = GUI.getUserButtonPressed(rb.getString("Købe")+" "+price+"$?", rb.getString("Ja"),rb.getString("Nej"));
		if(buy.equals(rb.getString("Ja"))) {
			player.getPlayerAccount().adjustBalance(-price);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addProperty(this);
//			player.getProperty().get(0).getFeltNavn();
			gameBoard.getGUIFields()[player.getCurrentField()].setSubText(player.getPlayerName());
		}
	}

	public void sellHouse(Player player) {
		// TODO Auto-generated method stub
		
	}

	public void buyHouse(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	territoryData getTerritoryData(){
		return  td;
	}
	
	private class territoryData {
		
		
		private int rent;
		private int houseCounter;
		private String buy;
		private Player owner;
		private ResourceBundle rb;
		private territoryData(int rent, String buy, Player owner, ResourceBundle rb) {
			super();
			this.rent = rent;
			this.buy = buy;
			this.owner = owner;
			this.rb = rb;
		}
		public Player getOwner() {
			return owner;
		}
		public void setOwner(Player owner) {
			this.owner = owner;
		}
		public int getRent() {
			return rent;
		}
		public int getHouseCounter() {
			return houseCounter;
		}
		
		
		
		
	}
	
}