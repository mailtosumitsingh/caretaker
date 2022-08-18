package org.rinky.digitalassistant.bot;

import org.sikuli.script.Location;
import org.sikuli.script.Region;

public class Robot {
public void click(int x, int y, int w, int h) {
	Region r = new Region(x,y,w,h);
	r.getCenter().click();
	
}
public void click(int x, int y) {
	Location l = new Location(x,y);
	l.click();
}
public void doubleClick(int x, int y) {
	Location l = new Location(x,y);
	l.doubleClick();
}
public void sendText(int x, int y,int w, int h,String text) {
	Region r = new Region(x,y,w,h);
	r.type(text);
	
}

}
