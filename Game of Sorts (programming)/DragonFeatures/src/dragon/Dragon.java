package dragon;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Dragon {
    private int posX;
    private int posY;
    private Image Image = (new ImageIcon("imagenes\\dragon.gif")).getImage().getScaledInstance(150, 150, 1);
    private String name;
    private int reloadSpeed;
    private int age;
    private int resistance;
    private int rank;
    private String father;
    public int dragnum = 0;
    private int oleada;

    public Dragon(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setImage(ImageIcon image) {
        Image img2 = image.getImage();
        img2 = img2.getScaledInstance(150, 150, 1);
        this.Image = img2;
    }

    public Image getImageData() {
        return this.Image;
    }

    public void setOleada(int oleada) {
        this.oleada = oleada;
    }

    public int getOleada() {
        return this.oleada;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateName() {
        int var10001 = this.getOleada();
        this.name = "Dragon" + var10001 + this.dragnum;
        ++this.dragnum;
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }

    private int Random(int limit) {
        Random rand = new Random();
        return rand.nextInt(limit - 2) + 1;
    }

    public void setReloadSpeed() {
        this.reloadSpeed = this.Random(100);
        System.out.println("ReloadSpeed: " + this.reloadSpeed);
    }

    public int getReloadSpeed() {
        return this.reloadSpeed;
    }

    public void setAge() {
        this.age = this.Random(1000);
        System.out.println("Age: " + this.age);
    }

    public int getAge() {
        return this.age;
    }

    public void setResistance() {
        this.resistance = this.Random(3);
        System.out.println("Resistance: " + this.resistance);
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getFather() {
        return this.father;
    }
}

