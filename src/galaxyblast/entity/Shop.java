package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class Shop {
	private static double x;
	private static double y;
	
	BufferedImage image;
	GalaxyAbduction game;
	
	public Shop(double x, double y, GalaxyAbduction game){
		Shop.x = x;
		Shop.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		image = ss.grabImage(11, 1, 32, 32);
	}
	
	
	public void tick(){
		y -= 3;
	}
	
	public double getY(){
		return y;
	}
	public double getX(){
		return x;
	}
	
	public void setX(double x){
		Shop.x = x;
	}
	public void setY(double y){
		Shop.y = y;
	}
	
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
}
