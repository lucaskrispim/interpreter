package org.example;

import java.util.List;

public class Texto implements InterpretadorLatex {
    private List<String> palavras;

    public Texto(List<String> palavras) {
        this.palavras = palavras;
    }

    @Override
    public String interpretar() {
        return String.join(" ", palavras);
    }

}
