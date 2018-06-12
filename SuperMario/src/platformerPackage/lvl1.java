package platformerPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class lvl1 extends gameState{
	private gamePlayer player;
	private gameBlock[] b;
	public lvl1(gameStateManager gsm) {
		super(gsm);
	}
	public void init() {
		player = new gamePlayer(30, 30);
		b = new gameBlock[23];
		b[0] = new gameBlock(400, 400);
		b[1] = new gameBlock(464, 400);
		b[2] = new gameBlock(528, 400);
		b[3] = new gameBlock(592, 400);
		b[4] = new gameBlock(656, 400);
		b[5] = new gameBlock(720, 400);
		b[6] = new gameBlock(784, 400);
		b[7] = new gameBlock(848, 400);
		b[8] = new gameBlock(912, 400);
		b[9] = new gameBlock(976, 400);
		b[10] = new gameBlock(1104, 400);
		b[11] = new gameBlock(1232, 336);
		b[12] = new gameBlock(1328, 272);
		b[13] = new gameBlock(1552, 272);
		b[14] = new gameBlock(1890, 336);
		b[15] = new gameBlock(2146, 300);
		b[16] = new gameBlock(2402, 300);
		b[17] = new gameBlock(2466, 300);
		b[18] = new gameBlock(2530, 300);
		b[19] = new gameBlock(2594, 300);
		b[20] = new gameBlock(2658, 300);
		b[21] = new gameBlock(2658, 236);
		b[22] = new gameBlock(2658, 172);
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
