package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class AlienLaser {
	private static double x;
	private static double y;
	
	BufferedImage image;
	GalaxyAbduction game;
	
	public AlienLaser(double x, double y, GalaxyAbduction game){
		AlienLaser.x = x;
		AlienLaser.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		image = ss.grabImage(6, 1, 32, 32);
	}
	
	
	public void tick(){
		y++;
	}
	
	public double getY(){
		return y;
	}
	public double getX(){
		return x;
	}
	
	public void setX(double x){
		AlienLaser.x = x;
	}
	public void setY(double y){
		AlienLaser.y = y;
	}
	
	public static void fireBullet(){
			
	}
	
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
}
