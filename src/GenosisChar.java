import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
//colors 

//231 185 102
//14 121 126
//223 158 79
//124 78 52
//158 84 37
public class GenosisChar extends JFrame {
	private Controller c;
	public static Font customFont;
	public int imageI = 1;
	public int RedX = 10;
	public int Screen = 1;
	public ImageIcon imageIcon3;
	public JLabel trooper;
	public int RedY = 350;
	public ImageIcon ImageIconS;
	//public JLabel Back;
	public boolean jump = true;

	public int imageDroid1 = 1;
	public int Droid1X = 1150;
	public int Droid1Y = 350;
	public boolean Droid1Alive = true;
	public int Droid1D = 1;
	public int health = 100;
	public int ammo = 100;
	public int ammoX;
	public int ammoY;
	public JLabel blast;
	public boolean running = true;
	public static JFrame frame;
	public static Timer t;
	public static boolean gamerunning = true;
	public static boolean clonealive1 = true;
	long timer = System.currentTimeMillis();
public static JPanel BackgroundPanel;
	public GenosisChar() {
		frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			// create the font to use. Specify the size!
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Starjedi.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			// register the font
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Starjedi.ttf")));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 22; i++) {
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("sand" + (int) (Math.random() * 3 + 1) + ".png")
					.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			JLabel l5 = new JLabel(imageIcon2);
			l5.setBounds(i * 60, 600, 60, 60);
			frame.add(l5);
		}
		for (int i = 0; i < 22; i++) {
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("sand" + (int) (Math.random() * 3 + 1) + ".png")
					.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			JLabel l5 = new JLabel(imageIcon2);
			l5.setBounds(i * 60, 660, 60, 60);
			frame.add(l5);
		}
		/*
		 * JLabel scoreA = new JLabel(); int score=100; String
		 * ss=Integer.toString(score); scoreA.setFont(new Font("Starjedi", Font.BOLD,
		 * 10)); scoreA.setFont(customFont); scoreA.setText(ss);
		 * scoreA.setBounds(1100,20,100,40); frame.add(Score.drawscoreicon(900, 20, 40,
		 * 40));
		 */

		imageIcon3 = new ImageIcon(new ImageIcon("redtrooper" + imageI + ".png").getImage().getScaledInstance(100,240,
				Image.SCALE_DEFAULT));
		trooper = new JLabel(imageIcon3);
		trooper.setBounds(500, 350, 100,240);
		frame.add(trooper);

		ImageIcon healthP = new ImageIcon(
				new ImageIcon("clonehealth.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel healthI = new JLabel(healthP);
		healthI.setBounds(20, 20, 60, 60);
		frame.add(healthI);

		JLabel healthA = new JLabel();
		healthA.setText(Integer.toString(health) + "%");
		healthA.setBounds(90, 20, 100, 30);
		healthA.setFont(new Font("Starjedi", Font.BOLD, 10));
		healthA.setFont(customFont);
		frame.add(healthA);

		ImageIcon weaponP = new ImageIcon(
				new ImageIcon("weapon.png").getImage().getScaledInstance(100, 60, Image.SCALE_DEFAULT));
		JLabel weaponI = new JLabel(weaponP);
		weaponI.setBounds(440, 10, 100, 60);
		frame.add(weaponI);

		JLabel weaponA = new JLabel();
		weaponA.setText(Integer.toString(ammo) + "%");
		weaponA.setBounds(550, 20, 100, 30);
		weaponA.setFont(new Font("Starjedi", Font.BOLD, 10));
		weaponA.setFont(customFont);

		frame.add(weaponA);

		JLabel Droid1 = this.DroidDraw1();
		
		
		ImageIcon icon = new ImageIcon("g1.png");
		Image image = icon.getImage();
		BackgroundPanel = new JPanel();
		/*{
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.drawImage(image, 0, 0, 1280, 720, null);
			}
		};*/
		BackgroundPanel.setBackground(Color.green);
		BackgroundPanel.setPreferredSize(new Dimension(800, 600));
		
		/*
		 * ImageIcon blastblue = new ImageIcon( new
		 * ImageIcon("blueblast.png").getImage().getScaledInstance(80, 80,
		 * Image.SCALE_DEFAULT)); blast = new JLabel(blastblue);
		 * blast.setBounds(blueblastX, blueblastY, 80, 80);
		 */

//ImageIcon p = new ImageIcon(new ImageIcon("blueblast.png").getImage().getScaledInstance(100, 60, Image.SCALE_DEFAULT));
//JLabel v = new JLabel(p);
//v.setBounds(440, 200, 100, 60);
//frame.add(v);

		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (imageI == 1) {
					imageI = 2;
				} else if (imageI == 2) {
					imageI = 1;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					ammo = ammo - 5;
					frame = new JFrame();
					

					weaponA.setText(Integer.toString(ammo) + "%");
					BackgroundPanel.add(Blastlist.addblast(400, 200, 60, 30, 2));
					
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {

					int count = 0;
					int intialx = RedX;
					for (int c = 0; c < 170; c++) {
						RedY = RedY - 1;
						if (count < 50) {
							RedX = RedX + c / 130;
							count += c / 130;
						}

					}
					// RedY = RedY - 150;
					trooper.setBounds(RedX, RedY,100,240);
					if (RedY <= 280 && count < intialx + 50 && count < 50) {
						for (int c = 0; c < 170; c++) {
							RedY = RedY + 1;
							RedX = RedX + c / 130;
						}
						count = RedX;

					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					RedY = RedY + 5;
					trooper.setBounds(RedX, RedY, 100,240);
					if (RedY > 350) {
						RedY = 350;
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					/*
					 * if (Droid1Alive) { Droid1X = Droid1X + randomMoveBot() * Droid1D;
					 * Droid1.setBounds(Droid1X, Droid1Y, 130, 300); }
					 */
					RedX = RedX + 10;
					if (imageI == 1) {
						imageI = 2;
					} else if (imageI == 2) {
						imageI = 1;
					}
					trooper.setIcon(new ImageIcon(new ImageIcon("redtrooper" + imageI + ".png").getImage()
							.getScaledInstance(100,240, Image.SCALE_DEFAULT)));
					trooper.setBounds(RedX, RedY, 100,240);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					RedX = RedX - 10;
					/*
					 * if (Droid1Alive) { Droid1X = Droid1X + randomMoveBot() * Droid1D;
					 * Droid1.setBounds(Droid1X, Droid1Y, 130, 300); }
					 */

					if (imageI == 1) {
						imageI = 2;
					} else if (imageI == 2) {
						imageI = 1;
					}
					trooper.setIcon(new ImageIcon(new ImageIcon("redtrooperl" + imageI + ".png").getImage()
							.getScaledInstance(100,240, Image.SCALE_DEFAULT)));
					trooper.setBounds(RedX, RedY, 100,240);
				}
				if (RedX < 11) {
					RedX = 12;
					Screen = Screen - 1;
			//		Back.setIcon(new ImageIcon(new ImageIcon("g" + Screen + ".png").getImage()));
					if (Screen > 1) {
						RedX = 1190;
					}
				}
				if (RedX > 1200) {
					RedX = 10;
					Screen = Screen + 1;
				//	Back.setIcon(new ImageIcon(new ImageIcon("g" + Screen + ".png").getImage()));
				}
				if (Droid1X < 50) {
					Droid1X = 50;
					Droid1D = -1;
					imageDroid1 = 3;
					Droid1.setIcon(new ImageIcon(new ImageIcon("driod" + imageDroid1 + ".png").getImage()
							.getScaledInstance(100,240, Image.SCALE_DEFAULT)));
					Droid1.setBounds(Droid1X, Droid1Y, 130, 300);
				}
				if (Droid1X > 1200) {
					Droid1X = 1200;
					Droid1D = 1;
				}
				if (Screen < 1) {
					Screen = 1;
				//	Back.setIcon(new ImageIcon(new ImageIcon("g" + Screen + ".png").getImage()));
				}
				if (Screen > 5) {
					Screen = 5;
				//	Back.setIcon(new ImageIcon(new ImageIcon("g" + Screen + ".png").getImage()));
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					trooper.setIcon(new ImageIcon(new ImageIcon("redtrooper" + imageI + ".png").getImage()
							.getScaledInstance(100,240, Image.SCALE_DEFAULT)));
					trooper.setBounds(RedX, RedY, 100,240);
					BackgroundPanel.add(Blastlist.addblast(200, 200, 3, 60, 3));
				}
			}
		});
		frame.setFocusable(true);
	//	frame.add(this.DrawTrooper());

		frame.setLocationRelativeTo(null);
		if (t == null) {
			TimerTask task = new TimerTask() {
				@Override
				public void run() {

					Droid1X -= 10;
					Droid1.setBounds(Droid1X, Droid1Y, 130, 300);
					System.out.println("timer");

					for (JLabel bb : Blastlist.blasts) {
						bb.setBounds(bb.getX() + 40, bb.getY(), bb.getWidth(), bb.getHeight());
					}

				}
			};

			t = new Timer();
			t.scheduleAtFixedRate(task, 0, 200);
		}
		frame.add(BackgroundPanel);
		frame.setVisible(true);

	}

	public JLabel DroidDraw1() {
		ImageIcon imageDriod = new ImageIcon(new ImageIcon("driod" + imageDroid1 + ".png").getImage()
				.getScaledInstance(100,240, Image.SCALE_DEFAULT));
		JLabel Droid = new JLabel(imageDriod);
		Droid.setBounds(Droid1X, Droid1Y, 130, 300);
		return Droid;

	}

	public int randomMoveBot() {
		int r = (int) (Math.random() * 20 - 16);
		return r;
	}

	//public JLabel DrawTrooper() {
	//	ImageIconS = new ImageIcon(new ImageIcon("g" + Screen + ".png").getImage());
//		Back = new JLabel(ImageIconS);
	//	Back.setBounds(0, 0, 1280, 600);
	//	return Back;
	//}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		Font font = new Font("Serif", Font.PLAIN, 24);
		g.setFont(font);
		g.drawString("Welcome to TutorialsPoint", 50, 150);
	}

	// Defines the general properties of and starts the window.

	// The thread controlling changes of panels in the main window.

}
