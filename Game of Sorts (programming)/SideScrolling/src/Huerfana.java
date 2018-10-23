import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Importa swing y todos sus elementos.
public class Huerfana extends JFrame implements Runnable{
    
    protected static Graphics dbg;
    protected static Image dbImage, load;
    protected static ArrayList<Object> dragonlist = new ArrayList<>();
    protected static int x, y, xDirection, yDirection, fuegoX, fuegoY, disparo=0, a=1200, dragones=7, lives=3, X=0, X1=800, X2=1600;
    protected static Boolean limit = false,pause=false;
    protected static Rectangle ball = new Rectangle(fuegoX+28,fuegoY+20,20,20); Rectangle drake = new Rectangle(-10,-10,98,55); Rectangle griffin = new Rectangle(43, 80,98,45);
    protected GriffinRider player = new GriffinRider();

    public void run(){
        try{
            while(true){
                if (!pause){
                    collidePlayer();
                    move();
                    scrolling();
                    movimientoDisparo();
                }
                Thread.sleep(10);
            }
        }catch(Exception e){
            System.out.println("!Uh-oh, something went wrong!.");
        }
    }

    protected void move() {
        if (a>-200){
            a-=1;
            for (int i=0; i<dragonlist.size();i++){
                ((Dragon)dragonlist.get(i)).setPosX(a);
            }
        }
    	if(player.getPosX()>=0 && player.getPosX()<=904 && player.getPosY()>=0 && player.getPosY()<=625) {
    		 player.setPosX(player.getPosX()+xDirection);
            player.setPosY(player.getPosY()+yDirection);
    	}
    	else{
    		if(player.getPosX()<0) {
    			limit=true;
    			xDirection = 0;
                player.setPosX(0);
    		}
    		else if (player.getPosX()>904) {
    			limit=true;
    			xDirection = 0;
                player.setPosX(904);
    		}
    		else if (player.getPosY()<0) {
    			limit=true;
    			yDirection = 0;
                player.setPosY(0);
    		}
    		else if (player.getPosY()>625) {
    			limit=true;
    			yDirection = 0;
                player.setPosY(625);
    		}
    	}
    	griffin.x = player.getPosX()+43;
    	griffin.y = player.getPosY()+60;
    	x=player.getPosX();
        y=player.getPosY();
    }

    protected static void setXDirection(int xdir) { xDirection = xdir; }
    protected static void setYDirection(int ydir) { yDirection = ydir;
    }

    public Huerfana(){

        addKeyListener(new KeyDetective());
        setLayout(null);
        setTitle("Game of Thrones, digo, Sorts...");
        setDefaultCloseOperation(3);
        setBounds(50,0,1324,775);
        setVisible(true);

        load = new ImageIcon("imagenes\\coloso.jpg").getImage().getScaledInstance(800, 800, 1);

        dragonMaker();
    }

    protected void scrolling(){
        if (X == -798){
            X=1600; }
        if (X1 == -798){
            X1=1600; }
        if (X2 == -798){
            X2=1600; }
        X--; X1--;X2--;
    }

    public void paint(Graphics g){
        dbImage = createImage(1104,775);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0,null);
    }

    protected void paintComponent(Graphics g){
        g.drawImage(load,X, 0, null);
        g.drawImage(load,X1, 0,null);
        g.drawImage(load,X2, 0, null);
        g.drawImage(player.getImageData(),player.getPosX(), player.getPosY(), null);
        g.drawImage(player.getImageLife(),20, 30, null);
        if (dragonlist.size() > 0){
            for(int i=0; i < dragonlist.size(); i++){
                g.drawImage(((Dragon)dragonlist.get(i)).getImageData(), ((Dragon)dragonlist.get(i)).getPosX(), ((Dragon)dragonlist.get(i)).getPosY(),null);
                g.drawRect(((Dragon)dragonlist.get(i)).getPosX()+35, ((Dragon)dragonlist.get(i)).getPosY()+40,98,55);
            }
        }
        if(fuegoX > 0 && fuegoX < 850){
            g.drawImage(player.getBullet(), fuegoX, fuegoY,null);
            g.drawRect(fuegoX+28,fuegoY+20,20,20);
        }
        g.fillRect(1100,0,4,775);
        g.drawRect(player.getPosX()+43, player.getPosY()+60,98,45);
        //String algo=Integer.toString(fuegoX);
        //g.setFont(new Font("Arial",Font.ITALIC,30));
        //g.setColor(Color.blue);
        //g.drawString(algo,200,200);
        repaint();
    }

    protected static void ataque(){
        if (disparo == 1){
            fuegoX = x + 102; fuegoY = y + 75;
            disparo--;
        }
    }

    protected void movimientoDisparo(){
        if (fuegoX > 0 && fuegoX < 850 && !collide()){
            fuegoX += 12;
        }
        else {fuegoX=0;}
        ball.x = fuegoX+28;
        ball.y = fuegoY+20;
    }

    protected boolean collide(){
        boolean resultado = false;
        if (dragonlist.size() > 0){
            for(int i = 0; i < dragonlist.size(); i++){
                drake.x=((Dragon)dragonlist.get(i)).getPosX() + 35;
                drake.y=((Dragon)dragonlist.get(i)).getPosY() + 40;
                if (drake.intersects(ball)){
                    resultado = true;
                    dragonlist.remove(i);
                    break;
                }
            }
        }
        else {
            if (player.getLives() > 0){
                reset(false);
            }
            else {
                reset(true);
            }
        }
        return resultado;
    }

    public void collidePlayer(){
        if (dragonlist.size() > 0 && lives > 0){
            for(int i = 0; i < dragonlist.size(); i++){
                drake.x=((Dragon)dragonlist.get(i)).getPosX() + 35;
                drake.y=((Dragon)dragonlist.get(i)).getPosY() + 40;
                if (drake.intersects(griffin) || drake.x < -150){
                    dragonlist.remove(i);
                    if (player.getLives() > 1) {
                        player.setLives(player.getLives() - 1);
                        break;
                    }else {
                        reset(true);
                    }
                }
            }
        }
        else {
            if (player.getLives() > 0){
                reset(false);
            }
            else {
                reset(true);
            }
        }
    }

    public void dragonMaker(){
        int b = 20;
        for (int i=0; i < dragones; i++){
            Dragon dragon = new Dragon(a,b);
            dragon.dragnum=i+1;
            dragonlist.add(dragon);
            b += 100;
        }
    }

    public void reset(boolean mode){
        if (mode){
            player.setLives(3); player.setPosX(0); player.setPosY(300);
        }
        a = 1200;
        dragonlist.clear();
        dragonMaker();
    }
}