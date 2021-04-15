package Menu_and_game_things.Listas;

public class Node <Object> {
    private Object value;
    private Node<Object> next;

    public Node() {
        value = null;
        next = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node<Object> getNext() {
        return next;
    }

    public void setNext(Node<Object> next) {
        this.next = next;
    }
}
