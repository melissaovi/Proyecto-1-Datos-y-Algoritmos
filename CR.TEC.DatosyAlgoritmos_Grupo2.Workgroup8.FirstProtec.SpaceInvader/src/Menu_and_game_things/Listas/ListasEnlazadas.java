package Menu_and_game_things.Listas;

import Enemies.Alien;
import Main.Window;

public class ListasEnlazadas{
    private Nodo head;
    private Nodo last;
    private int size;
    // constructor
    public ListasEnlazadas(){
        head = null;
        last = null;
        size = 0;
    }
    // gets the value of a space in the list
    public Object gett(int index){
        int cont = 0;
        Nodo temp = head;
        while (cont < index){
            temp = temp.getNext();
            cont++;
        }
        return temp.getvalue();
    }

    public Nodo gettt(int index){
        int cont = 0;
        Nodo temp = head;
        while (cont < index){
            temp = temp.getNext();
            cont++;
        }
        return temp;
    }

    // add to the beginning of the list
    public void insertHead(Object obj) {
        if (head == null) {
            head = new Nodo(obj,null,null);
            last = head;
        } else {
            Nodo temp = head;
            Nodo neww = new Nodo(obj,null,head);
            neww.setNext(temp);
            head = neww;
        }
        size++;
    }

    // add to the end of the list
    public void insertLast(Object obj){
        if (head == null){
            last = new Nodo(obj, null, null);
            head = last;
        } else {
            Nodo neww = new Nodo(obj, null, head);
            last.setPrevious(neww);
            last = neww;
        }
        size++;
    }

    // add in a specific space of the list
    public void insertMiddle(Object obj, int index){
        int cont = 0;
        Nodo temp = head;
        if (head == null){
            insertHead(obj);
        } else if (index >= size-1) {
            insertLast(obj);
        } else {
            while (cont < index) {
                temp = temp.getNext();
                cont++;
            }
        }
    }
    // delete a element of list
    public void delete(int index){
        if (index == 0) {
            head = head.getNext();
        } else {
            int cont = 0;
            Nodo temp = head;
            while(cont < index -1){
                temp = temp.getNext();
                cont++;
            }
            temp.setNext(
                    temp.getNext().getNext()
            );
        }
        size--;
    }

    // check if the list is empty
    public boolean estaVacia(){
        // verifica si la lista esta vacia
        return (head == null)?true:false;
    }

    // returns the list size
    public int getSize(){
        return size;
    }
}
