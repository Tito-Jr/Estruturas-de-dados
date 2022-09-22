package Arvores;

public interface TADArvore<T> {

    public void add(T e);
    public void remove(T e);
    public void print();
    public T find(T e);
    public boolean exist(T e);
    public int size();

}
