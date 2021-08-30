// this class is replaced with some high class cos sin math formula in the bat tick method 
import java.awt.*;
import java.util.Arrays;

public class Rotate {
    // make your own rotaye class using matrix and multiplying it and stuff 
    static double x, y, x1, y1;
    
    public Polygon rotatePolygon (Polygon polygon, int xCenter, int yCenter, double angle) {
        
        for(int i=0; i<polygon.xpoints.length; i++) {
            // translate all cordinates to origin(0,0)
            polygon.xpoints[i] = polygon.xpoints[i]-xCenter;
            polygon.ypoints[i] = polygon.ypoints[i]-yCenter;

            // rotate about origin(0,0) no one sees this it happens at the top left of the window
            Long x1 =  Math.round((polygon.xpoints[i] * Math.cos(Math.toRadians(angle)) - polygon.ypoints[i] * Math.sin(Math.toRadians(angle))));
            Long y1 = Math.round((polygon.xpoints[i] * Math.sin(Math.toRadians(angle)) + polygon.ypoints[i] * Math.cos(Math.toRadians(angle))));
            polygon.xpoints[i] = x1.intValue();
            polygon.ypoints[i] = y1.intValue();

            // translate back to previous position brings it back from the top left to the center of rotation xCenter yCenter
            polygon.xpoints[i] = polygon.xpoints[i] + xCenter;
            polygon.ypoints[i] = polygon.ypoints[i] + yCenter;
        }
        
        return polygon;
    }    
}
