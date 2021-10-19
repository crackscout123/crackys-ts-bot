package de.crackscout123.Wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LangWrapper {
	
	public static Properties prop = new Properties();
	
	public static void saveProp (String key, String value) {
		try {
			prop.setProperty(key, value);
			prop.store(new FileOutputStream("default.lang"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String loadProp(String key) {
		String value = "";
		try {
			prop.load(new FileInputStream("default.lang"));
			value = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static boolean checkForDefault() {
		File file = new File("default.lang");
		if(!file.exists()) {
			return false;
		}
		return true;
	}
	
	// create default values for config.app
	public static void createDefaults() {
		saveProp("channelAlertMsg", "[color=blue] %client% is waiting in '%channel%'");
		saveProp("channelAlertPoke", "[color=blue] %client% is waiting in '%channel%'");
		saveProp("alertedNotify", "[color=red][B]%alerted%[/B] stuff members got notified that you're here!");
		saveProp("afkAlertMsg", "[color=red]We moved you into the AFK channel!");
		saveProp("afkAlertPoke", "[color=red]We moved you into the AFK channel!");
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 19.10.2021 - 19:42:44
 *
 */