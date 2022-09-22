package Pilhas;

import Lista.NoLista;

public class PilhaDinamica<T> implements TADPilha<T> {

    private NoLista<T> topo;
    private int qtd;

    public void push(T e) {
        NoLista<T> novo = new NoLista<T>(e);
        if (topo == null) {
            topo = novo;
        } else {
            novo.next = topo;
            topo = novo;
        }
        qtd++;
    }

    public T pop() {
        T r = null;
        if (topo != null) {
            r = topo.element;
            topo = topo.next;
            qtd--;
        }
        return r;
    }

    public T top() {
        T r = null;
        if (topo != null) {
            r = topo.element;
        }
        return r;
    }

    public void print() {
        System.out.println(this);
    }

    public String toString() {
        String s = "topo ";
        NoLista<T> aux = topo;
        while (aux != null) {
            s += ("-> " + aux.element);
            aux = aux.next;
        }
        return s;
    }

    public int size() {
        return qtd;
    }

}
