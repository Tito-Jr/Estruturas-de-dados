package Fila;

public interface TADFila<T> {

    public void enqueue(T e);

    public T dequeue();

    public T head();

    public int length();

    public void print();
}

