import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.util.Enumeration;


//Importa swing y todos sus elementos.
public class Huerfana extends JFrame implements Runnable, SerialPortEventListener{
    JPanel p1;
    Graphics dbg;
    Image dbImage;
    Image Pik1,load,load2,load3,load4,dragonArmy;
    static ImageIcon active;
    int x,y, xDirection, yDirection,disparo=0;
    int X=0,X1=800,X2=1600,fuegoX,fuegoY,fuegoX2,fuegoY2,fuegoX3,fuegoY3;
    Boolean limit = false;

    ImageIcon dragons = new ImageIcon("imagenes\\dragon2.gif");
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
    	if(x>=0 && x<=1170 && y>=0 && y<=625) {
    		 x += xDirection;
    		 y += yDirection;
    	}
    	else{
    		if(x<0) {
    			limit=true;
    			xDirection = 0;
    			x=0;
    		}
    		else if (x>1170) {
    			limit=true;
    			xDirection = 0;
    			x=1170;
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
    SerialPort serialPort;
    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {
            "/dev/tty.usbserial-A9007UX1", // Mac OS X
            "/dev/ttyACM0", // Raspberry Pi
            "/dev/ttyUSB0", // Linux
            "COM3", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    public void initialize() {
        // the next line is for Raspberry Pi and
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        //System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {

                String inputLine = input.readLine();



                if(inputLine.equals("D") ){
                    if(limit == false) {
                        setXDirection(+3);
                        move();
                    }

                }

                if(inputLine.equals("I") ){
                    if(limit == false) {
                        setXDirection(-3);
                        move();
                    }
                }

                if(inputLine.equals("Ar") ){
                    if(limit == false) {
                        setYDirection(-3);
                        move();
                    }
                }

                if(inputLine.equals("Ab")){
                    if(limit == false) {
                        setYDirection(+3);
                        move();
                    }

                }
                limit = false;
                setXDirection(0);
                setYDirection(0);






            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }


    public void setXDirection(int xdir) {

    	xDirection = xdir;
        
    }
    public void setYDirection(int ydir) {
    		yDirection = ydir;
    }




    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e ) {
            int keyCode = e.getKeyCode();

            if(keyCode == e.VK_LEFT ) {
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
            if(keyCode==e.VK_SPACE && disparo<3) {
                ataque();
            }

        }

        /*@Override
        public void keyTyped(KeyEvent e) {


        }*/

    }

    public Huerfana(){
        JPanel p1=new JPanel();
        ;

        ImageIcon still = new ImageIcon("imagenes\\GryffinRider.gif");
        ImageIcon fondo = new ImageIcon("imagenes\\coloso.jpg");
        ImageIcon fuego = new ImageIcon("imagenes\\fireball.gif");





        Image img0 = still.getImage();
        Image img = fondo.getImage();
        Image img1 = fuego.getImage();
        Image img2 = dragons.getImage();
        img0=img0.getScaledInstance(150, 150, 1);
        img=img.getScaledInstance(800, 800, 1);
        img1=img1.getScaledInstance(50,50,1);
        img2=img2.getScaledInstance(150, 150, 1);

        initialize();
        Thread t=new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {Thread.sleep(15);} catch (InterruptedException ie) {}
            }
        };
        t.start();
        System.out.println("Started");
        //Huerfana ejemplox=new Huerfana();//Instancia una nueva ventana de la clase que no hereda de JFrame.


        dragonArmy= img2;
        Pik1 = img0;
        load=img;
        load2=img;
        load3=img;
        load4=img1;


        p1.setLayout(null);
        p1.setLocation(0,0);



        addKeyListener(new Huerfana.AL());
        setTitle("GoS");
        setDefaultCloseOperation(3);
        setBounds(50,0,1324,775);
        setVisible(true);
        add(p1);
    }
    public void scrolling(){

        if (X==-798){
            X=1600;
        }
        if (X1==-798){
            X1=1600;
        }
        if (X2==-798){
            X2=1600;
        }
        X-=1;
        X1-=1;
        X2-=1;

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
        Dragon dragonArmy2 = new Dragon(dragons);
        dragonArmy2.setPosX(50);
        dragonArmy2.setPosY(100);

        dragonlist.add(dragonArmy);
        dragonlist.add(x);
        dragonlist.add(y);
        dragonlist.add(p1);

        int a=1000,b=dragonArmy2.getPosY(),c=0;
        for (int i=0;i<4;i++){

            g.drawImage((Image)dragonlist.get(0),dragonArmy2.getPosX(),b,(JPanel)dragonlist.get(3));
            b= b+100;
        }
        if(fuegoX>0 && fuegoX<1174){
            g.drawImage(load4,fuegoX,fuegoY,p1);
        }




        repaint();
        
    }
    public void ataque(){
        if (disparo==1){
            fuegoX=x+102;fuegoY=y+75;
        }
    }
    public void movimientoDisparo(){
        if (fuegoX>0 && fuegoX<1174){
            fuegoX+=9;
        }
    }
}
