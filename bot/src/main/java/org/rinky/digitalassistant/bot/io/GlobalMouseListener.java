package org.rinky.digitalassistant.bot.io;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.rinky.digitalassistant.bot.StaticUtil;
import org.sikuli.script.Image;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class GlobalMouseListener implements NativeMouseInputListener {
	public void nativeMouseClicked(NativeMouseEvent e) {
		System.out.println("Mouse Clicked: " + e.getClickCount());
		Region r = new Region(Screen.getPrimaryScreen());
		Image img = r.getImage();
		Image img2 = img.getSub(e.getX()-20, e.getY()-20, 40, 40);
		StaticUtil.saveImage(img2, StaticUtil.getTempDir()+"m_"+e.getClickCount()+".png");
		StaticUtil.saveImage(img, StaticUtil.getTempDir()+"s_"+e.getClickCount()+".png");
		
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
