import java.awt.Graphics;
public abstract class gameState {
	public gameStateManager gsm;
	public gameState(gameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics Z);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
}
