package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class Alien {
	private double x;
	private double y;
	
	private double velX = 0;
	private double velY = 0;
	
	private static BufferedImage alien;
	
	public static int askin = 7;
	int move = 1;
	
	public void isDead(){
		System.out.println("alien is Dead");
	}
	
	
	public Alien(double x, double y,GalaxyAbduction game){
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		alien = ss.grabImage(askin, 1, 32, 32);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		if(GalaxyAbduction.pause == 0){	
			if(x == 1){
				move = 1;
			} 
			if(x == 610){
				move = 2;
			}
			if(move == 1){
				x++;
			}else if(move == 2){
				x--;
			}
		}
	}
	
	public void render(Graphics g){
		g.drawImage(alien, (int)x, (int)y, null);
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setVelX(double velX){
		this.velX = velX;
	}
	public void setVelY(double velY){
		this.velY = velY;
	}
}
