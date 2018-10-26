package dragon;

public class Main {
    public static void main(String []args){
        Dragon dragon1 = new Dragon(1,1);
        Dragon dragon2 = new Dragon(1,1);

        dragon1.setOleada(1);
        dragon1.generateName();

        dragon1.setAge();
        dragon1.setReloadSpeed();
        dragon1.setResistance();

    }
}
