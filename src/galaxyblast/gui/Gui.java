package galaxyblast.gui;

import java.awt.Graphics;

public abstract class Gui {
	
	protected String menuName;
	
	public Gui(String menuName){
		this.menuName = menuName;
	}
	
	public abstract void render(Graphics g);
	
	public abstract String getName();
}
