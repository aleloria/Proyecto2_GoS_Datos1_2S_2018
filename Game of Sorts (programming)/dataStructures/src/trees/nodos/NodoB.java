package trees.nodos;

public class NodoB<E extends Comparable<E>>{
    public Object[] key;
    public NodoB[] c;
    public boolean isLeaf;
    public int n;
    public int T; //Each node has at least T-1 and at most 2T-1 keys
    private Node<?> auxiliar;

    public NodoB(int t){
        T = t;
        isLeaf = true;
        key = new Object[2*T-1];
        c = new NodoB[2*T];
        n=0;
        set_Auxiliar(null);
    }

    public boolean isFull(){
        return n==(2*T-1);
    }

    public void insert(E newKey){
        // Insert new key to current node
        // We make sure that the current node is not full by checking and
        // splitting if necessary before descending to node

        //System.out.println("inserting " + newKey); // Debugging code
        int i=n-1;
        if (isLeaf){
            while ((i>=0)&& (newKey.compareTo((E) key[i])<0)) {
                key[i+1] = key[i];
                i--;
            }
            n++;
            key[i+1]=newKey;
        }
        else{
            while ((i>=0)&& (newKey.compareTo((E) key[i])<0)) {
                i--;
            }
            int insertChild = i+1;  // Subtree where new key must be inserted
            if (c[insertChild].isFull()){
                // The root of the subtree where new key will be inserted has to be split
                // We promote the mediand of that root to the current node and
                // update keys and references accordingly

                //System.out.println("This is the full node we're going to break ");
                // Debugging     code
                //c[insertChild].printNodes();
                //System.out.println("going to promote " + c[insertChild].key[T-1]);
                n++;
                c[n]=c[n-1];
                for(int j = n-1;j>insertChild;j--){
                    c[j] =c[j-1];
                    key[j] = key[j-1];
                }
                key[insertChild]= (E) c[insertChild].key[T-1];
                c[insertChild].n = T-1;

                NodoB newNode = new NodoB(T);
                for(int k=0;k<T-1;k++){
                    newNode.c[k] = c[insertChild].c[k+T];
                    newNode.key[k] = c[insertChild].key[k+T];
                }

                newNode.c[T-1] = c[insertChild].c[2*T-1];
                newNode.n=T-1;
                newNode.isLeaf = c[insertChild].isLeaf;
                c[insertChild+1]=newNode;

                //System.out.println("This is the left side ");
                //c[insertChild].printNodes();
                //System.out.println("This is the right side ");
                //c[insertChild+1].printNodes();
                //c[insertChild+1].printNodes();

                if (newKey.compareTo((E) key[insertChild])<0){
                    c[insertChild].insert(newKey);     }
                else{
                    c[insertChild+1].insert(newKey);    }
            }
            else
                c[insertChild].insert(newKey);
        }
    }
    public void print(){
        //Prints all keys in the tree in ascending order
        if (isLeaf){
            for(int i =0; i<n;i++)
                System.out.print(key[i]+" ");
            System.out.println();
        }
        else{
            for(int i =0; i<n;i++){
                c[i].print();
                System.out.print(key[i]+" ");
            }
            c[n].print();
        }
    }

    public void printNodes(){
        //Prints all keys in the tree, node by node, using preorder
        //It also prints the indicator of whether a node is a leaf
        //Used mostly for debugging purposes
        printNode();
        if (!isLeaf){
            for(int i =0; i<=n;i++){
                c[i].printNodes();
            }
        }
    }
    public void printNode(){
        //Prints all keys in node
        for(int i =0; i<n;i++)
            System.out.print(key[i]+" ");
        System.out.println(isLeaf);
    }

    public Node<?> get_Auxiliar() {
        return auxiliar;
    }

    public void set_Auxiliar(Node<?> referencia) {
        this.auxiliar = referencia;
    }
}

