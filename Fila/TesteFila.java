package Fila;

public class TesteFila {

    public static void main(String[] args) {
        TADFila<String> fila = new FilaCircular<String>();
        fila.print();
        fila.enqueue("A");
        fila.enqueue("B");
        fila.enqueue("C");
        fila.enqueue("D");
        fila.print();
        System.out.println("Removido elemento " + fila.dequeue());
        fila.print();
        fila.enqueue("E");
        fila.enqueue("F");
        fila.print();
    }

}
