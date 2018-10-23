/** Clase Nodo, representa los valores que estarán dentro de una lista.
 * @author Rodrigo Mendoza.
 * */
public class Nodo {
    //Inicio de campos para los atributos de la clase.
    protected Object data;      //Contiene el valor del nodo.
    protected Nodo next;        //Puntero al nodo siguiente.
    //Fin de campo para los atributos de la clase.

    //Inicio del constructor de la clase Nodo.
    /**
     * Constructor de objetos tipo Nodo.
     * @param dato El parametro dato corresponde a un tipo Object que sera el valor que tenga el nodo creado.
     */
    public Nodo(Object dato){
        data=dato;
    }
    //Fin del constructor de la clase Nodo.
}