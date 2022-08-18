package org.rinky.digitalassistant.bot.model;

import org.jnativehook.keyboard.NativeKeyEvent;

public class ShortCut {
	int ch0;
	int ch1;
	int ch2;
	private String txt;
	Runnable r  = null;
	
	public void setAction(Runnable r) {
		this.r = r;
	}
	public ShortCut(int ch0, int ch1, int ch2,String txt) {
		this.ch0 = ch0;
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.txt = txt;
	}
	public int getCh0() {
		return ch0;
	}
	public void setCh0(int ch0) {
		this.ch0 = ch0;
	}
	public int getCh1() {
		return ch1;
	}
	public void setCh1(int ch1) {
		this.ch1 = ch1;
	}
	public int getCh2() {
		return ch2;
	}
	public void setCh2(int ch2) {
		this.ch2 = ch2;
	}
	public void action() {
		if(r==null)
			System.out.println("Triggered: " +txt);
		else
			r.run();
	}
	
}
