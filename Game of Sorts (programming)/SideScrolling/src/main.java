import java.util.ArrayList;

public class main {
    public static void main (String args[]){
        Huerfana frame =new Huerfana();
        Thread t1 = new Thread(frame);
        t1.start();

        /*Matriz m=new Matriz(100,5,1);
        m.setVal(1,1,"Imagen");
        m.setVal(1,2,"X");
        m.setVal(1,3,"Y");
        m.setVal(1,4,"Observer");
        m.setVal(1,5,"Nombre");
        m.recorrido();*/

        /*ArrayList<String> prueba=new ArrayList<>();
        for (int i=0;i<3;i++){
            prueba.add(Integer.toString(i));
        }
        for (int i=0;i<prueba.size();i++){
            System.out.println(prueba.get(i));
        }
        System.out.println();
        prueba.remove(0);
        prueba.remove(0);
        for (int i=0;i<prueba.size();i++){
            System.out.println(prueba.get(i));
        }*/
    }
}
