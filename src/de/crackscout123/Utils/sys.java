package de.crackscout123.Utils;

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
	public static String nickname = CrackysBot.args_nickname;
	
	public static String msg_botrunning = "Hi %sender%. All my system are online and running.";

	
//	### other useful stuff ### 	
	
	
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