import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;


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
	
	public Body(int x, int y, int width, int height, Color color, int speedX, int speedY, int minX, int minY, int maxX, int maxY) {
		this.start = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
		this.center = new Point(x+width/2, y+height/2);
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
		if(d > this.height/2 + other.height/2 && d > this.width/2 + other.width/2) {
			return false;
		}
		return true;
	}
	
	private void move() {
		if (this.start.getX() + this.width >= maxX && speedX > 0) {
			this.speedX = 0;
		}
		if (this.start.getY() + this.height >= maxY && speedY > 0) {
			this.speedY = 0;
		}
		if (this.start.getX() <= minX && speedX < 0) {
			this.speedX = 0;
		}
		if (this.start.getY() <= minY && speedY < 0) {
			this.speedY = 0;
		}
		this.start.move(speedX, speedY);
		this.center.move(speedX, speedY);
		
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
