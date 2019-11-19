import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RedTrooper {
public static JLabel trooper;
	public RedTrooper() {
		
	}
	public static JLabel Draw() {
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("sand" + (int) (Math.random() * 3 + 1) + ".png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel l5 = new JLabel(imageIcon2);
		return l5;
	}
	public static JLabel ChangeTrooper(int m) {
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("redtrooper" + m + ".png").getImage().getScaledInstance(120, 360,Image.SCALE_DEFAULT));
		return trooper;
	}
}
