import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//Importa swing y todos sus elementos.
public class Huerfana extends JFrame implements Runnable{

    JPanel p1,p2;

    Graphics dbg;

    Image dbImage;

    Image Pik1,load,load2,load3,load4,load5;

    int x,y, xDirection, yDirection,disparo=0,a=1100;

    int X=0,X1=800,X2=1600,fuegoX,fuegoY,fuegoX2,fuegoY2,fuegoX3,fuegoY3;

    Boolean limit = false;

    public void run(){
        try{
            while(true){
                move();
                scrolling();
                movimientoDisparo();
                Thread.sleep(10);
            }
        }catch(Exception e){
            System.out.println("Uh-oh, something went wrong!.");
        }
    }

    private void move() {
        if (a>0){
            a-=1;
        }
    	if(x>=0 && x<=904 && y>=0 && y<=625) {
    		 x += xDirection;
    		 y += yDirection;
    	}
    	else{
    		if(x<0) {
    			limit=true;
    			xDirection = 0;
    			x=0;
    		}
    		else if (x>904) {
    			limit=true;
    			xDirection = 0;
    			x=904;
    		}
    		else if (y<0) {
    			limit=true;
    			yDirection = 0;
    			y=0;
    		}
    		else if (y>625) {
    			limit=true;
    			yDirection = 0;
    			y=625;
    		}
    	}
    }

    public void setXDirection(int xdir) { xDirection = xdir; }

    public void setYDirection(int ydir) {
    		yDirection = ydir;
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if(keyCode == e.VK_LEFT) {
            	//System.out.println(x);
            	if(limit == false) {
            		setXDirection(-3);
            	}
            }
            if(keyCode == e.VK_RIGHT) {
            	if(limit == false) {
            		setXDirection(+3);
            	}	
            }
            if(keyCode == e.VK_UP) {
            	if(limit == false) {
            		setYDirection(-3);
            	}
            }
            if(keyCode == e.VK_DOWN) {
            	if(limit == false) {
            		setYDirection(+3);
            	}
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if(keyCode== e.VK_LEFT){
            	limit = false;
                setXDirection(0);
            }
            if(keyCode== e.VK_RIGHT){
            	limit = false;
                setXDirection(0);
            }
            if(keyCode== e.VK_UP){
            	limit = false;
                setYDirection(0);
            }
            if(keyCode== e.VK_DOWN){
            	limit = false;
                setYDirection(0);
            }
            if(keyCode==e.VK_SPACE && disparo<1 && fuegoX<=0) {
                disparo++;
                ataque();
            }
        }
    }

    public Huerfana(){

        addKeyListener(new Huerfana.AL());
        setLayout(null);
        setTitle("GoS");
        setDefaultCloseOperation(3);
        setBounds(50,0,1324,775);
        setVisible(true);

        JPanel p1=new JPanel();
        p1.setBounds(0,0,1324,775);

        add(p1);

        ImageIcon still = new ImageIcon("imagenes\\GryffinRider.gif");
        ImageIcon fondo = new ImageIcon("imagenes\\coloso.jpg");
        ImageIcon fuego = new ImageIcon("imagenes\\fireball.gif");
        ImageIcon dragon = new ImageIcon("imagenes\\dragon.gif");

        Image img0 = still.getImage();
        Image img = fondo.getImage();
        Image img1 = fuego.getImage();
        Image imgD = dragon.getImage();

        img0=img0.getScaledInstance(150, 150, 1);
        img=img.getScaledInstance(800, 800, 1);
        img1=img1.getScaledInstance(60,60,1);
        imgD=imgD.getScaledInstance(150,150,1);

        Pik1 = img0; load=img; load2=img; load3=img; load4=img1; load5=imgD;

    }

    public void scrolling(){
        if (X==-798){
            X=1600; }
        if (X1==-798){
            X1=1600; }
        if (X2==-798){
            X2=1600; }
        X-=1;X1-=1;X2-=1;
    }

    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, p1);
    }

    public void paintComponent(Graphics g){
        g.drawImage(load,X, 0, p1);
        g.drawImage(load,X1, 0, p1);
        g.drawImage(load,X2, 0, p1);
        g.drawImage(Pik1,x, y, p1);
        ArrayList<Object> dragonlist = new ArrayList<Object>();
        dragonlist.add(load5);
        dragonlist.add(x);
        dragonlist.add(y);
        dragonlist.add(p1);
        int b=20;
        for (int i=0;i<7;i++){
            g.drawImage((Image)dragonlist.get(0),a,b,(JPanel)dragonlist.get(3));
            b+=100;
        }
        if(fuegoX>0 && fuegoX<1004){
            g.drawImage(load4,fuegoX,fuegoY,p1);
        }
        g.drawRect(1104,0,220,775);
        repaint();
    }

    public void ataque(){
        System.out.println(disparo);
        if (disparo==1){
            fuegoX=x+102;fuegoY=y+75;
            disparo--;
        }
    }

    public void movimientoDisparo(){
        if (fuegoX>0 && fuegoX<1004){
            fuegoX+=9;
        }
        else {fuegoX=0;}
    }
}
