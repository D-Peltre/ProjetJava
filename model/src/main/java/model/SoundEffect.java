package model;
import java.io.*;
import javax.sound.sampled.*;
public enum SoundEffect {
   COIN("/Sound/coin.wav"),
   ENERGY("/Sound/energy.wav"),
   SHOOT("/Sound/shoot.wav"),
   GAMEOVER("/Sound/gameover.wav"),
   BONK("/Sound/bonk.wav");
   
   private Clip clip;
   
   SoundEffect(String soundFileName) {
      try {
         //URL url = this.getClass().getResource(soundFileName);
    	 InputStream ressource = this.getClass().getResourceAsStream(soundFileName);
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ressource);
         clip = AudioSystem.getClip();
         clip.open(audioInputStream);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   public void play() {
         if (clip.isRunning())
            clip.stop();
         clip.setFramePosition(0);
         clip.start();
      	}
   
   static void init() {
      values();
   }
}