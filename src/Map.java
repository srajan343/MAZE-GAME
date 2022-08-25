import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner m;
	private String Map[] = new String[14];
	
	Image grass;
	Image wall;
	Image finish;

	public Map() {
		
		ImageIcon img = new ImageIcon("grass.png");
		Image e = img.getImage();
		Image dup_img = e.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(dup_img);
		grass = img.getImage();
		
		ImageIcon block  = new ImageIcon("wall4.png");
		Image i = block.getImage();
		Image mod_img = i.getScaledInstance(50, 70, java.awt.Image.SCALE_SMOOTH);
		block = new ImageIcon(mod_img);		
		wall = block.getImage();
		
		ImageIcon exit = new ImageIcon("exit.png");
		Image KA = exit.getImage();
		Image replace = KA.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		exit = new ImageIcon(replace);	
		finish = exit.getImage();
		
		
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass() {
		return grass;
	}
	
	public Image getwall() {
		return wall;
	}
	
	public Image getfinish() {
		return finish;
	}
	
	public String getMap(int x , int y) {
		String index = Map[y].substring(x,x+1);
		return index;
		
	}
	
	public void openFile() {
		try {
			m = new Scanner(new File("C:\\Users\\S SETHIYA\\OneDrive\\Desktop\\maze game.txt"));
		} catch (Exception e) {
			System.out.println("error loading map");
		}
		
	}
	
	public void readFile() {
		while(m.hasNext()){
			for(int i=0 ; i<14;i++) {
				Map[i] = m.next();
			}
		}
	}
	
	public void closeFile() {
		m.close();
	}
}
