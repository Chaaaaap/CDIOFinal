package chance;

import entities.Player;

public class ChanceRecieveFromAll extends ChanceCard {
	
	private int amount;
	private Player[] players;
	private Player player;

	public ChanceRecieveFromAll(String cardName, int amount, Player[] players) {
		super(cardName);
		this.amount = amount;
		this.players = players;
//		this.player = player;
	}

	@Override
	public void executeCard(Player player) {
		for(int i = 0; i < players.length; i++) {
			if(!players[i].equals(player)) {
				players[i].transfer(players[i], player, amount);
			}
		}

	}

}
