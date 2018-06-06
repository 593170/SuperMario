import java.awt.BorderLayout;
import javax.swing.JFrame;
public class game {
	public static void main(String[] args) {
		JFrame frame = new JFrame("TESTWINDOW");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new MarioPanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
