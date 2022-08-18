package org.rinky.digitalassistant.bot.ai;



import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.bytedeco.opencv.opencv_core.IplImage;
import org.locationtech.jts.geom.Polygon;
import org.rinky.digitalassistant.bot.ai.vision.CameraCapture;
import org.rinky.digitalassistant.bot.ai.vision.DetectThingsUtils;
import org.rinky.digitalassistant.bot.ai.vision.FaceUtils;
import org.rinky.digitalassistant.bot.ai.vision.Image2Text;
import org.rinky.digitalassistant.bot.io.SoundCapture;
import org.rinky.digitalassistant.bot.io.SoundPlayer;
import org.rinky.digitalassistant.bot.io.SpeechToText;
import org.rinky.digitalassistant.bot.model.FaceObj;
import org.rinky.digitalassistant.bot.model.TextObj;
import static org.bytedeco.opencv.global.opencv_core.IPL_DEPTH_8U;
import static org.bytedeco.opencv.global.opencv_core.cvAbsDiff;
import static org.bytedeco.opencv.global.opencv_imgproc.CV_GAUSSIAN;
import static org.bytedeco.opencv.global.opencv_imgproc.CV_RGB2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.CV_THRESH_BINARY;
import static org.bytedeco.opencv.global.opencv_imgproc.CV_THRESH_OTSU;
import static org.bytedeco.opencv.global.opencv_imgproc.cvCvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.cvSmooth;
import static org.bytedeco.opencv.global.opencv_imgproc.cvThreshold;


public class AIHelper {

		public static String txlate(String what, String from, String to)throws Exception {
			return TxlateUtils.txlate(what, from, to);
		}
		public static String txtToSpeech(String what,String fname)throws Exception {
			String file= Text2SpeechUtils.synthesizeText(what,fname);
			if(file!=null) {
				return file;
			}else {
				return "";
			}
		}
		public static void delete(String fname)throws Exception {
			new File(fname).delete();
		}
		public static List<String> detectThings(String fileName)throws Exception{
			return DetectThingsUtils.detectObjects(fileName);
		}
		
		public static List<TextObj> image2Text(String fileName) throws IOException, Exception {
			return Image2Text.getText(fileName);
		}
		public static String getTextFromImage(String fileName) throws IOException, Exception {
			List<TextObj> a = Image2Text.getText(fileName);
			StringBuilder sb = new StringBuilder();
			for(TextObj aa: a) {
				sb.append(aa.getTxt());
			}
			return sb.toString();
		}
		public static List<TextObj> filter(List<TextObj> input,List<Polygon> polys) throws IOException, Exception {
			return Image2Text.filter(input,polys);
		}
		
		public static String captureSound(int seconds) {
			SoundCapture sc = new SoundCapture();
			String fname = AIConfig.getTmpDir()+StringUtils.replaceChars(UUID.randomUUID().toString(),"-","_")+".wav";
			sc.with(new File(fname));
			System.out.println(fname);
			sc.captureForTime();
			return fname;
		}
		
		public static void playSound(String fname) throws Exception {
			SoundPlayer.playSound(fname);
		}
		
		public static String speechToText(String fname) throws Exception {
			return SpeechToText.convert(fname);
		}
		
		public static IplImage captureCamera(String fname) throws Exception{
			return CameraCapture.captureCamera(0, fname);
		}
		public static FaceObj emotionDetect(String fname) throws Exception {
			return FaceUtils.detectFaces(fname);
		}
		public static int getPercentageChangeBinary(IplImage orig, IplImage imglast) {
			IplImage img = clone(orig);
			gaussSmooth(imglast, 9, 9, 2, 2);
			gaussSmooth(img, 9, 9, 2, 2);
			img = convertToGrayImage(img);
			imglast = convertToGrayImage(imglast);
			IplImage diffImg = createGrayImage(img);
			absDiff(imglast, img, diffImg);
			convertToBinImage(diffImg, 3, 255);
			int hist = calculateWhitePixelCount(diffImg);
			int percentageChange = calculatePercChange(diffImg, hist);
			return percentageChange;
		}
		public static void gaussSmooth(IplImage img, int apWidth, int apHeight, int colorSigma, int spatSigma) {
			cvSmooth(img, img, CV_GAUSSIAN, apWidth, apHeight, colorSigma, spatSigma);
		}

		public static IplImage clone(IplImage img) {
			IplImage orig;
			orig = img.clone();
			return orig;
		}
		public static IplImage convertToGrayImage(IplImage imglast) {
			IplImage grayImglast = createGrayImage(imglast);
			toGrayImage(imglast, grayImglast);
			return grayImglast;
		}
		public static void toGrayImage(IplImage img, IplImage grayImg) {
			cvCvtColor(img, grayImg, CV_RGB2GRAY);
		}

		public static IplImage createGrayImage(IplImage img) {
			IplImage grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
			return grayImg;
		}
		public static void convertToBinImage(IplImage diffImg, double threshold, double maxVal) {
			cvThreshold(diffImg, diffImg, threshold, maxVal, CV_THRESH_BINARY);
		}
		public static void convertToBinImage2(IplImage diffImg, double threshold, double maxVal) {
			cvThreshold(diffImg, diffImg, threshold, maxVal, CV_THRESH_BINARY|CV_THRESH_OTSU);
		}
		public static void absDiff(IplImage imglast, IplImage grayImg, IplImage diffImg) {
			cvAbsDiff(grayImg, imglast, diffImg);
		}
		public static int calculateWhitePixelCount(IplImage diffImg) {
			int hist = 0;
			ByteBuffer buffer = diffImg.getByteBuffer();
			for (int y = 0; y < diffImg.height(); y++) {
				for (int x = 0; x < diffImg.width(); x++) {
					int index = y * diffImg.widthStep() + x * diffImg.nChannels();
					int value = buffer.get(index) & 0xFF;
					if (value > 0) {
						hist++;
					}

				}
			}
			return hist;
		}

		public static int calculatePercChange(IplImage diffImg, int hist) {
			int percentageChange = hist * 100 / (diffImg.height() * diffImg.width());
			return percentageChange;
		}


	}