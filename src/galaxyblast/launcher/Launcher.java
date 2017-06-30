package galaxyblast.launcher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import galaxyblast.GalaxyAbduction;

//The Simple Web Browser.
public class Launcher extends JFrame implements HyperlinkListener {

	private static final long serialVersionUID = 1L;

	private JEditorPane displayEditorPane;
	
	private JCheckBox checkbox;
	
	private JButton play;
	private JButton vmjSearch;
	
	
	public Launcher(){
		 displayEditorPane = new JEditorPane();
	       displayEditorPane.setContentType("text/html");
	       displayEditorPane.setEditable(false);
	       displayEditorPane.addHyperlinkListener(this);
	       displayEditorPane.setDragEnabled(true);
	       try {
	    	   displayEditorPane.setPage("http://galaxyabduction.net16.net/game.html");
	       } catch (IOException e1){
	    	   e1.printStackTrace();
	       }
	       
	       getContentPane().setLayout(new BorderLayout());
	       getContentPane().add(new JScrollPane(displayEditorPane),BorderLayout.CENTER);
	       
	       checkbox = new JCheckBox("Test");
	       getContentPane().add(checkbox ,BorderLayout.PAGE_END);
	       
	       play = new JButton("Play");
	       vmjSearch = new JButton("VMJSearch");

	       getContentPane().add(play ,BorderLayout.PAGE_END);
	       getContentPane().add(vmjSearch ,BorderLayout.PAGE_START);
	       
	       vmjSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			       try {
			    	   displayEditorPane.setPage("http://vmjsearch.netii.net/");
			       } catch (IOException e1){
			    	   e1.printStackTrace();
			       }
			}
		});
	       
	       play.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GalaxyAbduction.main(null);
			}
		});
	       
	       // Handle closing events.
	       addWindowListener(new WindowAdapter() {
	           public void windowClosing(WindowEvent e) {
	               System.exit(1);
	           }
	       });
	       
	        setTitle("Galaxy Abduction Launcher 0.1 ALPHA");
	        setSize(640, 480);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
   @SuppressWarnings("deprecation")
   public static void main(String[] args) {
       Launcher news = new Launcher();
       news.show();
   }

@Override
public void hyperlinkUpdate(HyperlinkEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
