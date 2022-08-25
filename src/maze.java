import javax.swing.JFrame;

public class maze {
	
	maze(){
		
		JFrame frame = new JFrame();
		frame.setTitle("MAZE GAME");
		frame.setSize(585,630);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(new board());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new maze();

	}

}
