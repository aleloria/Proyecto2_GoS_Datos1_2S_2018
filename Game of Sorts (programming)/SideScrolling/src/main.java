import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main (String args[]){
        Huerfana frame =new Huerfana();
        Thread t1 = new Thread(frame);
        t1.start();
    }
}
