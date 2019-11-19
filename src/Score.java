import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Score {
public static int health=100;
public static int score=0;
public static int kill=0;
	public Score() {

	}

	public static JLabel drawhealth(int x, int y, int sizex, int sizey) {
		ImageIcon imageIcon2 = new ImageIcon(
				new ImageIcon("clonehealth.png").getImage().getScaledInstance(sizex, sizey, Image.SCALE_DEFAULT));
		JLabel l = new JLabel(imageIcon2);
		l.setBounds(x,y,sizex,sizey);
		return l;
	}
	public static JLabel drawscoreicon(int x, int y, int sizex, int sizey) {
		ImageIcon imageIcon2 = new ImageIcon(
				new ImageIcon("score.png").getImage().getScaledInstance(sizex, sizey, Image.SCALE_DEFAULT));
		JLabel l = new JLabel(imageIcon2);
		l.setBounds(x,y,sizex,sizey);
		return l;
	}
	public static JLabel drawscore(int x, int y, int sizex, int sizey) {
		
		JLabel l = new JLabel();
		String ss=Integer.toString(score);
		l.setFont(new Font("Starjedi", Font.BOLD, 10));
		l.setFont(GenosisChar.customFont);
		l.setText(ss);
		l.setBounds(x,y,sizex,sizey);
		return l;
	}
	public static void hithealth() {
		health-=10;
		if(health<=0) {
			GenosisChar.clonealive1=false;
			GenosisChar.gamerunning=false;
		}
		
	}
	public static void addhealth() {
		health+=30;
		if(health>100) {
			health=100;
		}
	}
}
