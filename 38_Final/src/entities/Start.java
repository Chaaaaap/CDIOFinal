package entities;

public class Start extends Felt {

	public Start(String feltNavn) {
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
