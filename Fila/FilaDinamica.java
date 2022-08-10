package Fila;

import Lista.NoLista;

public class FilaDinamica<T> implements TADFila<T> {

    private NoLista<T> inicio, fim;
    private int qtd;

    public void enqueue(T e) {
        NoLista<T> novo = new NoLista<T>(e);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.next = novo;
            fim = novo;
        }
        qtd++;
    }

    public T dequeue() {
        T r = null;
        if (inicio != null) {
            r = inicio.element;
            inicio = inicio.next;
            if (inicio == null)
                fim = null;
            qtd--;
        }
        return r;
    }

    public T head() {
        T r = null;
        if (inicio != null) {
            r = inicio.element;
        }
        return r;
    }

    public int length() {
        return qtd;
    }

    public String toString() {
        String s = "inicio";
        if (inicio != null) {
            for(NoLista<T> p=inicio; p != null; p = p.next) {
                s += " -> " + p.element;
            }
        } else {
            s += " -> null";
        }
        return s;
    }

    public void print() {
        System.out.println(this);
    }
}
