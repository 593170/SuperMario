package platformerPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class gameBlock extends Rectangle {
	public static final int blockSize = 64;
	public gameBlock(int x, int y) {
		setBounds(x, y, blockSize, blockSize);
	}
	public void tick() {
		
	}
	public void draw(Graphics z) {
		z.setColor(Color.white);
		z.fillRect(x - (int)gameState.xOffset, y - (int)gameState.yOffset, width, height);
	}
}
