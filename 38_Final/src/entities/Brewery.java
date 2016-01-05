package entities;

import controllers.GameBoard;

public class Brewery extends Ownable {

	public Brewery(int pris, String feltNavn, GameBoard gb) {
		super(pris, feltNavn, gb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRent(Player player) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOwner(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buyFieldOption(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFeltBesked(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pawnField(Player player) {
		// TODO Auto-generated method stub
		
	}
}
