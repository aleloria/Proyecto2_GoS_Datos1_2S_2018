public class main {
    public static void main (String args[]){
        Huerfana frame =new Huerfana();
        Thread t1 = new Thread(frame);
        t1.start();
        //Huerfana ejemplox=new Huerfana();//Instancia una nueva ventana de la clase que no hereda de JFrame.
    }
}
