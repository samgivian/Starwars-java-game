import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BlueBlast {
private int blastX;
private int blastY;
Image imageIcon3 ;
public BlueBlast(int x, int y) {
	this.blastX=x;
	this.blastY=y;
	imageIcon3= new ImageIcon(this.getClass().getResource("blueblast.png")).getImage().getScaledInstance(40, 10,Image.SCALE_DEFAULT);
	
	
}
public void thick() {
	blastY=-10;
}
public void draw (Graphics g) {
	g.drawImage(imageIcon3,blastX,blastY,null);
}
}
