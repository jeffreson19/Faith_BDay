import java.awt.*;

public class Arrows {
    
    Color newColor = new Color(227, 11, 92);
    int id;
    int count = 1;
    Arrows (int id) {
        this.id = id;
    }

    public void tick() {
        if(count>200){
            count = 1;
        }else{
            count++;
        }
    }

    public void rightArrow(Graphics2D g2d, int xC, int yC, int r, int width, Color color) {
        // r is the height of a parallelogram of the two parallelograms that make the arrow 
        int xPoints4[] = new int[6];
        int yPoints4[] = new int[6];
        for (int i=0; i<xPoints4.length; i++) {
            if (i==0) {
                yPoints4[i] = yC -r;
                xPoints4[i] = xC;
            }
            if (i==1) {
                yPoints4[i] = yC-r;
                xPoints4[i] = xC-width/2;//xPoints4[0] - r;
            }
            if (i==2) {
                yPoints4[i] = yC;
                xPoints4[i] = xC-width;//xPoints4[1] - r/2;
            }
            if (i==3) {
                yPoints4[i] = yC + r;
                xPoints4[i] = xC-width/2;//xPoints4[2] +r;
            }
            if (i==4) {
                yPoints4[i] = yC+r;
                xPoints4[i] = xC;//xPoints4[3] + r;
            }
            if (i==5) {
                yPoints4[i] = yC;
                xPoints4[i] = xC-width/2;//xPoints4[2] + r;
            }
        }

        if (count/10==id){
            g2d.setColor(newColor);
        }
        else g2d.setColor(color);
        
        g2d.fillPolygon(xPoints4, yPoints4, 6);
    }

    public void leftArrow(Graphics2D g2d, int xC, int yC, int r, int width, Color color) {
        // r is the height of a parallelogram of the two parallelograms that make the arrow 
        int xPoints4[] = new int[6];
        int yPoints4[] = new int[6];
        for (int i=0; i<xPoints4.length; i++) {
            if (i==0) {
                yPoints4[i] = yC - r;
                xPoints4[i] = xC;
            }
            if (i==1) {
                yPoints4[i] = yC - r;
                xPoints4[i] = xC + width/2;//xPoints4[0] - r;
            }
            if (i==2) {
                yPoints4[i] = yC;
                xPoints4[i] = xC + width;//xPoints4[1] - r/2;
            }
            if (i==3) {
                yPoints4[i] = yC + r;
                xPoints4[i] = xC + width/2;//xPoints4[2] +r;
            }
            if (i==4) {
                yPoints4[i] = yC + r;
                xPoints4[i] = xC;//xPoints4[3] + r;
            }
            if (i==5) {
                yPoints4[i] = yC;
                xPoints4[i] = xC + width/2;//xPoints4[2] + r;
            }
        }

        if (count/10==id){
            g2d.setColor(newColor);
        }
        else g2d.setColor(color);
        g2d.fillPolygon(xPoints4, yPoints4, 6);
    }
}
