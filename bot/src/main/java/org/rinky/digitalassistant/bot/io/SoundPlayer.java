package org.rinky.digitalassistant.bot.io;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.springframework.stereotype.Component;
@Component
public class SoundPlayer {

    public static void playSound(String name) throws Exception{
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(name));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
