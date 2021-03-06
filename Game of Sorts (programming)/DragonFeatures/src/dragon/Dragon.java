package dragon;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Dragon {
    protected int posX;
    protected int posY;
    protected Image Image = (new ImageIcon("imagenes\\dragon.gif")).getImage().getScaledInstance(150, 150, 1);
    protected String name;
    protected int reloadSpeed;
    protected int age;
    protected int resistance;
    protected String rank;
    protected Dragon father = null;
    public int dragnum = 0;
    protected int oleada;

    public Dragon(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public Dragon() {

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
        this.name = "Dragon" +"Ol"+var10001+"Num"+ this.dragnum;
        ++this.dragnum;
        System.out.println(this.name);
    }

    public String getName() { return this.name; }

    public int Random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min)+1) + min;
    }

    public void setReloadSpeed() {
        // Comandantes tienen velocidad de recarga alta 65 - 100
        // Capitan tienen velocidad de recarga media 31 - 64
        // Infanteria tienen velocidad de recarga baja 1 - 30

        this.reloadSpeed = this.Random(1, 100);
        System.out.println("ReloadSpeed: " + this.reloadSpeed);
    }

    public int getReloadSpeed() {
        return this.reloadSpeed;
    }

    public void setAge() {
        this.age = this.Random(1, 1000);
        System.out.println("Age: " + this.age);
    }

    public int getAge() {
        return this.age;
    }

    public void setResistance() {
        this.resistance = this.Random(1, 3);
        System.out.println("Resistance: " + this.resistance);
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setRank(int randonRank) {
        // rango = 0 -> Comandante -> Raiz del arbol
        if (randonRank == 0) {
            this.rank = "Comandante";
            System.out.println("Rango: " + this.rank);
        }
    }
    public void setRank(){
        // rango = 1 -> Capitan -> Siguiente nivel bajo la raiz del arbol, rango = 2 -> Infanteria -> Hojas del arbol
        int randomRank = Random(1, 2);

        if(randomRank == 2){
            this.rank = "Capitan";
            System.out.println("Rango: " + this.rank);
        }
        else{
            this.rank = "Infanteria";
            System.out.println("Rango: " + this.rank);
        }
    }

    public String getRank() {
        return this.rank;
    }

    public void setFather(Dragon father) {
        this.father = father;
        System.out.println("Padre: " + this.father.getName());
    }

    public Dragon getFather() {
        return this.father;
    }
}

