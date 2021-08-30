import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConfettiGun {
    
    ArrayList<Confetti> arrayOfConfetti = new ArrayList<>();
    Main main;
    boolean isSpacePressed = false;

    ConfettiGun (Main main) {
        this.main = main;
        refreshGun();
    }

    public void tick() {
        if(isSpacePressed) {
            for (int i = 0; i < arrayOfConfetti.size(); i++) {
                arrayOfConfetti.get(i).tick();
            }
        }

        if(arrayOfConfetti.size() == 0) isSpacePressed = false;
        killConfetti();
    }


    public void paint(Graphics2D g2d) {
        if(isSpacePressed) {
            for (int i = 0; i < arrayOfConfetti.size(); i++) {
                arrayOfConfetti.get(i).paint(g2d);
            }
        }
    }

    public void refreshGun() {
        arrayOfConfetti.clear();
        // bottom left corner
        arrayOfConfetti.add(new Confetti(0, 500, 5f, -5f, 0.1f,0.002f, 2f, Color.orange));
        arrayOfConfetti.add(new Confetti(0, 500, 7f, -7f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(0, 500, 9f, -6f, 0.1f,0.002f, 2f, Color.magenta));
        arrayOfConfetti.add(new Confetti(0, 500, 2f, -6f, 0.1f,0.002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(0, 500, 3f, -5f, 0.1f,0.002f, 2f, Color.orange));
        arrayOfConfetti.add(new Confetti(0, 500, 6f, -8f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(0, 500, 4f, -3f, 0.1f,0.002f, 2f, Color.magenta));
        arrayOfConfetti.add(new Confetti(0, 500, 8f, -4f, 0.1f,0.002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(0, 500, 1f, -5f, 0.1f,0.002f, 2f, Color.orange)); //
        arrayOfConfetti.add(new Confetti(0, 500, 8f, -8f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(0, 500, 6f, -6f, 0.1f,0.002f, 2f, Color.magenta));
        arrayOfConfetti.add(new Confetti(0, 500, 2f, -4f, 0.1f,0.002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(0, 500, 9f, -5f, 0.1f,0.002f, 2f, Color.orange));
        arrayOfConfetti.add(new Confetti(0, 500, 5f, -3f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(0, 500, 7f, -3f, 0.1f,0.002f, 2f, Color.magenta));
        arrayOfConfetti.add(new Confetti(0, 500, 8f, -9f, 0.1f,0.002f, 2f, Color.cyan));
        // bottom right corner 
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -5f, -5f, 0.1f,0.002f, 2f, Color.red));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -7f, -7f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -9f, -4f, 0.1f,0.0002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -2f, -6f, 0.1f,0.0002f, 2f, Color.pink));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -3f, -5f, 0.1f,0.002f, 2f, Color.red));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -6f, -8f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -4f, -3f, 0.1f,0.0002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -8f, -4f, 0.1f,0.0002f, 2f, Color.pink));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -1f, -5f, 0.1f,0.002f, 2f, Color.red)); //
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -8f, -8f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -6f, -6f, 0.1f,0.0002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -2f, -4f, 0.1f,0.0002f, 2f, Color.pink));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -9f, -5f, 0.1f,0.002f, 2f, Color.red));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -5f, -3f, 0.1f,0.002f, 2f, Color.yellow));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -7f, -3f, 0.1f,0.0002f, 2f, Color.cyan));
        arrayOfConfetti.add(new Confetti(main.getWidth(), 500, -8f, -9f, 0.1f,0.0002f, 2f, Color.pink));
    }

    public void killConfetti() {
        // this method removes a confetti when it is out of the screen 
        for (int i = 0; i < arrayOfConfetti.size(); i++) {
            if(arrayOfConfetti.get(i).x < 0 || arrayOfConfetti.get(i).x > main.getWidth()){
                arrayOfConfetti.remove(i);
            }
            else if(arrayOfConfetti.get(i).y < 0 || arrayOfConfetti.get(i).y > main.getHeight()){
                arrayOfConfetti.remove(i);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE){
            refreshGun();  
            isSpacePressed = true;
        }
    }
}
