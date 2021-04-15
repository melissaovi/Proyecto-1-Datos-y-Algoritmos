package Menu_and_game_things.Listas;

public class ListaCircular<Object> {
    private Node<Object> head;
    private int size;
    public ListaCircular() {
        head = null;
        size = 0;
    }
    public void add(Object value) {
        Node<Object> newNode = new Node<Object>();
        newNode.setValue(value);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            ++size;
        } else {
            Node<Object> current = head;
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
        } else {
            Node<Object> current = head;
            int counter = 0;
            while (counter < index - 1) {
                current = current.getNext();
                counter++;
            }
            current.setNext(current.getNext().getNext());
            --size;
        }
    }
    public Object get(int index) {
        Node<Object> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }
    public int size() {
        return size;
    }
    public void clear() {
        this.head = null;
        this.size = 0;
    }
}
