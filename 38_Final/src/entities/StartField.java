package entities;

import java.util.ResourceBundle;

public class StartField extends Felt {

	public StartField(String feltNavn, ResourceBundle rb) {
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
