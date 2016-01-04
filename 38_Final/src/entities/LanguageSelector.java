package entities;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageSelector {

	private String[][] messageArray = new String[2][];
	private String[] chanceArray;
	private String[] mesArray;

	public String[][] selectLanguage(String language, String country) {

		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale);

		messageArray[0] = messageLanguage(currentLocale, messages);
		messageArray[1] = chanceLanguage(currentLocale, messages);

		return messageArray;
	}

	private String[] messageLanguage(Locale currentLocale, ResourceBundle bundle) {
		mesArray = bundle.getStringArray("Messages");
		return mesArray;
	}

	private String[] chanceLanguage(Locale locale, ResourceBundle bundle) {
		chanceArray = bundle.getStringArray("Chance");
		return chanceArray;
	}
}
