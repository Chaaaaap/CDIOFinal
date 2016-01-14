package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;

public class GoToJail extends Felt {

	private ResourceBundle rb;

	public GoToJail(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		this.rb = rb;
		
	}
	
	private void goToJail(Player player) {
		player.isJailed = true;
		player.setCurrentField(10);
		GUI.removeAllCars(player.getPlayerName());
		GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
		
	}

	@Override
	public void landOnField(Player player) {
		GUI.showMessage(getFeltBesked(player));
		goToJail(player);
		
	}

	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", "+rb.getString("Jail2");
	}

}
