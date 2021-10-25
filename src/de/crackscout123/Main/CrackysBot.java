package de.crackscout123.Main;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;

import de.crackscout123.Events.AfkMoveEvent;
import de.crackscout123.Events.ChannelAlertEvent;
import de.crackscout123.Events.MessageEvent;
import de.crackscout123.Events.SeverJoinEvent;
import de.crackscout123.Utils.sys;
import de.crackscout123.Verify.VerifyCommand;
import de.crackscout123.Wrapper.ConfigWrapper;
import de.crackscout123.Wrapper.LangWrapper;

// Alpha-v1.1

public class CrackysBot {
		
	// Define login variables getting as start parameters
	public static String args_user = "", args_pass = "", args_host = "", args_nickname = "";
	public static boolean debug, dryrun = false;
	
	// Define default variables & initialize the teamspeak-api     
	public static TS3Config cfg = new TS3Config();
	public static TS3Query query = new TS3Query(cfg);
	public static TS3Api api = new TS3Api(query);
	
	
	public static void main(String[] args) {
		// Check if default.lang & config.app exists, create one if not
		if(!LangWrapper.checkForDefault()) { LangWrapper.createDefaults(); }
		if(!ConfigWrapper.checkForDefault()) { ConfigWrapper.createDefaults(); }
				
		// Fetch start parameters
		// java -jar crackysbot.jar arg0 arg1 arg2
		for(int i = 0; i < args.length; i++) {
			// Handle the arguments 
			
	        if(args[i].contains("-debug")) {
	        	System.out.println("=====STARTED THE BOT IN DEBUG MODE====");
	        	System.out.println("you need to add the login credentials as start arguments!");
	        	debug = true;
	        }
	        	        
	        if(args[i].contains("--help")) {
	        	System.out.println("=====HELP ARGUMENT TRIGGERD====");
	        	System.out.println("java -jar crackybot.jar username password hostname");
	        }
	        
	        if(args[i].contains("--dry-run")) {
	        	System.out.println("=====STARTED THE BOT IN DRYRUN MODE====");
	        	System.out.println("Creating config.app...");
	        	ConfigWrapper.createDefaults();
	        	System.out.println("config.app successfully created!");
	        	System.out.println("Please setup the config.app & restart the bot wihtout the argument --dry-run.");
	        	System.out.println("exiting now!");
	        	System.exit(0);
	        }
		}
		
		if(debug == true) {
			args_user = args[0];			
			args_pass = args[1];
			args_host = args[2];
			args_nickname = "CrackysBot - debugmode";
		} else {
			args_user = ConfigWrapper.loadProp("query");		
			args_pass = ConfigWrapper.loadProp("password");	
			args_host = ConfigWrapper.loadProp("host");	
			args_nickname = ConfigWrapper.loadProp("nickname");	
		}
		
		// only connect to a server when bot is started without the --dry-run argument 
		if(!dryrun) {
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
			SeverJoinEvent.load();
			ChannelAlertEvent.load();
			AfkMoveEvent.load();

			VerifyCommand.load();
			
			// Initialize channel & group list for ChannelAlerts & AfkMover
			sys.initAfkGroups();
			sys.initSupportChannels();
			sys.initSupportGroups();
			
			// Print in console bot is ready
			System.out.println("Crackys-Bot loaded.");
		}
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 22.01.2021 - 12:46:10
 *
 */