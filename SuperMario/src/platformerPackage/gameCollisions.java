package platformerPackage;
import java.awt.Point;
import platformerPackage.gameBlock;
public class gameCollisions {
	public static boolean playerBlock(Point p, gameBlock b) {
		return b.contains(p);
		
	}
}
