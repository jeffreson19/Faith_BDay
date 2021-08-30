// this is like my 2nd or so attempt at game physics but my first successful one
import java.awt.*;

public class Confetti {

    float x = 100, y = 400;
    float xVel = 0.1f, yVel = -4, gravity = 0.1f;
    float dt = 0.15f, xAcc = 0.002f;
    Color color;

    // an array of confetti shapes that a random num generator will pick to render

    Confetti(float x, float y, float xVel, float yVel, float gravity, float xAcc, float dt, Color color) { // make all the variables in this class a para here
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        this.gravity = gravity;
        this.dt = dt;
        this.color = color;
    }

    public void tick() {
        y += yVel * dt;
        yVel += gravity * dt;
        x += xVel * dt;
        xVel += xAcc;
    }

    public void paint(Graphics2D g2d) {

        g2d.setColor(color);
        g2d.fillOval((int)x, (int)y, 10, 15); // casting x and y here won't actually round x and y (which remains a float) but only uses it to render. So the actual x and y values are not tampered with (rounded)
    }

}