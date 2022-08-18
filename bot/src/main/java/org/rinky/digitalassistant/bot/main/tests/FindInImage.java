package org.rinky.digitalassistant.bot.main.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.rinky.digitalassistant.bot.StaticUtil;
import org.sikuli.script.Image;
import org.sikuli.script.Match;

public class FindInImage {
public static void main(String[] args) throws Exception{
	BufferedImage img =StaticUtil.getBufferedImageFromFile("C:\\projects\\data\\images\\logosall.PNG");
	BufferedImage img2 = StaticUtil.getBufferedImageFromFile("C:\\projects\\data\\images\\logoap.PNG");
	List<Match> matches = StaticUtil.getImage(new Image(img),new Image(img2));
	int i=0;
	for(Match m: matches) {
		BufferedImage img3 = img.getSubimage(m.x,m.y,m.w+100,m.h+100);
		ImageIO.write(img3,"png",new File("c:\\temp\\a"+(++i)+".png"));
	}
	System.out.println("Done");
}
}
