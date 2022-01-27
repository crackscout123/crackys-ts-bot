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
import de.crackscout123.Wrapper.Config;

public class Workbench {

	public static Client sender;
	public static String file = "Workbench.app";
	
//	Create Workbench.app
	public static void createDefaults() {
		if(!Config.checkForDefault(file)) {
			Config.saveProp("enabled", "false", file);
		}
	}
	
	public static void load() {

		Boolean enabled = Boolean.parseBoolean(Config.loadProp("enabled", file));
		
		if(enabled) {
			CrackysBot.api.registerAllEvents();
			CrackysBot.api.addTS3Listeners(new TS3Listener[] { new TS3Listener() {
	
				@Override
				public void onChannelCreate(ChannelCreateEvent arg0) {
				}
	
				@Override
				public void onChannelDeleted(ChannelDeletedEvent arg0) {
				}
	
				@Override
				public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
				}
	
				@Override
				public void onChannelEdit(ChannelEditedEvent arg0) {
				}
	
				@Override
				public void onChannelMoved(ChannelMovedEvent arg0) {
				}
	
				@Override
				public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
				}
	
				@Override
				public void onClientJoin(ClientJoinEvent arg0) {
				}
	
				@Override
				public void onClientLeave(ClientLeaveEvent arg0) {
				}
	
				@Override
				public void onClientMoved(ClientMovedEvent arg0) {
				}
	
				@Override
				public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {
				}
	
				@Override
				public void onServerEdit(ServerEditedEvent arg0) {
				}
	
				@Override
				public void onTextMessage(TextMessageEvent arg0) {
				}
			}});
		}
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 26.01.2022 - 18:50:46
 *
 */