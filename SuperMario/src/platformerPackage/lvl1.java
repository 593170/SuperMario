package platformerPackage;
import java.awt.Color;
import java.awt.Graphics;
public class lvl1 extends gameState{
	private gamePlayer player;
	private gameBlock[] b;
	public lvl1(gameStateManager gsm) {
		super(gsm);
	}
	public void init() {
		player = new gamePlayer(30, 30);
		b = new gameBlock[3];
		b[0] = new gameBlock(900, 900);
		b[1] = new gameBlock(600, 600);
		b[2] = new gameBlock(300, 300);
	}
	
	public void tick() {
		for (int i = 0; i < b.length; i++) {
			b[i].tick();
		}
		player.tick(b);
	}

	public void draw(Graphics z) {
		z.setColor(Color.black);
		z.fillRect(0, 0, 800, 600);
		player.draw(z);
		for (int i = 0; i < b.length; i++) {
			b[i].draw(z);
		}
	}

	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	public void keyReleased(int k) {
		player.keyReleased(k);
	}
}
