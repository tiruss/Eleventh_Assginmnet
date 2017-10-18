import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class Panel_7 extends JPanel implements ActionListener {
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_X = 0;
	private final int START_Y = 250;
	private BufferedImage image;
	public Timer timer;
	private int x, y;
  
	public Panel_7() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDoubleBuffered(true);
  
		File input = new File("GTS.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = START_X;
		y = START_Y;
		timer = new Timer(20, this);
		timer.start();


	}
  	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
  	
  	@Override
	public void actionPerformed(ActionEvent e) {
  		x += 3;
		y -= 1;
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
		}
		repaint();
	}
}

public class Simple_Animation extends JFrame {
	  
	public Simple_Animation() {
		add(new Panel_7());
		setTitle("애니메이션 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500, 1000);
		setVisible(true);
	}
  
	public static void main(String[] args) {
		new Simple_Animation();
	}
}


