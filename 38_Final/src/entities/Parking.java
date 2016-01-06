package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;

public class Parking extends Felt {

	private Player player;
	private ResourceBundle rb;
	private GameBoard gameBoard;

	public Parking(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
		
	}

	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", "+rb.getString("Park");
	}

}
