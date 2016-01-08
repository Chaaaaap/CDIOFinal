package chance;

import java.util.Random;

import entities.Player;

public abstract class ChanceCard {

	private Random generator;
	private String cardName;
	private ChanceCard[] chanceCards;

	public ChanceCard(String cardName) {
		this.cardName = cardName;
	}
	
	public void shuffle() {
		for(int i = 0; i < chanceCards.length; i++) {
			int j = generator.nextInt(chanceCards.length);
			ChanceCard tmp = chanceCards[i];
			chanceCards[i] = chanceCards[j];
			chanceCards[j] = tmp;
		}
	}
	
	public ChanceCard drawCard() {
		ChanceCard drawn;
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
