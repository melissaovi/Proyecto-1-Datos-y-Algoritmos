package Menu_and_game_things.Listas;

public class Prueb {
    public static void main(String[] args) {
/*
        ListasEnlazadas lista = new ListasEnlazadas(t);

        System.out.println("Vacia? "+lista.estaVacia());

        lista.insertHead(32); // Last
        lista.insertHead(25);
        lista.insertHead(47);
        lista.insertHead(85);
        lista.insertHead(43);
        lista.insertHead(16); // First

        System.out.println("Vacia? "+lista.estaVacia());

        System.out.println("tamaño: "+lista.getSize());
        System.out.println("El primer elemento es: "+lista.gett(0));
        System.out.println("El ultimo elemento es: "+lista.gett(lista.getSize()-1));

        lista.delete(3);

        System.out.println("Cuarto elemento: "+lista.gett(3));*/
        DoubleLinkedList<Integer> listadoble=new DoubleLinkedList<>();
        listadoble.add(1);
        listadoble.add(2);
        listadoble.add(3);
        listadoble.add(4);
        listadoble.add(5);
        System.out.println(listadoble.size());
        listadoble.remove(3);
        System.out.println(listadoble.size());
        System.out.println(listadoble.get(2));
        listadoble.swap(0,3);
        System.out.println(listadoble.get(0));
    }
}
