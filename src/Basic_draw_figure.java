import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Basic_draw_figure {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(new draw_test());
		j.setSize(1100, 400);
		j.setVisible(true);

	}
}

class draw_test extends JPanel {
	public draw_test() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawLine(25, 25, 125, 125);
		g.drawString("drawLine()", 25, 140);
		
		int[] x = {25, 75, 125, 85, 125, 75, 25, 65};
		int[] y = {200, 240, 200, 250, 300, 260, 300, 250};		
		g.drawPolyline(x, y, 8);
		g.drawString("drawPolyline()", 25, 315);
		
		g.drawRect(175, 25, 100, 100);
		g.drawString("drawRect()", 175, 140);
		
		g.fillRect(175, 200, 100, 100);
		g.drawString("fillRect()", 175, 315);
		
		g.draw3DRect(325, 25, 100, 100, true);
		g.drawString("draw3DRect()", 325, 140);
		
		g.fill3DRect(325, 200, 100, 100, true);
		g.drawString("fill3DRect()", 325, 315);
		
		g.drawRoundRect(475, 25, 100, 100, 100, 100);
		g.drawString("drawROundRect()", 475, 140);
		
		g.fillRoundRect(475, 200, 100, 100, 100, 100);
		g.drawString("fillRoundRect()", 475, 315);
		
		g.drawOval(625, 25, 100, 100);
		g.drawString("drawOval()", 625, 140);
		
		g.fillOval(625, 200, 100, 100);
		g.drawString("fillOval()", 625, 315);
		
		g.drawArc(775, 25, 100, 100, 120, 200);
		g.drawString("drawArc()", 775, 140);
		
		g.fillArc(775, 200, 100, 100, 120, 200);
		g.drawString("fillArc()", 775, 315);
		
		int[] x_2 = {925, 1025, 925, 1025, 925};
		int[] y_2 = {25, 25, 125, 125, 25};
		g.drawPolygon(x_2, y_2, 5);
		g.drawString("drawPolygon()", 925, 140);
		
		int[] x_3 = {925, 1025, 925, 1025, 925};
		int[] y_3 = {200, 200, 300, 300, 200};
		g.fillPolygon(x_3, y_3, 5);
		g.drawString("fillPolygon()", 925, 315);
	}
}
