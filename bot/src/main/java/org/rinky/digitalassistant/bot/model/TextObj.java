package org.rinky.digitalassistant.bot.model;

import org.locationtech.jts.geom.Polygon;

public class TextObj {
	private Polygon poly;
	private String txt;
	private String id;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Polygon getPoly() {
		return poly;
	}

	public void setPoly(Polygon poly) {
		this.poly = poly;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public String toString() {
		return "TextObj [poly=" + poly + ", txt=" + txt + ", id=" + id + "]";
	}

}
