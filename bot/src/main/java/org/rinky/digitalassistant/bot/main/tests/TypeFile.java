package org.rinky.digitalassistant.bot.main.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.rinky.digitalassistant.bot.MouseAndKeyboard;

public class TypeFile {
	public static void main(String[] args)throws Exception {
		Thread.sleep(10000);
		String s = FileUtils.readFileToString(new File("d:\\mystore\\contentsmanager\\contentsmanager.py"));
		MouseAndKeyboard.sendText(s, 20);
	}

}
