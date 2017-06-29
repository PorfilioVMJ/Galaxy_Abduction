package galaxyblast;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	GalaxyAbduction game;

	public KeyInput(GalaxyAbduction game){
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}

}
