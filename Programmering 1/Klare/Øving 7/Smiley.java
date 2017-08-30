import java.applet.Applet;
import java.awt.*;
 
public class Smiley extends Applet {
 
  public void paint(Graphics g) {
    g.setColor(Color.black);
    g.fillOval(50,60,15,25);    // Tegn øyne 
    g.fillOval(120,60,15,25);    
    g.drawArc(55,95,78,50,0,-180);  // Tegn minn
  }
}



/* <applet code="Smiley.class" width="200" height="200">
   </applet>


public class Smiley extends JPanel {
  
}