package galaxyblast.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Button {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Button(String label, int x, int y, int width, int height, Graphics2D g2d, Graphics g){
		Rectangle btn = new Rectangle(x, y, width, height);

		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLUE);
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		g.drawString(label, x + width / 20, y + height-height/3);
		g2d.draw(btn);
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Bounds getBounds(){
		Bounds bounds = new Bounds(x, y, width, height);
		return bounds;
	}
	final class Bounds{
	    private final int x;
	    private final int y;
	    private final int width;
	    private final int height;

	    public Bounds(int x, int y, int width, int height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}
	    

	}
}
