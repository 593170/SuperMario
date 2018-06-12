import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class gamePlayer {
	private boolean right = false, left = false, isJumping = false, isFalling = false;
	private double x, y;
	private int width, height;
	private double jumpSpeed = 2;
	private double currentJumpSpeed = jumpSpeed;
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	public gamePlayer(int height, int width) {
		x = MarioPanel.WIDTH / 2;
		y = MarioPanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void tick() {
		if (right) {
			x++;
		}
		if (left) {
			x--;
		}
		if (isJumping) {
			y -= currentJumpSpeed;
			currentJumpSpeed -= 0.015;
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				isJumping = false;
				isFalling = true;
			}
		}
		if (isFalling) {
			y += currentFallSpeed;
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.015;
			}
		}
		if (!isFalling) {
			currentFallSpeed = 0.1;
		}
	}
	
	public void draw(Graphics z) {
		z.setColor(new Color(0, 161, 255));
		z.fillRect((int)x, (int)y, width, height);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_LEFT) left = true;
		if (k == KeyEvent.VK_RIGHT) right = true;	
		if (k == KeyEvent.VK_UP) isJumping = true;
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_LEFT) left = false;
		if (k == KeyEvent.VK_RIGHT) right = false;
	}
}
