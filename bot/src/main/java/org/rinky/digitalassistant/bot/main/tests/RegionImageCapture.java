package org.rinky.digitalassistant.bot.main.tests;

import org.rinky.digitalassistant.bot.StaticUtil;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class RegionImageCapture {
public static void main(String[] args) {
	Region r = new Region(Screen.getPrimaryScreen());
	r.getScreen().capture().save(StaticUtil.getTempDir(),StaticUtil.getTempFile());
	
}
}
