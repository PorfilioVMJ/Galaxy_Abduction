package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class Player {
	private static double x;
	private static double y;
	
	private double velX = 0;
	private double velY = 0;
	
	
	
	private static BufferedImage player;
	
	public static int skin = 1;
	
	
	public void isDead(){
		System.out.println("Player is Dead");
	}
	
	
	public Player(double x, double y,GalaxyAbduction game){
		Player.x = x;
		Player.y = y;
		
		if(GalaxyAbduction.textures == 1){
			SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
			player = ss.grabImage(skin, 1, 32, 32);
		}
		if(GalaxyAbduction.textures == 2){
			SpriteSheet ss = new SpriteSheet(game.getSpriteSheet2());
			player = ss.grabImage(skin, 1, 32, 32);
		}
		if(GalaxyAbduction.textures == 3){
			SpriteSheet ss = new SpriteSheet(game.getSpriteSheet3());
			player = ss.grabImage(skin, 1, 32, 32);
		}
		
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		/*
		  g.drawImage(lazer, 3, 435, this);
		  g.drawImage(itemsel, 3, 435, this);
		*/
		if(x <= 0)
			x = 1;
		if(x >= 640 - 39)
			x = 640 - 38;
		if(y <= 11)
			y = 0 + 16;
		if(y >= 480 - 40)
			y = 480 - 42;
		if(y >= 405)
			y = 405 - 1;
	}
	
	public void render(Graphics g){
		g.drawImage(player, (int)x, (int)y, null);
	}
	
	public static void rerender(Graphics g){
		g.drawImage(player, (int)x, (int)y, null);
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double x){
		Player.x = x;
	}
	public void setY(double y){
		Player.y = y;
	}
	public void setVelX(double velX){
		this.velX = velX;
	}
	public void setVelY(double velY){
		this.velY = velY;
	}
}
