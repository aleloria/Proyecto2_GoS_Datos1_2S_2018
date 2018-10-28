import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main (String args[]){
        Huerfana frame =new Huerfana();
        Thread t1 = new Thread(frame);
        t1.start();
        /*Matriz drakes = new Matriz(3,7,0);
        drakes.recorrido();
        drakes.setVal(1,4,1);
        drakes.setVal(2,2,1);
        drakes.setVal(3,1,1);
        drakes.setVal(3,3,1);
        drakes.setVal(2,6,1);
        drakes.setVal(3,5,1);
        drakes.setVal(3,7,1);
        drakes.recorrido();
        drakes.longitud();
        int x=1200;
        int y=20;
        for (int i=1;i<=3;i++){
            for (int j=1;j<=7;j++){
                if ((int)drakes.nodoDato(i,j)==1){
                    System.out.println(x+((j-1)*100)+"   "+y);
                    y+=100;
                }
            }
        }
        drakes.recorrido();*/
        /*ArrayList<Integer> cosas = new ArrayList<>();
        Random eso = new Random();
        for (int i=10;i>0;i--){
            cosas.add(i);
        }
        System.out.println(cosas);
        QuickSort queso = new QuickSort(cosas);
        queso.startQuickStart(0,cosas.size()-1);
        System.out.println(cosas);*/
    }
}
