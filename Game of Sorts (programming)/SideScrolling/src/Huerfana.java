import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

//Importa swing y todos sus elementos.
public class Huerfana extends JFrame implements Runnable{

    protected static int x, y, xDirection, yDirection, fuegoX, fuegoY, disparo=0,
                         a=1200, X=0, X1=800, X2=1600, mode=3, kills=0, amov=0,
                         bulletcont=0, dragmov=0;

    protected static Graphics2D dbg;
    protected static Image dbImage, load;
    protected static Rectangle ball = new Rectangle(fuegoX+28,fuegoY+20,20,20);
                     Rectangle drake = new Rectangle(-10,-10,98,55);
                     Rectangle griffin = new Rectangle(43, 80,98,45);
                     Rectangle pointer = new Rectangle(0, 0,1,1);
                     Rectangle bullet = new Rectangle(0, 0,20,20);


    protected ArrayList<Dragon> dragokrema = new ArrayList<>();ArrayList<Integer> kesocrema = new ArrayList<>();ArrayList<Integer> edades = new ArrayList<>();ArrayList<DragonBullet> dbullets = new ArrayList<>();

    protected static Matriz drakes = new Matriz(3,7,0);

    protected static Boolean limit = false,pause=false,arranque=true;
    int OlDragCounter=0,dragnum=1;

    protected GriffinRider player = new GriffinRider();
    protected String layout="",dragonData=
                                " Nombre: "+"\n"+
                                " Edad: "+"\n"+
                                " Velocidad de recarga: "+"\n"+
                                " Resistencia: "+"\n"+
                                " Rango: "+"\n"+
                                " Padre: ";

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
            System.out.println(e);
        }
    }

    protected void move() {
        if (dragmov==1){
            dragmov=0;
        }
        else {
            dragmov=1;
        }
        if (bulletcont>=1000){
            bulletcont=0;
        }
        amov+=dragmov;bulletcont++;
            for (int i=1; i<=drakes.fila;i++){
                for (int j=1;j<=drakes.columna;j++){
                    if ((drakes.nodoDato(i,j)).getClass()==Dragon.class){
                        ((Dragon)drakes.nodoDato(i,j)).setPosX(((Dragon)drakes.nodoDato(i,j)).getPosX()-dragmov);
                        if(((Dragon)drakes.nodoDato(i,j)).getReloadSpeed()==bulletcont){

                            DragonBullet fuego=new DragonBullet(((Dragon)drakes.nodoDato(i,j)).getPosX(),((Dragon)drakes.nodoDato(i,j)).getPosY());

                            dbullets.add(fuego);
                        }
                    }
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,0,1324,775);
        setResizable(false);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                pointer.x = (int) getMousePosition().getX();
                pointer.y = (int) getMousePosition().getY();

                collidePointer();
            }
        });


        load = new ImageIcon("imagenes\\coloso.jpg").getImage().getScaledInstance(800, 800, 1);

        drakes.objetos=20;
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
        dbImage = createImage(1324,775);
        dbg = (Graphics2D) dbImage.getGraphics();
        dbg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0,null);
    }

    protected void paintComponent(Graphics g){
        g.drawImage(load,X, 0, null);
        g.drawImage(load,X1, 0,null);
        g.drawImage(load,X2, 0, null);
        g.drawImage(player.getImageData(),player.getPosX(), player.getPosY(), null);
        g.drawImage(player.getImageLife(),20, 30, null);

        if (drakes.objetos > 0){
            for(int i=1; i <=drakes.fila; i++){
                for (int j = 1; j <= drakes.columna; j++) {
                    if ((drakes.nodoDato(i,j)).getClass()==Dragon.class){
                        g.drawImage(((Dragon) drakes.nodoDato(i,j)).getImageData(), ((Dragon) drakes.nodoDato(i,j)).getPosX(), ((Dragon) drakes.nodoDato(i,j)).getPosY(), null);
                        //g.drawRect(((Dragon) drakes.nodoDato(i,j)).getPosX() + 35, ((Dragon) drakes.nodoDato(i,j)).getPosY() + 40, 98, 55);
                    }
                }
            }
        }

        if (dbullets.size()>0){
            for (int i=0;i<dbullets.size();i++){
                g.drawImage(dbullets.get(i).getImage(),dbullets.get(i).getPosX(),dbullets.get(i).getPosY(),null);
                //g.drawRect(dbullets.get(i).posX+10,dbullets.get(i).posY+20,20,20);
            }
        }
        if(fuegoX > 0 && fuegoX < 850){
            g.drawImage(player.getBullet(), fuegoX, fuegoY,null);
            //g.drawRect(fuegoX+28,fuegoY+20,20,20);
        }

        //g.drawRect(player.getPosX()+43, player.getPosY()+60,98,45);
        g.setColor(Color.BLACK);g.fillRect(1095,0,5,775);
        g.setColor(Color.WHITE);g.fillRect(1100,0,224,775);
        g.setFont(new Font("Times new roman",Font.BOLD,18));
        g.setColor(Color.BLACK);

        int space=80;
        for (String dragonData: dragonData.split("\n")) {
        	g.drawString(""+dragonData,1100,space);
        	space+=25;
        }
        g.fillRect(1100,210,224,5);
        g.fillRect(1100,25,224,40);
        if (mode==3){layout="Random.";}
        if (mode==2){layout="QuickSort.";}
        if (mode==1){layout="Árbol.";}
        g.setFont(new Font("Times new roman",Font.ITALIC+Font.BOLD,18));g.setColor(Color.WHITE);g.drawString((" Layout: "+layout),1100,50);
        repaint();
    }

    protected static void ataque(){
        if (disparo == 1){
            fuegoX = x + 102; fuegoY = y + 75;
            disparo--;
        }
    }

    protected void movimientoDisparo(){
        for (int i=0;i<dbullets.size();i++){
            dbullets.get(i).setPosX(dbullets.get(i).getPosX()-3);
            if (dbullets.get(i).posX<=-20){
                dbullets.remove(i);
            }
        }
        if (fuegoX > 0 && fuegoX < 1000 && !collide()){
            fuegoX += 13;
        }
        else {fuegoX=0;}
        ball.x = fuegoX+28;
        ball.y = fuegoY+20;
    }

    protected boolean collide(){
        boolean resultado = false;
        if (drakes.objetos > 0){
            for(int i = 1; i <=drakes.fila; i++){
                for(int j = 1; j <=drakes.columna; j++) {
                    if ((drakes.nodoDato(i,j).getClass()==Dragon.class)){
                        drake.x = ((Dragon) drakes.nodoDato(i, j)).getPosX() + 35;
                        drake.y = ((Dragon) drakes.nodoDato(i, j)).getPosY() + 40;
                        if (drake.intersects(ball)) {
                            resultado = true;
                            drakes.setVal(i,j,0);
                            drakes.objetos--;
                            if (kills<4){
                                kills++;
                            }
                            else {
                                if (kills>=4){
                                    kills=0;
                                    sorting();
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        else {
            reset();
        }
        return resultado;
    }

    public void collidePlayer(){
        if (drakes.objetos > 0 && player.getLives() > 0){
            for(int i = 1; i <= drakes.fila; i++){
                for (int j=1;j<=drakes.columna;j++){
                    if ((drakes.nodoDato(i,j)).getClass()==Dragon.class){
                        drake.x=((Dragon)drakes.nodoDato(i,j)).getPosX() + 35;
                        drake.y=((Dragon)drakes.nodoDato(i,j)).getPosY() + 40;

                        if (drake.intersects(griffin) || drake.x < -150){
                            drakes.setVal(i,j,0);
                            drakes.objetos--;
                            if (player.getLives() > 1) {
                                player.setLives(player.getLives() - 1);
                                break;
                            }else {
                                reset();
                            }
                        }
                    }
                }
            }
            for (int i=0;i<dbullets.size();i++){
                bullet.x = dbullets.get(i).getPosX()+10;
                bullet.y = dbullets.get(i).getPosY()+20;
                if(bullet.intersects(griffin)){
                    dbullets.remove(i);
                    if (player.getLives() > 1){
                        player.setLives(player.getLives() - 1);
                        break;
                    }else {
                        reset();
                    }

                }

            }
        }
        else {
            reset();
        }
    }

    public void collidePointer(){
        if (drakes.objetos > 0){
            for(int i = 1; i <= drakes.fila; i++){
                for (int j = 1; j <= drakes.columna; j++){
                    if ((drakes.nodoDato(i,j)).getClass()==Dragon.class){
                        drake.x=((Dragon)drakes.nodoDato(i,j)).getPosX() + 35;
                        drake.y=((Dragon)drakes.nodoDato(i,j)).getPosY() + 40;
                        if (drake.intersects(pointer)){
                            dragonData=
                                    " Nombre: "+((Dragon)drakes.nodoDato(i,j)).getName()+"\n"+
                                            " Edad: "+(((Dragon) drakes.nodoDato(i,j)).getAge())+"\n"+
                                            " Velocidad de recarga: "+(((Dragon) drakes.nodoDato(i,j)).getReloadSpeed())+"\n"+
                                            " Resistencia: "+(((Dragon) drakes.nodoDato(i,j)).getResistance())+"\n"+
                                            " Rango: "+(((Dragon) drakes.nodoDato(i,j)).getPosX())+"\n"+
                                            " Padre: "+(((Dragon) drakes.nodoDato(i,j)).getPosY());
                        }
                    }
                }
            }
        }
    }


    public void dragonMaker(){
        int c=20,age;
        Random ages = new Random();
        if (arranque){
            arranque=false;
            mode=3;
        }
        drakes.dragonSpace(drakes,mode);
        for (int i=1;i<=drakes.fila;i++) {
            for (int j = 1; j <=drakes.columna; j++) {
                if ((int) drakes.nodoDato(i, j) == 1) {
                    while (true){
                        if (edades.size()<1000){
                            age=ages.nextInt(1001);
                            if (!edades.contains(age)) {
                                Dragon dragon = new Dragon(a,(c+((j-1)*100)),age,OlDragCounter,dragnum);
                                dragnum++;
                                drakes.setVal(i,j,dragon);
                                edades.add(age);
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            a+=100;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sorting(){
        if (drakes.objetos>0){
            for (int i=1;i<=drakes.fila;i++){
                for (int j=1;j<=drakes.columna;j++){
                    if ((drakes.nodoDato(i,j)).getClass()==Dragon.class){
                        dragokrema.add((Dragon)drakes.nodoDato(i,j));
                        kesocrema.add((((Dragon) drakes.nodoDato(i,j)).getAge()));
                        drakes.setVal(i,j,1);
                    }
                }
            }
            QuickSort sort = new QuickSort();
            sort.quickSort(kesocrema);
            sorter();
        }
    }

    public void sorter(){
        int i=0;
        while (kesocrema.size()>0) {
            i=0;
            while (i<dragokrema.size()){
                if (dragokrema.get(i).getAge()==kesocrema.get(0)){
                    kesocrema.remove(0);
                    Dragon temp=dragokrema.get(i);
                    dragokrema.remove(i);
                    dragokrema.add(temp);
                    break;
                }
                i++;
            }
        }
        drakes.resetear();
        mode=2;
        drakes.dragonSpace(drakes,mode);
        for (int j=0;j<dragokrema.size();j++){
            for (int k=1;k<=drakes.fila;k++){
                for (int l=1;l<=drakes.columna;l++){
                    if ((int)drakes.nodoDato(k,l)==1){
                        drakes.setVal(k,l,dragokrema.get(0));
                        dragokrema.remove(0);
                    }
                }
            }
        }
        pause=true;
        for (int j=1;j<=drakes.fila;j++){
            for (int k=1;k<=drakes.columna;k++){
                a=1200+(100*(j-1));
                if (drakes.nodoDato(j,k).getClass()==Dragon.class){
                    while (((Dragon)drakes.nodoDato(j,k)).getPosX()!=(a-amov)){
                        try {
                            if (((Dragon)drakes.nodoDato(j,k)).getPosX()<a-amov){
                                ((Dragon)drakes.nodoDato(j,k)).setPosX(((Dragon)drakes.nodoDato(j,k)).getPosX()+1);
                            }
                            else if (((Dragon)drakes.nodoDato(j,k)).getPosX()>a-amov){
                                ((Dragon)drakes.nodoDato(j,k)).setPosX(((Dragon)drakes.nodoDato(j,k)).getPosX()-1);
                            }
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        while (((Dragon)drakes.nodoDato(j,k)).getPosY()!=20+(100*(k-1))){
                            if (((Dragon)drakes.nodoDato(j,k)).getPosY()<20+(100*(k-1))){
                                ((Dragon)drakes.nodoDato(j,k)).setPosY(((Dragon)drakes.nodoDato(j,k)).getPosY()+1);
                            }
                            if (((Dragon)drakes.nodoDato(j,k)).getPosY()>20+(100*(k-1))){
                                ((Dragon)drakes.nodoDato(j,k)).setPosY(((Dragon)drakes.nodoDato(j,k)).getPosY()-1);
                            }
                            Thread.sleep(1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        kills=0;
        pause=false;
    }

    public void reset(){
        System.out.println("erra");
        if (player.getLives()>=1) {
            player.setLives(3);
            player.setPosX(0);
            player.setPosY(300);
            edades.clear();
        }
        dbullets.clear();
        a = 1200;
        drakes.resetear();
        drakes.objetos=20;
        kills=0;
        amov=0;
        dragonMaker();
    }
}