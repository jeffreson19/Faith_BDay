import java.awt.*;
import java.util.Arrays;

public class Polygons {
    
    Main main;   

    Polygons (Main main) {
        this.main = main;
    }


    // the sad thing about this method is that i makes the same points everytime it is called 

    public void paint(Graphics2D g2d,int n, int xC, int yC, int radius, double angle, Color color) {

        int[] xPoints = new int[n];
        int[] yPoints = new int[n];
        for (int i = 0; i < n; i++) { // this for loop generates points for the
            //                  center point + radius cos (2PI * i/no of sides) 
            xPoints[i] = (int) (xC + radius*Math.cos(2*Math.PI*i/n));
            yPoints[i] = (int) (yC + radius*Math.sin(2*Math.PI*i/n));
        }
        // g2d.rotate(Math.toRadians(rotation), xC, yC);
        Polygon poly = new Polygon(xPoints, yPoints, n);
        g2d.setColor(color);
        g2d.fillPolygon(new Rotate().rotatePolygon(poly, xC, yC, angle));
        // g2d.drawOval(xC-radius, yC-radius, radius*2, radius*2);
    }

}
