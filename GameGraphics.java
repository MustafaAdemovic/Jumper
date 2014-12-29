import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.xml.internal.bind.v2.model.core.Adapter;


public class GameGraphics extends JPanel implements ActionListener {
	
	private Body player;
	

	private Timer animation;
	Body[] elements;
	int elementCount = 10; // Nulu smo stavili zbog debugignga
	int width;
	int height;

	public GameGraphics(int width, int heigth) {
		super();
		animation = new Timer(100, this);
		elements = new Body[10];
		for (int i = 0; i < 10; i++) {
			elements[i] = new Oval((int) (Math.random() * 1000 + 500), 370, 10, 30, Color.BLACK, -1 - (int) (Math.random() * 10), 0, 800 + (int) (Math.random() * 3500), 0, 500, 400);
		}
		player = new Oval(240, 370, 20, 30, Color.RED, 0, 0, 0, 0, 500, 400);
		animation.start();
		this.width = width;
		this.height = heigth;
		addKeyListener(new KeyHandler());
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(184, 242, 245));
		g.setColor(new Color(54, 140, 22));
		g.fill3DRect(0, this.height - 100, width, 100, true);
		player.draw(g);;
		for (int i = 0; i < elementCount; i++) {
			elements[i].draw(g);
			elements[i].reset();
			if(player.checkCollision(elements[i])){
				JOptionPane.showMessageDialog(null,"Prozor", "Izgubio si", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private class KeyHandler extends KeyAdapter{
		
		@Override
		public void keyTyped(KeyEvent e) {
			player.jupm();
			
			System.out.println(e.getKeyCode());
			
		
		}
	}

}
