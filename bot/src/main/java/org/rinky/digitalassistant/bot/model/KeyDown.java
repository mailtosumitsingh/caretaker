package org.rinky.digitalassistant.bot.model;

public class KeyDown {
	int ch;
	long at;
	String txt;
	

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public KeyDown(int keyCode, long when) {
		this.ch = keyCode;
		this.at = when;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public long getAt() {
		return at;
	}

	public void setAt(long at) {
		this.at = at;
	}

}
