package entities;

import java.util.ResourceBundle;

public class Tax extends Felt {
	
	private int rent;

	public Tax(int rent, String feltNavn, ResourceBundle rb) {
		super(feltNavn);
		this.rent = rent;
	}

	@Override
	public void landOnField(Player player) {
		getFeltBesked(player);
		getRent(player);
		
	}

	@Override
	public String getFeltBesked(Player player) {
		return null;
	}
	
	private int getRent(Player player) {
		return rent;
	}

}
