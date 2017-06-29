package galaxyblast.keys;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import galaxyblast.GalaxyAbduction;

//import galaxyblast.gui.Selector;

public class MouseScroll implements MouseWheelListener{
	
	GalaxyAbduction game;
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation()>=0){
			GalaxyAbduction.scroller -= 32;
		}else{
			GalaxyAbduction.scroller += 32;
		}
	}
	
}
