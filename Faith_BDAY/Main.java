// import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
// import java.awt.image.*;
// import java.io.*;
import java.awt.event.KeyListener;

public class Main extends JPanel{
    Dimension size = new Dimension(700,600);
    int degrees = -1;
    int rev = 1;
    ConfettiGun gun = new ConfettiGun(this);
    Polygons polygon1 = new Polygons(this);;
    Arrows arrow1 = new Arrows(5);
    Arrows arrow2 = new Arrows(4);
    Arrows arrow3 = new Arrows(3);
    Arrows arrow4 = new Arrows(2);
    Arrows arrow5 = new Arrows(1);
    TextGlitch glitch = new TextGlitch(this);
    Main () {
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);        
    }

    public void tick() {
        gun.tick();
        glitch.tick();
        arrow1.tick();
        arrow2.tick();
        arrow3.tick();
        arrow4.tick();
        arrow5.tick();
        if(rev>360){
            rev = 0;
        }
        if (degrees<-360) {
            degrees = 0;
        }
        degrees-=4;
        rev+=3;
    }

   

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D  g2d = (Graphics2D)g;
        g2d.fillRect(0, 0, getWidth(), getHeight());

        
        arrow1.rightArrow(g2d, getWidth()/2-450/*50*/, getHeight()/2, 30, 50, Color.PINK);
        arrow2.rightArrow(g2d, getWidth()/2-400/*100*/, getHeight()/2, 30, 50, Color.PINK);
        arrow3.rightArrow(g2d, getWidth()/2-350/*50*/, getHeight()/2, 30, 50, Color.PINK);
        arrow4.rightArrow(g2d, getWidth()/2-300/*100*/, getHeight()/2, 30, 50, Color.PINK);
        arrow5.rightArrow(g2d, getWidth()/2-250/*150*/, getHeight()/2, 30, 50, Color.PINK);
        arrow5.leftArrow(g2d, getWidth()/2+250/*200*/, getHeight()/2, 30, 50, Color.PINK);
        arrow4.leftArrow(g2d, getWidth()/2+300/*250*/, getHeight()/2, 30, 50, Color.PINK);
        arrow3.leftArrow(g2d, getWidth()/2+350/*300*/, getHeight()/2, 30, 50, Color.PINK);
        arrow2.leftArrow(g2d, getWidth()/2+400/*250*/, getHeight()/2, 30, 50, Color.pink);
        arrow1.leftArrow(g2d, getWidth()/2+450/*300*/, getHeight()/2, 30, 50, Color.pink);
        
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 350, rev, new Color(64, 181, 173, 200));
        //----------------------------------------------------------------
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 300, degrees, new Color(243, 58, 106, 200));        
        //---------------------------------------------------------------------------
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 250, rev, new Color(64, 181, 173, 200));
        //----------------------------------------------------------------
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 200, degrees, new Color(243, 58, 106, 200));
        // //----------------------------------------------------------------
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 150, rev, new Color(135, 206, 235, 200));
        // //--------------------------------------------------------------------------
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 100, degrees, new Color(243, 58, 106, 200));
        // //----------------------------------------------------------------
        polygon1.paint(g2d, 5, getWidth()/2, getHeight()/2, 50, rev, new Color(64, 181, 173, 200));
         

        // new Flower().paint(g2d, getWidth()/2, getHeight()/2, 100);

        // Image img = Toolkit.getDefaultToolkit().getImage("seth.jpg");
        // try {
        //     Image img = ImageIO.read(new File("seth.jpg"));
        //     g2d.drawImage(img, getWidth()/2-50, getHeight()/2, 100, 100, null, null);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        glitch.paint(g2d);
        gun.paint(g2d);
        

        g2d.dispose();
    }

    public static void main(String[] args) {
        Main main = new Main();
        JFrame frame = new JFrame("\u2665 HAPPY BIRTHDAY \u2665");
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                main.gun.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        while (true) {
            main.tick();
            main.repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}