import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GenosisBackground {
public  GenosisBackground(){
	
}
public static JLabel back() {
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("sand" + (int) (Math.random() * 3 + 1) + ".png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel l5 = new JLabel(imageIcon2);
		return l5;
	}
	
}

