package chance;

import controllers.GameBoard;
import desktop_resources.GUI;
import entities.Player;

public class ChanceMove extends ChanceCard {
	
	private int antalFelter;
	private GameBoard gb;

	public ChanceMove(String cardName, int antalFelter, GameBoard gameBoard) {
		super(cardName);
		this.antalFelter = antalFelter;
		this.gb = gameBoard;
	}
	
	@Override
	public void executeCard(Player player) {
		GUI.removeAllCars(player.getPlayerName());
		player.setCurrentField(player.getCurrentField()+antalFelter);
		if(player.getCurrentField() < 2) {
			player.setCurrentField(39);
			GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
		} else {
			
		GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
		gb.getlogicFields()[player.getCurrentField()-1].landOnField(player);
		}
	}
}
