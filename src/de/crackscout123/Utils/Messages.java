package de.crackscout123.Utils;

import de.crackscout123.Wrapper.ConfigWrapper;
import de.crackscout123.Wrapper.LangWrapper;

public class Messages {
	// notify messages 
	
	// strings
	public static String channelAlertMsg = LangWrapper.loadProp("channelAlertMsg");
	public static String channelAlertPoke = LangWrapper.loadProp("channelAlertPoke");
	public static String alertedNotify = LangWrapper.loadProp("alertedNotify");
	
	public static String afkAlertMsg = LangWrapper.loadProp("afkAlertMsg");
	public static String afkAlertPoke = LangWrapper.loadProp("afkAlertPoke");
	
	// boolean's
	public static boolean support_poke = Boolean.parseBoolean(ConfigWrapper.loadProp("support_poke"));
	public static boolean afk_poke = Boolean.parseBoolean(ConfigWrapper.loadProp("afk_poke"));

}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 19.10.2021 - 19:39:50
 *
 */