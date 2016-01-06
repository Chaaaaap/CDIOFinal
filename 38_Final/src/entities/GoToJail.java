package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;

public class GoToJail extends Felt {

	public GoToJail(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
	}
	
	private void goToJail(Player player) {
		player.isJailed = true;
		player.setCurrentField(11);
		GUI.removeAllCars(player.getPlayerName());
		GUI.setCar(player.getCurrentField(), player.getPlayerName());
	}

	@Override
	public void landOnField(Player player) {
		goToJail(player);
		getFeltBesked(player);
	}

	@Override
	public String getFeltBesked(Player player) {
		return null;
	}

}
