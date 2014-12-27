import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GameGraphics extends JPanel implements ActionListener {
	
	private Timer animation;
	Body[] elements;
	int elementCount; //Nulu smo stavili zbog debugignga
	int width;
	int height;
	
	public GameGraphics(int width, int heigth) {
		super();
		animation = new Timer(200, this);
		elements = new Body[3];
		elementCount = 1;
		elements[0] = new Oval(0, 0, 20, 30, Color.RED, 3, 1);
		animation.start();
		this.width = width;
		this.height = heigth;
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
		g.fill3DRect(0, this.height-100, width, 100, true);
		for (int i=0; i<elementCount; i++) {
			elements[i].draw(g);
		}
	}

}
