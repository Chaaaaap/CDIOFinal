package entities;

import java.util.ResourceBundle;
import desktop_resources.GUI;

public class Parking extends Felt {

	private ResourceBundle rb;

	public Parking(String feltNavn, ResourceBundle rb) {
		super(feltNavn);
		this.rb = rb;
	}

	@Override
	public void landOnField(Player player) {
		GUI.showMessage(getFeltBesked(player));
		
	}

	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", " +rb.getString("Park");
	}

}
