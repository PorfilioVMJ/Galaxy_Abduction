package galaxyblast.gui.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import galaxyblast.gui.Button;
import galaxyblast.gui.Gui;
import galaxyblast.gui.Input;

public class LoginMenu extends Gui{
	
	String menuName;
	
	public Button enter;
	public Input input;
	
	public String text;

	public LoginMenu(String menuName) {
		super(menuName);
		this.menuName = menuName;
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		enter = new Button("Login", 235, 300, 100, 50, g2d, g);
		//USERNAME
		Font font1 = new Font("arial", Font.BOLD, 30);
		g.setFont(font1);
		g.setColor(Color.BLUE);
		g.drawString("Username", 200,  180);
		input = new Input(text, 200, 200, 300, 50, g2d, g);
		
		Font font0 = new Font("arial", Font.BOLD, 50);
		g.setFont(font0);
		g.setColor(Color.BLUE);
		g.drawString(menuName, 60,  60);
	}

	@Override
	public String getName() {
		return menuName;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
