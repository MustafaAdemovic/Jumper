import javax.swing.JFrame;


public class Play {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Jumper");
		window.setSize(500, 500);
				
		GameGraphics game = new GameGraphics(500, 500);
		window.setContentPane(game);
		
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setVisible(true);
//		window.addWindowListener(l); napraviti listener za ovo sa anonimnom klasom

	}

}
