package dragon.rango;

import dragon.Dragon;

public class Infanteria extends Dragon {
    public Infanteria(int x, int y) {
        super(x, y);
    }

    @Override
    public void setReloadSpeed(){
        // Infanteria tienen velocidad de recarga baja 1 - 30
        this.reloadSpeed = Random(1,30);
    }

}
