package dragon.features;

import javax.swing.*;
import java.awt.*;

public class Dragon {
    private int posX;
    private int posY;
    private Image Image;
    private String name;
    private int reloadSpeed;
    private int age;
    private int resistance;
    private String rank;
    private String father;


    static ImageIcon active;


    public Dragon(ImageIcon dragons){
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

    public void setName(String name){
        this.name = name
    }

    public void generateName(){
        this.name = "Dragon" + "Wave" + "RandomString";
    }

    public String getName(){
        return this.name;
    }

    public void setReloadSpeed(int reloadSpeed){
        this.reloadSpeed = reloadSpeed;
    }

    public int getReloadSpeed() {
        return this.reloadSpeed;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void setResistance(int resistance){
        this.resistance = resistance;
    }

    public int getResistance(){
        return this.resistance;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }

    public void setFather(String father){
        this.father = father;
    }

    public String getFather(){
        return this.father;
    }
}
