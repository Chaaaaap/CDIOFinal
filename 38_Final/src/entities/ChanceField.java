package entities;

public class ChanceField extends Felt {

	public ChanceField(String feltNavn) {
		super(feltNavn);
	}

	@Override
	public void landOnField(Player player) {	
	}

	@Override
	public String getFeltBesked(Player player) {
		return "PrøvLykken";
	}

}
