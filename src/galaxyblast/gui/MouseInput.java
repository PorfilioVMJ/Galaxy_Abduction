package galaxyblast.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import galaxyblast.GalaxyAbduction;
import galaxyblast.data.Data;
public class MouseInput implements MouseListener{

	public static int menbtn;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		
		/*
	    	public Rectangle play = new Rectangle(GalaxyBlast.XSize /2 - 60, 100, 100, 50);
			public Rectangle credits = new Rectangle(GalaxyBlast.XSize /2 - 60, 200, 100, 50);
			public Rectangle option = new Rectangle(GalaxyAbduction.XSize /2 - 60, 300, 100, 50);
			public Rectangle quit = new Rectangle(GalaxyBlast.XSize /2 - 60, 400, 100, 50);
		*/
		//play
		if(GalaxyAbduction.State == GalaxyAbduction.STATE.MENU){
			if(mx > GalaxyAbduction.XSize /2 - 60 && mx <= GalaxyAbduction.XSize /2 + 160){
				if(my >= 100 && my <= 150){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.GAME;
					System.out.println("Playing Game");
				}
			}
			if(mx > GalaxyAbduction.XSize /2 - 60 && mx <= GalaxyAbduction.XSize /2 + 160){
				if(my >= 400 && my <= 450){
					//pressed
					System.exit(1);
					System.out.println("Quit Game");
				}
			}
			if(mx > GalaxyAbduction.XSize /2 - 60 && mx <= GalaxyAbduction.XSize /2 + 160){
				if(my >= 300 && my <= 350){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.OPTIONS;
					System.out.println("Options");
				}
			}
			if(mx > GalaxyAbduction.XSize /2 - 60 && mx <= GalaxyAbduction.XSize /2 + 160){
				if(my >= 200 && my <= 250){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.CREDITS;
					System.out.println("Credits");
				}
			}
		}else if(GalaxyAbduction.State == GalaxyAbduction.STATE.RESPAWN){
			if(mx > GalaxyAbduction.XSize /2 - 80 && mx <= GalaxyAbduction.XSize /2 + 150){
				if(my >= 150 && my <= 200){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.GAME;
					System.out.println("Rerspawning...");
					
				}else if(mx > GalaxyAbduction.XSize /2 - 60 && mx <= GalaxyAbduction.XSize /2 + 160){
					if(my >= 250 && my <= 300){
						//pressed
						GalaxyAbduction.State = GalaxyAbduction.STATE.MENU;
						System.out.println("Menu");
					}
				}
			}
		}else if(GalaxyAbduction.State == GalaxyAbduction.STATE.WIN){
			if(mx > GalaxyAbduction.XSize /2 - 80 && mx <= GalaxyAbduction.XSize /2 + 150){
				if(my >= 150 && my <= 200){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.MENU;
					System.out.println("Going to Menu");
				}
			}
		}
		
		if(GalaxyAbduction.State == GalaxyAbduction.STATE.OPTIONS){
			Data data = new Data();
			if(mx > 10 && mx <= 110){
				if(my >= 140 && my <= 467){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.MENU;
					System.out.println("Going Back To Menu");
				}
			}
			if(mx > 175 && mx <= 207){
				if(my >= 35 && my <= 67){
					//pressed
					GalaxyAbduction.textures = 1;
					data.writeFile("assets/game.txt");
					data.loadFile("assets/game.txt");
					System.out.println("Changed Textures");
				}
			}
			if(mx > 290 && mx <= 322){
				if(my >= 35 && my <= 67){
					//pressed
					GalaxyAbduction.textures = 2;
					data.writeFile("assets/game.txt");
					data.loadFile("assets/game.txt");
					System.out.println("Changed Textures");
				}
			}
			if(mx > 390 && mx <= 422){
				if(my >= 35 && my <= 67){
					//pressed
					GalaxyAbduction.textures = 3;
					data.writeFile("assets/game.txt");
					data.loadFile("assets/game.txt");
					System.out.println("Changed Textures");
				}
			}
		}
		if(GalaxyAbduction.State == GalaxyAbduction.STATE.DEBUG){
			//DebugMenu debugMenu = new DebugMenu("Debug Menu");
			//Bounds debugBounds = debugMenu.debugBtn.getBounds();
			
			if(mx >= 60 && mx <= 60+100){
				if(my >= 130 && my <= 130+50){
					System.out.println("Post Test");
				}
			}
		}
		if(GalaxyAbduction.State == GalaxyAbduction.STATE.SHOP){
			if(mx > 10 && mx <= 110){
				if(my >= 140 && my <= 467){
					//pressed
					GalaxyAbduction.State = GalaxyAbduction.STATE.GAME;
					System.out.println("Going Back To Game");
				}
			}
		}
		if(GalaxyAbduction.State == GalaxyAbduction.STATE.LOGIN){
			if(mx > 235 && mx <= 235+100){
				if(my >= 300 && my <= 300+50){
					if(GalaxyAbduction.hasName){
						GalaxyAbduction.State = GalaxyAbduction.STATE.MENU;
						System.out.println("Logging In..");
					}
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
