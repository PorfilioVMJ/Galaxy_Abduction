package galaxyblast.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener{
	
	int x;
	int y;
	int width;
	int height;
	
	Object result;
	
	public ButtonListener(Button button, Object result){
		x = button.getBounds().getX();
		y = button.getBounds().getY();
		width = button.getBounds().getWidth();
		height = button.getBounds().getHeight();
		this.result = result;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= x && mx >= x-width){
			if(my >= y && my <= y-height){
				result = new Object();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
