package Arvores;

public class NoBinario<T extends Comparable> {

    T elemento;
    NoBinario<T> esq, dir;

    public NoBinario(T e) {
        elemento = e;
    }

    public String toString() {
        return "" + elemento;
    }
}
