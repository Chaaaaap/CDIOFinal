package entities;

public class Player 
{
	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String playerName;
	private PlayerAccount playerAccount;
	private int currentField=1, fleetCounter,breweryCounter;
	public boolean isJailed;

	public Player() 
	{
		playerAccount = new PlayerAccount(30000);
		fleetCounter = 0;
		breweryCounter =0;
		
	}

	//Setter method for setting player name.
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	//It simply returns the player name
	public String getPlayerName()
	{
		return playerName;
	}

	public PlayerAccount getPlayerAccount()
	{
		return playerAccount;
	}
	
	public int getCurrentField() {
		return currentField;
	}
	
	public void setCurrentField(int currentField) {
		this.currentField = currentField;
	}
	
	public void addFleetCounter() {
		fleetCounter++;
	}
	
	public int getFleetCounter(Player player) {
		return fleetCounter;
	}

	public void addBreweryCounter() {
		breweryCounter++;
	}
	
	public int getBreweryCounter(Player player) {
		return breweryCounter;
	}

	
	
	public int getBalance(Player player) {
		return player.getPlayerAccount().getBalance();
	}
	
	public void adjustBalance(Player player, int amount) {
		player.getPlayerAccount().adjustBalance(amount);
	}
	
	public void setBalance(Player player, int amount) {
		player.getPlayerAccount().setBalance(amount);
	}
}