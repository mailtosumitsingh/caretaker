package org.rinky.digitalassistant.bot.ai;


public class AIConfig {
public static String getTokenFile() {
	return "C:/projects/robotics.json";
}
public static String getTmpDir() {
	return System.getProperty("user.dir")+"\\tmp\\";
}
public static String getAudioFileDir() {
	return System.getProperty("user.dir")+"\\tmp\\";
}
} 
