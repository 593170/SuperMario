package platformerPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
public class menuState extends gameState {
	private String[] menuOptions = {"Start", "Quit"};
	private int selection = 0;
	protected menuState(gameStateManager gsm) {
		super(gsm);
	}
	public void init() {}
	public void tick() {	
	}
	public void draw(Graphics z) {
		z.setColor(new Color(0, 0, 0));
		z.fillRect(0, 0, MarioPanel.WIDTH, MarioPanel.HEIGHT);
		for (int i = 0; i < menuOptions.length; i++) {
			if (i == selection) {
				z.setColor(new Color(0, 161, 255));
			} else {
				z.setColor(Color.white);
			}
			z.setFont(new Font("Arial", Font.PLAIN, 55));
			z.drawString(menuOptions[i], MarioPanel.WIDTH / 2 - 60 + i * 5, 250 + i * 100);
		}
	}
	public void keyPressed(int k) {
			if (k == KeyEvent.VK_DOWN) {
				selection++;
				if (selection >= menuOptions.length) {
					selection = 0;
				}
			} else if (k == KeyEvent.VK_UP) {
				selection--;
				if (selection < 0 ) {
					selection = menuOptions.length - 1;
				}
			}
			if (k == KeyEvent.VK_ENTER) {
				if (selection == 0) {
					System.out.println("- Game is playing");
					gsm.states.push(new lvl1(gsm));
				} else if (selection == 1) {
					System.out.println("- Game quit expectedly, user has ended game");
					System.exit(0);
				}
			}
	}
	public void keyReleased(int k) {
			
	}
}