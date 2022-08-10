package Lista;

public class NoLista<T> {

    public T element;
    public NoLista<T> next;

    public NoLista(T e) {
        element = e;
    }

    public String toString() {
        return "" + element;
    }
}
