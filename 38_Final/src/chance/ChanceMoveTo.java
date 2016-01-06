package chance;

import desktop_resources.GUI;
import entities.Player;

public class ChanceMoveTo extends ChanceCards {

	private int moveTo;

	public ChanceMoveTo(String cardName, int moveTo) {
		super(cardName);
		this.moveTo = moveTo;
	}

	@Override
	public void executeCard(Player player) {
		GUI.removeAllCars(player.getPlayerName());
		player.setCurrentField(moveTo);
		GUI.setCar(player.getCurrentField(), player.getPlayerName());		
	}
	
	

}
