//George F Rice 2023
//Jesse McNary 2023
//This is supposed to look like the sun
package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Canvas extends JPanel {
    public Canvas() {
        turtle = new Turtle();
    
        turtle.pen(Turtle.Pen.DOWN);
    
        for(int i=1; i<200; i += 1) {
            // turtle.forward(i*10); 
            // turtle.turn(61);

            turtle.forward(i);
            turtle.turn(i);

        }
    }

    public Dimension getPreferredSize() {
    
        return new Dimension(200,360);
    
    }
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);                

        Graphics2D g = (Graphics2D) graphics.create(); 
        g.setColor(new Color(240,0,0));
        Rectangle size = getBounds();                  
    
        g.translate(size.width / 2, size.height/2);    
    
        turtle.paintComponent(g);                      
    }
    
    private Turtle turtle;
}
