import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;


public class Play {
	GameGraphics game;
	static int width = 500;
	static int height = 500;

	public static void main(String[] args) {
		
		
		
		JFrame window = new JFrame("Jumper");
		window.setSize(500, 500);
				
		GameGraphics game = new GameGraphics(width, height);
		window.setContentPane(game);		
		
		window.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		       height = window.getHeight();
		       width = window.getWidth();
		       
		       game.setWidth(width);
		       game.setHeight(height);
		    }
		});		
		
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}
