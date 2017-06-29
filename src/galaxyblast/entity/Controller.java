package galaxyblast.entity;

import java.awt.Graphics;
import java.util.LinkedList;

import galaxyblast.GalaxyAbduction;

public class Controller {
	
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	
	Bullet TB;
	GalaxyAbduction game;
	
	Player p;
	
	Alien a;
	
	public Controller(GalaxyAbduction game){
		this.game = game;
		
		//addBullet(new Bullet(100, 300, game));
	}

	public void tick(){
		for(int i = 0; i < b.size(); i++){
			TB = b.get(i);
			
			TB.tick();
		}
		
		if(TB.getX() >= a.getX() - 5 && TB.getX() <= a.getX() + 5 && TB.getY() >= a.getY() - 2 && TB.getY() <= a.getY() + 2){
			System.out.println("hit");
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < b.size(); i++){
			TB = b.get(i);
			
			TB.render(g);
		}
	}
	
	
	public void addBullet(Bullet block){
		b.add(block);
	}
	public void removeBullet(Bullet block){
		b.remove(block);	
	}

}
