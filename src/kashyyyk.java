import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
	 * Allows calculations and logic to happen on the game and 
	 * game components by calling each object individual tick() 
	 * method
	 */

public class kashyyyk extends JPanel {
	public Timer t;
	public Timer t1;
	public Timer t2;
	public JPanel BackgroundPanel;
	private BufferedImage img;
	public int myhealth = 100;
	public static Font customFont;
	public static int score = 0;
	public static int mytroopx = 50;;
	public static int mytroopy = 370;
	public static int mytroopd = 1;
	public static int mytrooppic = 1;

	public kashyyyk() {
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

		ImageIcon icon = new ImageIcon("kas.png");
		Image image = icon.getImage();

		BackgroundPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.drawImage(image, 0, 0, 1280, 720, null);
			}
		};

		for (int i = 0; i < 22; i++) {
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("grass" + (int) (Math.random() * 3 + 1) + ".png")
					.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			JLabel l5 = new JLabel(imageIcon2);
			l5.setBounds(i * 60, 600, 60, 60);
			BackgroundPanel.add(l5);
		}
		for (int i = 0; i < 22; i++) {
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("grass" + (int) (Math.random() * 3 + 1) + ".png")
					.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			JLabel l5 = new JLabel(imageIcon2);
			l5.setBounds(i * 60, 660, 60, 60);
			BackgroundPanel.add(l5);
		}
		frame.add(BackgroundPanel);
		frame.setLocationRelativeTo(null);

		ImageIcon weaponP = new ImageIcon(
				new ImageIcon("clonehealth.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel weaponI = new JLabel(weaponP);
		weaponI.setBounds(50, 10, 60, 60);
		BackgroundPanel.add(weaponI);

		ImageIcon scoreP = new ImageIcon(
				new ImageIcon("score.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JLabel scoreI = new JLabel(scoreP);
		scoreI.setBounds(500, 10, 60, 60);
		BackgroundPanel.add(scoreI);

		JLabel scoreB = new JLabel();
		scoreB.setText(Integer.toString(score) + "  Kills");
		scoreB.setBounds(600, 20, 200, 30);
		scoreB.setFont(new Font("Starjedi", Font.BOLD, 10));
		scoreB.setFont(customFont);
		BackgroundPanel.add(scoreB);

		JLabel healthB = new JLabel();
		healthB.setText(Integer.toString(myhealth) + "%");
		healthB.setBounds(120, 20, 100, 30);
		healthB.setFont(new Font("Starjedi", Font.BOLD, 10));
		healthB.setFont(customFont);
		BackgroundPanel.add(healthB);

		JLabel exitB = new JLabel();
		exitB.setText("Exit");
		exitB.setBounds(1100, 20, 100, 30);
		exitB.setFont(new Font("Starjedi", Font.BOLD, 10));
		exitB.setFont(customFont);
		BackgroundPanel.add(exitB);

		exitB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// you can open a new frame here as
				// i have assumed you have declared "frame" as instance variable
				System.exit(0);

			}
		});

		ImageIcon mytroopp = new ImageIcon(
				new ImageIcon("mytroop1.png").getImage().getScaledInstance(100, 240, Image.SCALE_DEFAULT));
		JLabel mytroopi = new JLabel(mytroopp);
		mytroopi.setBounds(mytroopx, mytroopy, 100, 240);
		BackgroundPanel.add(mytroopi);


		JLabel end = new JLabel();
		//end.setText(Integer.toString(health2) + "%");
		end.setBounds(500, 300, 300, 30);
		end.setFont(new Font("Starjedi", Font.BOLD, 10));
		end.setFont(customFont);
		end.setForeground(Color.black);
		end.setText("Game has ended");
		BackgroundPanel.add(end);
		end.setVisible(false);
		
		
		BackgroundPanel.add(Droids.addblast(1100, 360, 100, 240, 1));
		if (t == null) {
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					try {
						if (Droids.blasts.size() < 5) {
							int randroid = (int) (Math.random() * 1000);
							if (randroid > 980) {
								BackgroundPanel
										.add(Droids.addblast((int) (Math.random() * 400 + 700), 360, 100, 240, 1));
							}
						}
						if (Troops.blasts.size() < 1) {
							int randtrooper = (int) (Math.random() * 1000);
							if (randtrooper > 990) {
								BackgroundPanel.add(Troops.addblast((int) (Math.random() * 400), 368, 100, 240, 2));
							}
						}
						for (int o = 0; o < Droids.blasts.size(); o++) {
							JLabel h = Droids.blasts.get(o);
							h.setBounds(h.getX() - 1, h.getY(), 100, 240);

							int randdroidpic = (int) (Math.random() * 2);
							if (randdroidpic >= 1) {
								h.setIcon(new ImageIcon(new ImageIcon("driod" + 2 + ".png").getImage()
										.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
							} else {
								h.setIcon(new ImageIcon(new ImageIcon("driod" + 1 + ".png").getImage()
										.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
							}
							/*
							 * if(h.getX()<=30) { Droids.blasts.remove(h); }
							 */
							int randshoot = (int) (Math.random() * 1000);
							if (randshoot > 950) {
								BackgroundPanel.add(RedBlast.addblast(h.getX(), h.getY() + 95, 25, 15, 2));
							}
							if (h.getX() < 150) {
								BackgroundPanel.remove(h);
								Droids.blasts.remove(h);
							}
						}
						for (int o = 0; o < Troops.blasts.size(); o++) {
							JLabel h = Troops.blasts.get(o);
							h.setBounds(h.getX() + 1, h.getY(), 100, 240);

							int randtrooperpic = (int) (Math.random() * 2);
							if (randtrooperpic >= 1) {
								h.setIcon(new ImageIcon(new ImageIcon("redtrooper" + 2 + ".png").getImage()
										.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
							} else {
								h.setIcon(new ImageIcon(new ImageIcon("redtrooper" + 1 + ".png").getImage()
										.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
							}
							int randshoot = (int) (Math.random() * 1000);
							if (randshoot > 950) {
								BackgroundPanel.add(Blastlist.addblast(h.getX(), h.getY() + 70, 25, 15, 1));
							}
							if (h.getX() > 1150) {
								BackgroundPanel.remove(h);
								Troops.blasts.remove(h);
							}
						}
						for (int o = 0; o < Blastlist.blasts.size(); o++) {
							JLabel h = Blastlist.blasts.get(o);
							for (int q = 0; q < Droids.blasts.size(); q++) {
								JLabel s = Droids.blasts.get(q);
								if (h.getX() <= s.getX() + 2 && h.getX() >= s.getX() - 2) {
									score += 1;
									scoreB.setText(Integer.toString(score));
									BackgroundPanel.remove(h);
									Blastlist.blasts.remove(h);
									BackgroundPanel.remove(s);
									Droids.blasts.remove(s);
									score += 1;
									if (Droids.blasts.size() == 0) {
										BackgroundPanel.add(
												Droids.addblast((int) (Math.random() * 400) + 700, 360, 100, 240, 1));
									}
								}

								h.setBounds(h.getX() + 30, h.getY(), 25, 15);
							}
						}
						for (int o = 0; o < RedBlast.blasts.size(); o++) {
							JLabel h = RedBlast.blasts.get(o);
							for (int q = 0; q < Troops.blasts.size(); q++) {
								JLabel s = Troops.blasts.get(q);
								if (h.getX() <= s.getX() + 2 && h.getX() >= s.getX() - 2) {
									BackgroundPanel.remove(h);
									RedBlast.blasts.remove(h);
									BackgroundPanel.remove(s);
									Troops.blasts.remove(s);
									if (Troops.blasts.size() == 0) {
										BackgroundPanel
												.add(Troops.addblast((int) (Math.random() * 400), 360, 100, 240, 1));
									}
								}

							}
							if (h.getX() <= mytroopi.getX() + 2 && h.getX() >= mytroopi.getX() - 2
									&& h.getY() >= mytroopi.getY() - 100 && h.getY() <= mytroopi.getY() + 100) {
								myhealth -= 5;
								healthB.setText(Integer.toString(myhealth) + "%");
								if (myhealth <= 0) {
									t.cancel();
									end.setVisible(true);
								}
							}
							h.setBounds(h.getX() - 30, h.getY(), 35, 15);
						}

					} catch (Exception e) {

					}
				}
			};
			t = new Timer();
			t.scheduleAtFixedRate(task, 0, 1);
		}
		BackgroundPanel.setLayout(null);
		frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					BackgroundPanel.add(Blastlist.addblast(mytroopx, mytroopy + 85, 30, 15, 1));
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					mytroopx = mytroopx - 3;
					if (mytroopx <= 20) {
						mytroopx = 20;
					}

					if (mytrooppic == 1) {
						mytrooppic = 2;
					} else if (mytrooppic == 2) {
						mytrooppic = 1;
					}

					mytroopi.setIcon(new ImageIcon(new ImageIcon("mytroop" + mytrooppic + ".png").getImage()
							.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
					mytroopi.setBounds(mytroopx, mytroopy, 100, 240);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					mytroopx = mytroopx + 3;
					if (mytroopx >= 1200) {
						mytroopx = 1200;
					}

					if (mytrooppic == 1) {
						mytrooppic = 2;
					} else if (mytrooppic == 2) {
						mytrooppic = 1;
					}

					mytroopi.setIcon(new ImageIcon(new ImageIcon("mytroop" + mytrooppic + ".png").getImage()
							.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
					mytroopi.setBounds(mytroopx, mytroopy, 100, 240);
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {

					int count = 0;
					int intialx = mytroopx;
					for (int c = 0; c < 170; c++) {
						mytroopy = mytroopy - 1;
						if (count < 50) {
							// mytroopx = mytroopx + c / 130;
							count += c / 130;
						}

					}
					// RedY = RedY - 150;
					mytroopi.setBounds(mytroopx, mytroopy, 100, 240);

					if (mytroopy <= 280 && count < intialx + 50 && count < 50) {
						for (int c = 0; c < 170; c++) {
							mytroopy = mytroopy + 1;
							// mytroopx = mytroopx - c / 130;
						}
						count = mytroopx;

					}
				
				}}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					mytroopi.setIcon(new ImageIcon(new ImageIcon("mytroop" + mytrooppic + ".png").getImage()
							.getScaledInstance(100, 240, Image.SCALE_DEFAULT)));
					mytroopi.setBounds(mytroopx, mytroopy, 100, 240);

				}
			}
		});
	}
}