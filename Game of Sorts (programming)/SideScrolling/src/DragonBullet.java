import javax.swing.*;
import java.awt.*;

public class DragonBullet {
    public Image Image = new ImageIcon("imagenes\\fireballD.gif").getImage().getScaledInstance(60,60,1);
    public int posX,posY;

    public DragonBullet(int x,int y){
        //this.posX=x;
        //this.posY=y;
        setPosX(x);
        setPosY(y);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public java.awt.Image getImage() {
        return Image;
    }
}
