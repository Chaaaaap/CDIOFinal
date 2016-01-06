package entities;

import java.util.ResourceBundle;

import chance.ChanceCards;
import controllers.GameBoard;
import desktop_resources.GUI;

public class ChanceField extends Felt {

	private ChanceCards[] chanceCard;
	private String[] chanceCards;
	private String cardText;

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
//		chanceCard.drawCard();
//		cardText = chanceCard.toString();
//		
//		switch(cardText) {
//		case "ChanceAktie": GUI.showMessage(""); player.adjustBalance(player, 1000); break;
//		case "ChancePayFine": GUI.showMessage(""); player.adjustBalance(player, -1000); break;
//		case "ChanceJail": GUI.showMessage(""); player.isJailed = true; GUI.removeAllCars(player.getPlayerName()); player.setCurrentField(11); GUI.setCar(player.getCurrentField(), player.getPlayerName()); break;
//		}
		
	}

	@Override
	public String getFeltBesked(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

}
