import java.awt.Graphics;
import java.util.Stack;
public class gameStateManager {
	private Stack<gameState> states;
	public gameStateManager() {
		states = new Stack<gameState>();
		states.push(new menuState(this));
	}
	public void tick() {
		states.peek().tick();
	}
	public void draw(Graphics z) {
		states.peek().draw(z);
	}
	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}
	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}
}
