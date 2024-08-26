package org.example;

import java.util.ArrayList;
import java.util.List;

public class DocumentoLatex {
    private List<String> expressoes;

    public DocumentoLatex() {
        this.expressoes = new ArrayList<>();
    }

    public void adicionarExpressao(String expressao) {
        this.expressoes.add(expressao);
    }

    public String compilarDocumento() {
        StringBuilder resultado = new StringBuilder();
        for (String expressao : expressoes) {
            InterpretadorLatex interpretador = new InterpretadorExpressoesLatex(expressao);
            resultado.append(interpretador.interpretar()).append(" ");
        }
        return resultado.toString().trim();
    }
}
