package chance;

import desktop_resources.GUI;
import entities.Player;

public class ChanceMove extends ChanceCards {
	
	private int antalFelter;

	public ChanceMove(String cardName, int antalFelter) {
		super(cardName);
		this.antalFelter = antalFelter;
	}
	
	@Override
	public void executeCard(Player player) {
		GUI.removeAllCars(player.getPlayerName());
		player.setCurrentField(player.getCurrentField()-antalFelter);
		GUI.setCar(player.getCurrentField(), player.getPlayerName());
	}
}
