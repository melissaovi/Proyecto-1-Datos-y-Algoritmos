package Menu_and_game_things.Listas;

public class DoubleNode<Object> {
    private DoubleNode<Object> next;
    private DoubleNode<Object> prev;
    private Object data;

    public DoubleNode() {
        this.next = null;
        this.prev = null;
        this.data= null;
    }

    public DoubleNode<Object> getNext() {
        return next;
    }

    public void setNext(DoubleNode<Object> next) {
        this.next = next;
    }

    public DoubleNode<Object> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<Object> prev) {
        this.prev = prev;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
