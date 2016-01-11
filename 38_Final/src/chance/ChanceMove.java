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
		
		if(player.getCurrentField() < 4) {
			player.setCurrentField(40);
			GUI.setCar(player.getCurrentField(), player.getPlayerName());
		} else 	{
			player.setCurrentField(player.getCurrentField()+antalFelter-1);
			GUI.setCar(player.getCurrentField(), player.getPlayerName());
		}

		gb.getlogicFields()[player.getCurrentField()-1].landOnField(player);
	}
}
