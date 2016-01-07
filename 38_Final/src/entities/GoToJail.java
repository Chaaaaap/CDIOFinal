package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;

public class GoToJail extends Felt {

	private Player player;
	private ResourceBundle rb;
	private GameBoard gameBoard;

	public GoToJail(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		this.gameBoard = gameBoard;
		this.rb = gameBoard.getBundle();
		
	}
	
	private void goToJail(Player player) {
		player.isJailed = true;
		player.setCurrentField(10);
		GUI.removeAllCars(player.getPlayerName());
		GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
		
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		goToJail(player);
		GUI.showMessage(getFeltBesked(player));
	}

	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", "+rb.getString("Jail2");
	}

}
