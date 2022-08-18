package org.rinky.digitalassistant.bot.ai.vision;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameUtils;
import org.bytedeco.javacv.VideoInputFrameGrabber;
import org.bytedeco.opencv.opencv_core.IplImage;

public class CameraCapture {
public static IplImage captureCamera(int id, String fname) throws Exception {
	FrameGrabber grabber = new VideoInputFrameGrabber(id);
	   grabber.start();
	   Thread.currentThread().sleep(3000);
       Frame imgframe = grabber.grab();
       IplImage img = Java2DFrameUtils.toIplImage(imgframe);
       grabber.release();
       return img;
}
public static void main(String[] args)throws Exception {
	captureCamera(0, "c:/tmp/t.jpg");
}
}
