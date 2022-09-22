package Arvores;

public class ArvoreBinaria<T extends Comparable> implements TADArvore<T> {

    public NoBinario<T> raiz;
    public int qtd;

    public void add(T e) {
        if (raiz == null) {
            raiz = new NoBinario<T>(e);
            qtd++;
        } else {
            NoBinario<T> p = raiz;
            while (p != null) {
                int c = p.elemento.compareTo(e);
                if (c == 0) {
                    // encontrei o elemento, nao permite duplicidade
                    p.elemento = e; // substitui o elemento pelo novo
                    break;
                } else if (c < 0) {
                    // desce para direita
                    if (p.dir == null) {
                        p.dir = new NoBinario<T>(e);
                        qtd++;
                        break;
                    } else {
                        p = p.dir;
                    }
                } else {
                    // desce para esquerda
                    if (p.esq == null) {
                        p.esq = new NoBinario<T>(e);
                        qtd++;
                        break;
                    } else {
                        p = p.esq;
                    }
                }
            }
        }
    }

    public void remove(T e) {
        NoBinario<T> p = raiz;
        if (p != null) {
            if (p.elemento.equals(e)) {
                // devo remover a raiz da árvore
                if (p.esq == null) {
                    raiz = p.dir;
                } else if (p.dir == null) {
                    raiz = p.esq;
                } else {
                    removeSubRoot(p);
                }
            } else {
                NoBinario<T> paiP = p;
                while (p != null) {
                    int c = p.elemento.compareTo(e);
                    if (c == 0) {
                        // encontrei o elemento!
                        break;
                    } else if (c < 0) {
                        // desce para direita
                        paiP = p;
                        p = p.dir;
                    } else {
                        // desce para esquerda
                        paiP = p;
                        p = p.esq;
                    }
                }
                if (p != null) {
                    // encontrei o elemento pra remover
                    if (p.esq == null) {
                        if (paiP.esq == p)
                            paiP.esq = p.dir;
                        else
                            paiP.dir = p.dir;
                    } else if (p.dir == null) {
                        if (paiP.esq == p)
                            paiP.esq = p.esq;
                        else
                            paiP.dir = p.esq;
                    } else {
                        removeSubRoot(p);
                    }
                }
            }
        }
    }

    private void removeSubRoot(NoBinario<T> p) {
        NoBinario<T> w = p.dir;
        NoBinario<T> paiW = p;
        while (w.esq != null) {
            paiW = w;
            w = w.esq;
        }
        p.elemento = w.elemento;
        if (paiW != p) {
            paiW.esq = w.dir;
        } else {
            paiW.dir = w.dir;
        }
    }

    public void percursoEmOrdem(NoBinario<T> p) {
        if (p != null) {
            percursoEmOrdem(p.esq);
            System.out.print(p.elemento + " ");
            percursoEmOrdem(p.dir);
        }
    }

    public void print() {
        System.out.println("Imprimindo a árvore:");
        percursoEmOrdem(raiz);
        System.out.println("");
    }

    private int percursoPosOrdem(NoBinario<T> p) {
        int altura = -1;
        if (p != null) {
            int alturaEsq = percursoPosOrdem(p.esq);
            int alturaDir = percursoPosOrdem(p.dir);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
            altura++;
        }
        return altura;
    }

    public int alturaArvore() {
        return percursoPosOrdem(raiz);
    }

    public T find(T e) {
        T r = null;
        NoBinario<T> p = raiz;
        while (p != null) {
            int c = p.elemento.compareTo(e);
            if (c == 0) {
                // encontrei o elemento!
                r = p.elemento;
                break;
            } else if (c < 0) {
                // desce para direita
                p = p.dir;
            } else {
                // desce para esquerda
                p = p.esq;
            }
        }
        return r;
    }

    public boolean exist(T e) {
        return find(e) != null;
    }

    public int size() {
        return qtd;
    }

}
