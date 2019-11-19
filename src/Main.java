import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.border.MatteBorder;

public class Main extends JFrame {
	public  static Font customFont;
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setUndecorated(true);
		
		try {
		    //create the font to use. Specify the size!
			 customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Starjedi.ttf")).deriveFont(30f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Starjedi.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
	JLabel l1=new JLabel("Select your planet");
	l1.setFont(new Font("Starjedi", Font.BOLD, 12));
	l1.setFont(customFont);
	l1.setForeground(Color.white);
	l1.setBounds(700, 50, 400, 50);
	frame.add(l1);
	
	JLabel  l2;
	l2 = new JLabel("Geonosis");
	l2.setBounds(600, 150, 300, 30);
	l2.setFont(customFont);

	l2.setForeground(Color.white);
	frame.add(l2);
	

	       // you can open a new frame here as
	       // i have assumed you have declared "frame" as instance variable


	
	ImageIcon imageIcon1 = new ImageIcon(
			new ImageIcon("databank_geonosis_01_169_1d04e086.jpeg").getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
	JLabel l4 = new JLabel(imageIcon1);
	l4.setBounds(600, 200, 250, 150);
	frame.add(l4);
	
	l4.addMouseListener(new MouseAdapter()  
	{  
	    public void mouseClicked(MouseEvent e)  
	    {  
	       // you can open a new frame here as
	       // i have assumed you have declared "frame" as instance variable
	    //	GenosisChar gr=new GenosisChar();
	    	Genosis gr=new Genosis();
	    	frame.setVisible(false);

	    }  
	}); 

	
	
	JLabel  l5;
	l5 = new JLabel("kashyyyk");
	l5.setBounds(900, 150, 300, 30);
	l5.setFont(customFont);

	l5.setForeground(Color.white);
	frame.add(l5);

	ImageIcon imageIcon2 = new ImageIcon(
			new ImageIcon("maxresdefault-20.jpg").getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
	JLabel l6 = new JLabel(imageIcon2);
	l6.setBounds(900, 200, 250, 150);
	frame.add(l6);
	


	
	
	JLabel  l7;
	l7 = new JLabel("Hoth");
	l7.setBounds(600, 400, 300, 30);
	l7.setFont(customFont);
	l7.setForeground(Color.white);
	frame.add(l7);

	
	
	ImageIcon imageIcon3 = new ImageIcon(
			new ImageIcon("310274-Star_Wars-snow-Hoth.jpg").getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
	JLabel l8 = new JLabel(imageIcon3);
	l8.setBounds(600, 450, 250, 150);
	frame.add(l8);
	l8.addMouseListener(new MouseAdapter()  
	{  
	    public void mouseClicked(MouseEvent e)  
	    {  
	       // you can open a new frame here as
	       // i have assumed you have declared "frame" as instance variable
	    	HothChar hc=new HothChar();
	    	frame.setVisible(false);

	    }  
	}); 
	l6.addMouseListener(new MouseAdapter()  
	{  
	    public void mouseClicked(MouseEvent e)  
	    {  
	       // you can open a new frame here as
	       // i have assumed you have declared "frame" as instance variable
	    	kashyyyk kash =new kashyyyk();
	    	frame.setVisible(false);

	    }  
	}); 

	
	
	JLabel  l9;
	l9 = new JLabel("Space");
	l9.setBounds(900, 400, 300, 30);
	l9.setFont(customFont);
	l9.setForeground(Color.white);
	frame.add(l9);

	ImageIcon imageIcon4 = new ImageIcon(
			new ImageIcon("space.jpg").getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
	JLabel l10 = new JLabel(imageIcon4);
	l10.setBounds(900, 450, 250, 150);
	frame.add(l10);
	l10.addMouseListener(new MouseAdapter()  
	{  
	    public void mouseClicked(MouseEvent e)  
	    {  
	       // you can open a new frame here as
	       // i have assumed you have declared "frame" as instance variable
	    	SpaceChar gr=new SpaceChar();
	    	frame.setVisible(false);

	    }  
	}); 
	
	frame.add(new ContentPanel());
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	}

}

class ContentPanel extends JPanel {
	Image bgimage = null;

	ContentPanel() {
		MediaTracker mt = new MediaTracker(this);
		bgimage = Toolkit.getDefaultToolkit().getImage("clonewall.jpg").getScaledInstance(1280, 720,
				Image.SCALE_DEFAULT);
		mt.addImage(bgimage, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int imwidth = bgimage.getWidth(null);
		int imheight = bgimage.getHeight(null);
		g.drawImage(bgimage, 1, 1, null);
	}
}