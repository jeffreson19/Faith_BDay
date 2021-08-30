import java.awt.*;


public class TextGlitch{

    Main main;
    int x, y;
    int count = 0, time= 100;
    String text = "Happy B Day Faith";
    Font font = new Font("Arial Black", Font.PLAIN, 47);
    TextGlitch (Main main) {
        this.main = main;
    }

    
    public void tick() {
        x = main.getWidth()/2;
        y = main.getHeight()/2;
        if(count>=time)
            count=0;
        else
            count++;
    }

    public void paint(Graphics2D g2d) {
        g2d.setFont(font);
        x = x - g2d.getFontMetrics(font).stringWidth(text)/2;
        y = y + g2d.getFontMetrics(font).getAscent()/2-4;
        if (count < time/3) {
            g2d.setColor(new Color(50, 205, 50));
            g2d.drawString(text, x+3, y-1);
            g2d.setColor(new Color(31, 81, 255));
            g2d.drawString(text, x-1, y-3);
            g2d.setColor(new Color(227, 115, 131));
            g2d.drawString(text, x+1, y+1);
        } else if (count < time/2) {
            g2d.setColor(new Color(31, 81, 255));
            g2d.drawString(text, x+3, y-1);
            g2d.setColor(new Color(50, 205, 50));
            g2d.drawString(text, x-1, y-3);
            g2d.setColor(new Color(227, 115, 131));
            g2d.drawString(text, x+1, y+1);
        } else {
            g2d.setColor(new Color(31, 81, 255));
            g2d.drawString(text, x+3, y-1);
            g2d.setColor(new Color(227, 115, 131));
            g2d.drawString(text, x-1, y-3);
            g2d.setColor(new Color(50, 205, 50));
            g2d.drawString(text, x+1, y+1);
        }
        g2d.setColor(new Color(227, 11, 92));
        g2d.drawString(text, x, y);
    }
}
