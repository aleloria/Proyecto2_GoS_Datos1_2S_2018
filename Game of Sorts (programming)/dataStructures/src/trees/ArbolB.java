package trees;

import trees.nodos.NodoB;

public class ArbolB<E extends Comparable<E>>{
    private NodoB<E> root;
    private int T; //2T is the maximum number of childen a node can have
    private int height;

    public ArbolB(int t){
        root = new NodoB<E>(t);
        T = t;
        height = 0;
    }

    public void printHeight(){
        System.out.println("Tree height is "+height);
    }

    public void insert(E newKey){
        if (root.isFull()){//Split root;
            split();
            height++;
        }
        root.insert(newKey);
    }

    public void print(){
        // Wrapper for node print method
        root.print();
    }

    public void printNodes(){
        // Wrapper for node print method
        root.printNodes();
    }

    public void split(){
//Splits the root into three nodes.
//The median element becomes the only element in the root
//The left subtree contains the elements that are less than the median
//The right subtree contains the elements that are larger than the median
//The height of the tree is increased by one

//System.out.println("Before splitting root");
//root.printNodes(); // Code used for debugging
        NodoB<E> leftChild = new NodoB<E>(T);
        NodoB<E> rightChild = new NodoB<E>(T);
        leftChild.isLeaf = root.isLeaf;
        rightChild.isLeaf = root.isLeaf;
        leftChild.n = T-1;
        rightChild.n = T-1;
        int median = T-1;
        for (int i = 0;i<T-1;i++){
            leftChild.c[i] = root.c[i];
            leftChild.key[i] = root.key[i];
        }
        leftChild.c[median]= root.c[median];
        for (int i = median+1;i<root.n;i++){
            rightChild.c[i-median-1] = root.c[i];
            rightChild.key[i-median-1] = root.key[i];
        }
        rightChild.c[median]=root.c[root.n];
        root.key[0]=root.key[median];
        root.n = 1;
        root.c[0]=leftChild;
        root.c[1]=rightChild;
        root.isLeaf = false;
    //System.out.println("After splitting root");
    //root.printNodes();
    }
}

