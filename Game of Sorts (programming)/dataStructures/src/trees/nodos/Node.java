package trees.nodos;

public class Node<T> {
    private int _ID = -1;
    private Node _Next;
    private T _Data=null;
    private boolean _State = false;
    /**
     * Constructor
     * @param pData Dato del nodo
     * @param pID ID del nodo
     */
    public Node(T pData,int pID){
        this._Data = pData;
        this._ID = pID;
        this._State=true;
    }
    /**
     *
     * @return Retorna el dato del nodo
     */
    public T get_Data(){
        return this._Data;
    }
    /**
     *
     * @param pObject Nuevo dato del nodo
     */
    public void set_Data(T pObject){
        this._Data = pObject;
    }
    /**
     *
     * @return La referencia del siguiente nodo
     */
    public Node get_Next(){
        return this._Next;
    }
    /**
     *
     * @param pNode Cambiar la referencia del siguiente nodo
     */
    public void set_Next(Node pNode){
        this._Next=pNode;
    }
    /**
     *
     * @return Develve el ID del nodo
     */
    public int get_ID(){
        return this._ID;
    }
    /**
     * Elimina este nodo
     */
    public void delete(){
        this._State = false;
    }
    /**
     *
     * @return El estado de este nodo
     */
    public boolean get_state(){
        return this._State;
    }
}

