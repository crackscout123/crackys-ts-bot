package de.crackscout123.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import de.crackscout123.Main.CrackysBot;
import de.crackscout123.Wrapper.Config;
import de.crackscout123.Wrapper.Debug;

public class AfkMoveEvent {
	// Initialize variables
	public static Client sender;
	public static Client target;
	public static String file = "AfkMover.app";
	
	public static void createDefaults() {
		if(!Config.checkForDefault(file)) {
			Config.saveProp("afk_channel", "72", file);
			Config.saveProp("ingnoreAfk_groups", "24,18", file);
			Config.saveProp("poke", "true", file);
			Config.saveProp("afkMoverEnabled", "true", file);
			Config.saveProp("afkMoveTime", "1", file);
			Config.saveProp("afkAlertMsg", "[color=red]We moved you into the AFK channel!", file);
		}
	}

	public static void load() {

		
		Integer afk_channel = Integer.parseInt(Config.loadProp("afk_channel", file));
		Integer afkMoveTime = Integer.parseInt(Config.loadProp("afkMoveTime", file));

		Boolean poke = Boolean.parseBoolean(Config.loadProp("poke", file));
		Boolean enabled = Boolean.parseBoolean(Config.loadProp("afkMoverEnabled", file));
		
		String afkAlertMsg = Config.loadProp("afkAlertMsg", file);
		
		List<Integer> afk_groups = new ArrayList<Integer>();

		// fetching afk_group id from config.app 
		String[] numbers = Config.loadProp("ingnoreAfk_groups", file).split(",");
		for (String string : numbers) {
			afk_groups.add(Integer.parseInt(string));
		}
	
		
		if(enabled) {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// Scheduler checking idle time
					for(Client c : CrackysBot.api.getClients()) {
						if(c.getIdleTime() > afkMoveTime*60*1000 && c.getChannelId() != afk_channel && c.isInputMuted()) {
							for(int i = 0; i < c.getServerGroups().length; i++) {
								if(!(c.getServerGroups()[i] == afk_groups.get(i))) {
								//if(!(sys.afk_groups.contains(c.getServerGroups()[i]))) {
									CrackysBot.api.moveClient(c.getId(), afk_channel);
									Debug.info("MOVING " + c.getNickname() + "(" + c.getId() + ") INTO AFK CHANNEL");
									if(poke) {
										CrackysBot.api.pokeClient(c.getId(), afkAlertMsg);
									} else {
										CrackysBot.api.sendPrivateMessage(c.getId(), afkAlertMsg);									
									}
								}
							}
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
 * @date 19.10.2021 - 21:47:59
 *
 */