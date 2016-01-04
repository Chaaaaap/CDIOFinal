package entities;

public abstract class Felt {

	private String feltNavn;

	public Felt(String feltNavn) {
		this.feltNavn = feltNavn;
	}

	//These methods are abstract because we don't ever use them from the Felt class.
	//They will always be overriden from the subclasses of Felt.
	public abstract void landOnField(Player player);
	public abstract String getFeltBesked(Player player);

}