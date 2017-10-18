import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Image_Grayscaling extends JFrame{
	
	private BufferedImage image;
	int width;
	int height;
	
	public Image_Grayscaling() {
		setTitle("Gralyscaling");
		File input = new File("audi_spider.png");
		try {
			image = ImageIO.read(input);
			width = image.getWidth() - 1;
			height = image.getHeight() - 1;
			
			for (int row=0; row< width; row++) {
				for (int col=0; col< height; col++) {
					Color color = new Color(image.getRGB(row, col));
					
					int red = (int)(color.getRed());
					int green = (int)(color.getGreen());
					int blue = (int)(color.getBlue());
					int avg = (red + green + blue)/3;
					Color newColor = new Color(avg, avg, avg);
					
					image.setRGB(row, col, newColor.getRGB());
				}
			}
				
			File output = new File("output.png");
			ImageIO.write(image, "png", output);
			add(new Panel_test4());
			pack();
			setVisible(true);
		} catch (Exception e) {
			//System.out.println("이미지 읽기 실패!");
			e.printStackTrace();
		}
	}
	
	class Panel_test4 extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
		}
		
		public Dimension getPreferredSize() {
			if(image == null) {
				return new Dimension(100, 100);
			} else {
				return new Dimension(image.getWidth(null), 
						image.getHeight(null));
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
	       Image_Grayscaling obj = new Image_Grayscaling();
	}

}
