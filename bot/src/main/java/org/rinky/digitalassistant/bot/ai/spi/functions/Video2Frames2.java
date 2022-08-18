package org.rinky.digitalassistant.bot.ai.spi.functions;

import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.rinky.digitalassistant.bot.StaticUtil;

public class Video2Frames2 {
public static void main(String[] args) throws Exception{
	 	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	  VideoCapture camera = new VideoCapture("C:\\projects\\data\\videos\\B.m4v");
	  
	          Mat frame = new Mat();  
	          int i = 0;
	          while(true){
	              System.out.println("Looping.. \n");
	              if (camera.read(frame)){
	                  System.out.println("Frame Obtained");
	                  BufferedImage img = (BufferedImage) HighGui.toBufferedImage( frame);
	                  StaticUtil.save(img, "C:\\projects\\data\\videos\\b\\B_"+i+++".jpg", "jpg");
	                  System.out.println("OK");
	          }
	          }
}
}
