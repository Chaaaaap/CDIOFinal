package entities;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageSelector {

	private String[] chanceArray;
	private String[] mesArray;

	public void selectLanguage(String language, String country) {

		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale);

		mesArray = messageLanguage(currentLocale, messages);
		chanceArray = chanceLanguage(currentLocale, messages);

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
