package org.rinky.digitalassistant.bot.io;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.rinky.digitalassistant.bot.MouseAndKeyboard;
import org.rinky.digitalassistant.bot.model.KeyDown;
import org.rinky.digitalassistant.bot.model.ShortCut;
import org.sikuli.script.Image;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.google.common.collect.EvictingQueue;

public class GlobalKeyListener implements NativeKeyListener {
	EvictingQueue<KeyDown> keys = EvictingQueue.create(3);
	List<ShortCut> shortCuts = new LinkedList<>();
	{
		KeyDown nullKeyDown  = new KeyDown(-1, -10);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		addShortCut( new ShortCut(NativeKeyEvent.VC_S,NativeKeyEvent.VC_S,NativeKeyEvent.VC_SLASH,"hello!"));

	}
	public void addShortCut(ShortCut c){
			shortCuts.add(c);
	}
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		//System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
		keys.add(new KeyDown(e.getKeyCode(),e.getWhen()));
		for(ShortCut ss: shortCuts) {
			KeyDown[] ar = new KeyDown[3];
			int i=0;
			for(KeyDown k: keys) {
				ar[i++]=k;
			}
			if(ss.getCh0()==ar[0].getCh()&&ss.getCh1()==ar[1].getCh()&&ss.getCh2()==ar[2].getCh()) {
				clear();
				ss.action();
			}
			
		}
	}

	private void clear() {
		MouseAndKeyboard.sendBackSpace();
		MouseAndKeyboard.sendBackSpace();
		MouseAndKeyboard.sendBackSpace();
	}

	public void stop() {
		try {
			GlobalScreen.unregisterNativeHook();
		} catch (NativeHookException nativeHookException) {
			nativeHookException.printStackTrace();
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		//System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}

	
}