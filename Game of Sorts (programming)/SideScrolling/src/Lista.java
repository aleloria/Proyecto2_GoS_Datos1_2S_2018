/** Clase Lista, implementación de una lista que se utiliza para recorrer un conjunto nodos, entre otros metodos utiles
 * se utiliza como clase padre de la clase matriz.
 * @author Rodrigo Mendoza.
 * */
public class Lista {
    //Inicio de campos para atributos de la clase.
    protected Nodo first,current;//first representa al primer valor de la lista y current el nodo actual que reviso.
    protected int lon;          //lon es el atributo que almacena la longitud de la lista.
    protected String arreglo;   //arreglo es una variable acumulativa para la representación estetica de la lista como un arreglo.
    //Fin de campos para atributos de la clase.
    /**
     * Constructor de objetos tipo Lista.
     */
    public Lista(){
        first=null;//Instancia un nuevo objeto tipo lista con valor nulo.
    }

    /**
     * El metodo add agrega un nodo a la lista en la primera posicion.
     * @param contenido corresponde al dato que contendra dicho nodo.
     */
    public void add(Object contenido){
        Nodo newNodo=new Nodo(contenido);//Instancia de objeto tipo nodo con el correspondiente dato.
        if (first==null){
            newNodo.next=null;          //Se establece un puntero a la siguiente posicion nula.
            first=newNodo;              //first o la primera posicion de la lista se establece en el nuevo nodo.
        }else{
            newNodo.next=first;         //Si ya existe un nodo entonces el nuevo nodo tendra un puntero hacia el primer nodo.
            first=newNodo;              //el nuevo nodo pasa a la primera posicion de la lista.
        }
        lon++;                          //aumenta en una cifra la longitud de la lista por cada nuevo nodo agregado, esta cifra se almacena en lon.
    }

    /**
     * metodo vacion que imprime la longitud de una lista determinada.
     */
    public void longitud(){
        System.out.println(lon);
    }

    /**
     * Metedo recorrido, imprime todos los datos de los nodos disponibles en la lista.
     * @param y corresponde la coordenada "Y" del nodo, es representativo y sirve como guia.
     * @param x corresponde la coordenada "X" del nodo, es representativo y sirve como guia.
     */
    public void recorrido(int y, int x){
        if (first==null){
            System.out.println("[]"); //Si la lista esta vacia imprime dos corchetes.
        }else{
            arreglo="";              //Se hace uso de la variable acumulativa arreglo, la cual acomoda de manera sucesiva los datos de cada nodo.
            current=first;           //El nodo actual recorrido pasa a ser el primero de la lista.
            while(current!=null){
                if (current.next==null){
                    arreglo=arreglo+current.data; //En arreglo se concatena el dato del nodo actual sin espaciar si y solo si es el ultimo nodo..
                }else{
                    arreglo=arreglo+current.data+", ";//Se concatena el dato del nodo a la variable arreglo y se separa con coma y espacio si hay mas nodos.
                }
                current=current.next;   //El nodo recorrido actual cambia al siguiente.
            }
            System.out.println("La lista del nodo ("+y+","+x+") es ["+arreglo+"]");//Se imprime la variable acumulativa arreglo entre corchetes
            // para expresarlo lo mas cercano a un arreglo.
        }
    }

    /**
     * Metodo imprimir, imprime y retorna un nodo localizado en una determinada posicion existende de la lista.
     * @param posicion recibe un entero que va desde 1 hasta la longitud de la lista, imprimira y retornara el nodo en esa posicion.
     * @return
     */
    public Object imprimir(int posicion){
        Object retorno=null;            //instancia de un objeto retorno, inicia vacio.
        if (posicion>lon || posicion<0){
            System.out.println("La longitud de la lista es: "+lon); //imprime la longitud de la lista si se ingresa una posicion invalida.
        }else{
            current=first;  //Si la posicion existe inicia el recorrido extableciendo el nodo actual en el primero.
            int temporal=1; //Instancia de un entero temporal, compara si la posicion actual es menor a la longiud.
            while (temporal<=lon){
                if (temporal==posicion){
                    retorno=current;    //Cuando la posicion actual es igual a la ingresada se establece el objeto retorno como el nodo deseado.
                }
                current=current.next;   //Si las posiciones no coinciden pasa al siguiente nodo.
                ++temporal; //Incremento de la posicion actual.
            }
        }
        return retorno; //retorna el valor del nodo.
    }

    /**
     * Metodo de busqueda, retorna un true o false si el dato buscado se encuentra en la lista.
     * @param arreglo se establece la lista enlazada en la que se realiza la busqueda.
     * @param dato se establece el dato a buscar en la lista.
     * @return
     */
    public Object busqueda(Lista arreglo,Object dato){
        Object retorno=false; //Instancia de un objeto retorno con valor false.
        current=arreglo.first;  //el nodo actual se establece como el primero de la lista.
        for(int i=0;i<arreglo.lon;++i){
            if (current.data==dato){
                retorno=true;   //Si el dato buscado es igual al nodo o dato actual que se recorre entonces retorno sera true.
                break;
            }else {
                if (current.next!=null){
                    current=current.next; //Si el siguiente nodo no es nulo y no se obtiene el dato buscado se pasa al siguiente nodo.
                }else {
                    break; //Si no se encuentra el nodo o dato deseado se termina el ciclo.
                }
            }
        }
        return retorno; //Se retorna el valor en la variable de tipo objeto retorno.
    }

    /**
     * Metodo in lista, funciona igual que el metodo busqueda, pero, con diferentes parametros y ademas imprime true o false,
     * mas que nada usado para busquedas generales, no recursivas como el metodo busqueda.
     * @param dato varible que contiene el dato o nodo a buscar en la lista.
     * @return
     */
    public boolean inLista(Object dato){
        Object retorno=false;
        current=first;
        for (int i=0;i<lon;i++){
            if (dato==current.data){
                retorno=true;
                break;
            }
            else {
                current=current.next;
            }
        }
        System.out.println(retorno); //Imprime el valor booleano true o false del objeto retorno.
        return (boolean)retorno;
    }

    /**
     * Metodo delet, toma una lista y la vacia, dejandola con un valor nulo, sirve para reutilizar una lista que contiene valores
     * que no seran necesarios.
     */
    public void delet(){
        first=null; //Establece el primer nodo con la referencia a null, de esta forma los demas nodos pierden las referencias
        //y la lista puede ser reutilizada.
    }

    /**
     * Metodo eraser, se utiliza para eliminar el primer nodo de la lista.
     */
    public void eraser(){
        first=first.next; //Establece que el nuevo primer nodo sera el siguiente del actual primer nodo.
    }
}