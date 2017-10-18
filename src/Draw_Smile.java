import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Panel_set extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
        g.fillOval(20, 30, 200, 200);
        g.setColor(Color.BLACK);
        g.drawArc(60, 80, 50, 50, 180, -180);	
        g.drawArc(150, 80, 50, 50, 180, -180);	
        g.drawArc(70, 130, 100, 70, 180, 180);	

	}
}
public class Draw_Smile extends JFrame {
	public Draw_Smile() {
        setSize(280, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("´«»ç¶÷ ¾ó±¼");
        setVisible(true);
        add(new Panel_set());
	}

	public static void main(String[] args) {
        Draw_Smile s=new Draw_Smile();
	}
}

