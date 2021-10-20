package de.crackscout123.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import de.crackscout123.Main.CrackysBot;
import de.crackscout123.Wrapper.ConfigWrapper;


public class sys {

//	### CrackyBot.java ###
	// Client and server settings 
	public static Level DebugLvl = Level.ALL;
	public static String hostname = CrackysBot.args_host;
	public static String query_user = CrackysBot.args_user;
	public static String query_pass = CrackysBot.args_pass;
	public static Integer VirtualServerId = 1;
	public static String nickname = CrackysBot.args_nickname;
	public static Integer afkMoveTime = Integer.parseInt(ConfigWrapper.loadProp("afkMoveTime"));
	
// 	### MessageEvent.java ###
	// You can use %sender% to display the nickname of user who triggered the command
	public static String msg_botrunning = "Hi %sender%. All my system are online and running.";
	
//	### ClientEvents.java ###	
	// ChannelAlerts - channel list
	public static List<Integer> support_channels = new ArrayList<Integer>();
	
	// fetching support_channels id from config.app 
	public static void initSupportChannels() {
		String[] numbers = ConfigWrapper.loadProp("support_channels").split(",");
		for (String string : numbers) {
			support_channels.add(Integer.parseInt(string));
		}
	}
	public static List<Integer> support_groups = new ArrayList<Integer>();

	// fetching support_groups id from config.app 
	public static void initSupportGroups() {
		String[] numbers = ConfigWrapper.loadProp("support_groups").split(",");
		for (String string : numbers) {
			support_groups.add(Integer.parseInt(string));
		}
	}

	public static Integer afk_channel = Integer.parseInt(ConfigWrapper.loadProp("afk_channel"));
	
	public static List<Integer> afk_groups = new ArrayList<Integer>();

	// fetching afk_group id from config.app 
	public static void initAfkGroups() {
		String[] numbers = ConfigWrapper.loadProp("ingnoreAfk_groups").split(",");
		for (String string : numbers) {
			afk_groups.add(Integer.parseInt(string));
		}
	}
	
	public static String getChannelNameById(Integer TargetChannelId) { return CrackysBot.api.getChannelInfo(TargetChannelId).getName(); }
	
	public static String getNicknameById(Integer ClientId) { return CrackysBot.api.getClientInfo(ClientId).getNickname().toString(); }
	
	public static Integer getActivQuarrys() { return CrackysBot.api.getServerInfo().getQueryClientsOnline(); }
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 22.01.2021 - 12:56:45
 *
 */