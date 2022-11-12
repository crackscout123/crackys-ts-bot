package de.crackscout123.Verify;

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

public class VerifyCommand {
	
	public static Client sender;
	public static Client target;
	public static String file = "Verify.app";
	
//	Create verify.app
	public static void createDefaults() {
		if(!Config.checkForDefault(file)) {
			Config.saveProp("verifiedGroup", "26", file);
			Config.saveProp("verifyEnabled", "false", file);
			Config.saveProp("poke", "true", file);
			Config.saveProp("notificationMsg", "[color=red]You need to verify yourself - use !verify", file);
			Config.saveProp("verifiedMsg", "[color=green]Successfully verified!", file);
		}
	}
		
	public static void load() {

		Integer verifiedGroup = Integer.parseInt(Config.loadProp("verifiedGroup", file));
		Boolean verifyEnabled = Boolean.parseBoolean(Config.loadProp("verifyEnabled", file));
		
		Boolean poke = Boolean.parseBoolean(Config.loadProp("poke", file));
		
		String notificationMsg = Config.loadProp("notificationMsg", file);
		//String verifiedMsg = Config.loadProp("verifiedMsg", file);
		
		CrackysBot.api.registerAllEvents();
		CrackysBot.api.addTS3Listeners(new TS3Listener[] { new TS3Listener(){

			@Override
			public void onClientJoin(ClientJoinEvent e) {
			
				sender = CrackysBot.api.getClientByUId(e.getUniqueClientIdentifier());
				
				if(verifyEnabled) {
					for(int i = 0; i < sender.getServerGroups().length; i++) {
						// check if sender is already verified
						if(sender.getServerGroups()[i] != verifiedGroup) {
							// notify sender to verify his self
							if(poke) {
								CrackysBot.api.pokeClient(sender.getId(), notificationMsg);
							}else {
								CrackysBot.api.sendPrivateMessage(sender.getId(), notificationMsg);
							}
						}
					}
				}
			}
			

			@Override
			public void onTextMessage(TextMessageEvent e) {

				sender = CrackysBot.api.getClientByUId(e.getInvokerUniqueId());
				
				if(e.getMessage().startsWith("!verify")) {
					// catch the message and split in to single strings (args) 
					String[] args = e.getMessage().split(" ");
 					for(int i = 0; i < args.length; i++) {
 						if(args.length == 0) {
 							// 1. generate a verify-code 
 							// 2. save this code in combination with ClientId() to a database?
 						} else {
 							@SuppressWarnings("unused")
							String key = args[1];
 							//
 						}
						
					}
				}
				
			}
			
			@Override
			public void onChannelCreate(ChannelCreateEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChannelDeleted(ChannelDeletedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChannelEdit(ChannelEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChannelMoved(ChannelMovedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onClientLeave(ClientLeaveEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onClientMoved(ClientMovedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onServerEdit(ServerEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}

		}});
		
	}
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 25.10.2021 - 00:34:00
 *
 */