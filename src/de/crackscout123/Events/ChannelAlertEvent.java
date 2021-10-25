package de.crackscout123.Events;

import java.util.ArrayList;
import java.util.List;

import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import de.crackscout123.Main.CrackysBot;
import de.crackscout123.Utils.sys;
import de.crackscout123.Wrapper.Config;

public class ChannelAlertEvent {

	public static Client sender;
	public static String file = "ChannelAlert.app";
	
//	Create verify.app
	public static void createDefaults() {
		if(!Config.checkForDefault(file)) {
			Config.saveProp("support_channels", "7,50", file);
			Config.saveProp("support_groups", "9,18", file);
			Config.saveProp("poke", "true", file);
			Config.saveProp("channelAlertEnabled", "true", file);
			Config.saveProp("channelAlertMsg", "[color=blue] %client% is waiting in '%channel%'", file);
			Config.saveProp("notificationMsg", "[color=red][B]%alerted%[/B] stuff members got notified that you're here!", file);
		}
	}
	
	public static void load() {
		

		Boolean poke = Boolean.parseBoolean(Config.loadProp("poke", file));
		Boolean channelAlertEnabled = Boolean.parseBoolean(Config.loadProp("channelAlertEnabled", file));
		
		String channelAlertMsg = Config.loadProp("channelAlertMsg", file);
		String notificationMsg = Config.loadProp("notificationMsg", file);
		
		
		// ChannelAlerts - channel list
		List<Integer> support_channels = new ArrayList<Integer>();
		
		// fetching support_channels 
		String[] numbers_c = Config.loadProp("support_channels", file).split(",");
		for (String string : numbers_c) {
			support_channels.add(Integer.parseInt(string));
		}
		
		List<Integer> support_groups = new ArrayList<Integer>();
		
		// fetching support_groups id from config.app 
		String[] numbers_g = Config.loadProp("support_groups", file).split(",");
		for (String string : numbers_g) {
			support_groups.add(Integer.parseInt(string));
		}
		
		
		CrackysBot.api.registerAllEvents();
		CrackysBot.api.addTS3Listeners(new TS3Listener[] { new TS3Listener() {
			
			@Override
			public void onClientMoved(ClientMovedEvent e) {

				sender = CrackysBot.api.getClientByUId(e.getInvokerUniqueId());
				if(channelAlertEnabled) {
					// Check if the channels list contains the channel id which the user have joined
					if(support_channels.contains(e.getTargetChannelId())) {
						int alerted = 0; 
						// fetch all online clients
						for(int i = 0; i < sender.getServerGroups().length; i++) {
							// check if one of the users groups is listed in the groups list
							if(sender.getServerGroups()[i] == support_groups.get(i)) {
							//if(sys.groups.contains(c.getServerGroups()[i])) {
								alerted++;
								if(poke) {
									String pre_convertedPoke = channelAlertMsg.replace("%client%", sys.getNicknameById(e.getClientId()));
									String convertedPoke = pre_convertedPoke.replace("%channel%", sys.getChannelNameById(e.getTargetChannelId()));
									CrackysBot.api.pokeClient(sender.getId(), convertedPoke);
								} else {
									String pre_convertedMsg = channelAlertMsg.replace("%client%", sys.getNicknameById(e.getClientId()));
									String convertedMsg = pre_convertedMsg.replace("%channel%", sys.getChannelNameById(e.getTargetChannelId()));
									CrackysBot.api.sendPrivateMessage(sender.getId(), convertedMsg);
								}
							}
						}
						CrackysBot.api.sendPrivateMessage(e.getClientId(), notificationMsg.replace("%alerted%", String.valueOf(alerted-sys.getActivQuarrys())));
					}
				}
			}
			
			@Override
			public void onClientLeave(ClientLeaveEvent arg0) {}
			
			@Override
			public void onClientJoin(ClientJoinEvent arg0) {}
			
			@Override
			public void onChannelMoved(ChannelMovedEvent arg0) {}
			
			@Override
			public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {}
			
			@Override
			public void onChannelEdit(ChannelEditedEvent arg0) {}
			
			@Override
			public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {}
			
			@Override
			public void onChannelDeleted(ChannelDeletedEvent arg0) {}
			
			@Override
			public void onChannelCreate(ChannelCreateEvent arg0) {}
			
			@Override
			public void onTextMessage(TextMessageEvent arg0) {}
			
			@Override
			public void onServerEdit(ServerEditedEvent arg0) {}
			
			@Override
			public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {}
			
		}});
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 22.01.2021 - 15:51:57
 *
 */