import javax.swing.*;
import java.awt.*;

public class GriffinRider {

    private int posX;
    private int posY;
    private int Lives = 3;
    private Image Image = new ImageIcon("imagenes\\GryffinRider.gif").getImage().getScaledInstance(150,150,1);
    private Image fullLives = new ImageIcon("imagenes\\fulllives.png").getImage().getScaledInstance(80,30,1);
    private Image lives2 = new ImageIcon("imagenes\\2lives.gif").getImage().getScaledInstance(80,30,1);
    private Image live = new ImageIcon("imagenes\\1live.gif").getImage().getScaledInstance(80,30,1);
    private Image bullet = new ImageIcon("imagenes\\fireball.gif").getImage().getScaledInstance(60,60,1);

    public GriffinRider(){
        posX=0;
        posY=300;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int x){
        posX=x;
    }

    public int getPosY(){
        return posY;
    }

    public void setPosY(int y){
        posY=y;
    }

    public int getLives(){
        return Lives;
    }

    public void setLives(int life){
        Lives=life;
    }

    public Image getImageLife(){
        Image retorno=null;
        if (Lives==3){
            retorno=fullLives;
        }
        if (Lives==2){
            retorno=lives2;
        }
        if (Lives==1){
            retorno=live;
        }
        return retorno;
    }

    public Image getImageData(){
        return Image;
    }

    public Image getBullet(){
        return bullet;
    }
}
