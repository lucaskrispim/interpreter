package org.example;

public class Negrito implements InterpretadorLatex {
    private Texto texto;

    public Negrito(Texto texto) {
        this.texto = texto;
    }

    @Override
    public String interpretar() {
        return "\\textbf{" + texto.interpretar() + "}";
    }
}