package de.crackscout123.Events;

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

public class ClientEvents {


	public Client sender;
	
	public static void load() {
		
		CrackysBot.api.registerAllEvents();

		CrackysBot.api.addTS3Listeners(new TS3Listener[] { new TS3Listener() {
			
			@Override
			public void onClientMoved(ClientMovedEvent e) {
				
				// Check if the channels list contains the channel id which the user have joined
				if(sys.channels.contains(e.getTargetChannelId())) {
					int alerted = 0; 
					// fetch all online clients
					for(Client c : CrackysBot.api.getClients()) {
						for(int i = 0; i < c.getServerGroups().length; i++) {
							// check if one of the users groups is listed in the groups list
							if(c.getServerGroups()[i] == sys.groups.get(i)) {
							//if(sys.groups.contains(c.getServerGroups()[i])) {
								alerted++;
								if(sys.pokeAlert) {
									String pre_convertedPoke = sys.channelAlertPoke.replace("%client%", sys.getNicknameById(e.getClientId()));
									String convertedPoke = pre_convertedPoke.replace("%channel%", sys.getChannelNameById(e.getTargetChannelId()));
									CrackysBot.api.pokeClient(c.getId(), convertedPoke);
								} else {
									String pre_convertedMsg = sys.channelAlertMsg.replace("%client%", sys.getNicknameById(e.getClientId()));
									String convertedMsg = pre_convertedMsg.replace("%channel%", sys.getChannelNameById(e.getTargetChannelId()));
									CrackysBot.api.sendPrivateMessage(c.getId(), convertedMsg);
								}
								// TODO: Kleiner bugfix wenn user in mehreren Gruppen sind werden diese bei alerted doppelt gezählt und doppelt benachrichtigt
							}
						}
					}
					CrackysBot.api.sendPrivateMessage(e.getClientId(), sys.alertedNotify.replace("%alerted%", String.valueOf(alerted-1)));
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