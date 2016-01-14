package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;
import desktop_resources.GUI;

public class Jail extends Felt {
	
	private ResourceBundle rb;

	public Jail(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		this.rb = rb;
	}

	@Override
	public void landOnField(Player player) {
		GUI.showMessage(getFeltBesked(player));
	}

	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", "+rb.getString("Jail");
	}

}
