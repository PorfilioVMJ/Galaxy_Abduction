package galaxyblast.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import galaxyblast.GalaxyAbduction;
import galaxyblast.SpriteSheet;

public class TestEntity extends Entity{
	
	private double x;
	private double y;
	
	private double velX = 0;
	private double velY = 0;
	
	private static BufferedImage sprite;
	int move = 1;
	
	public TestEntity(double x, double y, GalaxyAbduction game) {
		super(6,50,game);
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet1());
		
		sprite = ss.grabImage(1, 1, 32, 32);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(sprite, (int)x, (int)y, null);
	}
	
	
	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
