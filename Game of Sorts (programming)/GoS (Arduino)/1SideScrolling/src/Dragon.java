import javax.swing.*;
import java.awt.*;

public class Dragon {
    int posX;
    int posY;
    String Name;
    Image Image;

    static ImageIcon active;



    Dragon(ImageIcon dragons){
        setImage(dragons);


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

    public void setImage(ImageIcon image) {

        Image img2 = image.getImage();
        img2=img2.getScaledInstance(150, 150, 1);
        Image = img2;
    }

    public Image getImageData() {
        return Image;
    }
}
