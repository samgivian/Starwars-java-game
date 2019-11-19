import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemySpaceShip {
	public static ArrayList<JLabel> blasts= new ArrayList<JLabel>();

	public EnemySpaceShip() {
		 
	}

	public static JLabel addblast(int x, int y, int sizeX, int sizeY ,int i) {

		ImageIcon blast = new ImageIcon(new ImageIcon("spaceship4.png").getImage().getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT));
		JLabel b = new JLabel(blast);
		b.setBounds(x, y, sizeX, sizeY);
		blasts.add(b);
		return b;

	}
	

	public void removeblast() {

	}
}
