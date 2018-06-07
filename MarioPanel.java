import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class MarioPanel extends JPanel implements Runnable, KeyListener{
	public static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public MarioPanel() {
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
			start();
	}
	private int fps = 60;
	private long targetTime = 1000 / fps;
	private Thread thread;
	private boolean isRunning = false;
	private gameStateManager gsm;
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();	
	}
	public void run() {
		long start, elapsed, wait;
		gsm = new gameStateManager();
		while(isRunning) {
			start = System.nanoTime();
			tick();
			repaint();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;	
			if (wait <= 0) {
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		}
	public void tick() {
		gsm.tick();
	}
	public void paintComponent(Graphics z) {
		super.paintComponent(z);
		z.clearRect(0, 0, WIDTH, HEIGHT);
		gsm.draw(z);
	}
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	public void keyReleased(KeyEvent e) {	
		gsm.keyReleased(e.getKeyCode());
	}
	public void keyTyped(KeyEvent e) {
		
	}
	
	
}
