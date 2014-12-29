public class Point {

	protected int x;
	protected int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
		
	}

	public int getDistance(Point other) {
		int result, dX, dY;
		dX = (int) (Math.pow(other.x - this.x, 2));
		dY = (int) (Math.pow(other.y - this.y, 2));
		result = (int) (Math.sqrt(dX - dY));
		return result;
	}

	public void move(int speedX, int speedY) {
		this.x += speedX;
		this.y += speedY;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
