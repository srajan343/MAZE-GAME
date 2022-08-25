import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class board extends JPanel implements ActionListener {
	
	private javax.swing.Timer timer;
	private player p;
	private Map m;
	private boolean win = false;
	private String message = "";
	private Font font = new Font("Serif",Font.BOLD,48) ;
	
	board(){
		
		p = new player();
		m= new Map();
		addKeyListener(new AL());
		setFocusable(true);
		timer = new javax.swing.Timer(25, this);
		timer.start();
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(!win) {
		for(int y=0;y<14;y++) {
			for(int x=0;x<14;x++) {
				if(m.getMap(x, y).equals("f")) {
					g.drawImage(m.getfinish(), x*40, y*40 , null);
				}
				if(m.getMap(x, y).equals("g")) {
					g.drawImage(m.getGrass(), x*40, y*40 , null);
				}
				if(m.getMap(x, y).equals("w")) {
					g.drawImage(m.getwall(), x*40 , y*40, null);
				}
				
			}
		}
		g.drawImage(p.getplayer(), p.get_tilex()*40, p.get_tiley()*40, null);
		 repaint();
		}
		
		if(win) {
		g.setColor(Color.pink);
		g.setFont(font);
		g.drawString(message, 150, 300);
			}
		}
	
	
	
	
	public class AL extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			
		int keycode = e.getKeyCode();
			if(keycode == KeyEvent.VK_W) {
				if(!m.getMap(p.get_tilex(), p.get_tiley() -1 ).equals("w")) {
				 p.move(0,-1);
			}
			}
			if(keycode == KeyEvent.VK_S) {
				if(!m.getMap(p.get_tilex(), p.get_tiley() +1 ).equals("w")) {
				p.move( 0, 1);
		}}
			if(keycode == KeyEvent.VK_A) {
				if(!m.getMap(p.get_tilex() -1, p.get_tiley()  ).equals("w")) {
				p.move( -1,0);
			}}
			if(keycode == KeyEvent.VK_D) {
				if(!m.getMap(p.get_tilex() + 1 , p.get_tiley() ).equals("w")) {
				 p.move(1,0);
			}}
			
			
//			switch(e.getKeyChar()) {
//			case 'a' : p.move(-1,0);
//			break;
//			
//			case 's' : p.move(0, 1);
//			break;
//			
//			case 'w' :  p.move(0,-1);
//			break;
//			
//			case 'd' :  p.move(1,0);
//			}	
		}
			
		
		
		public void keyReleased(KeyEvent e) {
			
		}
		
		public void keyTyped(KeyEvent e) {
			
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(m.getMap(p.get_tilex(), p.get_tiley()).equals("f")) {
			message = "WINNER :)";
			win = true;
		}
		repaint();
		
	}
	
	

}
