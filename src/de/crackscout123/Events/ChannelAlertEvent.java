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
import de.crackscout123.Utils.Messages;
import de.crackscout123.Utils.sys;

public class ChannelAlertEvent {

	public static Client sender;
	public static Messages msg;
	
	public static void load() {
		
		CrackysBot.api.registerAllEvents();
		CrackysBot.api.addTS3Listeners(new TS3Listener[] { new TS3Listener() {
			
			@Override
			public void onClientMoved(ClientMovedEvent e) {

				sender = CrackysBot.api.getClientByUId(e.getInvokerUniqueId());
				
				// Check if the channels list contains the channel id which the user have joined
				if(sys.support_channels.contains(e.getTargetChannelId())) {
					int alerted = 0; 
					// fetch all online clients
					for(int i = 0; i < sender.getServerGroups().length; i++) {
						// check if one of the users groups is listed in the groups list
						if(sender.getServerGroups()[i] == sys.support_groups.get(i)) {
						//if(sys.groups.contains(c.getServerGroups()[i])) {
							alerted++;
							if(Messages.support_poke) {
								String pre_convertedPoke = Messages.channelAlertPoke.replace("%client%", sys.getNicknameById(e.getClientId()));
								String convertedPoke = pre_convertedPoke.replace("%channel%", sys.getChannelNameById(e.getTargetChannelId()));
								CrackysBot.api.pokeClient(sender.getId(), convertedPoke);
							} else {
								String pre_convertedMsg = Messages.channelAlertMsg.replace("%client%", sys.getNicknameById(e.getClientId()));
								String convertedMsg = pre_convertedMsg.replace("%channel%", sys.getChannelNameById(e.getTargetChannelId()));
								CrackysBot.api.sendPrivateMessage(sender.getId(), convertedMsg);
							}
						}
					}
					CrackysBot.api.sendPrivateMessage(e.getClientId(), Messages.alertedNotify.replace("%alerted%", String.valueOf(alerted-sys.getActivQuarrys())));
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