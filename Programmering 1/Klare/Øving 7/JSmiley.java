// JPanel verson
import java.awt.*;
import javax.swing.*;
// JFrame


class Window extends JFrame {
	Window() {
		setTitle("Bæbæm!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		Smiley smiley = new Smiley();
		add(smiley);
	}
}




class Smiley extends JPanel {
  public void paint(Graphics g) {
    g.setColor(Color.black);
    g.fillOval(50,60,15,25);    // Tegn øyne 
    g.fillOval(120,60,15,25);    
    g.drawArc(55,95,78,50,0,-180);  // Tegn minn
  }
}

class JSmiley {
	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);
	}
}

