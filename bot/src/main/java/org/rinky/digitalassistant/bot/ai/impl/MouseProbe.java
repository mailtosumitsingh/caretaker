package org.rinky.digitalassistant.bot.ai.impl;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.rinky.digitalassistant.bot.ai.spi.Probe;
import org.rinky.digitalassistant.bot.io.Event;
import org.rinky.digitalassistant.bot.io.EventBus;
import org.rinky.digitalassistant.bot.io.Event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MouseProbe extends Probe  implements NativeMouseInputListener {
	@Autowired protected EventBus bus ;
	@Autowired protected Context ctx;
	public void nativeMouseClicked(NativeMouseEvent e) {
		System.out.println("Mouse Clicked: " + e.getClickCount());
		Event evt = new Event();
		evt.setEventType(Event.EventType.LeftMouseClick);
		evt.setData("MouseData",e);
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
