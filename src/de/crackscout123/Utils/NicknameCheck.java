package de.crackscout123.Utils;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import de.crackscout123.Wrapper.Config;

public class NicknameCheck {
	// Initialize variables
	public static Client sender;
	public static Client target;
	public static String file = "badNicknames.yml";
	
	public static void createDefaults() {
		if(!Config.checkForDefault(file)) {
			Config.saveProp("path", "value", file);
		}
	}

	public static void load(Client c) {
		
	}

}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 11.11.2022 - 23:42:49
 *
 */