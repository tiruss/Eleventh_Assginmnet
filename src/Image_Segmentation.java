import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public  class Image_Segmentation extends JFrame implements ActionListener{
	
	private int pieces = 4;
	private int totalPieces = pieces * pieces;
	private int[] pieceNumber;
	private BufferedImage img;
	
	public Image_Segmentation() {
		setTitle("Image segmentation");
		try {
			img = ImageIO.read(new File("GTS.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		pieceNumber = new int[totalPieces];
		for (int i=0; i<totalPieces;i++) {
			pieceNumber[i] = i;
		}
		
		add(new Panel_test3(), BorderLayout.CENTER);
		JButton button = new JButton("Segmentation");
		
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
		setSize(img.getWidth(null), img.getHeight(null));
		setVisible(true);
	}
	
	void Segment() {
		Random rand = new Random();
		int ri;
		for(int i=0; i<totalPieces; i++) {
			ri = rand.nextInt(totalPieces);
			int tmp = pieceNumber[i];
			pieceNumber[i] = pieceNumber[ri];
			pieceNumber[ri] = tmp;
		}
	}
	
	class Panel_test3 extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int pieceWidth = img.getWidth(null) / pieces;
			int pieceHeight = img.getHeight(null) / pieces;
			for (int x = 0; x < pieces; x++) {
			       int sx = x * pieceWidth;
			       for (int y = 0; y < pieces; y++) {
				int sy = y * pieceHeight;
				int number = pieceNumber[x * pieces + y];
				int dx = (number / pieces) * pieceWidth;
				int dy = (number % pieces) * pieceHeight;
				g.drawImage(img, dx, dy, dx + pieceWidth, dy + pieceHeight,
					sx, sy, sx + pieceWidth, sy + pieceHeight, null);
			       }
			}

		}
	}
	public static void main(String[] args) {
		new Image_Segmentation();
	}
	public void actionPerformed(ActionEvent e) {
		Segment();
		repaint();
	}

}
