package controllers;

import entities.*;
import entities.Felt;
import entities.Player;
import entities.StartField;

import java.awt.Color;

import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;

public class GameBoard {

	private DiceCup diceCup;
	private Field[] guiFields;
	private Felt[] logicFields;

	
	//GameBoard constructor
	public GameBoard(DiceCup cup) {
		guiFields = createGUIFields();;
		diceCup = cup;
		initFields();
		logicFields = createLogicFields();
		initGUI();
	}
	
	//Initializes the fields as their respective type.
	private Felt[] createLogicFields() {
		Felt[] logiskeFelter = new Felt[40];
		logiskeFelter[0] = new StartField("Start");
		logiskeFelter[1] = new Territory(1200, "Rødovrevej", this);
		logiskeFelter[2] = new ChanceField("Prøv Lykken");
		logiskeFelter[3] = new Territory(1200, "Hvidovrevej", this);
		logiskeFelter[4] = new Tax(4000, "Betal indkomstskat");
		logiskeFelter[5] = new ShippingCompany(4000, "SFL-Færgerne", this);
		logiskeFelter[6] = new Territory(2000, "Roskildevej", this);
		logiskeFelter[7] = new ChanceField("Prøv Lykken");
		logiskeFelter[8] = new Territory(2000, "Valby Langgade", this);
		logiskeFelter[9] = new Territory(2400, "Allégade", this);
		logiskeFelter[10] = new Jail("I Fængsel");
		logiskeFelter[11] = new Territory(2800, "Frederiksberg Allé", this);
		logiskeFelter[12] = new Brewery(3000, "Tuborg", this);
		logiskeFelter[13] = new Territory(2800, "Bülowsvej", this);
		logiskeFelter[14] = new Territory(3200, "Gl. Kongevej", this);
		logiskeFelter[15] = new ShippingCompany(4000, "DSB Kalundborg/Århus", this);
		logiskeFelter[16] = new Territory(3600, "Bernstorffsvej", this);
		logiskeFelter[17] = new ChanceField("Prøv Lykken");
		logiskeFelter[18] = new Territory(3600, "Hellerupvej", this);
		logiskeFelter[19] = new Territory(4000, "Strandvej", this);
		logiskeFelter[20] = new Parking("Parkering");
		logiskeFelter[21] = new Territory(4400, "Trianglen", this);
		logiskeFelter[22] = new ChanceField("Prøv Lykken");
		logiskeFelter[23] = new Territory(4400, "Østerbrogade", this);
		logiskeFelter[24] = new Territory(4800, "Grønningen", this);
		logiskeFelter[25] = new ShippingCompany(4000, "DFDS Seaways", this);
		logiskeFelter[26] = new Territory(5200, "Bredgade", this);
		logiskeFelter[27] = new Territory(5200, "Kgs. Nytorv", this);
		logiskeFelter[28] = new Brewery(3000, "Coca-Cola", this);
		logiskeFelter[29] = new Territory(5600, "Østergade", this);
		logiskeFelter[30] = new GoToJail("De Fængsles");
		logiskeFelter[31] = new Territory(6000, "Amagertorv", this);
		logiskeFelter[32] = new Territory(6000, "Vimmelskaftet", this);
		logiskeFelter[33] = new ChanceField("Prøv Lykken");
		logiskeFelter[34] = new Territory(6400, "Nygade", this);
		logiskeFelter[35] = new ShippingCompany(4000, "DSB Halsskov/Knudshoved", this);
		logiskeFelter[36] = new ChanceField("Prøv Lykken");
		logiskeFelter[37] = new Territory(7000, "Frederiksberggade", this);
		logiskeFelter[38] = new Tax(2000, "Ekstraordinær statsskat");
		logiskeFelter[39] = new Territory(8000, "Rådhuspladsen", this);
	
		return logiskeFelter;
	}


	private Field[] createGUIFields(){
		//Creates the fields, making them ready to plot into the GUI.
				Field[] newGuiFields = new Field[40];
				newGuiFields[0] = new Start.Builder().setBgColor(Color.RED).build();
				
//				Field blueField = new Street.Builder().setBgColor(Color.BLUE).build();
				newGuiFields[1] = new Street.Builder().setBgColor(Color.BLUE).build();
				newGuiFields[3] = new Street.Builder().setBgColor(Color.BLUE).build();
//				
//				Field orangeField = new Start.Builder().setBgColor(Color.ORANGE).build();
				newGuiFields[6] = new Street.Builder().setBgColor(Color.ORANGE).build();
				newGuiFields[8] = new Street.Builder().setBgColor(Color.ORANGE).build();
				newGuiFields[9] = new Street.Builder().setBgColor(Color.ORANGE).build();
//				
//				Field greenField = new Street.Builder().setBgColor(Color.GREEN).build();
				newGuiFields[11] = new Street.Builder().setBgColor(Color.GREEN).build();
				newGuiFields[13] = new Street.Builder().setBgColor(Color.GREEN).build();
				newGuiFields[14] = new Street.Builder().setBgColor(Color.GREEN).build();
//				
//				Field grayField = new Start.Builder().setBgColor(Color.GRAY).build();
				newGuiFields[10] = new Street.Builder().setBgColor(Color.GRAY).build();
				newGuiFields[16] = new Street.Builder().setBgColor(Color.GRAY).build();
				newGuiFields[18] = new Street.Builder().setBgColor(Color.GRAY).build();
				newGuiFields[19] = new Street.Builder().setBgColor(Color.GRAY).build();
				newGuiFields[30] = new Street.Builder().setBgColor(Color.GRAY).build();
//				
//				Field redField = new Street.Builder().setBgColor(Color.RED).build();
				newGuiFields[21] = new Street.Builder().setBgColor(Color.RED).build();
				newGuiFields[23] = new Street.Builder().setBgColor(Color.RED).build();
				newGuiFields[24] = new Street.Builder().setBgColor(Color.RED).build();
//				
//				Field whiteField = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[5] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[15] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[20] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[25] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[26] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[27] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[29] = new Start.Builder().setBgColor(Color.WHITE).build();
				newGuiFields[35] = new Start.Builder().setBgColor(Color.WHITE).build();
//				
//				Field yellowField = new Start.Builder().setBgColor(Color.YELLOW).build();
				newGuiFields[31] = new Start.Builder().setBgColor(Color.YELLOW).build();
				newGuiFields[32] = new Start.Builder().setBgColor(Color.YELLOW).build();
				newGuiFields[34] = new Start.Builder().setBgColor(Color.YELLOW).build();
//				
//				Field magentaField = new Start.Builder().setBgColor(Color.MAGENTA).build();
				newGuiFields[37] = new Start.Builder().setBgColor(Color.MAGENTA).build();
				newGuiFields[39] = new Start.Builder().setBgColor(Color.MAGENTA).build();
//				
//				Field blackField = new Chance.Builder().setBgColor(Color.BLACK).build();
				newGuiFields[2] = new Chance.Builder().setBgColor(Color.CYAN).build();
				newGuiFields[7] = new Chance.Builder().setBgColor(Color.CYAN).build();
				newGuiFields[17] = new Chance.Builder().setBgColor(Color.CYAN).build();
				newGuiFields[22] = new Chance.Builder().setBgColor(Color.CYAN).build();
				newGuiFields[33] = new Chance.Builder().setBgColor(Color.CYAN).build();
				newGuiFields[36] = new Chance.Builder().setBgColor(Color.CYAN).build();
//				
//				Field darkGrayField = new Start.Builder().setBgColor(Color.DARK_GRAY).build();
				newGuiFields[4] = new Start.Builder().setBgColor(Color.DARK_GRAY).build();
				newGuiFields[38] = new Start.Builder().setBgColor(Color.DARK_GRAY).build();
//				
//				Field pinkField = new Start.Builder().setBgColor(Color.PINK).build();
				newGuiFields[12] = new Street.Builder().setBgColor(Color.PINK).build();
				newGuiFields[28] = new Street.Builder().setBgColor(Color.PINK).build();
//
				return newGuiFields;
				
	}
	//Plotting the title and descriptopn in to the fields.
	private void initFields() {
		//Removes subtext for all fields.
		for(int i=0; i < guiFields.length; i++)
			guiFields[i].setSubText(" ");
		
		//Initializes every field with Title and description.

		guiFields[0].setTitle("Start"); guiFields[0].setDescription("Start\nHvergang De passere modtag kr. 4000"); guiFields[0].setSubText("Start"); 
		guiFields[1].setTitle("Rødovrevej"); guiFields[1].setDescription("Territory\nPris: 1200\nLeje: 100\nHus: 1000\nHotel: 1000"); guiFields[1].setSubText("Territory");
		guiFields[2].setTitle("Prøv Lykken"); guiFields[2].setDescription("Chance\nTræk et kort"); guiFields[2].setSubText("Chance");
		guiFields[3].setTitle("Hvidovrevej"); guiFields[3].setDescription("Territory\nPris: 1200\nLeje: 100\nHus: 1000\nHotel: 1000"); guiFields[3].setSubText("Territory");
		guiFields[4].setTitle("Betal indkomstskat"); guiFields[4].setDescription("Tax\nBetal indkomstskat 10% eller kr. 4000"); guiFields[4].setSubText("Tax");
		guiFields[5].setTitle("SFL-Færgerne"); guiFields[5].setDescription("Shipping Company\nPris: 4000\nLeje: 500"); guiFields[5].setSubText("Shipping Company");
		guiFields[6].setTitle("Roskildevej"); guiFields[6].setDescription("Territory\nPris: 2000\nLeje: 100\nHus: 1000\nHotel: 1000"); guiFields[6].setSubText("Territory");
		guiFields[7].setTitle("Prøv Lykken"); guiFields[7].setDescription("Chance\nTræk et kort"); guiFields[7].setSubText("Chance");
		guiFields[8].setTitle("Valby Langgade"); guiFields[8].setDescription("Territory\nPris: 2000\nLeje: 100\nHus: 1000\nHotel: 1000"); guiFields[8].setSubText("Territory");
		guiFields[9].setTitle("Allégade"); guiFields[9].setDescription("Territory\nPris: 2400\nLeje: 150\nHus: 1000\nHotel: 1000"); guiFields[9].setSubText("Territory");
		guiFields[10].setTitle("I Fængsel"); guiFields[10].setDescription("Jail"); guiFields[10].setSubText("Jail");
		guiFields[11].setTitle("Frederiksberg Allé"); guiFields[11].setDescription("Territory\nPris: 2800\nLeje: 200\nHus: 2000\nHotel: 2000"); guiFields[11].setSubText("Territory");
		guiFields[12].setTitle("Tuborg Bryggeri"); guiFields[12].setDescription("Brewery\nLeje: 100 x antal øjne"); guiFields[12].setSubText("Brewery");
		guiFields[13].setTitle("Bülowsvej"); guiFields[13].setDescription("Territory\nPris: 2800\nLeje: 200\nHus: 2000\nHotel: 2000"); guiFields[13].setSubText("Territory");
		guiFields[14].setTitle("Gl. Kongevej"); guiFields[14].setDescription("Territory\nPris: 3200\nLeje: 250\nHus: 2000\nHotel: 2000"); guiFields[14].setSubText("Territory");
		guiFields[15].setTitle("DSB Kalundborg/Århus"); guiFields[15].setDescription("Shipping Company\nPris: 4000\nLeje: 500"); guiFields[15].setSubText("Shipping Company");
		guiFields[16].setTitle("Bernstorffvej"); guiFields[16].setDescription("Territory\nPris: 3600\nLeje: 300\nHus: 2000\nHotel: 2000"); guiFields[16].setSubText("Territory");
		guiFields[17].setTitle("Prøv Lykken"); guiFields[17].setDescription("Chance\nTræk et kort"); guiFields[17].setSubText("Chance");
		guiFields[18].setTitle("Hellerupvej"); guiFields[18].setDescription("Territory\nPris: 3600\nLeje: 300\nHus: 2000\nHotel: 2000"); guiFields[18].setSubText("Territory");
		guiFields[19].setTitle("Strandvej"); guiFields[19].setDescription("Territory\nPris: 4000\nLeje: 350\nHus: 2000\nHotel: 2000"); guiFields[19].setSubText("Territory");
		guiFields[20].setTitle("Parkering"); guiFields[20].setDescription("Parking\nDer sker ingenting her!"); guiFields[20].setSubText("Parking");
		guiFields[21].setTitle("Trianglen"); guiFields[21].setDescription("Territory\nPris: 4400\nLeje: 350\nHus: 3000\nHotel: 3000"); guiFields[21].setSubText("Territory");
		guiFields[22].setTitle("Prøv Lykken"); guiFields[22].setDescription("Chance\nTræk et kort"); guiFields[22].setSubText("Chance");
		guiFields[23].setTitle("Østerbrogade"); guiFields[23].setDescription("Territory\nPris: 4400\nLeje: 350\nHus: 3000\nHotel: 3000"); guiFields[23].setSubText("Territory");
		guiFields[24].setTitle("Grønningen"); guiFields[24].setDescription("Territory\nPris: 4800\nLeje: 400\nHus: 3000\nHotel: 3000"); guiFields[24].setSubText("Territory");
		guiFields[25].setTitle("DFDS Seaways"); guiFields[25].setDescription("Shipping Company\nPris: 4000\nLeje: 500"); guiFields[25].setSubText("Shipping Company");
		guiFields[26].setTitle("Bredgade"); guiFields[26].setDescription("Territory\nPris: 5200\nLeje: 450\nHus: 3000\nHotel: 3000"); guiFields[26].setSubText("Territory");
		guiFields[27].setTitle("Kgs. Nytorv"); guiFields[27].setDescription("Territory\nPris: 5200\nLeje: 450\nHus: 3000\nHotel: 3000"); guiFields[27].setSubText("Territory");
		guiFields[28].setTitle("Coca-Cola Tapperi"); guiFields[28].setDescription("Brewery\nLeje: 100 x antal øjne"); guiFields[28].setSubText("Brewery");
		guiFields[29].setTitle("Østergade"); guiFields[29].setDescription("Territory\nPris: 5600\nLeje: 500\nHus: 3000\nHotel: 3000"); guiFields[29].setSubText("Territory");
		guiFields[30].setTitle("De Fængsles"); guiFields[30].setDescription("Go To Jail\nDu bliver overført til fængslet"); guiFields[30].setSubText("GoToJail");
		guiFields[31].setTitle("Amagertorv"); guiFields[31].setDescription("Territory\nPris: 6000\nLeje: 550\nHus: 4000\nHotel: 4000"); guiFields[31].setSubText("Territory");
		guiFields[32].setTitle("Vimmelskaftet"); guiFields[32].setDescription("Territory\nPris: 6000\nLeje: 550\nHus: 4000\nHotel: 4000"); guiFields[32].setSubText("Territory");
		guiFields[33].setTitle("Prøv Lykken"); guiFields[33].setDescription("Chance\nTræk et kort"); guiFields[33].setSubText("Chance");
		guiFields[34].setTitle("Nygade"); guiFields[34].setDescription("Territory\nPris: 6400\nLeje: 600\nHus: 4000\nHotel: 4000"); guiFields[34].setSubText("Territory");
		guiFields[35].setTitle("DSB Halsskov/Knudshoved"); guiFields[35].setDescription("Shipping Company\nPris: 4000\nLeje: 500"); guiFields[35].setSubText("Shipping Company");
		guiFields[36].setTitle("Prøv Lykken"); guiFields[36].setDescription("Chance\nTræk et kort"); guiFields[36].setSubText("Chance");
		guiFields[37].setTitle("Frederiksberggade"); guiFields[37].setDescription("Territory\nPris: 7000\nLeje: 700\nHus: 4000\nHotel: 4000"); guiFields[37].setSubText("Territory");
		guiFields[38].setTitle("Ekstraordinær statsskat"); guiFields[38].setDescription("Tax\nEkstraordinær statsskat betal kr. 2000"); guiFields[38].setSubText("Tax");
		guiFields[39].setTitle("Rådhuspladsen"); guiFields[39].setDescription("Territory\nPris: 8000\nLeje: 1000\nHus: 4000\nHotel: 4000"); guiFields[39].setSubText("Territory");




	}
	
	//Plotting the fields into the GUI and showing welcome message.
	private void initGUI() 
	{
		
//		for (Field field : guiFields) {
//			System.out.println(field);
//		}
//		System.out.println(guiFields.length);
		
		GUI.create(guiFields);
		GUI.showMessage("Welcome to Matador!\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	
	}

	public void landOnField(int i, Player player){
		logicFields[i].landOnField(player);
	}
	
	public Field[] getGUIFields() {
		return guiFields;
	}

	public Felt[] getlogicFields() {
		// TODO Auto-generated method stub
		return logicFields;
	}

	
}

