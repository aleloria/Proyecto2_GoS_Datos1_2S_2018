package dragon;

import dragon.rango.Capitan;
import dragon.rango.Comandante;

public class Main {
    public static void main(String []args){
        Comandante dragon1 = Comandante.getInstance(1,1);
        Capitan dragon2 = new Capitan(1,1);


        dragon1.setOleada(1);
        dragon1.generateName();

        dragon1.setAge();
        dragon1.setReloadSpeed();
        dragon1.setResistance();
        dragon1.setRank(0);


        System.out.println();

        dragon2.setOleada(1);
        dragon2.generateName();

        dragon2.setAge();
        dragon2.setReloadSpeed();
        dragon2.setResistance();
        dragon2.setRank();
        dragon2.setFather(dragon1);

    }
}
