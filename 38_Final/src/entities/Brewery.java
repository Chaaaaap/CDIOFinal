package entities;

import controllers.GameBoard;
import desktop_resources.GUI;
import controllers.DiceCup;
import entities.Player;
import java.util.ResourceBundle;

public class Brewery extends Ownable {


	private int rent, pris, sum,rentModifier;
	private String buy, feltNavn;
	private Player owner, player;
	private DiceCup diceCup;
	private GameBoard gameBoard;
	
	
	public Brewery(int pris, String feltNavn, DiceCup cup, GameBoard gameBoard,ResourceBundle rb) {
		super(pris, feltNavn, gameBoard);
		this.pris = pris;
		this.feltNavn = feltNavn;
		owner = null;
		diceCup = cup;
		this.gameBoard = gameBoard;
	}

	@Override
	public int getRent(Player player) {
	return 0;
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
		buy = GUI.getUserButtonPressed("Do you want to buy this field for "+pris+"$?", "Yes","No");
		if(buy.equals("Yes")) {
			player.getPlayerAccount().adjustBalance(-pris);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addBreweryCounter();
			gameBoard.getGUIFields()[player.getCurrentField()].setSubText(player.getPlayerName());
		}
	}

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
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+"\n";
	
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
		this.player = player;
		if(owner == null) {
			buyFieldOption(player);
		} else if(owner.getPlayerName().equalsIgnoreCase(player.getPlayerName())) {
			GUI.showMessage(getFeltBesked(player));
		} else  if (owner.getPlayerAccount().isBankrupt() == true){
			
		} else {
//			GUI.getUserButtonPressed("Shake dice to determine how much you should pay!", "Shake Dice Cup!");
//			diceCup.shake();
			sum = diceCup.getSumResult();
			rentModifier = owner.getBreweryCounter(owner);
			
			GUI.showMessage(player.getPlayerName()+", you rolled "+sum+", therefore you have to pay "+rentModifier*sum*100+" to "+owner.getPlayerName());
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), sum*100*rentModifier);	
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
		
			
			
		}
	}
}
