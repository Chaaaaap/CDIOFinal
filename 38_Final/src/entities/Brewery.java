package entities;

import controllers.GameBoard;
import desktop_resources.GUI;
import controllers.DiceCup;
import entities.Player;
import java.util.ResourceBundle;

public class Brewery extends Ownable {


	private int rent, price, sum,rentModifier;
	private String buy, feltNavn;
	private Player owner;
	private DiceCup diceCup;
	private GameBoard gameBoard;
	private ResourceBundle rb;
	
	
	public Brewery(int price, String feltNavn, DiceCup cup, GameBoard gameBoard, ResourceBundle rb) {
		super(price, feltNavn, gameBoard);
		this.price = price;
		this.feltNavn = feltNavn;
		owner = null;
		diceCup = cup;
		this.gameBoard = gameBoard;
		this.rb = gameBoard.getBundle();
	}

	@Override
	public int getRent(Player player) {
		return rent;
	}
	
	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void setOwner(Player player) {
		owner = player;
		
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed(rb.getString("Købe")+" "+price+" kr.?", rb.getString("Ja"), rb.getString("Nej"));
		if(buy.equals(rb.getString("Ja"))) {
			GUI.setOwner(player.getCurrentField()+1, player.getPlayerName());
			player.getPlayerAccount().adjustBalance(-price);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addBreweryCounter();
			player.adjustPropertyValue(player, price);
		}
		gameBoard.getGUIFields()[player.getCurrentField()].setSubText(rb.getString("Ejer")+" "+player.getPlayerName());

	}

	@Override
	public String getFeltBesked(Player player) {
		if(owner == null)
			return  player.getPlayerName()+", " + rb.getString("Owned")+" "+feltNavn+".";
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", " + rb.getString("Owned4");
	
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", " + rb.getString("Owned")+" "+feltNavn+", " + rb.getString("Owned1")+" "+owner.getPlayerName()+
			", " + rb.getString("Owned2")+" "+owner.getPlayerName()+" "+ rb.getString("Bankrupt");
		
		else
			return player.getPlayerName()+", "+rb.getString("Owned")+" "+feltNavn+", "+rb.getString("Owned1")+" "+owner.getPlayerName()
					+" "+ rb.getString("Owned5");
	}
	
	public DiceCup getDiceCup() {
		return diceCup;
	}

	public void setDiceCup(DiceCup diceCup) {
		this.diceCup = diceCup;
	}

	@Override
	public void landOnField(Player player) {
		GUI.showMessage(getFeltBesked(player));
		if(owner == null) {
			buyFieldOption(player);
		} else if(owner.getPlayerName().equalsIgnoreCase(player.getPlayerName())) {
			GUI.showMessage(getFeltBesked(player));
		} else  if (owner.getPlayerAccount().isBankrupt() == true){
			
		} else {
			sum = diceCup.getSumResult();
			rentModifier = owner.getBreweryCounter(owner);
			
			GUI.showMessage(player.getPlayerName()+", " +rb.getString("Roll") +" "+ sum +", "+ rb.getString("Roll1") +" "+ rentModifier*sum*100+" "+rb.getString("Roll2")+" "+owner.getPlayerName());
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), sum*100*rentModifier);	
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
		
			
			
		}
	}
}
