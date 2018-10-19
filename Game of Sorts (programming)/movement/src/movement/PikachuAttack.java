package movement;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PikachuAttack extends JFrame implements Runnable{

    Graphics dbg;
    Image dbImage;
    Image Pik1;
    static ImageIcon active;

    int x, y, xDirection, yDirection;

    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(10);
            }
        }catch(Exception e){
            System.out.println("Uh-oh, something went wrong!.");
        }
    }

    private void move() {
        x += xDirection;
        y += yDirection;

    }

     public void setXDirection(int xdir) {
            xDirection = xdir;
        }

        public void setYDirection(int ydir) {
            yDirection = ydir;
        }


    // KEY COMMANDS //
      public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

                if(keyCode == e.VK_LEFT) {
                    setXDirection(-1);
                }
                if(keyCode == e.VK_RIGHT) {
                    setXDirection(+1);
                }
                if(keyCode == e.VK_UP) {    
                    setYDirection(-1);
                }
                if(keyCode == e.VK_DOWN) {
                    setYDirection(+1);
                }   
                /*(if(keyCode == e.VK_LEFT | keyCode == e.VK_RIGHT | keyCode == e.VK_UP | keyCode == e.VK_DOWN){
                    active = new ImageIcon("C:\\Users\\Neil\\workspace\\MyOwnTutorials\\bin\\game\\pikready.gif");
                }else{
                    active = new ImageIcon("C:\\Users\\Neil\\workspace\\MyOwnTutorials\\bin\\game\\pikachu.gif");
                } */

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
                    if(keyCode== e.VK_LEFT){
                       setXDirection(0);                    
                    }
                    if(keyCode== e.VK_RIGHT){
                       setXDirection(0);                    
                    }
                    if(keyCode== e.VK_UP){
                        setYDirection(0);
                    }
                    if(keyCode== e.VK_DOWN){
                        setYDirection(0);                   
                    }

        }

        @Override
        public void keyTyped(KeyEvent e) {


        }

    }

    // CONSTRUCTOR //
    public PikachuAttack(){

        //Image Import
        ImageIcon still = new ImageIcon("dragon.png");
        Pik1 = still.getImage();
        //ImageIcon ready = new ImageIcon("C:\\Users\\Neil\\workspace\\MyOwnTutorials\\bin\\game\\pikready.gif");
        //Pik2 = ready.getImage(); */
        // Pik1 = active.getImage();

        //JFrame properties
        addKeyListener(new AL());
        setTitle("Pikachu Attack");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        x = 15;
        y = 15;
    }



    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);   

    }

    public void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillRect(200, 190, 12, 20);
        g.drawImage(Pik1, x, y, this);
        g.setColor(Color.red);



        repaint();
    }


    public static void main(String[] args) {
        PikachuAttack game = new PikachuAttack();
        Thread t1 = new Thread(game);
        t1.start();
    }

}