package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class Rocket {
	private static double x;
	private static double y;
	
	BufferedImage image;
	GalaxyAbduction game;
	
	public Rocket(double x, double y, GalaxyAbduction game){
		Rocket.x = x;
		Rocket.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		image = ss.grabImage(13, 1, 32, 32);
	}
	
	
	public void tick(){
		y -= 10;
	}
	
	public double getY(){
		return y;
	}
	public double getX(){
		return x;
	}
	
	public void setX(double x){
		Rocket.x = x;
	}
	public void setY(double y){
		Rocket.y = y;
	}
	
	public static void fireBullet(){
			y--;
	}
	
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
}
