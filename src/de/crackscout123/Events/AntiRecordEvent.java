package de.crackscout123.Events;

import java.util.Timer;
import java.util.TimerTask;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import de.crackscout123.Main.CrackysBot;
import de.crackscout123.Wrapper.Config;
import de.crackscout123.Wrapper.Debug;

public class AntiRecordEvent {

	public static Client sender;
	public static Client target;
	public static String file = "AntiRecord.app";
	
//	Create AntiRecord.app
	public static void createDefaults() {
		if(!Config.checkForDefault(file)) {
			Config.saveProp("ignoredGroups", "24,18", file);
			Config.saveProp("ignoredChannels", "9,18", file);
			Config.saveProp("antiRecordEnabled", "true", file);
			Config.saveProp("poke", "true", file);
			Config.saveProp("kickReason", "Recording not allowed!", file);
			Config.saveProp("notifyMsg", "[color=red]You're not allowed to record here!", file);
		}
	}
	
		
//		TODO:
//			check if user is in of the ignoredGroups or in one of the ignoredChannels!
//	
//	
//	
//	
	
	
	public static void load() {
		
		Boolean enabled = Boolean.parseBoolean(Config.loadProp("antiRecordEnabled", file));
		Boolean poke = Boolean.parseBoolean(Config.loadProp("poke", file));
		
		String kickReason = Config.loadProp("kickReason", file);		
		String notifyMsg = Config.loadProp("notifyMsg", file);
		
		if(enabled) {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// Scheduler checking idle time
					for(Client c : CrackysBot.api.getClients()) {
						if(c.isRecording()) {
							if(poke) {
								CrackysBot.api.pokeClient(c.getId(), notifyMsg);
							}else{
								CrackysBot.api.sendPrivateMessage(c.getId(), notifyMsg);
							}
							Debug.info("KICKING " + c.getNickname() + "(" + c.getId() + ") FOR RECORDING.");
						CrackysBot.api.kickClientFromServer(kickReason, c);
						}
					}
				}
			}, 1000, 5*1000);
		}
	}
	
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 25.10.2021 - 06:40:12
 *
 */