package Lista;

public interface TADLista<T> {

    public void add(T e);
    public void remove(T e);
    public T getElement(int i);
    public int indexOf(T e);
    public void print();
    public boolean exist(T e);
    public int length();

}

