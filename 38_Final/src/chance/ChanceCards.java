package chance;

import java.util.Random;

import entities.Player;

public abstract class ChanceCards {

	private Random generator;
	private String cardName;
	private ChanceCards[] chanceCards;

	public ChanceCards(String cardName) {
		this.cardName = cardName;
	}
	
	public void shuffle() {
		for(int i = 0; i < chanceCards.length; i++) {
			int j = generator.nextInt(chanceCards.length);
			ChanceCards tmp = chanceCards[i];
			chanceCards[i] = chanceCards[j];
			chanceCards[j] = tmp;
		}
	}
	
	public ChanceCards drawCard() {
		ChanceCards drawn;
		drawn = chanceCards[0];
		for(int i=0;i<51;i++){
			chanceCards[i]=chanceCards[i+1];
		}
		return drawn;
	}
	
//	public String[] getCards() {
//		return chanceCards;
//	}
	
	public String toString() {
		return cardName;
	}
	
	public abstract void executeCard(Player player);

}
