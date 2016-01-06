package chance;

import entities.Player;

public class ChanceJailBreak extends ChanceCards {

	public ChanceJailBreak(String cardName) {
		super(cardName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeCard(Player player) {
		player.addJailBreakCounter();
		
	}

}
