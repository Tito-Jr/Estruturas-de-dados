package Lista;

import java.util.Iterator;

public class ListaDinamica<T> implements TADLista<T> {

    protected NoLista<T> inicio, fim;
    protected int qtd;

    public void add(T e) {
        NoLista<T> novo = new NoLista<T>(e);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.next = novo;
            fim = novo;
        }
        qtd++;
    }

    public void remove(T e) {
        if (inicio != null) {
            if (inicio.element.equals(e)) {
                inicio = inicio.next;
                if (inicio == null) {
                    fim = null;
                }
                qtd--;
            } else {
                NoLista<T> p = inicio;
                while (p.next != null) {
                    if (p.next.element.equals(e)) {
                        p.next = p.next.next;
                        if (p.next == null) {
                            fim = p;
                        }
                        qtd--;
                        break;
                    }
                    p = p.next;
                }
            }
        }
    }

    public T getElement(int i) {
        T r = null;
        int c=0;
        NoLista<T> p = inicio;
        while (c < i && p != null) {
            c++;
            p = p.next;
        }
        if (p != null) {
            r = p.element;
        }
        return r;
    }

    public int indexOf(T e) {
        int i = -1, c = 0;
        NoLista<T> p = inicio;
        while (p != null) {
            if (p.element.equals(e)) {
                i = c;
                break;
            }
            c++;
            p = p.next;
        }
        return i;
    }

    public String toString() {
        String s = "";
        for(NoLista<T> p=inicio; p != null; p = p.next) {
            s += " -> " + p.element;
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
