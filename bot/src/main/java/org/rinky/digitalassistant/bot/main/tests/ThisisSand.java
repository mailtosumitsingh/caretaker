package org.rinky.digitalassistant.bot.main.tests;

import java.util.Arrays;
import java.util.Map;

import org.rinky.digitalassistant.bot.MouseAndKeyboard;

import com.google.api.client.util.Maps;

public class ThisisSand {
	public static class ColorXY {
		String color;
		int x;
		int y;

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		private ColorXY(String color, int x, int y) {
			super();
			this.color = color;
			this.x = x;
			this.y = y;
		}

	}

	static Map<String, ColorXY> c = Maps.newHashMap();
	static {
		c.put("s", new ColorXY("s", 1843, 170));
		c.put("0", new ColorXY("random", 300, 400));
		c.put("1", new ColorXY("yellow", 67, 545));
		c.put("2", new ColorXY("green", 350, 517));
		c.put("3", new ColorXY("aqua", 628, 513));
		c.put("4", new ColorXY("blue", 1256, 542));
		c.put("5", new ColorXY("pink", 1573, 518));
		c.put("6", new ColorXY("red", 1831, 514));

	}

	public static void pickColor(String color) throws Exception {
		ColorXY cc = c.get("s");
		MouseAndKeyboard.moveMouse(cc.getX(), cc.getY());
		Thread.sleep(100);
		MouseAndKeyboard.moveLClicked();
		Thread.sleep(1000);
		cc = c.get(color);
		MouseAndKeyboard.moveMouse(cc.getX(), cc.getY());
		Thread.sleep(20);
		MouseAndKeyboard.moveLClicked();
		Thread.sleep(2000);
	}

	public static void main(String[] args) throws Exception {
		Thread.sleep(3000);
		ColorXY cx = c.get("s");
		MouseAndKeyboard.moveMouse(cx.x, cx.y);
		Thread.sleep(1000);
		System.out.println(Arrays.toString(MouseAndKeyboard.getMouseLoc()));
		for (int i = 0; i < 1000; i++) {
			int ii = (int) ((Math.random()*10)%6);
			pickColor(""+ii);
			MouseAndKeyboard.moveLDown();
			Thread.sleep(10);
			int x = (int) (Math.random() * 1000);
			int y = (int) (Math.random() * 1000);
			for (int j = 0; j < 300; j++) {
				System.out.println(x + " : " + y);
				MouseAndKeyboard.moveMouseApprox(x + j, y + j);
				Thread.sleep(10);
			}
			MouseAndKeyboard.moveLUp();
			Thread.sleep(10);
		}
	}
}
