package dragon.rango;

// Se utiliza Singleton
// https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
// Singleton using ThreadSafe

import dragon.Dragon;

public class Comandante extends Dragon{
    // Rango Comandante -> 2
    private static Comandante instance;

    private Comandante(int x, int y){
        super(x,y);
    }

    public static synchronized Comandante getInstance(int x, int y){
        if(instance == null){
            instance = new Comandante(x,y);
        }
        return instance;
    }

    @Override
    public void setReloadSpeed(){
        // Comandantes tienen velocidad de recarga alta 65 - 100
        this.reloadSpeed = Random(65,100);
    }
}
