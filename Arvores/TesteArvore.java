package Arvores;

public class TesteArvore {

    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
        arvore.add(7);
        arvore.add(4);
        arvore.add(14);
        arvore.add(12);
        arvore.add(3);
        arvore.add(9);
        arvore.add(6);
        arvore.print();
        System.out.println("Altura da arvore: " + arvore.alturaArvore());
        System.out.println("Removendo o no 7");
        arvore.remove(7);
        arvore.print();
        System.out.println("Altura da arvore: " + arvore.alturaArvore());
    }

}