package entities;

public abstract class Ownable extends Felt{
	
	//This is an abstract class that extends from the abstract Felt class.
	//the class is abstract because other classes have to extend
	//from this class. Its the body of all classes, that are ownable.
	private Player owner;
	private int pris;

	public Ownable(int pris, String feltNavn) {
		super(feltNavn);
		this.owner = null;
		this.pris = pris;
	}
	
	//Abstract methods. 
	//These methods are being overrided in the subclasses.
	public abstract int getRent(Player player);
	
	public abstract void setOwner(Player player);
	
	public abstract Player getOwner();
	
	public abstract void buyFieldOption(Player player);

	public void landOnField(Player player) {
		getFeltBesked(player);
		if(!player.equals(owner)){
			if(owner == null)
				buyFieldOption(player);
			else
				getRent(player);
		}
	}
	
	public abstract String getFeltBesked(Player player);


}
