package entities;

import java.util.ResourceBundle;

import chance.ChanceCards;
import controllers.GameBoard;
import desktop_resources.GUI;

public class ChanceField extends Felt {

	private ChanceCards[] chanceCard;
	private String[] chanceCards;
	private String cardText;
	private ChanceCards cc;

	public ChanceField(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		chanceCard = new ChanceCards[33];
		initCards();
//		chanceCard.shuffle();
		
	}

	private void initCards() {
		
		
	}

	@Override
	public void landOnField(Player player) {
		getFeltBesked(player);
//		cc = chanceCa
//		cc.
		
	}

	@Override
	public String getFeltBesked(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
