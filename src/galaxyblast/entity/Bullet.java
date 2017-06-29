package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class Bullet {
	private static double x;
	private static double y;
	
	BufferedImage image;
	GalaxyAbduction game;
	
	public Bullet(double x, double y, GalaxyAbduction game){
		Bullet.x = x;
		Bullet.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		image = ss.grabImage(6, 1, 32, 32);
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
		Bullet.x = x;
	}
	public void setY(double y){
		Bullet.y = y;
	}
	
	public static void fireBullet(){
			y--;
	}
	
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
}
