package org.rinky.digitalassistant.bot.io;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import org.springframework.stereotype.Component;

/**
 * A sample program is to demonstrate how to record sound in Java
 * author: www.codejava.net
 */
@Component
public class SoundCapture{
    private long recordTime = 3000;  
    private File wavFile = new File("c:\\temp\\sound.wav");;
    private AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    private TargetDataLine line;
    
    public SoundCapture with(File f) {
		this.wavFile = f;
		return this;
	}
    public SoundCapture with(long recordTimeInMillis) {
		this.recordTime   = recordTimeInMillis;
		return this;
	}
    private AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }

    private void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing

            System.out.println("Start capturing...");

            AudioInputStream ais = new AudioInputStream(line);

            System.out.println("Start recording...");

            // start recording
            AudioSystem.write(ais, fileType, wavFile);

        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

   private  void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }

    public void captureForTime() {
        final SoundCapture recorder = new SoundCapture();
        recorder.with(wavFile);
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(recordTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
        stopper.start();
        recorder.start();
    }
    public void captureForTime(final Runnable r) {
        final SoundCapture recorder = new SoundCapture();
        recorder.with(wavFile);
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(recordTime);
                    r.run();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
        stopper.start();
        recorder.start();
    }

}