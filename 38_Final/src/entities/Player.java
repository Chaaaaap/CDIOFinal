package entities;

import java.util.ArrayList;
import entities.Territory;

public class Player 
{
	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String playerName;
	private PlayerAccount playerAccount;
	private int currentField=1, fleetCounter,breweryCounter,jailRollCounter,freeCardCounter;
	public boolean isJailed;
	private int hotelCounter;
	private int houseCounter;
	private int jailBreakCounter;
	private ArrayList<Territory> OwnedProperties;

	public Player() 
	{
		OwnedProperties = new ArrayList<Territory>();
		playerAccount = new PlayerAccount(30000);
		fleetCounter = 0;
		breweryCounter = 0;
		houseCounter = 0;
		hotelCounter = 0;
		jailRollCounter = 0;
		freeCardCounter = 0;
		
		
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
	
	public void addHouseCounter() {
		houseCounter++;
	}
	
	public int getHouseCounter() {
		return houseCounter;
	}
	
	public void addHotelCounter() {
		hotelCounter++;
	}
	
	public int getHotelCounter() {
		return hotelCounter;
	}

	public void setJailRoll(int JailRollCounter)
	{
		this.jailRollCounter = JailRollCounter;
	}

	public int getJailRoll()
	{
		return jailRollCounter;
	}
	
	public void addJailRollCounter() {
		jailRollCounter++;
	}
	
	public int getFreeCard()
	{
		return freeCardCounter;
	}
	
	public void addFreeCard() {
		freeCardCounter++;
	}
	
	public void useFreeCard() {
		freeCardCounter--;
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

	public void addJailBreakCounter() {
		jailBreakCounter++;		
	}
	
	public void useJailBreakCounter() {
		if(jailBreakCounter > 0)
			jailBreakCounter--;
	}
	
	public void addProperty(Territory territory) {
	
		OwnedProperties.add(territory);
	}
	
	public ArrayList<Territory>  getProperty(){
		return OwnedProperties;
	}
	
	
}