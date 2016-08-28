package galaxyblast;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import galaxyblast.data.Data;
import galaxyblast.entity.Alien;
import galaxyblast.entity.AlienLaser;
import galaxyblast.entity.Bullet;
import galaxyblast.entity.Player;
import galaxyblast.entity.Rocket;
import galaxyblast.entity.Shop;
import galaxyblast.gui.Menu;
import galaxyblast.gui.MouseInput;
import galaxyblast.gui.Selector;
import galaxyblast.keys.MouseScroll;

public class GalaxyAbduction extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final String TITLE = "Galaxy Abduction";
	public static final int YSize = 500;
	public static final int XSize = 640;
	public static final String VERSION = "v0.8 Public BETA";
	
	private boolean running =  false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet1 = null;
	private BufferedImage spriteSheet2 = null;
	private BufferedImage spriteSheet3 = null;
	private BufferedImage background = null;
	private BufferedImage menubackground = null;
	private BufferedImage skin1 = null;
	private BufferedImage skin2 = null;
	private BufferedImage skin3 = null;
	private BufferedImage load = null;
	private BufferedImage skinc = null;
	private BufferedImage skinback = null;
	private BufferedImage lazer = null;
	private BufferedImage rockettext = null;
	
	public static boolean isShooting = false;
	private boolean aisShooting = false;
	
	public static String user;
	
	static int amount = 0;
	static int rocket = 3;
	static int bullet = 50;
	static int none = 0;
	
	public static int pause = 0;
	static int aHealth = 1000; 
	static int Health = 50;
	static int Regen = 0;  
	static int roll = 0;
	
	static int loader = 0;
	public static int scroller;
	
	public static int score = 0;
	
	public static int textures = 1;
	public static String spriteSheet;
	
	public int frames = 0;
	
	private Player p;
	private Bullet b;
	private Alien a;
	private Menu menu;
	private Shop shop;
	private AlienLaser laser;
	private Selector select; 
	private Rocket rocketb; 
	
	public static enum STATE{
		MENU,
		GAME,
		RESPAWN,
		WIN,
		OPTIONS,
		CREDITS,
		LOAD,
		SHOP
	};
	
	public static STATE State = STATE.LOAD;
	
	private synchronized void Start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		scroller = 3;
	}
	
	private synchronized void stop(){
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	
	//TODO: Tick
	public void tick(){
		if(State == STATE.GAME){
			p.tick();
			a.tick();
			laser.tick();
			rocketb.tick();
		}
	}
	
	public void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		if(State == STATE.GAME){
			//TODO: HUD
			Font font3 = new Font("arial", Font.BOLD, 12);
			g.setColor(Color.CYAN);
			g.setFont(font3);
			g.drawLine(1, 15, XSize, 15);
			//g.fillRect(66, 0, 520, 15);
			g.drawImage(background,  0, 0, null);
			g.drawString("Bullets: " + amount, 5, 11);
			
			g.drawString("FPS: " + frames + " Srorry FPS is buggy Default amount is 150", 150, 455);
			
			//TODO: HERE
			g.drawString("Health: " + Health, 575, 11);
			g.setColor(Color.BLUE);
			g.drawString("Alien Health: " + aHealth, 280, 11);
			g.setColor(Color.GRAY);
			g.fillRect(565, 444, 66, 22);
			g.setColor(Color.CYAN);
			g.drawString("Score: " + score, 570, 460);
			g.drawImage(lazer, 3, 435, this);
			g.drawString("Laser", 2, 425);
			g.drawImage(rockettext, 35, 435, this);
			g.drawString("Rocket", 36, 425);
			g.setColor(Color.GREEN);
			g.drawString("Shop", 550, 360);
			g.setColor(Color.CYAN);
			
			//TODO: Render
		
				a.render(g);
				p.render(g);
				b.render(g);
				shop.render(g);
				laser.render(g);
				select.render(g);
				rocketb.render(g);
		}
		if(State == STATE.MENU){
			g.drawImage(menubackground,  0, 0, null);
			menu.render(g);
		}
		if(State == STATE.RESPAWN){
			g.drawImage(menubackground,  0, 0, null);
			Rectangle respawn = new Rectangle(GalaxyAbduction.XSize /2 - 80, 150, 150, 50);
			Rectangle menu = new Rectangle(GalaxyAbduction.XSize /2 - 80, 250, 150, 50);
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(respawn.x, respawn.y, 150, 50);
			g.fillRect(menu.x, menu.y, 150, 50);
			g.setColor(Color.BLUE);
			
			Font font0 = new Font("arial", Font.BOLD, 50);
			g.setFont(font0);
			g.setColor(Color.BLUE);
			g.drawString("You Were Abducted", 80,  110);
			
			Font font2 = new Font("arial", Font.BOLD, 30);
			g.setFont(font2);
			g.drawString("Respawn", respawn.x + 10, respawn.y + 35);
			g.drawString("Menu", menu.x + 35, menu.y + 35);
			g2d.draw(respawn);
			g2d.draw(menu);
		}
		if(State == STATE.WIN){
			g.drawImage(menubackground, 0, 0, null);
			Rectangle menu = new Rectangle(GalaxyAbduction.XSize /2 - 60, 150, 100, 50);
			
				Graphics2D g2d = (Graphics2D) g;
				
				Font font0 = new Font("arial", Font.BOLD, 50);
				g.setFont(font0);
				g.setColor(Color.DARK_GRAY);
				g.fillRect(menu.x, menu.y, 100, 50);
				g.setColor(Color.BLUE);
				g.drawString("YOU DEFEATED HIM", 60,  110);
				
				Font font2 = new Font("arial", Font.BOLD, 30);
				g.setFont(font2);
				g.drawString("Menu", menu.x + 11, menu.y + 35);
				g2d.draw(menu);
		}
		if(State == STATE.CREDITS){
			g.drawImage(menubackground, 0, 0, null);
			Font font0 = new Font("arial", Font.BOLD, 40);
			g.setFont(font0);
			g.setColor(Color.CYAN);
			g.drawString("VMJLabs Presents", 180, roll);
			g.drawString(TITLE, 180, roll + 30);
			Font font1 = new Font("arial", Font.BOLD, 30);
			g.setFont(font1);
			g.setColor(Color.BLUE);
			g.drawString("Creator:", 240, roll + 60);
			g.drawString("PorfilioVMJ", 240,  roll + 90);
		}
		if(State == STATE.OPTIONS){
			Graphics2D g2d = (Graphics2D) g;
			Rectangle back = new Rectangle(10, 410, 100, 50);
			g.drawImage(skinback, 0, 0, null);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(10, 410, 100, 50);
			Font font3 = new Font("arial", Font.BOLD, 30);
			g.setColor(Color.BLUE);
			g.setFont(font3);
			g.drawString("Back", back.x + 15, back.y + 35);
			
			g.drawImage(skin1, 175, 35, this);
			g.drawImage(skin2, 290, 35, this);
			g.drawImage(skin3, 395, 35, this);
			g.drawImage(skinc, 50, 35, this);
			
			g2d.draw(back);
		}
		if(State == STATE.LOAD){
			g.drawImage(load, 0, 0, this);
		}
		if(State == STATE.SHOP){
			Graphics2D g2d = (Graphics2D) g;
			Rectangle back = new Rectangle(10, 410, 100, 50);
			
			g.drawImage(menubackground, 0, 0, this);
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(10, 410, 100, 50);
			Font font3 = new Font("arial", Font.BOLD, 30);
			g.setColor(Color.BLUE);
			g.setFont(font3);
			g.drawString("Back", back.x + 15, back.y + 35);
			g2d.draw(back);
		}
		/////////////////////////////////
		g.dispose();
		bs.show();
	}
	//TODO: Controls
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(State == STATE.GAME){
			if(key == KeyEvent.VK_D){
				Player.skin = 5;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				p.setVelX(5);
			}else if(key == KeyEvent.VK_A){
				Player.skin = 4;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				p.setVelX(-5);
			}else if(key == KeyEvent.VK_S){
				Player.skin = 3;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				p.setVelY(5);
			}else if(key == KeyEvent.VK_W){
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				p.setVelY(-5);
			}else if(key == KeyEvent.VK_F && !isShooting){
				//TODO: Only one bullet can be fired a a time
				isShooting = true;
				
				if(bullet > 0 && scroller == 3){
					b = new Bullet(p.getX(), p.getY() - 34, this);
					bullet--;
				}else if(rocket > 0 && scroller == 35){
					rocketb = new Rocket(p.getX(), p.getY(), this);
					rocket--;
				}
			}else if(key == KeyEvent.VK_2){
				scroller = 35;
			}else if(key == KeyEvent.VK_1){
				scroller = 3;
			}else if(key == KeyEvent.VK_3){
				scroller = 67;
			}else if(key == KeyEvent.VK_4){
				scroller = 99;
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(State == STATE.GAME){
			if(key == KeyEvent.VK_D){
				p.setVelX(0);
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
			}else if(key == KeyEvent.VK_A){
				p.setVelX(0);
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
			}else if(key == KeyEvent.VK_S){
				p.setVelY(0);
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
			}else if(key == KeyEvent.VK_W){
				p.setVelY(0);
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
			}else if(key == KeyEvent.VK_F){
				isShooting = false;
			}
		}
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			Bullet.fireBullet();
			
			if(pause == 2){
				pause = 0;
			}
			
		//	if(b.getY() == 15){
			//	b.setY(999999999);
			//}
			
			//loop
			loader++;
			
			select.setX(scroller);
			
				Regen++;
			
			if(Regen == 1000 && aHealth < 1000){
				aHealth++;
				Regen = 0;
			}
			
			//scroll
			
			if(scroller == 3){
				amount = bullet;
			}else if(scroller == 35){
				amount = rocket;
			}else if(scroller == 57){
				amount = none;
			}else if(scroller == 79){
				amount = none;
			}
			
			if(select.getX() >= 120){
				select.setX(3);
				scroller = 3;
			}
			if(loader == 1000){
				State = STATE.MENU;
			}
			
			
			if(aHealth >= 1000){
				aHealth = 1000;
			}
			
			roll++;
			
			if(State == STATE.GAME){
				if(p.getX() >= shop.getX() - 30 && p.getY() >= shop.getY() - 30){
					p.setX(p.getX() - 20);
					p.setY(p.getY() - 20);
					p.setVelX(0);
					p.setVelY(0);
					System.out.println("Going To Shop");
					State = STATE.SHOP;
				}
			}
			
			if(State != STATE.CREDITS){
				roll = 0;
			}
			
			if(roll == 500){
				State = STATE.MENU;
			}
		
			//TODO: Fix alien death
			if(b.getX() >= a.getX() - 5 && b.getX() <= a.getX() + 5 && b.getY() >= a.getY() - 2 && b.getY() <= a.getY() + 2){
				System.out.println("Hit");
				Alien.askin = 9;
				double px = a.getX();
				double py = a.getY();
				a = new Alien(px, py, this);
				score += 5;
				bullet++;
				aHealth--;
			}
			
	
			if(rocketb.getX() >= a.getX() - 15 && rocketb.getX() <= a.getX() + 15 && rocketb.getY() >= a.getY() - 12 && rocketb.getY() <= a.getY() + 12){
				System.out.println("Hit");
				Alien.askin = 9;
				double px = a.getX();
				double py = a.getY();
				a = new Alien(px, py, this);
				score += 5;
				aHealth -= 30;
			}
			if(laser.getX() >= p.getX() - 5 && laser.getX() <= p.getX() + 5 && laser.getY() >= p.getY() - 2 && laser.getY() <= p.getY() + 2){
				System.out.println("Hit");
				Player.skin = 10;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				Health--;
			}
			
			if(p.getX() == a.getX() - 5){
				p.setX(a.getX()-6);
				p.setY(p.getY()-1);
				Player.skin = 8;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
			}
			//ashoot
			if(p.getX() == a.getX() -2 && aisShooting == false){
				aisShooting = true;
				laser = new AlienLaser(a.getX(), a.getY(), this);
			}
			if(p.getX() == a.getX() - 2){
				p.setX(a.getX()+6);
				p.setY(p.getY()-1);
				Player.skin = 8;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
			}
			if(p.getY() == a.getY() && p.getY() == a.getY() && p.getX() >= a.getX() - 10 && p.getX() <= a.getX() + 10){
				p.setY(p.getY() - 100);
				Health -= 6;
				Health--;
			}
			
			if(p.getY() == laser.getY()){
				aisShooting = false;
			}
			
			if(Health == 0 || Health <= 0){
				System.out.println("Fail");
				p.setY(200);
				p.setX(200);
				p.setVelX(0);
				p.setVelY(0);
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				Alien.askin = 7;
				double ax = a.getX();
				double ay = a.getY();
				a = new Alien(ax, ay, this);
				bullet = 50;
				rocket = 3;
				aHealth = 1000;
				Health = 50;
				a.setX(1);
				State = STATE.RESPAWN;
			}
			
			if(aHealth == 0 || aHealth < 0){
				State = STATE.WIN;
				p.setY(200);
				p.setX(200);
				p.setVelX(0);
				p.setVelY(0);
				Player.skin = 1;
				double px = p.getX();
				double py = p.getY();
				p = new Player(px, py, this);
				Alien.askin = 7;
				double ax = a.getX();
				double ay = a.getY();
				a = new Alien(ax, ay, this);
				bullet = 50;
				aHealth = 1000;
				Health = 50;
				score += 10;
				rocket = 3;
				laser.setX(0 - 5);
				laser.setY(550);
				a.setX(1);
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("[" + updates + "Ticks, Fps " + frames + "]");
				updates = 0;
				frames = 0;
			}
			
		}
		stop();
	}
	
	
	//images
	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			System.out.println("Loading 512x512 SpriteSheet...");
			spriteSheet1 = loader.loadImage("/textures1.png");
			spriteSheet2 = loader.loadImage("/textures2.png");
			spriteSheet3 = loader.loadImage("/textures3.png");
			background = loader.loadImage("/background.png");
			menubackground = loader.loadImage("/Menubackground.png");
			skin1 = loader.loadImage("/skin1.png");
			skin2 = loader.loadImage("/skin2.png");
			skin3 = loader.loadImage("/skin3.png");
			skinc = loader.loadImage("/skin" + textures +".png");
			load = loader.loadImage("/load.png");
			skinback = loader.loadImage("/skinback.png");
			lazer = loader.loadImage("/laser.png");
			rockettext = loader.loadImage("/rockettext.png");
			//itemsel = loader.loadImage("/itemsel.png");
			System.out.println("Loaded 512x512 SpriteSheet");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		this.addMouseWheelListener(new MouseScroll());
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
		
		//TODO: Render Entity
		p = new Player(200, 200, this);
		b = new Bullet(0, 0, this);
		a = new Alien(1, 20, this);
		menu = new Menu();
		shop = new Shop(550, 370,this);
		laser = new AlienLaser(0, 0, this);
		select = new Selector(3, 435, this);
		rocketb = new Rocket(0, 0, this);
	}
	
	public static void main(String[] args){
		GalaxyAbduction game = new GalaxyAbduction();
		Data data = new Data();
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
	      BufferedImage icon = null;
	        try {
	            icon = ImageIO.read(
	                f.getClass().getResource("/icon.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    f.setIconImage(icon); 
		f.setTitle(TITLE + " " + VERSION);
		f.setSize(XSize, YSize);
		f.setResizable(false);
		f.setBackground(Color.BLUE);
		JLabel bullets = new JLabel("Bullets: " + bullet);
		p.setForeground(Color.green);
		p.add(bullets);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.add(game);
		game.Start();
		data.loadFile("assets/game.txt");
		data.writeFile("assets/playerdata.txt");
	}
	
	public BufferedImage getSpriteSheet1(){
		return spriteSheet1;
	}
	
	public BufferedImage getSpriteSheet2(){
		return spriteSheet2;
	}
	
	public BufferedImage getSpriteSheet3(){
		return spriteSheet3;
	}
	
	public int isPaused(){
		return pause;
	}
	
}
