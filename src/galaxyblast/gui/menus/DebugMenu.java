package galaxyblast.gui.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import galaxyblast.gui.Button;
import galaxyblast.gui.Gui;

public class DebugMenu extends Gui{
	
	boolean toggled = false;
	
	public Button debugBtn;
	public Button testBtn;
	
	String menuName;
	
	public DebugMenu(String menuName) {
		super(menuName);
		this.menuName = menuName;
	}
	
	
	@Override
	public void render(Graphics g) {		
		Graphics2D g2d = (Graphics2D) g;
		
		debugBtn = new Button("Debug", 60, 130, 100, 50, g2d, g);
		testBtn = new Button("Run Test", 60, 200, 145, 50, g2d, g);
		
		Font font0 = new Font("arial", Font.BOLD, 50);
		g.setFont(font0);
		g.setColor(Color.BLUE);
		g.drawString(menuName, 60,  60);
	}

	public boolean isToggled() {
		return toggled;
	}

	@Override
	public String getName() {
		return menuName;
	}

}
