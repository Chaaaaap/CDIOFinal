package entities;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import entities.Territory;

public class Player 
{
	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String playerName;
	private PlayerAccount playerAccount;
	private int currentField=1, fleetCounter,breweryCounter,jailRollCounter,freeCardCounter, blueTerritoryCounter, pinkTerritoryCounter, 
			greenTerritoryCounter, grayTerritoryCounter, redTerritoryCounter, whiteTerritoryCounter, yellowTerritoryCounter, magentaTerritoryCounter;
	public boolean isJailed;
	private int hotelCounter;
	private int houseCounter;
	private int jailBreakCounter;
	private ArrayList<String> OwnedProperties;

	public Player() 
	{
		OwnedProperties = new ArrayList<String>();
		playerAccount = new PlayerAccount(30000);
		fleetCounter = 0;
		breweryCounter = 0;
		houseCounter = 0;
		hotelCounter = 0;
		jailRollCounter = 0;
		freeCardCounter = 0;
		blueTerritoryCounter = 0;
		pinkTerritoryCounter = 0;
		greenTerritoryCounter = 0;
		grayTerritoryCounter = 0;
		redTerritoryCounter = 0;
		whiteTerritoryCounter = 0;
		yellowTerritoryCounter = 0;
		magentaTerritoryCounter = 0;



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

	public void addBlueTerritoryCounter() {
		blueTerritoryCounter++;
	}

	public int getBlueTerritoryCounter() {
		return blueTerritoryCounter;
	}

	public void addPinkTerritoryCounter() {
		pinkTerritoryCounter++;
	}

	public int getPinkTerritoryCounter() {
		return pinkTerritoryCounter;
	}

	public void addGreenTerritoryCounter() {
		greenTerritoryCounter++;
	}

	public int getGreenTerritoryCounter() {
		return greenTerritoryCounter;
	}

	public void addGrayTerritoryCounter() {
		grayTerritoryCounter++;
	}

	public int getGrayTerritoryCounter() {
		return grayTerritoryCounter;
	}

	public void addRedTerritoryCounter() {
		redTerritoryCounter++;
	}

	public int getRedTerritoryCounter() {
		return redTerritoryCounter;
	}

	public void addWhiteTerritoryCounter() {
		whiteTerritoryCounter++;
	}

	public int getWhiteTerritoryCounter() {
		return whiteTerritoryCounter;
	}

	public void addYellowTerritoryCounter() {
		yellowTerritoryCounter++;
	}

	public int getYellowTerritoryCounter() {
		return yellowTerritoryCounter;
	}

	public void addMagentaTerritoryCounter() {
		magentaTerritoryCounter++;
	}

	public int getMagentaTerritoryCounter() {
		return magentaTerritoryCounter;
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
		if(freeCardCounter > 0)
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

	public void transfer(Player fromPlayer, Player toPlayer, int amount) {
		fromPlayer.getPlayerAccount().transfer(toPlayer.getPlayerAccount(), amount);
	}

	public boolean isBankrupt(Player player) {
		return player.getPlayerAccount().isBankrupt();
	}

	//	public void addProperty(String feltNavn) {
	//			OwnedProperties.add(feltNavn);
	//	}

	public ArrayList<String>  getProperty(){
		return OwnedProperties;
	}

	//	public String[] getProperties(){
	//		String[] ownedFieldNames = new String[OwnedProperties.size()];
	//		ownedFieldNames = OwnedProperties.toArray(ownedFieldNames);		
	//		
	//		return ownedFieldNames;
	//	}

	public String[] getHusliste(){		
		String[] ownedFieldNames = new String[OwnedProperties.size()];
		ownedFieldNames = OwnedProperties.toArray(ownedFieldNames);		

		return ownedFieldNames;
	}

	public void addHouseList(){
		if(!OwnedProperties.contains("Rødovrevej")){
			if(getBlueTerritoryCounter()==2){
				OwnedProperties.add("Rødovrevej");
				OwnedProperties.add("Hvidovrevej");
			}
		}
		if(!OwnedProperties.contains("Roskildevej")){
			if(getPinkTerritoryCounter()==3){
				OwnedProperties.add("Roskildevej");
				OwnedProperties.add("Valby Langgade");
				OwnedProperties.add("Allégade");
			}
		}
		if(!OwnedProperties.contains("Frederiksberg Allé")){
			if(getGreenTerritoryCounter()==3){
				OwnedProperties.add("Frederiksberg Allé");
				OwnedProperties.add("Bülowsvej");
				OwnedProperties.add("GL. Kongevej");
			}
		}
		if(!OwnedProperties.contains("Bernstoffvej")){
			if(getGrayTerritoryCounter()==3){
				OwnedProperties.add("Bernstoffvej");
				OwnedProperties.add("Hellerupvej");
				OwnedProperties.add("Strandvej");
			}
		}
		if(!OwnedProperties.contains("Trianglen")){
			if(getRedTerritoryCounter()==3){
				OwnedProperties.add("Trianglen");
				OwnedProperties.add("Østerbrogade");
				OwnedProperties.add("Grønningen");
			}
		}
		if(!OwnedProperties.contains("Bredgade")){
			if(getWhiteTerritoryCounter()==3){
				OwnedProperties.add("Bredgade");
				OwnedProperties.add("Kgs. Nytorv");
				OwnedProperties.add("Østergade");
			}
		}
		if(!OwnedProperties.contains("Amagertorv")){
			if(getYellowTerritoryCounter()==3){
				OwnedProperties.add("Amagertorv");
				OwnedProperties.add("Vimmelskaftet");
				OwnedProperties.add("Nygade");
			}
		}
		if(!OwnedProperties.contains("Frederiksberggade")){
			if(getMagentaTerritoryCounter()==2){
				OwnedProperties.add("Frederiksberggade");
				OwnedProperties.add("Rådhuspladsen");
			}
		}
		
		
		
	}


}