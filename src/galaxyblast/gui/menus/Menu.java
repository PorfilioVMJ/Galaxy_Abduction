package galaxyblast.gui.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import galaxyblast.GalaxyAbduction;

public class Menu {
	
	public Rectangle play = new Rectangle(GalaxyAbduction.XSize /2 - 60, 100, 100, 50);
	public Rectangle credits = new Rectangle(GalaxyAbduction.XSize /2 - 60, 200, 100, 50);
	public Rectangle option = new Rectangle(GalaxyAbduction.XSize /2 - 60, 300, 100, 50);
	public Rectangle quit = new Rectangle(GalaxyAbduction.XSize /2 - 60, 400, 100, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font font0 = new Font("arial", Font.BOLD, 50);
		g.setFont(font0);
		g.setColor(Color.BLUE);
		g.drawString("GALAXY ABDUCTION", 60,  60);
			
		
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(play.x, play.y, 100, 50);
		g.fillRect(credits.x, credits.y, 100, 50);
		g.fillRect(option.x, option.y, 100, 50);
		g.fillRect(quit.x, quit.y, 100, 50);
		g.setColor(Color.BLUE);
		g.drawString("Play", play.x + 19, play.y + 35);
		g.drawString("Credits", credits.x - 1, credits.y + 35);
		Font font3 = new Font("arial", Font.BOLD, 27);
		g.setFont(font3);
		g.drawString("Options", option.x - 1, option.y + 35);
		Font font4 = new Font("arial", Font.BOLD, 30);
		g.setFont(font4);
		g.drawString("Quit", quit.x + 19, quit.y + 35);
		g2d.draw(play);
		g2d.draw(credits);
		g2d.draw(option);
		g2d.draw(quit);
	}
	
}
