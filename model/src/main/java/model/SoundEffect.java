package model;
import java.io.*;
import javax.sound.sampled.*;
public enum SoundEffect {
	/* The different resources... sounds generated with <a href="http://www.bfxr.net/">BFXR</a> */
   COIN("/Sound/coin.wav"),
   ENERGY("/Sound/energy.wav"),
   SHOOT("/Sound/shoot.wav"),
   GAMEOVER("/Sound/gameover.wav"),
   BONK("/Sound/bonk.wav");
    /* The current Audio clip */
   private Clip clip;
   
    /**
     * The initializer for a given sound effect
     * @param soundFileName - the file to load
     */
   SoundEffect(String soundFileName) {
      try {
    	   /* get the right ressource from the JAR */
    	 InputStream ressource = this.getClass().getResourceAsStream(soundFileName);
    	   /* makes a inputstream from it*/
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ressource);
           /* get a channel, and load our sound effect inside */
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
   
   /**
    * This function starts the given sound effect
    */
   public void play() {
	       /* test if it is running */
         if (clip.isRunning())
            clip.stop();
           /* reset the audio pos */
         clip.setFramePosition(0);
           /* start the effect */
         clip.start();
      	}
   
   /**
    * This starts the sound system
    */
   static void init() {
      values();
   }
}