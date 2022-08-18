package org.rinky.digitalassistant.bot.ai.impl;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.rinky.digitalassistant.bot.ai.spi.Probe;
import org.rinky.digitalassistant.bot.io.Event;
import org.rinky.digitalassistant.bot.io.EventBus;
import org.rinky.digitalassistant.bot.io.Event.EventType;
import org.rinky.digitalassistant.bot.model.KeyDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.EvictingQueue;
@Component
public class WordProbe extends Probe  implements NativeKeyListener {
	@Autowired protected EventBus bus ;
	@Autowired protected Context ctx;
	EvictingQueue<KeyDown> keys = EvictingQueue.create(10);
	{
		KeyDown nullKeyDown  = new KeyDown(-1, -10);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
		keys.add(nullKeyDown);
	}
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		//System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		if(e.getKeyCode()==NativeKeyEvent.VC_ENTER ||e.getKeyCode()==NativeKeyEvent.VC_TAB||e.getKeyCode()==NativeKeyEvent.VC_SPACE||e.getKeyCode()==NativeKeyEvent.VC_LEFT) {
			Event evt = new Event();
			evt.setEventType(EventType.Word);
			StringBuilder sb = new StringBuilder();
			for(KeyDown kd : keys) {
				sb.append(kd.getTxt());
			}
			evt.setData("KeyWord",sb.toString());
			keys.clear();
			bus.send(evt);
		}else {
			KeyDown e2 = new KeyDown(e.getKeyCode(),e.getWhen());
			e2.setTxt(e.getKeyText(e.getKeyCode()));
			keys.add(e2);
		}
	}


	public void nativeKeyReleased(NativeKeyEvent e) {
		//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		//System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}

	
}