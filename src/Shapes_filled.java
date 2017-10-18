import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shapes_filled extends JFrame{
	public Shapes_filled() {
		setSize(600, 160);
		setTitle("Java 2D shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel_6 panel = new Panel_6();
		add(panel);
		setVisible(true);
	}
	
	public static void main(String args[] ) {
		Shapes_filled m = new Shapes_filled();
	}
}

class Panel_6 extends JComponent{
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(3));
		GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0,
				70, Color.RED);
		
		g2.setPaint(Color.RED);
		g2.fill(new Rectangle2D.Float(10, 10, 70, 80));
		
		g2.setPaint(gp);
		g2.fill(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
		
		g2.setPaint(Color.RED);
		g2.fill(new Ellipse2D.Float(210, 10, 80, 80));

		g2.setPaint(gp);
		g2.fill(new Arc2D.Float(310, 10, 80, 80, 45, 225, 
			Arc2D.OPEN));

		g2.setPaint(Color.RED);
		g2.fill(new Arc2D.Float(410, 10, 80, 80, 45, 225, 
			Arc2D.CHORD));

		g2.setPaint(gp);
		g2.fill(new Arc2D.Float(510, 10, 80, 80, 45, 225, 
			Arc2D.PIE));
	}
}

