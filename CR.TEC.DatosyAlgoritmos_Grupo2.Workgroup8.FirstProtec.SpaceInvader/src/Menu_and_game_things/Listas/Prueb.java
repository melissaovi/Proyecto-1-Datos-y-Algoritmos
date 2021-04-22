package Menu_and_game_things.Listas;
public class Prueb {
    public static void main(String[] args) {
        ListaCircularDoble<Integer> listaCircularDoble=new ListaCircularDoble();
        listaCircularDoble.insertNode(1);
        listaCircularDoble.insertNode(4);
        listaCircularDoble.insertNode(6);
        listaCircularDoble.insertNode(10);
        listaCircularDoble.remove(0);
        listaCircularDoble.printt();
        System.out.println("Primer nodo:" +listaCircularDoble.get(0));
        listaCircularDoble.insertNode(3);
        listaCircularDoble.insertNode(3);
        listaCircularDoble.printt();
    }
}
