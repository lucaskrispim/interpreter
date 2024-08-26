package org.example;

public class Italico implements InterpretadorLatex {
    private Texto texto;

    public Italico(Texto texto) {
        this.texto = texto;
    }

    @Override
    public String interpretar() {
        return "\\textit{" + texto.interpretar() + "}";
    }
}
