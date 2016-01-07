package chance;

import java.util.Random;

import entities.Player;

public abstract class ChanceCards {

	private Random generator;
	private String cardName;

	public ChanceCards(String cardName) {
		this.cardName = cardName;
	}
	
	public void shuffle(ChanceCards[] chanceCards) {
		for(int i = 0; i < chanceCards.length; i++) {
			int j = generator.nextInt(chanceCards.length);
			ChanceCards tmp = chanceCards[i];
			chanceCards[i] = chanceCards[j];
			chanceCards[j] = tmp;
		}
	}
	
//	public void drawCard() {
//		ChanceCards drawn;
//		drawn = chanceCards[0];
//		for(int i=0;i<51;i++){
//			chanceCards[i]=chanceCards[i+1];
//		}
//	}
	
//	public String[] getCards() {
//		return chanceCards;
//	}
	
	public abstract void executeCard(Player player);

}