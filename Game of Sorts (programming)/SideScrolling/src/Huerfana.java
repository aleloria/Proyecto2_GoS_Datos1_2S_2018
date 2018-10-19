import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//Importa swing y todos sus elementos.
public class Huerfana extends JFrame{
    JLabel load,load2,load3,load4;
    public Huerfana(){
        load=new JLabel(new ImageIcon("imagenes\\coloso.jpg"));
        load2=new JLabel(new ImageIcon("imagenes\\coloso.jpg"));
        load3=new JLabel(new ImageIcon("imagenes\\loader.gif"));
        load4=new JLabel(new ImageIcon("imagenes\\coloso.jpg"));
        Image img=((ImageIcon) load.getIcon()).getImage();
        Image img2=((ImageIcon) load3.getIcon()).getImage();
        img=img.getScaledInstance(800,800, 1);
        img2=img2.getScaledInstance(100,100, 1);
        load.setIcon(new ImageIcon(img));
        load2.setIcon(new ImageIcon(img));
        load3.setIcon(new ImageIcon(img2));
        load4.setIcon(new ImageIcon(img));
        load.setBounds(0,0,800,800);
        load2.setBounds(800,0,800,800);
        load4.setBounds(1600,0,800,800);
        load3.setBounds(0,0,100,100);

        //JLayeredPane lp=new JLayeredPane();
        //lp.setPreferredSize(new Dimension(800,800));

        /*JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.add(load3);
        p2.setSize(load3.getSize());
        p2.setLocation(load3.getLocation());*/

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setLocation(0,0);
        //p1.add(load3);
        p1.add(load);
        p1.add(load2);
        p1.add(load4);

        //lp.add(p1,0);

        //add(lp);
        add(p1);
    }
    public void scrolling(){
        int x = load.getX(), x2 = load2.getX(),x3=load4.getX();
        System.out.println(x+"  "+x2+"  "+x3);
        try {
            while(true) {
                Thread.sleep(10);
                if (load.getX()==-798){
                    x=1600;
                }
                if (load2.getX()==-798){
                    x2=1600;
                }
                if (load4.getX()==-798){
                    x3=1600;
                }
                x-=1;
                x2-=1;
                x3-=1;
                //y+=1;
                load.setLocation(x, load.getY());
                load2.setLocation(x2, load2.getY());
                load4.setLocation(x3, load2.getY());
            }
        }catch (InterruptedException e){}
    }
}
