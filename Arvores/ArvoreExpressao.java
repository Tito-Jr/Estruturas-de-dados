package Arvores;

import Pilhas.PilhaDinamica;

public class ArvoreExpressao {

    private NoBinario<String> raiz;

    public ArvoreExpressao(String equacao) {
        // construir a arvore a partir da equacao ...
        // ex.: ( ( 4 + 10 ) * 30 )
        String[] termos = equacao.split(" ");
        PilhaDinamica<String> pilhaOp = new PilhaDinamica<String>();
        PilhaDinamica<NoBinario<String>> pilhaNos = new PilhaDinamica<NoBinario<String>>();

        for (int i = 0; i < termos.length; i++) {
            String termo = termos[i];
            if (termo.equals("(")) {
                // nada precisa ser feito
            } else if (termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/")) {
                pilhaOp.push(termo);
            } else if (termo.equals(")")) {
                NoBinario<String> novoNo = new NoBinario<String>(pilhaOp.pop());
                novoNo.dir = pilhaNos.pop();
                novoNo.esq = pilhaNos.pop();
                pilhaNos.push(novoNo);
            } else {
                // em ultimo caso, deve ser um numero
                NoBinario<String> novoNo = new NoBinario<String>(termo);
                pilhaNos.push(novoNo);
            }
        }

        if (pilhaOp.size() == 0 && pilhaNos.size() == 1) {
            raiz = pilhaNos.pop();
        } else {
            throw new RuntimeException("Erro na equacao!");
        }
    }

    public int calcular() {
        int valor = percursoPosOrdem(raiz);
        return valor;
    }

    private int percursoPosOrdem(NoBinario<String> noAtual) {
        if (noAtual != null && noAtual.dir == null && noAtual.esq == null) {
            int valor = Integer.parseInt(noAtual.elemento);
            return valor;
        } else {
            int valorEsq = percursoPosOrdem(noAtual.esq);
            int valorDir = percursoPosOrdem(noAtual.dir);
            int valorAtual = aplicarOperador(noAtual.elemento, valorEsq, valorDir);
            return valorAtual;
        }
    }

    private int aplicarOperador(String operador, int valorEsq, int valorDir) {
        int valor = 0;
        switch (operador.charAt(0)) {
            case '+': valor = valorEsq + valorDir; break;
            case '-': valor = valorEsq - valorDir; break;
            case '*': valor = valorEsq * valorDir; break;
            case '/': valor = valorEsq / valorDir; break;
        }
        return valor;
    }
}
