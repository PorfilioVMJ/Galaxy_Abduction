package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public abstract class Entity {
	
	private double x;
	private double y;
	private int cols;
	private int row;
	
	private double velX = 0;
	private double velY = 0;
	
	private static BufferedImage sprite;
	int move = 1;

	
	public Entity(double x, double y,GalaxyAbduction game){
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		sprite = ss.grabImage(cols, row, 32, 32);
	}
	
   public abstract void enableAI();

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public static BufferedImage getSprite() {
		return sprite;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
