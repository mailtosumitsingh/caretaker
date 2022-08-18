package org.rinky.digitalassistant.bot.ai.impl;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.rinky.digitalassistant.bot.StaticUtil;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.rinky.digitalassistant.bot.ai.spi.Probe;
import org.rinky.digitalassistant.bot.io.Event;
import org.rinky.digitalassistant.bot.io.EventBus;
import org.rinky.digitalassistant.bot.io.Event.EventType;
import org.sikuli.script.Image;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ScreenShotProbe extends Probe  implements NativeMouseInputListener {
	@Autowired protected EventBus bus ;
	@Autowired protected Context ctx;
	public void nativeMouseClicked(NativeMouseEvent e) {
		System.out.println("Mouse Clicked: " + e.getClickCount());
		Region r = new Region(Screen.getPrimaryScreen());
		Image img = r.getImage();
		String fname = ctx.getWorkingDir()+"screen_"+e.getClickCount()+".png";
		StaticUtil.saveImage(img, fname);
		Event evt = new Event();
		evt.setEventType(Event.EventType.ScreenShot);
		evt.setData("MouseData",e);
		evt.setData("ButtonImage",fname);
		bus.send(evt);
	}

	public void nativeMousePressed(NativeMouseEvent e) {
		//System.out.println("Mouse Pressed: " + e.getButton());
	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		//System.out.println("Mouse Released: " + e.getButton());
	}

	public void nativeMouseMoved(NativeMouseEvent e) {
		//System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
	}

	public void nativeMouseDragged(NativeMouseEvent e) {
		//System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
	}

}
