package galaxyblast.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Input {
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Input(String text, int x, int y, int width, int height, Graphics2D g2d, Graphics g){
		Rectangle input = new Rectangle(x, y, width, height);
		
		if(text==""||text==" "||text==null){
			text = "  ";
		}
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLUE);
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		g.drawString(text, x + width / 20, y + height-height/3);
		g2d.draw(input);
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
}
