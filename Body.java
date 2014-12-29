import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Body {

	private int width;
	private int height;
	private Color color;
	private Point start;
	private Point center;
	private int speedX;
	private int speedY;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;

	public Body(int x, int y, int width, int height, Color color, int speedX,
			int speedY, int minX, int minY, int maxX, int maxY) {
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.center = new Point(x + width / 2, y + height / 2);
		this.speedX = speedX;
		this.speedY = speedY;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;

	}

	public void draw(Graphics g) {
		move();
		g.setColor(color);
		return;

	}

	public boolean checkCollision(Body other) {
		int d = this.center.getDistance(other.center);
		if (d > this.height / 2 + other.height / 2 && d > this.width / 2 + other.width / 2) {
			return false;
		}
		return true;
	}

	private void move() {
		if (this.start.getX() + this.width + speedX >= maxX && speedX > 0) {
			this.speedX = 0;
			start.setX(maxX - width);
		}
		if (this.start.getY() + this.height + speedY >= maxY && speedY > 0) {
			this.speedY = 0;
			start.setY(maxY - height);
		}
		if (this.start.getX() + speedX <= minX && speedX < 0) {
			this.speedX = 0;
			start.setX(minX);
		}
		if (this.start.getY() + speedY <= minY && speedY < 0) {
			this.speedY = 0;
			start.setY(minY);
		}
		this.start.move(speedX, speedY);
		this.center.move(speedX, speedY);

	}

	public void jupm() {
		if (start.getY() == maxY - height) {

			speedY = -5;
			Timer t = new Timer(2000, new JumpHandler());//Kao argumente prima milisekunde i objekat nad kojim je implementiran ActionListener
			t.start();

		} 
	}
	public void reset(){
		if(this.start.getX() <= minX){
			this.start.setX(maxX);
			this.center.setX(maxX + width / 2);
		}
	}

	

	private class JumpHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			speedY *= (-1);
			Timer t = (Timer) e.getSource();
			t.stop();

		}

	}
	
	

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Point getStart() {
		return start;
	}

	public int getX() {
		return start.getX();
	}

	public int getY() {
		return start.getY();
	}

}
