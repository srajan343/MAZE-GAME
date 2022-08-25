import java.awt.Image;

import javax.swing.ImageIcon;

public class player {
	
	private int x,y,tilex , tiley;
	private Image player; 
	
	public player() {
		
		ImageIcon img = new ImageIcon("player.png");
		Image e = img.getImage();
		Image dup_img = e.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(dup_img);
		player = img.getImage();
				
		tilex = 1;
		tiley = 1;
	}
	
	public Image getplayer() {
		return player;
	}
	
	
	public int get_tilex() {
		return tilex;
	}
	
	public int get_tiley() {
		return tiley;
	}
	public void move( int dx , int dy) {
		
		tilex += dx;
		tiley += dy;
		
	}

}
