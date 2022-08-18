package org.rinky.digitalassistant.bot.main.tests;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.rinky.digitalassistant.bot.OCR;
import org.rinky.digitalassistant.bot.StaticUtil;
import org.sikuli.script.Image;

import com.google.common.util.concurrent.Uninterruptibles;

public class ScreenToText {
public static void main(String[] args) {
	System.out.println("STart");
	Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	Image img = StaticUtil.takeScreenShot(500, 500, 300, 300);
	StaticUtil.saveImage(img, "c:\\temp\\"+UUID.randomUUID().toString()+".png");
	OCR o = new OCR();
	String t = o.toText(img);
	System.out.println(t);
}
}
