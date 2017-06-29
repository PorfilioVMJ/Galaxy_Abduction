package galaxyblast.gui.menus;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;
import galaxyblast.gui.menus.Selector;

public class Selector {
	private static double x;
	private static double y;
	
	private double velX = 0;
	private double velY = 0;
	
	
	
	private static BufferedImage select;
	
	public static int skin = 12;
	
	
	public void isDead(){
		System.out.println("Selector is Dead");
	}
	
	
	public Selector(double x, double y,GalaxyAbduction game){
		Selector.x = x;
		Selector.y = y;
		
			SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
			select = ss.grabImage(skin, 1, 32, 32);
		
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
	}
	
	public void render(Graphics g){
		g.drawImage(select, (int)x, (int)y, null);
	}
	
	public static void rerender(Graphics g){
		g.drawImage(select, (int)x, (int)y, null);
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double x){
		Selector.x = x;
	}
	public void setY(double y){
		Selector.y = y;
	}
}
