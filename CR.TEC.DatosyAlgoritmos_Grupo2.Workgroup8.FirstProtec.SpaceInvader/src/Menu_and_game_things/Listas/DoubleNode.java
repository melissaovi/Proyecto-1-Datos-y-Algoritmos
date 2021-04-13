package Menu_and_game_things.Listas;

public class DoubleNode<T> {
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    private T data;

    public DoubleNode() {
        this.next = null;
        this.prev = null;
        this.data= null;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
