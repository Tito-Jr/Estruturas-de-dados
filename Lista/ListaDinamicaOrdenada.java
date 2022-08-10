package Lista;

public class ListaDinamicaOrdenada<T extends Comparable> extends ListaDinamica<T> {

    //private NoLista<T> inicio;
    //private int qtd;

    private int compare(T e1, T e2) {
        return e1.compareTo(e2);
    }

    public void add(T e) {
        NoLista<T> novo = new NoLista<T>(e);
        if (inicio == null) {
            inicio = novo;
        } else {
            int c = compare(e, inicio.element);
            if (c < 0) {
                novo.next = inicio;
                inicio = novo;
            } else {
                NoLista<T> p = inicio;
                while(p.next != null) {
                    c = compare(e, p.next.element);
                    if (c > 0) {
                        p = p.next;
                    } else {
                        break;
                    }
                }
                novo.next = p.next;
                p.next = novo;
            }
        }
        qtd++;
    }

}
