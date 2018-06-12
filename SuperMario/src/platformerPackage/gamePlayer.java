package platformerPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class gamePlayer {
	private boolean right = false, left = false, isJumping = false, isFalling = false;
	private double x, y;
	private int width, height;
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	private double moveSpeed = 5;
	public gamePlayer(int height, int width) {
		x = MarioPanel.WIDTH / 2;
		y = MarioPanel.HEIGHT / 2;
		this.width = width;
		this.height = height;
	}

	public void tick(gameBlock[] b) {
		int iX = (int)x;
		int iY = (int)y;
		for (int i = 0; i < b.length; i++) {
			if (gameCollisions.playerBlock(new Point(iX + width + (int)gameState.xOffset, iY + (int)gameState.yOffset), b[i]) || gameCollisions.playerBlock(new Point(iX + width, iY + height), b[i])) {
				right = false;
			}
			if (gameCollisions.playerBlock(new Point(iX + (int)gameState.xOffset, iY + (int)gameState.yOffset), b[i]) || gameCollisions.playerBlock(new Point(iX + (int)gameState.xOffset, iY + width + (int)gameState.yOffset), b[i])) {
				left = false;
			}
			if (gameCollisions.playerBlock(new Point(iX + (int)gameState.xOffset, iY + (int)gameState.yOffset), b[i]) || gameCollisions.playerBlock(new Point(iX + width + (int)gameState.xOffset, iY + (int)gameState.yOffset), b[i])) {
				isJumping = false;
				isFalling = true;
			}
			if (gameCollisions.playerBlock(new Point(iX + (int)gameState.xOffset, iY + (int)gameState.yOffset), b[i]) || gameCollisions.playerBlock(new Point(iX + (int)gameState.xOffset, iY + height + (int)gameState.yOffset), b[i])) {
				isFalling = false;
				break;
			} else {
				isFalling = true;
			}
		}
		
		if (right) {
			gameState.xOffset += moveSpeed;
		}
		if (left) {
			gameState.xOffset -= moveSpeed;
		}
		if (isJumping) {
			gameState.yOffset -= currentJumpSpeed;
			currentJumpSpeed -= 0.1;
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				isJumping = false;
				isFalling = true;
			}
		}
		if (isFalling) {
			gameState.yOffset += currentFallSpeed;
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.1;
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
