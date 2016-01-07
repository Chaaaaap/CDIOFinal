package controllers;

import entities.*;

import java.awt.Color;
import java.util.ResourceBundle;

import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;

public class GameBoard {

	private DiceCup diceCup;
	private Field[] guiFields;
	private Felt[] logicFields;
	private ResourceBundle rb;
	private String languageChosen;
	private String language;
	private String country;
	private LanguageSelector ls;


	//GameBoard constructor
	public GameBoard(DiceCup cup) {
		guiFields = createGUIFields();;
		diceCup = cup;
		initFields();
		logicFields = createLogicFields();
		initGUI();
		
	}

	public GameBoard(DiceCup cup, LanguageSelector ls) {
		guiFields = createGUIFields();;
		diceCup = cup;
		initFields();
		initGUI();	
		languageChosen = GUI.getUserButtonPressed("Vælg Sprog / Select Language", "Dansk", "English");
		languageSelect(languageChosen);
		rb = ls.selectLanguage(language, country);
		logicFields = createLogicFields();
		GUI.showMessage(rb.getString("Velkommen"));
	}
	
	private void languageSelect(String languageChosen2) {
		if(languageChosen.equalsIgnoreCase("Dansk")) {
			language = "da";
			country = "DK";
		} else {
			language = "en";
			country = "US";
		}
		
	}

	public ResourceBundle getBundle() {
		return rb;
	}
	//Initializes the fields as their respective type.
	private Felt[] createLogicFields() {
		Felt[] logiskeFelter = new Felt[40];
		logiskeFelter[0] = new StartField("Start", this, rb);
		logiskeFelter[1] = new Territory(1200, 100, "Rødovrevej", this, rb);
		logiskeFelter[2] = new ChanceField("Prøv Lykken", this, rb);
		logiskeFelter[3] = new Territory(1200, 100, "Hvidovrevej", this, rb);
		logiskeFelter[4] = new Tax(4000, "Betal indkomstskat", this, rb);
		logiskeFelter[5] = new ShippingCompany(4000, "SFL-Færgerne", this, rb);
		logiskeFelter[6] = new Territory(2000, 100, "Roskildevej", this, rb);
		logiskeFelter[7] = new ChanceField("Prøv Lykken", this, rb);
		logiskeFelter[8] = new Territory(2000, 100, "Valby Langgade", this, rb);
		logiskeFelter[9] = new Territory(2400, 150, "Allégade", this, rb);
		logiskeFelter[10] = new Jail("I Fængsel", this, rb);
		logiskeFelter[11] = new Territory(2800, 200, "Frederiksberg Allé", this, rb);
		logiskeFelter[12] = new Brewery(3000, "Tuborg",diceCup, this, rb);
		logiskeFelter[13] = new Territory(2800, 200, "Bülowsvej", this, rb);
		logiskeFelter[14] = new Territory(3200, 250, "Gl. Kongevej", this, rb);
		logiskeFelter[15] = new ShippingCompany(4000, "DSB Kalundborg/Århus", this, rb);
		logiskeFelter[16] = new Territory(3600, 300, "Bernstorffsvej", this, rb);
		logiskeFelter[17] = new ChanceField("Prøv Lykken", this, rb);
		logiskeFelter[18] = new Territory(3600, 300, "Hellerupvej", this, rb);
		logiskeFelter[19] = new Territory(4000, 350, "Strandvej", this, rb);
		logiskeFelter[20] = new Parking("Parkering", this, rb);
		logiskeFelter[21] = new Territory(4400, 350, "Trianglen", this, rb);
		logiskeFelter[22] = new ChanceField("Prøv Lykken", this, rb);
		logiskeFelter[23] = new Territory(4400, 350, "Østerbrogade", this, rb);
		logiskeFelter[24] = new Territory(4800, 400, "Grønningen", this, rb);
		logiskeFelter[25] = new ShippingCompany(4000, "DFDS Seaways", this, rb);
		logiskeFelter[26] = new Territory(5200, 450, "Bredgade", this, rb);
		logiskeFelter[27] = new Territory(5200, 450, "Kgs. Nytorv", this, rb);
		logiskeFelter[28] = new Brewery(3000, "Coca-Cola",diceCup, this, rb);
		logiskeFelter[29] = new Territory(5600, 500, "Østergade", this, rb);
		logiskeFelter[30] = new GoToJail("De Fængsles", this, rb);
		logiskeFelter[31] = new Territory(6000, 550, "Amagertorv", this, rb);
		logiskeFelter[32] = new Territory(6000, 550, "Vimmelskaftet", this, rb);
		logiskeFelter[33] = new ChanceField("Prøv Lykken", this, rb);
		logiskeFelter[34] = new Territory(6400, 600,  "Nygade", this, rb);
		logiskeFelter[35] = new ShippingCompany(4000, "DSB Halsskov/Knudshoved", this, rb);
		logiskeFelter[36] = new ChanceField("Prøv Lykken", this, rb);
		logiskeFelter[37] = new Territory(7000, 700, "Frederiksberggade", this, rb);
		logiskeFelter[38] = new Tax(2000, "Ekstraordinær statsskat", this, rb);
		logiskeFelter[39] = new Territory(8000, 1000, "Rådhuspladsen", this, rb);

		return logiskeFelter;
	}


	private Field[] createGUIFields(){
		//Creates the fields, making them ready to plot into the GUI.
		Field[] newGuiFields = new Field[40];
		newGuiFields[0] = new Start.Builder().setBgColor(Color.RED).build();

		newGuiFields[1] = new Start.Builder().setBgColor(Color.BLUE).build();
		newGuiFields[2] = new Chance.Builder().setBgColor(Color.CYAN).build();
		newGuiFields[3] = new Start.Builder().setBgColor(Color.BLUE).build();
		newGuiFields[4] = new Start.Builder().setBgColor(Color.DARK_GRAY).build();
		newGuiFields[5] = new Start.Builder().setBgColor(Color.LIGHT_GRAY).build();
		newGuiFields[6] = new Start.Builder().setBgColor(Color.PINK).build();
		newGuiFields[7] = new Chance.Builder().setBgColor(Color.CYAN).build();
		newGuiFields[8] = new Start.Builder().setBgColor(Color.PINK).build();
		newGuiFields[9] = new Start.Builder().setBgColor(Color.PINK).build();
		newGuiFields[10] = new Start.Builder().setBgColor(Color.GRAY).build();
		newGuiFields[11] = new Start.Builder().setBgColor(Color.GREEN).build();
		newGuiFields[12] = new Start.Builder().setBgColor(Color.ORANGE).build();
		newGuiFields[13] = new Start.Builder().setBgColor(Color.GREEN).build();
		newGuiFields[14] = new Start.Builder().setBgColor(Color.GREEN).build();
		newGuiFields[15] = new Start.Builder().setBgColor(Color.LIGHT_GRAY).build();
		newGuiFields[16] = new Start.Builder().setBgColor(Color.GRAY).build();
		newGuiFields[17] = new Chance.Builder().setBgColor(Color.CYAN).build();
		newGuiFields[18] = new Start.Builder().setBgColor(Color.GRAY).build();
		newGuiFields[19] = new Start.Builder().setBgColor(Color.GRAY).build();
		newGuiFields[20] = new Start.Builder().setBgColor(Color.WHITE).build();
		newGuiFields[21] = new Start.Builder().setBgColor(Color.RED).build();
		newGuiFields[22] = new Chance.Builder().setBgColor(Color.CYAN).build();
		newGuiFields[23] = new Start.Builder().setBgColor(Color.RED).build();
		newGuiFields[24] = new Start.Builder().setBgColor(Color.RED).build();
		newGuiFields[25] = new Start.Builder().setBgColor(Color.LIGHT_GRAY).build();
		newGuiFields[26] = new Start.Builder().setBgColor(Color.WHITE).build();
		newGuiFields[27] = new Start.Builder().setBgColor(Color.WHITE).build();
		newGuiFields[28] = new Start.Builder().setBgColor(Color.ORANGE).build();
		newGuiFields[29] = new Start.Builder().setBgColor(Color.WHITE).build();
		newGuiFields[30] = new Start.Builder().setBgColor(Color.GRAY).build();
		newGuiFields[31] = new Start.Builder().setBgColor(Color.YELLOW).build();
		newGuiFields[32] = new Start.Builder().setBgColor(Color.YELLOW).build();
		newGuiFields[33] = new Chance.Builder().setBgColor(Color.CYAN).build();
		newGuiFields[34] = new Start.Builder().setBgColor(Color.YELLOW).build();
		newGuiFields[35] = new Start.Builder().setBgColor(Color.LIGHT_GRAY).build();
		newGuiFields[36] = new Chance.Builder().setBgColor(Color.CYAN).build();
		newGuiFields[37] = new Start.Builder().setBgColor(Color.MAGENTA).build();
		newGuiFields[38] = new Start.Builder().setBgColor(Color.DARK_GRAY).build();
		newGuiFields[39] = new Start.Builder().setBgColor(Color.MAGENTA).build();


		return newGuiFields;

	}
	//Plotting the title and descriptopn in to the fields.
	private void initFields() {
		//Removes subtext for all fields.
		for(int i=0; i < guiFields.length; i++)
			guiFields[i].setSubText(" ");

		//Initializes every field with Title and description.

		guiFields[0].setTitle("Start"); guiFields[0].setDescription("Hvergang De passere modtag kr. 4000"); guiFields[0].setSubText("Start"); 
		guiFields[1].setTitle("Rødovrevej"); guiFields[1].setDescription("Pris: 1200 <BR> Leje: 100 <BR> Hus: 1000 <BR> Hotel: 1000"); guiFields[1].setSubText("Territory");
		guiFields[2].setTitle("Prøv Lykken"); guiFields[2].setDescription("Træk et kort"); guiFields[2].setSubText("Chance");
		guiFields[3].setTitle("Hvidovrevej"); guiFields[3].setDescription("Pris: 1200 <BR> Leje: 100 <BR> Hus: 1000 <BR> Hotel: 1000"); guiFields[3].setSubText("Territory");
		guiFields[4].setTitle("Betal indkomst skat"); guiFields[4].setDescription("Betal indkomstskat 10% eller kr. 4000"); guiFields[4].setSubText("Tax");
		guiFields[5].setTitle("SFL Færgerne"); guiFields[5].setDescription("Pris: 4000 <BR> Leje: 500"); guiFields[5].setSubText("Shipping Company");
		guiFields[6].setTitle("Roskildevej"); guiFields[6].setDescription("Pris: 2000 <BR> Leje: 100 <BR> Hus: 1000 <BR>Hotel: 1000"); guiFields[6].setSubText("Territory");
		guiFields[7].setTitle("Prøv Lykken"); guiFields[7].setDescription("Træk et kort"); guiFields[7].setSubText("Chance");
		guiFields[8].setTitle("Valby Langgade"); guiFields[8].setDescription("Pris: 2000 <BR> Leje: 100 <BR> Hus: 1000 <BR> Hotel: 1000"); guiFields[8].setSubText("Territory");
		guiFields[9].setTitle("Allégade"); guiFields[9].setDescription("Pris: 2400 <BR> Leje: 150 <BR> Hus: 1000 <BR> Hotel: 1000"); guiFields[9].setSubText("Territory");
		guiFields[10].setTitle("I Fængsel"); guiFields[10].setDescription("I Fængsel"); guiFields[10].setSubText("I Fængsel");
		guiFields[11].setTitle("Frederiks- berg Allé"); guiFields[11].setDescription("Pris: 2800 <BR> Leje: 200 <BR>Hus: 2000 <BR> Hotel: 2000"); guiFields[11].setSubText("Territory");
		guiFields[12].setTitle("Tuborg Bryggeri"); guiFields[12].setDescription("Leje: 100 x antal øjne"); guiFields[12].setSubText("Brewery");
		guiFields[13].setTitle("Bülowsvej"); guiFields[13].setDescription("Pris: 2800 <BR> Leje: 200 <BR> Hus: 2000 <BR> Hotel: 2000"); guiFields[13].setSubText("Territory");
		guiFields[14].setTitle("Gl. Kongevej"); guiFields[14].setDescription("Pris: 3200 <BR> Leje: 250 <BR> Hus: 2000 <BR> Hotel: 2000"); guiFields[14].setSubText("Territory");
		guiFields[15].setTitle("DSB Kalundborg/ Århus"); guiFields[15].setDescription("Pris: 4000 <BR> Leje: 500"); guiFields[15].setSubText("Shipping Company");
		guiFields[16].setTitle("Bernstorff- vej"); guiFields[16].setDescription("Pris: 3600 <BR> Leje: 300 <BR> Hus: 2000 <BR>Hotel: 2000"); guiFields[16].setSubText("Territory");
		guiFields[17].setTitle("Prøv Lykken"); guiFields[17].setDescription("Træk et kort"); guiFields[17].setSubText("Chance");
		guiFields[18].setTitle("Hellerupvej"); guiFields[18].setDescription("Pris: 3600 <BR> Leje: 300 <BR> Hus: 2000 <BR> Hotel: 2000"); guiFields[18].setSubText("Territory");
		guiFields[19].setTitle("Strandvej"); guiFields[19].setDescription("Pris: 4000 <BR> Leje: 350 <BR> Hus: 2000 <BR> Hotel: 2000"); guiFields[19].setSubText("Territory");
		guiFields[20].setTitle("Parkering"); guiFields[20].setDescription("Der sker ingenting her!"); guiFields[20].setSubText("Parking");
		guiFields[21].setTitle("Trianglen"); guiFields[21].setDescription("Pris: 4400 <BR> Leje: 350 <BR> Hus: 3000 <BR> Hotel: 3000"); guiFields[21].setSubText("Territory");
		guiFields[22].setTitle("Prøv Lykken"); guiFields[22].setDescription("Træk et kort"); guiFields[22].setSubText("Chance");
		guiFields[23].setTitle("Østerbro- gade"); guiFields[23].setDescription("Pris: 4400 <BR> Leje: 350 <BR> Hus: 3000 <BR> Hotel: 3000"); guiFields[23].setSubText("Territory");
		guiFields[24].setTitle("Grønningen"); guiFields[24].setDescription("Pris: 4800 <BR> Leje: 400 <BR> Hus: 3000 <BR> Hotel: 3000"); guiFields[24].setSubText("Territory");
		guiFields[25].setTitle("DFDS Seaways"); guiFields[25].setDescription("Pris: 4000 <BR> Leje: 500"); guiFields[25].setSubText("Shipping Company");
		guiFields[26].setTitle("Bredgade"); guiFields[26].setDescription("Pris: 5200 <BR> Leje: 450 <BR> Hus: 3000 <BR> Hotel: 3000"); guiFields[26].setSubText("Territory");
		guiFields[27].setTitle("Kgs. Nytorv"); guiFields[27].setDescription("Pris: 5200 <BR> Leje: 450 <BR> Hus: 3000 <BR> Hotel: 3000"); guiFields[27].setSubText("Territory");
		guiFields[28].setTitle("Coca-Cola Tapperi"); guiFields[28].setDescription("Leje: 100 x antal øjne"); guiFields[28].setSubText("Brewery");
		guiFields[29].setTitle("Østergade"); guiFields[29].setDescription("Pris: 5600 <BR> Leje: 500 <BR> Hus: 3000 <BR> Hotel: 3000"); guiFields[29].setSubText("Territory");
		guiFields[30].setTitle("De Fængsles"); guiFields[30].setDescription("Du bliver overflyttet til fængslet"); guiFields[30].setSubText("GoToJail");
		guiFields[31].setTitle("Amagertorv"); guiFields[31].setDescription("Pris: 6000 <BR> Leje: 550 <BR> Hus: 4000 <BR> Hotel: 4000"); guiFields[31].setSubText("Territory");
		guiFields[32].setTitle("Vimmel- skaftet"); guiFields[32].setDescription("Pris: 6000 <BR> Leje: 550 <BR> Hus: 4000 <BR> Hotel: 4000"); guiFields[32].setSubText("Territory");
		guiFields[33].setTitle("Prøv Lykken"); guiFields[33].setDescription("Træk et kort"); guiFields[33].setSubText("Chance");
		guiFields[34].setTitle("Nygade"); guiFields[34].setDescription("Pris: 6400 <BR> Leje: 600 <BR> Hus: 4000 <BR> Hotel: 4000"); guiFields[34].setSubText("Territory");
		guiFields[35].setTitle("DSB Halsskov/ Knudshoved"); guiFields[35].setDescription("Pris: 4000 <BR> Leje: 500"); guiFields[35].setSubText("Shipping Company");
		guiFields[36].setTitle("Prøv Lykken"); guiFields[36].setDescription("Træk et kort"); guiFields[36].setSubText("Chance");
		guiFields[37].setTitle("Frederiks- berggade"); guiFields[37].setDescription("Pris: 7000 <BR> Leje: 700 <BR> Hus: 4000 <BR> Hotel: 4000"); guiFields[37].setSubText("Territory");
		guiFields[38].setTitle("Ekstra ordinær statsskat"); guiFields[38].setDescription("Ekstraordinær statsskat <BR> Betal kr. 2000"); guiFields[38].setSubText("Tax");
		guiFields[39].setTitle("Rådhus- pladsen"); guiFields[39].setDescription("Pris: 8000 <BR> Leje: 1000 <BR> Hus: 4000 <BR> Hotel: 4000"); guiFields[39].setSubText("Territory");




	}

	//Plotting the fields into the GUI and showing welcome message.
	private void initGUI() 
	{

		//		for (Field field : guiFields) {
		//			System.out.println(field);
		//		}
		//		System.out.println(guiFields.length);

		GUI.create(guiFields);
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

