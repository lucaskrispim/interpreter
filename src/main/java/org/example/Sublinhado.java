package org.example;

public class Sublinhado implements InterpretadorLatex {
    private Texto texto;

    public Sublinhado(Texto texto) {
        this.texto = texto;
    }

    @Override
    public String interpretar() {
        return "\\underline{" + texto.interpretar() + "}";
    }
}
