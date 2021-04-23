package Menu_and_game_things.Listas;

import Menu_and_game_things.Score_Table;

public class ListaCircular<Object> {
    private Nodo head;
    private int size;
    public ListaCircular() {
        head = null;
        size = 0;
    }
    public void add(Object value) {
        Nodo newNode = new Nodo(value,null,head);
        newNode.setFact(value);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            ++size;
        } else {
            Nodo current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(head);
            ++size;
        }
    }
    public void remove(int index) {
        if (index == 0 && index < size) {
            head = head.getNext();
            --size;
            Score_Table.setPoint();
        } else {
            Nodo current = head;
            int counter = 0;
            while (counter < index - 1) {
                current = current.getNext();
                counter++;
            }
            current.setNext(current.getNext().getNext());
            --size;
            Score_Table.setPoint();
        }
    }
    public Object get(int index) {
        Nodo current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (Object) current.getvalue();
    }
    public int size() {
        return size;
    }
    public void swap(int index1, int index2) {}
    public void clear() {
        this.head = null;
        this.size = 0;
    }
}
