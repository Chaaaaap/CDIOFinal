package chance;

import desktop_resources.GUI;
import entities.Player;

public class ChanceMoveTo extends ChanceCard {

	private int moveTo;

	public ChanceMoveTo(String cardName, int moveTo) {
		super(cardName);
		this.moveTo = moveTo;
	}

	@Override
	public void executeCard(Player player) {
		if(player.getCurrentField() > (moveTo)){
			if(!player.isJailed) {
				player.adjustBalance(player, 4000);
				GUI.setBalance(player.getPlayerName(), player.getBalance(player));
			}
		}
		GUI.removeAllCars(player.getPlayerName());
		player.setCurrentField(moveTo);
		GUI.setCar(player.getCurrentField(), player.getPlayerName());		
	}
	
	

}
