package de.crackscout123.Wrapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigWrapper {

	public static Properties prop = new Properties();
	
	public static void saveProp (String key, String value) {
		try {
			prop.setProperty(key, value);
			prop.store(new FileOutputStream("config.app"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String loadProp(String key) {
		String value = "";
		try {
			prop.load(new FileInputStream("config.app"));
			value = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	// create default values for config.app
	public static void createDefaults() {
		saveProp("host", "localhost");
		saveProp("query", "serveradmin");
		saveProp("password", "password");
		saveProp("nickname", "CrackysBot v1");
		saveProp("groups" , "9,18");
		saveProp("channels", "7,50");
	}
	
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 15.10.2021 - 01:45:36
 *
 */