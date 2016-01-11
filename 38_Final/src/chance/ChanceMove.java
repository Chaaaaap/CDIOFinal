package chance;

import java.util.ResourceBundle;

import controllers.ChanceCardController;
import controllers.GameBoard;
import desktop_resources.GUI;
import entities.ChanceField;
import entities.Felt;
import entities.Player;

public class ChanceMove extends ChanceCard {

	private int antalFelter;
	private GameBoard gb;
	private ChanceCard[] cc;
	private ChanceCard chanceCard;
	private ResourceBundle rb;
	private ChanceCardController ccc;

	public ChanceMove(String cardName, int antalFelter, GameBoard gameBoard, ChanceCard[] cc, ResourceBundle rb, ChanceCardController ccc) {
		super(cardName);
		this.antalFelter = antalFelter;
		this.gb = gameBoard;
		this.cc = cc;
		this.rb = rb;
		this.ccc = ccc;
	}

	@Override
	public void executeCard(Player player) {
		GUI.removeAllCars(player.getPlayerName());
		player.setCurrentField(player.getCurrentField()+antalFelter);
		Felt currentField = gb.getlogicFields()[player.getCurrentField()];
		if(player.getCurrentField() < 4) {
			player.setCurrentField(39);
			GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
		} else if(currentField instanceof ChanceField) {
			GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
			GUI.showMessage(rb.getString(gb.getlogicFields()[player.getCurrentField()].getFeltBesked(player)));
			chanceCard = ccc.drawCard();
			GUI.showMessage(rb.getString(chanceCard.toString()));
			chanceCard.executeCard(player);
		} else 	{
			GUI.setCar(player.getCurrentField()+1, player.getPlayerName());
		}

		gb.getlogicFields()[player.getCurrentField()].landOnField(player);
	}
}
