import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicPaint {
	public static void main(String args[]) {
		JFrame f = new JFrame("그래픽 기초 프로그램");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Panel_test1());
		f.setSize(300, 200);
		f.setVisible(true);
	}
}

class Panel_test1 extends JPanel{
	
	public Panel_test1() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(50, 50, 50, 50);
		g.drawOval(200, 50, 50, 50);
	}
}
