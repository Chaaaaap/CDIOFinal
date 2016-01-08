package controllers;

import chance.ChanceCard;

public class ChanceCardController {

	private ChanceCard[] chanceCards;

	public ChanceCard drawCard() {
		ChanceCard drawn;
		drawn = chanceCards[0];
		for(int i=0;i<51;i++){
			chanceCards[i]=chanceCards[i+1];
		}
		return drawn;
	}

}
