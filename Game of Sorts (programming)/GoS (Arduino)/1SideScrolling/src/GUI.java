import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
    public GUI(){
        setTitle("Horno de microondas.");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(4,3));
        for (int i=1;i<10;i++){
            p1.add(new JButton(Integer.toString(i)));
        }
        p1.add(new JButton("0"));
        p1.add(new JButton("Start"));
        p1.add(new JButton("Stop"));
        JPanel p2=new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(new JTextField("Aquí el tiempo."),BorderLayout.NORTH);
        p2.add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.EAST);
        add(new JButton("Aquí la comida."),BorderLayout.CENTER);
        setSize(400,250);
        setVisible(true);
    }
}