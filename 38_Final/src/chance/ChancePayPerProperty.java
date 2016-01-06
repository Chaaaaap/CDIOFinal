package chance;

public class ChancePayPerProperty extends ChanceCards {

	private int amountPerHouse;
	private int amountPerHotel;

	public ChancePayPerProperty(String cardName, int amountPerHouse, int amountPerHotel) {
		super(cardName);
		this.amountPerHouse = amountPerHouse;
		this.amountPerHotel = amountPerHotel;
		
	}

}
