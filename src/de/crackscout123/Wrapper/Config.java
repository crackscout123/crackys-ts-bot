package de.crackscout123.Wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static Properties prop = new Properties();
	
	public static void saveProp (String key, String value, String file) {
		try {
			prop.setProperty(key, value);
			prop.store(new FileOutputStream("functions/" + file), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String loadProp(String key, String file) {
		String value = "";
		try {
			prop.load(new FileInputStream("functions/" + file));
			value = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void createFunctionsFolder() {
		File folder = new File("functions");
		if(!folder.exists()) {
			System.out.println("debug");
			folder.mkdirs();
		}
		
	}
	
	public static boolean checkForDefault(String file) {
		File path = new File("functions/" + file);
		if(!path.exists()) {
			path.getParentFile().mkdirs();
			System.out.println("created.");
			return false;
		}
		return true;
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 25.10.2021 - 04:31:53
 *
 */