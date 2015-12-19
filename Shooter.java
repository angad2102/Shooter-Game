import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; //for ArrayList
interface Animation { //A common interface for moving objects
 void move();
 void paint( Graphics g);
}
public class Shooter extends JFrame implements MouseListener{
	int x=0;
 final static int WIDTH0 = 600, HEIGHT0 = 600, FPS = 1;
 javax.swing.Timer alarm = new javax.swing.Timer(1000/FPS, new TimerAction());
 MyPanel p = new MyPanel(); //Drawing board
 ArrayList<Animation> list = new ArrayList<Animation>();
 Target a= new Target();
 Target b= new Target();
 Target c= new Target();
 Target d= new Target();
 JLabel fLabel;
 public static void main(String[] args) {

	 Shooter a = new Shooter();
	 a.go();

 }
 public void go(){


 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 add(p);

p.addMouseListener(this);


list.add(a);
list.add(b);
list.add(c);
list.add(d);


 setSize(WIDTH0, HEIGHT0);
 setVisible(true);

 alarm.start();
 }

 class MyPanel extends JPanel {

 public void paintComponent(Graphics g) {

 g.setColor(Color.white); //Erase the board
 g.fillRect(0, 0, WIDTH0-1, HEIGHT0-1);


if(x==0)
 for (Animation a : list) { //Move and draw the animation objects
a.move();
a.paint( g);



 }

if(list.isEmpty())
{
	paintext(g);
	 g.setColor(Color.RED); //Paint the boundary

}



 //g.setColor(Color.black); //Paint the boundary
g.drawRect(0, 0, WIDTH0-1, HEIGHT0-1);
 }

public void paintext(Graphics g) {

	Image landscape = new ImageIcon("a.png").getImage();
	g.drawImage(landscape, 0,0,Shooter.this );
}



 }
 class TimerAction implements ActionListener {
 public void actionPerformed(ActionEvent e) {
 repaint();
 }
 }

 public class Target implements Animation{

		int x;
		int y;
		int width;
		int height;

		Target()
		{
			width=500;
			height=500;
		}
		public void move() {
			// TODO Auto-generated method stub
			y = (int) (Math.random()* height);
			x = (int) (Math.random()* width);
		}

		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			Image landscape = new ImageIcon("ccc.jpg").getImage();
			g.drawImage(landscape, x, y,Shooter.this );
		}

		public int getx()
		{
			return x;
		}
		public int gety()
		{
			return y;
		}

	}
public void mouseClicked(MouseEvent e)
 {
	if(Math.abs(e.getX()-a.getx())<=91&&Math.abs(e.getY()-a.gety())<=99)
	{
		list.remove(a);
	}

	if(Math.abs(e.getX()-b.getx())<=91&&Math.abs(e.getY()-b.gety())<=99)
	{
		list.remove(b);
	}

	if(Math.abs(e.getX()-c.getx())<=91&&Math.abs(e.getY()-c.gety())<=99)
	{
		list.remove(c);
	}

	if(Math.abs(e.getX()-d.getx())<=91&&Math.abs(e.getY()-d.gety())<=99)
	{
		list.remove(d);
	}
 }
public void mousePressed(MouseEvent e) {
	//Do Nothing
}
public void mouseReleased(MouseEvent e) {
//Do Nothing
}
public void mouseEntered(MouseEvent e) {
	//Do Nothing

}
public void mouseExited(MouseEvent e) {
	//Do Nothing

}

}
