import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//Importa swing y todos sus elementos.
public class Huerfana extends JFrame implements Runnable{

    private JPanel p1;

    private Graphics dbg;

    private Image dbImage, Pik1,load,load4,load5,load6,load7,load8;

    private ArrayList<Object> dragonlist = new ArrayList<>();

    private int x,y, xDirection, yDirection,disparo=0,a=1200,dragones=7,lives=3;

    private int X=0,X1=800,X2=1600,fuegoX,fuegoY;

    private Boolean limit = false,pause=false;

    private Rectangle ball,drake,griffin;

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
            System.out.println("Uh-oh, something went wrong!.");
        }
    }

    private void move() {
        if (a>-200){
            a-=1;
            for (int i=0; i<dragones;i++){
                dragonlist.set((((i+(2)*i))+1),a);
            }
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
    	griffin.x+=xDirection;
    	griffin.y+=yDirection;
    }

    private void setXDirection(int xdir) { xDirection = xdir; }

    private void setYDirection(int ydir) {
    		yDirection = ydir;
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if(keyCode == e.VK_LEFT) {
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
            if(keyCode==e.VK_SPACE && disparo<1 && fuegoX<=0 && !pause) {
                disparo++;
                ataque();
            }
            if(keyCode==e.VK_P) {
                if (!pause){
                    pause=true;
                }
                else {
                    pause=false;
                }
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
        p1.setLayout(null);
        p1.setBounds(0,0,1104,775);
        p1.setBackground(Color.blue);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(1104,0,220,775);
        p2.setBackground(Color.red);
        p2.setVisible(true);

        add(p2);
        add(p1);

        ImageIcon still = new ImageIcon("imagenes\\GryffinRider.gif");
        ImageIcon fondo = new ImageIcon("imagenes\\coloso.jpg");
        ImageIcon fuego = new ImageIcon("imagenes\\fireball.gif");
        ImageIcon dragon = new ImageIcon("imagenes\\dragon.gif");
        ImageIcon fulllives = new ImageIcon("imagenes\\fulllives.png");
        ImageIcon lives2 = new ImageIcon("imagenes\\2lives.gif");
        ImageIcon live= new ImageIcon("imagenes\\1live.gif");

        Image img0 = still.getImage();
        Image img = fondo.getImage();
        Image img1 = fuego.getImage();
        Image imgD = dragon.getImage();
        Image imgFL = fulllives.getImage();
        Image imgL2 = lives2.getImage();
        Image imgL = live.getImage();

        img0=img0.getScaledInstance(150, 150, 1);
        img=img.getScaledInstance(800, 800, 1);
        img1=img1.getScaledInstance(60,60,1);
        imgD=imgD.getScaledInstance(150,150,1);
        imgFL=imgFL.getScaledInstance(80,30,1);
        imgL2=imgL2.getScaledInstance(80,30,1);
        imgL=imgL.getScaledInstance(80,30,1);

        Pik1=img0; load=img; load4=img1; load5=imgD; load6=imgFL; load7=imgL2; load8=imgL;

        ball=new Rectangle(fuegoX+28,fuegoY+20,20,20);

        drake=new Rectangle(530,57,75,75);

        griffin=new Rectangle(x+43,y+50,98,75);

        dragonMaker();
    }

    private void scrolling(){
        if (X==-798){
            X=1600; }
        if (X1==-798){
            X1=1600; }
        if (X2==-798){
            X2=1600; }
        X-=1;X1-=1;X2-=1;
    }

    public void paint(Graphics g){
        dbImage = createImage(1104,775);
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, p1);
    }

    private void paintComponent(Graphics g){
        g.drawImage(load,X, 0, p1);
        g.drawImage(load,X1, 0, p1);
        g.drawImage(load,X2, 0, p1);
        g.drawImage(Pik1,x, y, p1);
        if(lives==3){
            g.drawImage(load6,20, 30, p1);
        }
        if(lives==2){
            g.drawImage(load7,20, 30, p1);
        }
        if(lives==1){
            g.drawImage(load8,20, 30, p1);
        }
        if (dragonlist.size()>0){
            for(int i=0;i<dragones;i++){
                g.drawImage((Image)dragonlist.get((i+(2)*i)),(int)dragonlist.get(((i+(2)*i))+1),(int)dragonlist.get(((i+(2)*i))+2),p1);
            }
        }
        if(fuegoX>0 && fuegoX<850){
            g.drawImage(load4,fuegoX,fuegoY,p1);
            }
        g.fillRect(1100,0,4,775);
        //String algo=Integer.toString(fuegoX);
        g.setFont(new Font("Arial",Font.ITALIC,30));
        g.setColor(Color.blue);
        //g.drawString(algo,200,200);
        repaint();
    }

    private void ataque(){
        if (disparo==1){
            fuegoX=x+102;fuegoY=y+75;
            disparo--;
        }
    }

    private void movimientoDisparo(){
        if (fuegoX>0 && fuegoX<850 && !collide()){
            fuegoX+=9;
        }
        else {fuegoX=0;}
        ball.x=fuegoX;
        ball.y=fuegoY;
    }

    private boolean collide(){
        boolean resultado=false;
        if (dragonlist.size()>0){
            for(int i=0;i<dragones;i++){
                drake.x=(int)(dragonlist.get(((i+(2)*i))+1))+30;
                drake.y=(int)(dragonlist.get(((i+(2)*i))+2))+37;
                if (drake.intersects(ball)){
                    resultado=true;
                    for (int j=0;j<3;j++){
                        dragonlist.remove(((i+(2)*i)));
                    }
                    dragones--;
                    break;
                }
            }
        }
        else {
            a=1200;
            dragones=7;
            dragonMaker();
        }
        return resultado;
    }

    public void collidePlayer(){
        if (dragonlist.size()>0 && lives>0){
            for(int i=0;i<dragones;i++){
                drake.x=(int)(dragonlist.get(((i+(2)*i))+1))+30;
                drake.y=(int)(dragonlist.get(((i+(2)*i))+2))+37;
                if (drake.intersects(griffin) || drake.x<-150){
                    for (int j=0;j<3;j++){
                        dragonlist.remove(((i+(2)*i)));
                    }
                    lives--;
                    dragones--;
                    System.out.println(lives);
                    break;
                }
            }
        }
        else {
           reset();
        }
    }

    public void dragonMaker(){
        int b=20;
        for (int i=0; i<dragones;i++){
            dragonlist.add(load5);
            dragonlist.add(a);
            dragonlist.add(b);
            b+=100;
        }
    }

    public void reset(){
        a=1200;
        dragonlist.clear();
        lives=3;
        x=43;y=50;
        griffin.x=x;
        griffin.y=y;
        dragones=7;
        dragonMaker();
    }
}