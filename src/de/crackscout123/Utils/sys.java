package de.crackscout123.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import de.crackscout123.Main.CrackysBot;

public class sys {

//	### CrackyBot.java ###
	// Client and server settings 
	public static Level DebugLvl = Level.ALL;
	public static String hostname = CrackysBot.args_host;
	public static String query_user = CrackysBot.args_user;
	public static String query_pass = CrackysBot.args_pass;
	public static Integer VirtualServerId = 1;
	public static String nickname = "CrackysBot v0.1";
	
// 	### MessageEvent.java ###
	// You can use %sender% to display the nickname of user who triggered the command
	public static String msg_botrunning = "Hi %sender%. All my system are online and running.";
	
//	### ClientEvents.java ###	
	// ChannelAlerts - channel list
	public static List<Integer> channels = new ArrayList<Integer>();
	public static void initChannels() {
		channels.add(7); // Channel id of a support channel or similar 
		channels.add(50);
	}
	public static List<Integer> groups = new ArrayList<Integer>();
	public static void initGroups() {
		groups.add(9); // Group id from groups which get notified when a user join a specific channel
		groups.add(18);
	}
	
	// notify messages 
	public static boolean pokeAlert = true;
	public static String channelAlertMsg = "[color=blue] %client% is waiting in '%channel%'";
	public static String channelAlertPoke = "[color=blue] %client% is waiting in '%channel%'";
	public static String alertedNotify = "[color=red][B]%alerted%[/B] stuff members got notified that you're here!";
	
	public static String getChannelNameById(Integer TargetChannelId) {
		return CrackysBot.api.getChannelInfo(TargetChannelId).getName();
	}
	
	public static String getNicknameById(Integer ClientId) {
		return CrackysBot.api.getClientInfo(ClientId).getNickname().toString();
	}
	
	public static Integer getActivQuarrys() { return CrackysBot.api.getServerInfo().getQueryClientsOnline(); }
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 22.01.2021 - 12:56:45
 *
 */