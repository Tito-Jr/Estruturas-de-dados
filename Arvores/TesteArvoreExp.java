package Arvores;

public class TesteArvoreExp {

    public static void main(String[] args) {
        String exp = "( ( 2 + ( 3 * 4 ) ) + ( 5 * -10 ) )";
        ArvoreExpressao arvore = new ArvoreExpressao(exp);
        System.out.println(exp + " = " + arvore.calcular());
    }

}
