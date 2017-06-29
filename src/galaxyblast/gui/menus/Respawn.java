package galaxyblast.gui.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import galaxyblast.GalaxyAbduction;

public class Respawn {
	public Rectangle respawn = new Rectangle(GalaxyAbduction.XSize /2 - 60, 150, 150, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font font0 = new Font("arial", Font.BOLD, 50);
		g.setFont(font0);
		g.setColor(Color.BLUE);
		g.drawString("You Were Abducted", 60,  110);
		
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		g.drawString("Respawn", respawn.x + 19, respawn.y + 35);
		g2d.draw(respawn);
	}
}
