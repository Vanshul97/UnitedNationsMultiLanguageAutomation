package configReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {

	private Properties prop; // maintain at the class level
	private FileInputStream ip;

	public Properties initLangProp(String language) throws IOException {
		//String language=System.getProperty("lang");
		System.out.println("The Language is: " + language);
		try {
			prop = new Properties();
			if (language.equalsIgnoreCase("English")) {
				ip = new FileInputStream(".\\src\\main\\resources\\lang.eng.properties");
			} else if (language.equalsIgnoreCase("French")) {
				ip = new FileInputStream(".\\src\\main\\resources\\lang.french.properties");
			} else if (language.equalsIgnoreCase("Spanish")) {
				ip = new FileInputStream(".\\src\\main\\resources\\lang.spanish.properties");
			} else {
				System.out.println("Language not found");
			}
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
