package Lista;

public class TesteLista {

    public static void main(String[] args) {
        TADLista<Integer> lista = new ListaDinamicaOrdenada<Integer>();
        lista.add(7);
        lista.add(2);
        lista.add(5);
        lista.print();
        lista.remove(2);
        lista.add(4);
        lista.print();

        TADLista<String> lista2 = new ListaDinamicaOrdenada<String>();
        lista2.add("Jose");
        lista2.add("Maria");
        lista2.add("Carlos");
        lista2.add("Ana");
        lista2.print();
    }

}