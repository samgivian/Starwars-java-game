import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RTrooper {
	public static ArrayList<JLabel> Charc= new ArrayList<JLabel>();

	public RTrooper() {
		 
	}

	public static JLabel addblast(int x, int y, int sizeX, int sizeY ,int i,String s) {

		ImageIcon blast = new ImageIcon(new ImageIcon(s+i+".png").getImage().getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT));
		JLabel b = new JLabel(blast);
		b.setBounds(x, y, sizeX, sizeY);
		Charc.add(b);
		return b;

	}
	

	public void removeblast() {

	}
}
