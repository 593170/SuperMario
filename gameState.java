import java.awt.Graphics;
public abstract class gameState {
	protected gameStateManager gsm;
	protected gameState(gameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics Z);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
}
