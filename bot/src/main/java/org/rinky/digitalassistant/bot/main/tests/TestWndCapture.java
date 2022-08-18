package org.rinky.digitalassistant.bot.main.tests;

import java.awt.image.BufferedImage;

import org.rinky.digitalassistant.bot.StaticUtil;
import org.rinky.digitalassistant.bot.win32.NativeWindowUtils;

import com.sun.jna.platform.win32.WinDef.HWND;

public class TestWndCapture {
public static void main(String[] args)throws Exception {
	Thread.currentThread().sleep(2000);
	HWND hwnd = NativeWindowUtils.getForgroundWindow();
	BufferedImage b = NativeWindowUtils.captureWindow(hwnd);
	StaticUtil.save(b, "c:\\temp\\test.png", "png");
	
}
}
