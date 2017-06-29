package galaxyblast.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

public class Sound extends JApplet{
	private static final long serialVersionUID = 1L;
	
	private AudioClip audio; // Sound player
    private URL soundPath; // Sound path
      Sound(String filename)
     {
   try
   {
      soundPath = new URL(getCodeBase(),filename); // Get the Sound URL
      audio = Applet.newAudioClip(soundPath); // Load the Sound
   }
   catch(Exception e){} // Satisfy the catch
     }
	public void playSound()
     {
		audio.loop(); // Play
     }
     public void stopSound()
     {
    	 audio.stop(); // Stop
     }
     public void playLazer()
     {
    	 audio.play(); // Play only once
     }
     
     public void laser(){  
    	 Sound laser = new Sound("/Laser.wav");
    	 laser.playSound();
     }
}
