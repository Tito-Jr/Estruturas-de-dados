package Fila;

public class FilaCircular<T> implements TADFila<T> {

    private T[] elementos;
    private int front, back, qtd;

    public FilaCircular() {
        elementos = (T[]) new Object[4];
    }

    public void enqueue(T e) {
        if (qtd == elementos.length) {
            // expande a memoria
            T[] temp = (T[]) new Object[(int)(qtd*1.5)];
            for (int i=0; i<qtd; i++) {
                int k = (i+front) % elementos.length;
                temp[i] = elementos[k];
            }
            front = 0;
            back = qtd-1;
            elementos = temp;
        }

        if (qtd == 0) {
            elementos[back] = e;
        } else {
            back = (back+1) % elementos.length;
            elementos[back] = e;
        }
        qtd++;
    }

    public T dequeue() {
        T r = null;
        if (qtd > 0) {
            r = elementos[front];
            elementos[front] = null;
            if (qtd > 1)
                front = (front+1) % elementos.length;
            qtd--;
        }
        return r;
    }

    public T head() {
        T r = null;
        if (qtd > 0) {
            r = elementos[front];
        }
        return r;
    }

    public int length() {
        return qtd;
    }

    public String toString() {
        String s = "inicio";
        if (qtd > 0) {
            for (int i=0; i<qtd; i++) {
                int k = (i+front) % elementos.length;
                s += " -> " + elementos[k];
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
