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
	private ArrayList<Territory> OwnedProperties;
	
//	tester
	private ArrayList<String> buildingReadyFields;
	private int propertyValue;

	public Player() 
	{
		OwnedProperties = new ArrayList<Territory>();
		buildingReadyFields = new ArrayList<String>();
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
		propertyValue = 0;


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
	
	public int getPropertyValue() {
		return propertyValue;
	}
	
	public void adjustPropertyValue(int amount) {
		if(amount > 0)
			propertyValue += amount;
		else if(amount < 0)
			propertyValue -= amount;
	}

	public void addProperty(Territory territory) {
		OwnedProperties.add(territory);
	}

	public ArrayList<Territory>  getProperty(){
		return OwnedProperties;
	}



	//	public String[] getProperties(){
	//		String[] ownedFieldNames = new String[OwnedProperties.size()];
	//		ownedFieldNames = OwnedProperties.toArray(ownedFieldNames);		
	//		
	//		return ownedFieldNames;
	//	}

		public Territory[] getHusliste(){		
			Territory[] ownedFieldNames = new Territory[OwnedProperties.size()];
			ownedFieldNames = OwnedProperties.toArray(ownedFieldNames);		
	
			return ownedFieldNames;
		}
		
		public String[] getTestliste(){		
			String[] ownedtestNames = new String[buildingReadyFields.size()];
			ownedtestNames = buildingReadyFields.toArray(ownedtestNames);		
	
			return ownedtestNames;
		}
		

		public void addHouseList(){
			if(!buildingReadyFields.contains("Rødovrevej")){
				if(getBlueTerritoryCounter()==2){
					buildingReadyFields.add("Rødovrevej");
					buildingReadyFields.add("Hvidovrevej");
				}
			}
			if(!buildingReadyFields.contains("Roskildevej")){
				if(getPinkTerritoryCounter()==3){
					buildingReadyFields.add("Roskildevej");
					buildingReadyFields.add("Valby Langgade");
					buildingReadyFields.add("Allégade");
				}
			}
			if(!buildingReadyFields.contains("Frederiksberg Allé")){
				if(getGreenTerritoryCounter()==3){
					buildingReadyFields.add("Frederiksberg Allé");
					buildingReadyFields.add("Bülowsvej");
					buildingReadyFields.add("GL. Kongevej");
				}
			}
			if(!buildingReadyFields.contains("Bernstoffvej")){
				if(getGrayTerritoryCounter()==3){
					buildingReadyFields.add("Bernstoffvej");
					buildingReadyFields.add("Hellerupvej");
					buildingReadyFields.add("Strandvej");
				}
			}
			if(!buildingReadyFields.contains("Trianglen")){
				if(getRedTerritoryCounter()==3){
					buildingReadyFields.add("Trianglen");
					buildingReadyFields.add("Østerbrogade");
					buildingReadyFields.add("Grønningen");
				}
			}
			if(!buildingReadyFields.contains("Bredgade")){
				if(getWhiteTerritoryCounter()==3){
					buildingReadyFields.add("Bredgade");
					buildingReadyFields.add("Kgs. Nytorv");
					buildingReadyFields.add("Østergade");
				}
			}
			if(!buildingReadyFields.contains("Amagertorv")){
				if(getYellowTerritoryCounter()==3){
					buildingReadyFields.add("Amagertorv");
					buildingReadyFields.add("Vimmelskaftet");
					buildingReadyFields.add("Nygade");
				}
			}
			if(!buildingReadyFields.contains("Frederiksberggade")){
				if(getMagentaTerritoryCounter()==2){
					buildingReadyFields.add("Frederiksberggade");
					buildingReadyFields.add("Rådhuspladsen");
				}
			}	
		}


}