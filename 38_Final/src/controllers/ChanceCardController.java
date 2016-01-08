package controllers;

import java.util.Random;

import chance.ChanceCard;

public class ChanceCardController {

	private ChanceCard[] chanceCards;
	private Random generator;

	public ChanceCard drawCard() {
		ChanceCard drawn;
		drawn = chanceCards[0];
		for(int i=0;i<51;i++){
			chanceCards[i]=chanceCards[i+1];
		}
		return drawn;
	}
	
	public void shuffle() {
		for(int i = 0; i < chanceCards.length; i++) {
			int j = generator.nextInt(chanceCards.length);
			ChanceCard tmp = chanceCards[i];
			chanceCards[i] = chanceCards[j];
			chanceCards[j] = tmp;
		}
	}

}
