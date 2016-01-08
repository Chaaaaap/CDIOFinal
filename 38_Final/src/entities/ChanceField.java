package entities;

import java.util.ResourceBundle;

import chance.ChanceCard;
import controllers.GameBoard;
import desktop_resources.GUI;

public class ChanceField extends Felt {

	private ChanceCard[] chanceCards;
	private ChanceCard chanceCard;
	private String cardText;
	private ChanceCard cc;
	private ResourceBundle rb;

	public ChanceField(String feltNavn, GameBoard gameBoard, ResourceBundle rb) {
		super(feltNavn);
		this.rb = rb;
		chanceCards = new ChanceCard[33];
		initCards();
//		chanceCard.shuffle();
		
	}

	private void initCards() {
		
		
	}

	@Override
	public void landOnField(Player player) {
//		getFeltBesked(player);
//		chanceCard = cc.drawCard();
//		GUI.showMessage(rb.getString(chanceCard.toString()));
//		chanceCard.executeCard(player);		
	}

	@Override
	public String getFeltBesked(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
