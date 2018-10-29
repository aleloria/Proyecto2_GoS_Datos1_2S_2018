import java.util.Random;

/**
 * Clase MatrizMapa, impementacion de matrices a base de Listas de Listas enlazadas.
 * @author Rodrigo Mendoza.
 */
public class Matriz extends Lista {
    //Inicio del campo para atributos de la clase.
    public int tempFila,tempColumna,start,fila,columna,objetos=20; //tempFila almacena temporalmente los contadores de fila en iteraciones, tempColumna
    //start almacena un valor que puede ser 0 o 1, se utiliza para saber cual es la primera fila de la matriz.
    //almacena las columnas en iteraciones, fila y columna sirven para determinar la dimension de la matriz.
    private Lista Esquema,currentL;                      //La variable esquema contiene la lista principal que sirve comoe squeleto de la matriz
    //currentL es una variable temporal que almacena la lista actual que se recorre.
    private Nodo currentN,currentN1;                     //Tanto curentN como currentN1 son variables temporales que almacenan nodos.
    private String arreglo,aray;                         //La variable arreglo es acumulativa, utilizada para representar las listas como una matriz
    //La variable aray se utiliza para concatenar las listas representadas como matriz en la variable arreglo
    //aray se encarga de meter la matriz entre corchetes y separarlas entre saltos de linea.
    //Fin de campo para atributos de la clase.
    /**
     * Constructor de objetos tipo matriz.
     * @param m se utiliza para establecer la cantidad de filas.
     * @param n establece la cantidad de columnas.
     * @param o si su valor es 1 crea una matriz enumerando cada nodo, si es diferente de 1 crea una matriz nula (llena de 0 en cada nodo).
     */
    public Matriz(int m, int n, int o){
        Lista Body=new Lista();         //Crea una nueva lista.
        Esquema=Body;                   //El cuerpo de la matriz es ahora igual a la nueva lista.
        fila=m;columna=n;               //Se toman los parametros m y n como filas y columnas, respectivamente.
        tempFila=1; tempColumna=1; int i=m*n; //las variables temporales de fila y columna inician en 1 para la iteracion, i es igual a la cantidad de nodo de la matriz.
        if (o==1){  //Verifica que la bandera o (de opcion) sera 1.
            i=m*n;  //Calcula la cantidad de nodos en la matriz.
            while(tempFila<=m){
                Lista newFila=new Lista(); //Mientras el contador de filas sea menor o igual a la cantidad deseada se crean nuevas listas que sirven de filas.
                while (tempColumna<=n){
                    newFila.add(i); //Agrega el valor actual de i al nodo de la fila,
                    ++tempColumna; //Incremento del contador de columnas.
                    --i;           //Decremento en la cantidad de ndos.
                }
                ++tempFila;        //El contador de filas incrementa.
                tempColumna=1;     //Se establece nuevamente el contador de columnas en 1 (esto cuando una fila ya está llena).
                Esquema.add(newFila); } //A la matriz se le agrega una fila nueva.
        }else{
            while(tempFila<=m){ //En esta parte pasa lo mismo a excepcion de que en lugar de enumerar los nodos se agregan solamente 0.
                Lista newFila=new Lista();
                while (tempColumna<=n){
                    newFila.add(0);
                    ++tempColumna;;
                }
                ++tempFila;
                tempColumna=1;
                Esquema.add(newFila); }
        }
        tempFila=1; }          //Por si las moscas se establece nuevamente el contador de filas en 1.

    /**
     * Metodo recorrido, funciona para comprobar la matriz creada, la imprime en consola.
     */
    public void recorrido(){
        currentN=Esquema.first; //El nodo actual se establece como la primera fila.
        arreglo="";aray=""; //Variables acumulativas para la representación en forma de matriz.
        start=0;            //Si start es 0 se sabe que se trabaja actualmente con la primera fila, eso implica que no lleve un espacio al inicio.
        while (currentN!=null){
            currentL=(Lista) currentN.data; //Se establece la lista actual como la sublista en la fila 1.
            currentN1=currentL.first;   //El nodo actual por recorrer dentro se la sublista se establece como el primer valor de la anterior mencionada.
            while (currentN1!=null){
                if (currentN1.next!=null){
                    arreglo=arreglo+currentN1.data+", ";} //Concatenación de los datos de cada nodo separado por una coma y espacio, son las columnas.
                else{
                    arreglo=arreglo+currentN1.data;} //Si es el ultimo nodo no se hace la separacion de comas y espacio.
                currentN1=currentN1.next;}  //Nodo actual de la sublista pasa a ser el siguiente.
            if (currentN.next==null && fila>1){aray+=" ["+arreglo+"]";}
            else {
                if (start==0 && fila>1){
                    aray+="["+arreglo+"]\n";start=1;    //Se trabaja con la primer fila, se establece start en 1 y se indica que se acabo con la primera fila.
                }
                else {
                    if (fila>1){
                        aray+=" ["+arreglo+"]\n";   //Se van concatenando las filas dentro de la estructura dentro de corchetes y con un espacio al inicio para alinear.
                    }
                    else {
                        aray+="["+arreglo+"]";  //Si es la ultima fila de la matriz no se hace salto de linea.
                    }
                }
            }
            arreglo=""; //La variable que se encarga de contener las columnas se inicializa vacia nuevamente, permite concatenar mas columnas en otras filas.
            currentN=currentN.next; //Se pasa a la fila siguiente.
        }
        System.out.println("["+aray+"]\n"); //Se imprime la matriz estructurada de como una matriz "real".
    }

    /**
     * Metodo setVal, permite establecer un valor al nodo deseado si este existe en la matriz.
     * @param m toma el valor de la fila.
     * @param n toma el valor de la columna.
     * @param valor corresponde al dato que se quiere agregar al nodo.
     */
    public void setVal(int m, int n, Object valor){
        tempFila=1;tempColumna=1;   //Se inicializan los contadores de filas y columnas, respectivamente, en 1.
        if (fila<m || columna<n){
            System.out.println("La lista posee "+fila+" filas y "+columna+" columnas, ingrese un valor válido. "+m+"   "+n);   //Si las coordenadas no existen imprime un mensaje de error.
        }
        else {
            currentN=Esquema.first; //Posiciona la variable temporal en la primera fila de la matriz.
            while (tempFila<=m){
                currentL=(Lista) currentN.data; //Se establece la fila como la sublista contenida en la variable temporal tipo Nodo.
                currentN1=currentL.first; //Se establece el nodo en la primera columna de la fila, este es el dato actual que recorremos.
                if (tempFila==m){   //Cuando la fila es igual a la deseada.
                    while (tempColumna<=n){
                        if (tempColumna==n){ //Cuando se posiciona en la columna deseada.
                            currentN1.data=valor;   //Se sustituye el valor del nodo por el establecido en los parametros del metodo.
                        }
                        currentN1=currentN1.next;   //Se posiciona el nodo en el siguiente a el, en otras palabras se pasa a la siguiente columna.
                        ++tempColumna;  //Se incrementa el contador de columnas.
                    }
                }
                currentN=currentN.next; //Se pasa a la siguiente fila.
                ++tempFila; //Se aumenta el contador de filas.
            }
        }
    }

    /**
     * Metodo fila, retorna el valor de un nodo o el nodo en si mismo, en otras palabras, retorna el nodo o el dato.
     * @param y posicion y del nodo en la matriz.
     * @param x posicion x del nodo en la matriz.
     * @return retorna un objeto que puede ser el dato del nodo o el nodo.
     */
    public Object fila(int y, int x){
        Object retorno=null;
        tempFila=1;
        currentN=Esquema.first; //Se posiciona en la primera fila.
        while (tempFila<=y){
            if (tempFila==y){
                retorno=((Lista)currentN.data).imprimir(x); //Cuando "Y" es equivalente al valor ingresado llama al metodo imprimir.
            }
            currentN=currentN.next;    //Pasa a la siguiente fila.
            ++tempFila;
        }
        return ((Nodo)retorno).data;   //Retorna el dato del nodo.
    }

    /**
     * Metodo longitud, retorna la dimension de una matriz, sus filas y columnas.
     */
    public void longitud(){System.out.println("("+fila+","+columna+")");}

    /**
     * Metodo nodoDato, retorna el dato del nodo en una matriz.
     * @param y fil ade la matriz.
     * @param x columna de la matriz.
     * @return  retorna un objeto que es el dato del nodo.
     */
    public Object nodoDato(int y, int x){
        Object retorno=null;
        if (y>fila || x>columna || y<0 || x<0){
            System.out.println("Coordenadas invalidas.");   //Verifica que las coordenadas existan.
        }else {
            retorno=fila(y,x); //Cuando se cumplen las sentencias se llama al metodo fila para que retorne el dato.
        }
        return retorno;
    }

    /**
     * metodo datos, dependiendo del valor de "z" retornará una lista de enlaces o el valor de un nodo.
     * @param y fila.
     * @param x columna.
     * @return
     */
    public Object datos(int y, int x){
        Object retorno=null;
        currentN=Esquema.first;
        currentL=(Lista)currentN.data;
        currentN1=currentL.first;
        if (y<=fila && x<=columna){
            for(int i=1; i<=y;++i){ //for que recorre las filas hasta llegar a la deseada.
                if (i==y){
                    for(int j=1;j<=x;++j){  //for que recorre las columnas hasta coincidir con la ingresada.
                        if (j==x){
                            retorno=currentN1.data;
                        }
                        else {
                            currentN1=currentN1.next;
                        }
                    }
                }
                else{
                    currentN=currentN.next;
                    currentL=(Lista)currentN.data;
                    currentN1=currentL.first;
                }
            }
        }
        return retorno;
    }

    public void dragonSpace(Matriz m,int modo){
        int contador=objetos;
        if (modo==1){
            this.setVal(1,4,1);
            this.setVal(2,2,1);
            this.setVal(3,1,1);
            this.setVal(3,3,1);
            this.setVal(2,6,1);
            this.setVal(3,5,1);
            this.setVal(3,7,1);
        }
        if (modo==2){
            for (int i=1;i<=fila;i++){
                if (contador>0){
                    for (int j=1;j<=columna;j++){
                        if (contador>0){
                            setVal(i,j,1);
                            contador--;
                        }
                    }
                }
            }
        }
        if (modo==3){
            Random randomizer = new Random();
            while (contador>0){
                int tempx = (randomizer.nextInt(3)+1);
                int tempy = (randomizer.nextInt(7)+1);
                if ((int)this.nodoDato(tempx,tempy)==0){
                    this.setVal(tempx,tempy,1);
                    contador--;
                }
            }
        }
    }

    public void resetear(){
        for (int i=1;i<=fila;i++){
            for (int j=1;j<=columna;j++){
                this.setVal(i,j,0);
            }
        }
    }
}