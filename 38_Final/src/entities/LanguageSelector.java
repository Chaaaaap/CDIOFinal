package entities;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageSelector {

	private String country;
	private String language;
	
	public LanguageSelector(String language, String country) {
		this.language = language;
		this.country = country;
	}
	public ResourceBundle selectLanguage(String language, String country) {

		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale);

//		mesArray = messageLanguage(messages);
//		chanceArray = chanceLanguage(currentLocale, messages);
		
		return messages;
	}
	public ResourceBundle selectLanguage() {
		Locale currentLocale;
		ResourceBundle messages;

		currentLocale = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
		
		return messages;
	}

//	private String[] messageLanguage(ResourceBundle bundle) {
//		mesArray = bundle.getStringArray("Messages");
//		return mesArray;
//	}
//
//	private String[] chanceLanguage(Locale locale, ResourceBundle bundle) {
//		chanceArray = bundle.getStringArray("Chance");
//		return chanceArray;
//	}
}
