package entities;

import java.util.ResourceBundle;

public class Jail extends Felt {

	public Jail(String feltNavn, ResourceBundle rb) {
		super(feltNavn);
	}

	@Override
	public void landOnField(Player player) {

	}

	@Override
	public String getFeltBesked(Player player) {
		return null;
	}

}
