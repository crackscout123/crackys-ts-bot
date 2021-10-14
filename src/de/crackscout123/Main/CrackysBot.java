package de.crackscout123.Main;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;

import de.crackscout123.Events.ClientEvents;
import de.crackscout123.Events.JoinEvent;
import de.crackscout123.Events.MessageEvent;
import de.crackscout123.Utils.sys;

// Alpha-v0.1

public class CrackysBot {
	
	// Define login variables getting as start parameters
	public static String args_user = "", args_pass = "", args_host = "";
	
	// Define default variables & initialize the teamspeak-api     
	public static TS3Config cfg = new TS3Config();
	public static TS3Query query = new TS3Query(cfg);
	public static TS3Api api = new TS3Api(query);
	
	
	public static void main(String[] args) {
		
		// Fetch start parameters
		// java -jar crackysbot.jar arg0 arg1 arg2
		for(int i = 0; i < args.length; i++) {
			// Handle the arguments 
				args_user = args[0];			
				args_pass = args[1];
				args_host = args[2];
			
	        if(args[i].contains("--help")) {
	        	System.out.println("=====HELP ARGUMENT TRIGGERD====");
	        	System.out.println("java -jar crackybot.jar username password hostname");
	        }
		}
		
		// Initialize client and server settings
		cfg.setDebugLevel(sys.DebugLvl);
		cfg.setHost(sys.hostname);
		
		// Connect as query to server
		query.connect();
		
		// Initialize api
		api.login(sys.query_user, sys.query_pass);
		api.selectVirtualServerById(sys.VirtualServerId);
		api.setNickname(sys.nickname);
		
		// Register events
		api.registerEvents(TS3EventType.SERVER);
		
		// Initialize event class's
		MessageEvent.load();
		JoinEvent.load();
		ClientEvents.load();
		
		// Initialize channel & group list for ChannelAlerts 
		sys.initChannels();
		sys.initGroups();
		
		// Print in console bot is ready
		System.out.println("Crackys-Bot loaded.");
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 22.01.2021 - 12:46:10
 *
 */