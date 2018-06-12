package platformerPackage;
import java.awt.Graphics;
public abstract class gameState {
	public gameStateManager gsm;
	public static double xOffset;
	public static double yOffset;
	public gameState(gameStateManager gsm) {
		this.gsm = gsm;
		this.xOffset = 0;
		this.yOffset = 0;
		init();
	}
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics Z);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
}