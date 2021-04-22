package Menu_and_game_things.Listas;

public class Prueb {
    public static void main(String[] args) {
        ListaCircular<Integer> listadoble=new ListaCircular<>();
        listadoble.add(1);
        listadoble.add(2);
        listadoble.add(3);
        listadoble.add(4);
        listadoble.add(5);
        System.out.println(listadoble.size());
        listadoble.remove(3);
        System.out.println(listadoble.size());
        System.out.println(listadoble.get(2));
        System.out.println(listadoble.get(0));
    }
}
