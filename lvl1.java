import java.awt.Color;
import java.awt.Graphics;
public class lvl1 extends gameState{
	private gamePlayer player;
	public lvl1(gameStateManager gsm) {
		super(gsm);
	}
	public void init() {
		player = new gamePlayer(30, 30);
	}
	
	public void tick() {
		player.tick();
	}

	public void draw(Graphics z) {
		z.setColor(Color.black);
		z.fillRect(0, 0, 800, 600);
		player.draw(z);
	}

	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	public void keyReleased(int k) {
		player.keyReleased(k);
	}
}
