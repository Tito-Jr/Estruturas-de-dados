package Lista;

import java.util.Iterator;

public class ListaEstatica<T> implements TADLista<T> {

    private T[] elementos;
    private int qtd;

    public ListaEstatica() {
        elementos = (T[]) new Object[10];
    }

    public void add(T e) {
        if (qtd == elementos.length) {
            T[] temp = (T[]) new Object[qtd*2];
            for(int i=0; i<qtd; i++) {
                temp[i] = elementos[i];
            }
            elementos = temp;
        }
        elementos[qtd] = e;
        qtd++;
    }

    public void remove(T e) {
        int i = indexOf(e);
        if (i != -1) {
            while (i<qtd-1) {
                elementos[i] = elementos[i+1];
                i++;
            }
            elementos[i] = null;
            qtd--;
        }
    }

    public T getElement(int i) {
        T r = null;
        if (i < qtd) {
            r = elementos[i];
        }
        return r;
    }

    public int indexOf(T e) {
        int i = -1, c=0;
        while (c<qtd) {
            if (elementos[c].equals(e)) {
                i = c;
                break;
            }
            c++;
        }
        return i;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < qtd; i++) {
            s += " -> " + elementos[i];
        }
        return s;
    }

    public void print() {
        System.out.println(this);
    }

    public boolean exist(T e) {
        return indexOf(e) != -1;
    }

    public int length() {
        return qtd;
    }

}
