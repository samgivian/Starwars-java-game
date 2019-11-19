import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpaceChar {
	public Timer t;
	public Timer t1;
	public Timer t2;
	public JPanel BackgroundPanel;
	private BufferedImage img;
	public static int friend1d = 1;
	public static int friend1x = 100;
	public static int friend1y = 100;
	public static int friend2d = 1;
	public static int friend2x = 100;
	public static int friend2y = 400;

	public static int enemy1d = 1;

	public static int enemy2d = 1;

	public static int friend1health = 100;
	public static int friend2health = 100;
	public static int enemy1health = 100;
	public static int enemy2health = 100;
	public static Font customFont;

	public boolean enemy1alive = true;
	public boolean enemy2alive = true;

	public boolean friend1alive = true;
	public boolean friend2alive = true;

	public static int health1 = 100;
	public static int health2 = 100;
	public static boolean gamerunning=true;

	SpaceChar() {
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

		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("space.png");
		Image image = icon.getImage();
		BackgroundPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.drawImage(image, 0, 0, 1280, 720, null);
			}
		};
		BackgroundPanel.add(Friendlyspaceship.addblast(100,  (int)(Math.random()*400+50), 150, 75, 1));

		BackgroundPanel.add(EnemySpaceShip.addblast(1000, (int)(Math.random()*400+50), 75, 45, 1));

		BackgroundPanel.setLayout(null);
		// frame.add(l5);
		BackgroundPanel.setPreferredSize(new Dimension(800, 600));
		frame.add(BackgroundPanel);
		frame.setLocationRelativeTo(null);
		JLabel healthA = new JLabel();
		healthA.setText(Integer.toString(health1) + "%");
		healthA.setBounds(90, 20, 100, 30);
		healthA.setFont(new Font("Starjedi", Font.BOLD, 10));
		healthA.setFont(customFont);
		healthA.setForeground(Color.white);
		BackgroundPanel.add(healthA);
		
		
		
		JLabel healthB = new JLabel();
		healthB.setText(Integer.toString(health2) + "%");
		healthB.setBounds(1100, 20, 100, 30);
		healthB.setFont(new Font("Starjedi", Font.BOLD, 10));
		healthB.setFont(customFont);
		healthB.setForeground(Color.white);
		BackgroundPanel.add(healthB);
		
		
		JLabel end = new JLabel();
		//end.setText(Integer.toString(health2) + "%");
		end.setBounds(500, 300, 300, 30);
		end.setFont(new Font("Starjedi", Font.BOLD, 10));
		end.setFont(customFont);
		end.setForeground(Color.white);
		BackgroundPanel.add(end);
		end.setVisible(false);
		
		ImageIcon close = new ImageIcon(new ImageIcon("close.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel c = new JLabel(close);
		c.setBounds(1200, 20, 60, 60);

		JLabel exit = new JLabel();
		exit.setText("Exit");
		exit.setBounds(600, 20, 100, 30);
		exit.setFont(new Font("Starjedi", Font.BOLD, 10));
		exit.setFont(customFont);
		exit.setForeground(Color.white);
		BackgroundPanel.add(exit);
		exit.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
		    	System.exit(0);

		    }  
		}); 
		if (t == null) {

			TimerTask task = new TimerTask() {

				@Override
				public void run() {
				
					for (int o=0;o<Blastlist.blasts.size();o++) {
						JLabel h=Blastlist.blasts.get(o);
						h.setBounds(h.getX() + 15, h.getY(), 20, 10);
						JLabel s=EnemySpaceShip.blasts.get(0);
						if(h.getY()<=s.getY()+50 && h.getY()>=s.getY()-15 && h.getX()>=s.getX()+15  && h.getX()<=s.getX()+15) {
							
							health2-=15;
							if(health2<=0) {
								s.setIcon(new ImageIcon(new ImageIcon("explosion.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
								t.cancel();
								end.setText("Rebels has won");
								end.setVisible(true);
								gamerunning=false;
								
							
							}
							healthB.setText(Integer.toString(health2) + "%");
							BackgroundPanel.remove(h);
							Blastlist.blasts.remove(h);
							

						}
					}
					for (int o=0;o<RedBlast.blasts.size();o++) {
						JLabel y=RedBlast.blasts.get(o);
						y.setBounds(y.getX() - 15, y.getY(), 20, 10);
						JLabel s=Friendlyspaceship.blasts.get(0);
						if(y.getY()<=s.getY()+50 && y.getY()>=s.getY()-20 && y.getX()<=s.getX()+10 && y.getX()>=s.getX()-10) {
							health1-=10;
							if(health1<=0) {
								t.cancel();
								y.setIcon(new ImageIcon(new ImageIcon("explosion.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
								end.setText("Empire has won");
								end.setVisible(true);
								gamerunning=false;
							}
							healthA.setText(Integer.toString(health1) + "%");
							BackgroundPanel.remove(y);
							RedBlast.blasts.remove(y);
							
							

						}
						}
					
				}

			};

			t = new Timer();
			t.scheduleAtFixedRate(task, 0, 50);
		}

		frame.addKeyListener(new KeyListener() {
		
			public void keyPressed(KeyEvent e) {
				if(gamerunning) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX() + 5, k.getY(), 150, 75);
					if (k.getX() >= 1080) {
						k.setBounds(1080, k.getY(), 150, 75);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX(), k.getY() - 5, 150, 75);
					if (k.getY() <= 100) {
						k.setBounds(k.getX(), 100, 150, 75);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX(), k.getY() + 5, 150, 75);
					if (k.getY() >= 650) {
						k.setBounds(k.getX(), 650, 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX() - 5, k.getY(), 150, 75);
					if (k.getX() <= 10) {
						k.setBounds(10, k.getY(), 150, 75);
					}

				}
				
				
				
				
				
				
				if (e.getKeyCode() == KeyEvent.VK_D) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX() + 7, k.getY(), 150, 75);
					if (k.getX() >= 1080) {
						k.setBounds(1080, k.getY(), 150, 75);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX(), k.getY() - 7, 150, 75);
					if (k.getY() <= 100) {
						k.setBounds(k.getX(), 100, 150, 75);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX(), k.getY() + 7, 150, 75);
					if (k.getY() >= 650) {
						k.setBounds(k.getX(), 650, 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX() - 7, k.getY(), 150, 75);
					if (k.getX() <= 10) {
						k.setBounds(10, k.getY(), 150, 75);
					}

				}
			}
			}
			public void keyReleased(KeyEvent e) {
				if(gamerunning) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX() + 5, k.getY(), 150, 75);
					if (k.getX() >= 1080) {
						k.setBounds(1080, k.getY(), 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX(), k.getY() - 5, 150, 75);
					if (k.getY() <= 100) {
						k.setBounds(k.getX(), 100, 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX(), k.getY() + 5, 150, 75);
					if (k.getY() >= 650) {
						k.setBounds(k.getX(), 650, 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX() -5, k.getY(), 150, 75);
					if (k.getX() <= 10) {
						k.setBounds(10, k.getY(), 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					BackgroundPanel.add(Blastlist.addblast(k.getX(), k.getY()+10, 20, 10, 1));
				}
				
				
				
				
				
				
				
				if (e.getKeyCode() == KeyEvent.VK_F) {
					JLabel k = EnemySpaceShip.blasts.get(0);
				
					BackgroundPanel.add(RedBlast.addblast(k.getX(), k.getY()+10, 20, 10, 2));
				}
				
				if (e.getKeyCode() == KeyEvent.VK_D) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX() + 7, k.getY(), 150, 75);
					if (k.getX() >= 1080) {
						k.setBounds(1080, k.getY(), 150, 75);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX(), k.getY() - 7, 150, 75);
					if (k.getY() <= 100) {
						k.setBounds(k.getX(), 100, 150, 75);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX(), k.getY() + 7, 150, 75);
					if (k.getY() >= 650) {
						k.setBounds(k.getX(), 650, 150, 75);
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					JLabel k = EnemySpaceShip.blasts.get(0);
					k.setBounds(k.getX() - 7, k.getY(), 150, 75);
					if (k.getX() <= 10) {
						k.setBounds(10, k.getY(), 150, 75);
					}

				}
			}
			}
			public void keyTyped(KeyEvent e) {
			/*
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					JLabel k = Friendlyspaceship.blasts.get(0);
					k.setBounds(k.getX() + 20, k.getY(), 150, 75);

				}*/
			}
		});
		
		
		
	
		
		
		
		frame.setVisible(true);
	}

}
