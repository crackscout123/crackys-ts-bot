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
import de.crackscout123.Wrapper.Debug;

public class SeverJoinEvent {
	
	// Initialize variables
	public static Client sender;
	
	public static void load() {
		CrackysBot.api.registerAllEvents();
		CrackysBot.api.addTS3Listeners(new TS3Listener[] { new TS3Listener(){

			@Override
			public void onClientJoin(ClientJoinEvent e) {
				sender = CrackysBot.api.getClientByUId(e.getUniqueClientIdentifier());
				
				//check Nickname				
				if(e.getClientNickname().contains("56e34fcv")) {
					CrackysBot.api.kickClientFromServer("not allowed username!", e.getClientId());
				}
				
				Debug.info(sender.getNickname() + " joined the server.");			
				
				
			}
						
			@Override
			public void onTextMessage(TextMessageEvent args0) {}
			
			@Override
			public void onChannelCreate(ChannelCreateEvent arg0) {}

			@Override
			public void onChannelDeleted(ChannelDeletedEvent arg0) {}

			@Override
			public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {}

			@Override
			public void onChannelEdit(ChannelEditedEvent arg0) {}

			@Override
			public void onChannelMoved(ChannelMovedEvent arg0) {}

			@Override
			public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {}

			@Override
			public void onClientLeave(ClientLeaveEvent arg0) {}

			@Override
			public void onClientMoved(ClientMovedEvent arg0) {}

			@Override
			public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {}

			@Override
			public void onServerEdit(ServerEditedEvent arg0) {}
			
	    } });
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 22.01.2021 - 13:37:26
 *
 */