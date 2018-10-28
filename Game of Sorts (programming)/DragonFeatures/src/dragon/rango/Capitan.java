package dragon.rango;

import dragon.Dragon;

public class Capitan extends Dragon{

    public Capitan(int x, int y) {
        super(x,y);
    }

    @Override
    public void setReloadSpeed(){
        // Capitan tienen velocidad de recarga media 31 - 64
        this.reloadSpeed = Random(31,64);
    }
}
