import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {
 private LinkedList<BlueBlast> b =new LinkedList<BlueBlast>();
 BlueBlast TempBullet;
 public void thick() {
	 for(int i=0;i<b.size();i++) {
		 TempBullet=b.get(i);
		 TempBullet.thick();
	 }
 }
 public Controller() {
	 addBullet(new BlueBlast(100,300));
 }
 public void render(Graphics g) {
	 for(int i=0;i<b.size();i++) {
		 TempBullet=b.get(i);
		 TempBullet.draw(g);
	 }
 }
 public void addBullet(BlueBlast block) {
		b.add(block);
	}
 public void removeBullet(BlueBlast block) {
	 b.remove(block);
	}
}
