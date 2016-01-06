package entities;

import java.util.Random;

public class ChanceCards {
	
	Random generator;

	private String[] chanceCards = new String[] {
	"ChanceFerry",
	"ChanceJail",
	"ChancePayFine",
	"ChancePayInsurence",
	"ChanceShip",
	"ChanceAktie",
	"ChanceBirthday",
	"ChanceFine",
	"ChanceTown",
	"ChanceBond",
	"ChanceKing",
	"ChanceOil",
	"ChanceMove",
	"ChanceLottery",
	"ChanceRepair",
	"ChanceTax",
	"ChanceShippingCompany",
	"ChanceGrønningen",
	"ChancePropertyTax",
	"ChanceTipning",
	"ChanceStart",
	"ChanceMatador",
	"ChanceGarden",
	"ChanceDentist",
	"ChanceAbroad",
	"ChanceFrederiksberg",
	"ChanceDyrtid",
	"ChanceAktie",
	"ChanceAktie",
	"ChanceAktie",
	"ChanceAktie",
	"ChanceKing",
	"ChanceRepair"
	};

	private String cardName;

	public ChanceCards(String cardName) {
		this.cardName = cardName;
	}
	
	public void shuffle() {
		for(int i = 0; i < chanceCards.length; i++) {
			int j = generator.nextInt(chanceCards.length);
			String tmp = chanceCards[i];
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
	
	public String[] getCards() {
		return chanceCards;
	}
	
	public String toString() {
		return cardName;
	}

}
