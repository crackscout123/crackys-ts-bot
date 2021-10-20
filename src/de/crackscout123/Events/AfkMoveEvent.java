package de.crackscout123.Events;

import java.util.Timer;
import java.util.TimerTask;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import de.crackscout123.Main.CrackysBot;
import de.crackscout123.Utils.Messages;
import de.crackscout123.Utils.sys;

public class AfkMoveEvent {
	// Initialize variables
	public static Client sender;
	public static Client target;
	
	public static void load() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// Scheduler checking idle time
				for(Client c : CrackysBot.api.getClients()) {
					if(c.getIdleTime() > sys.afkMoveTime*60*1000 && c.getChannelId() != sys.afk_channel && c.isInputMuted()) {
						for(int i = 0; i < c.getServerGroups().length; i++) {
							if(!(c.getServerGroups()[i] == sys.afk_groups.get(i))) {
							//if(!(sys.afk_groups.contains(c.getServerGroups()[i]))) {
								CrackysBot.api.moveClient(c.getId(), sys.afk_channel);
								
								if(Messages.afk_poke) {
									CrackysBot.api.pokeClient(c.getId(), Messages.afkAlertPoke);
								} else {
									CrackysBot.api.sendPrivateMessage(c.getId(), Messages.afkAlertMsg);									
								}
							}
						}
					}
				}
			}
		}, 1000, 5*1000);
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 19.10.2021 - 21:47:59
 *
 */