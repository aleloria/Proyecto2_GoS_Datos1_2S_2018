package trees;

// https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

import trees.nodos.Nodo;

public class BinarySearchTree {
    public static  Nodo root;
    public BinarySearchTree(){
        this.root = null;
    }

    public boolean find(int id){
        Nodo current = root;
        while(current!=null){
            if(current.data==id){
                return true;
            }else if(current.data>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
    public boolean delete(int id){
        Nodo parent = root;
        Nodo current = root;
        boolean isLeftChild = false;
        while(current.data!=id){
            parent = current;
            if(current.data>id){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the Nodo
        //Case 1: if Nodo to be deleted has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if Nodo to be deleted has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){

            //now we have found the minimum element in the right sub tree
            Nodo successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Nodo getSuccessor(Nodo deleleNodo){
        Nodo successsor =null;
        Nodo successsorParent =null;
        Nodo current = deleleNodo.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleleNodo.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNodo.right;
        }
        return successsor;
    }
    public void insert(int id){
        Nodo newNodo = new Nodo(id);
        if(root==null){
            root = newNodo;
            return;
        }
        Nodo current = root;
        Nodo parent = null;
        while(true){
            parent = current;
            if(id<current.data){
                current = current.left;
                if(current==null){
                    parent.left = newNodo;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNodo;
                    return;
                }
            }
        }
    }
    public void display(Nodo root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }
    public static void main(String arg[]){
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Check whether Nodo with value 4 exists : " + b.find(4));
        System.out.println("Delete Nodo with no children (2) : " + b.delete(2));
        b.display(root);
        System.out.println("\n Delete Nodo with one child (4) : " + b.delete(4));
        b.display(root);
        System.out.println("\n Delete Nodo with Two children (10) : " + b.delete(10));
        b.display(root);
    }
}
