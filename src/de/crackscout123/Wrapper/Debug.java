package de.crackscout123.Wrapper;

import java.sql.Timestamp;

public class Debug {
	
	public static boolean debug = true;
	
	public static void info(String msg) {
		if(debug) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println(timestamp + " |DEBUG| " + msg);
		}
	}
	
	public static void err(String msg) {
		if(debug) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.err.println(timestamp + " |DEBUG| " + msg);
		}
	}
	
}


/**
 * @author Joel Rzepka - crackscout123.de
 *
 * @date 11.11.2021 - 00:17:14
 *
 */