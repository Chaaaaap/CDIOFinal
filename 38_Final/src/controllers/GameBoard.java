package controllers;

import entities.Felt;
import entities.Player;
import java.awt.Color;
import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_resources.GUI;

public class GameBoard {

	private DiceCup diceCup;
	Field[] guiFields;
	Felt[] logicFields;

	
	//GameBoard constructor
	public GameBoard(DiceCup cup) {
		guiFields = createGUIFields();;
		diceCup = cup;
		initFields();
//		logicFields = createLogicFields();
		initGUI();
	}
	
	//Initializes the fields as their respective type.
//	private Felt[] createLogicFields() {
//		Felt[] logiskeFelter = new Felt[22];
//		logiskeFelter[0] = new Startfield("Start");
//		logiskeFelter[1] = new Territory(1000, 100, "Tribe Encampment", this);
//		logiskeFelter[2] = new Territory(1500, 300, "Crater", this);
//		logiskeFelter[3] = new Territory(2000, 500, "Mountain", this);
//		logiskeFelter[4] = new Territory(3000, 700, "Cold Desert", this);
//		logiskeFelter[5] = new Territory(4000, 1000, "Black cave", this);
//		logiskeFelter[6] = new Territory(4300, 1300, "The Werewall", this);
//		logiskeFelter[7] = new Territory(4750, 1600, "Mountain village", this);
//		logiskeFelter[8] = new Territory(5000, 2000, "South Citadel", this);
//		logiskeFelter[9] = new Territory(5500, 2600, "Palace gates", this);
//		logiskeFelter[10] = new Territory(6000, 3200, "Tower", this);
//		logiskeFelter[11] = new Territory(8000, 4000, "Castle", this);
//		logiskeFelter[12] = new Refuge(5000, "Walled City");
//		logiskeFelter[13] = new Refuge(500, "Monastery");
//		logiskeFelter[14] = new LaborCamp(2500, "Huts in the mountain", diceCup, this);
//		logiskeFelter[15] = new LaborCamp(2500, "The pit", diceCup, this);
//		logiskeFelter[16] = new Tax(2000, "Goldmine");
//		logiskeFelter[17] = new Tax(4000, "Caravan");
//		logiskeFelter[18] = new Fleet(4000, "Second Sail", this);
//		logiskeFelter[19] = new Fleet(4000, "Sea Grover", this);
//		logiskeFelter[20] = new Fleet(4000, "The Buccaneers", this);
//		logiskeFelter[21] = new Fleet(4000, "Privateer armade", this);
//	
//		return logiskeFelter;
//	}


	private Field[] createGUIFields(){
		//Creates the fields, making them ready to plot into the GUI.
				Field[] newGuiFields = new Field[40];
				newGuiFields[0] = new Start.Builder().setBgColor(Color.RED).build();
				
				for(int i=1; i < 22; i++) {
					Field greyField = new Start.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				for(int i=22; i < 40; i++) {
					Field greyField = new Empty.Builder().build();
					newGuiFields[i] = greyField;
				}
				return newGuiFields;
				
	}
	//Plotting the title and descriptopn in to the fields.
	private void initFields() {
		//Removes subtext for all fields.
		for(int i=0; i< 40; i++)
			guiFields[i].setSubText(" ");
		
		//Initializes every field with Title and description.

		guiFields[0].setTitle("Start"); guiFields[0].setDescription("All players start here."); guiFields[0].setSubText("Start"); 
		guiFields[1].setTitle("Tribe Encampment"); guiFields[1].setDescription("Territory\nPrice: 1000"); guiFields[1].setSubText("Territory");
		guiFields[2].setTitle("Crater"); guiFields[2].setDescription("Territory\nPrice: 1500"); guiFields[2].setSubText("Territory");
		guiFields[3].setTitle("Mountain"); guiFields[3].setDescription("Territory\nPrice: 2000"); guiFields[3].setSubText("Territory");
		guiFields[4].setTitle("Cold Desert"); guiFields[4].setDescription("Territory\nPrice: 3000"); guiFields[4].setSubText("Territory");
		guiFields[5].setTitle("Black Cave"); guiFields[5].setDescription("Territory\nPrice: 4000"); guiFields[5].setSubText("Territory");
		guiFields[6].setTitle("The Werewall"); guiFields[6].setDescription("Territory\nPrice: 4300"); guiFields[6].setSubText("Territory");
		guiFields[7].setTitle("Mountain Village"); guiFields[7].setDescription("Territory\nPrice: 4750"); guiFields[7].setSubText("Territory");
		guiFields[8].setTitle("South Citadel"); guiFields[8].setDescription("Territory\nPrice: 5000"); guiFields[8].setSubText("Territory");
		guiFields[9].setTitle("Palace gates"); guiFields[9].setDescription("Territory\nPrice: 5500"); guiFields[9].setSubText("Territory");
		guiFields[10].setTitle("Tower"); guiFields[10].setDescription("Territory\nPrice: 6000"); guiFields[10].setSubText("Territory");
		guiFields[11].setTitle("Castle"); guiFields[11].setDescription("Territory\nPrice: 8000"); guiFields[11].setSubText("Territory");
		guiFields[12].setTitle("Walled City"); guiFields[12].setDescription("Refuge\nYou receive 5000"); guiFields[12].setSubText("Refuge");
		guiFields[13].setTitle("Monastery"); guiFields[13].setDescription("Refuge\nYou receive 500"); guiFields[13].setSubText("Refuge");
		guiFields[14].setTitle("Huts in the mountain"); guiFields[14].setDescription("Labor camp\nPrice: 2500"); guiFields[14].setSubText("Labor Camp");
		guiFields[15].setTitle("The pit"); guiFields[15].setDescription("Labor camp\nPrice: 2500"); guiFields[15].setSubText("Labor Camp");
		guiFields[16].setTitle("Goldmine"); guiFields[16].setDescription("Tax\nChoose between paying 2000 or 10% of your total assets"); guiFields[16].setSubText("Tax");
		guiFields[17].setTitle("Caravan"); guiFields[17].setDescription("Tax\nChoose between paying 4000 or 10% of your total assets"); guiFields[17].setSubText("Tax");
		guiFields[18].setTitle("Second Sail"); guiFields[18].setDescription("Fleet\nPrice: 4000"); guiFields[18].setSubText("Fleet");
		guiFields[19].setTitle("Sea Grover"); guiFields[19].setDescription("Fleet\nPrice: 4000"); guiFields[19].setSubText("Fleet");
		guiFields[20].setTitle("The Buccaneers"); guiFields[20].setDescription("Fleet\nPrice: 4000"); guiFields[20].setSubText("Fleet");
		guiFields[21].setTitle("Privateer armade"); guiFields[21].setDescription("Fleet\nPrice: 4000"); guiFields[21].setSubText("Fleet");

	}
	
	//Plotting the fields into the GUI and showing welcome message.
	private void initGUI() 
	{
		GUI.create(guiFields);
		GUI.showMessage("Welcome to Matador!\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	
	}

	public void landOnField(int i, Player player){
		logicFields[i].landOnField(player);
	}
	
	public Felt[] getFields() {
		return logicFields;
	}

	public Felt[] getlogicFields() {
		// TODO Auto-generated method stub
		return logicFields;
	}

}

