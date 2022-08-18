package org.rinky.digitalassistant.bot.main;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.rinky.digitalassistant.bot.StaticUtil;
import org.rinky.digitalassistant.bot.io.GlobalKeyListener;
import org.rinky.digitalassistant.bot.io.GlobalMouseListener;
import org.rinky.digitalassistant.bot.io.SoundCapture;
import org.rinky.digitalassistant.bot.io.SoundPlayer;
import org.rinky.digitalassistant.bot.io.SpeechToText;
import org.rinky.digitalassistant.bot.model.ShortCut;
import org.sikuli.script.Image;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.google.common.util.concurrent.Uninterruptibles;

public class StartUp {

	public static void main(String[] args) throws NativeHookException {
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
		logger.setUseParentHandlers(false);
		GlobalKeyListener key = new GlobalKeyListener();
		final SoundCapture sc = new SoundCapture();
		final SoundPlayer sp = new SoundPlayer();
		final SpeechToText spt = new SpeechToText();
		final File f = new File("c:\\temp\\sound.wav");
		sc.with(f);
		sc.with(3000);
		ShortCut s = new ShortCut(NativeKeyEvent.VC_R, NativeKeyEvent.VC_S, NativeKeyEvent.VC_SLASH, "hello!");
		s.setAction(() -> {
			sc.captureForTime(() -> {
				try {
					System.out.println(spt.convert("c:\\temp\\sound.wav"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});
		key.addShortCut(s);
		GlobalScreen.registerNativeHook();
		GlobalScreen.addNativeKeyListener(key);
		addScreenEventRecorder();
		GlobalMouseListener example = new GlobalMouseListener();
		GlobalScreen.addNativeMouseListener(example);
		GlobalScreen.addNativeMouseMotionListener(example);
		Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.SECONDS);
	}

	private static void addScreenEventRecorder() {
		GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
			@Override
			public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
			}

			@Override
			public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
			}

			@Override
			public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
				Region r = new Region(Screen.getPrimaryScreen());
				Image img = r.getImage();
				StaticUtil.saveImage(img, StaticUtil.getTempDir() + "sk_" + UUID.randomUUID().toString() + ".png");
			}
		});
	}
}
