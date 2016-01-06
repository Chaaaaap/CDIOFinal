package entities;

import java.util.ResourceBundle;

import controllers.GameBoard;

public class StartField extends Felt {

	public StartField(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
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
