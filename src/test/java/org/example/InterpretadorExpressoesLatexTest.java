package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InterpretadorExpressoesLatexTest {

    @Test
    void deveAplicarNegrito() {
        InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("\\negrito Hello");
        assertEquals("\\textbf{Hello}", interpretador.interpretar());
    }

    @Test
    void deveAplicarItalico() {
        InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("\\itálico World");
        assertEquals("\\textit{World}", interpretador.interpretar());
    }

    @Test
    void deveAplicarSublinhado() {
        InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("\\sublinhado Java");
        assertEquals("\\underline{Java}", interpretador.interpretar());
    }

    @Test
    void deveAplicarCombinacaoDeFormatacoes() {
        InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("\\negrito Hello \\itálico World \\sublinhado Java");
        assertEquals("\\textbf{Hello} \\textit{World} \\underline{Java}", interpretador.interpretar());
    }

    @Test
    void deveManterTextoSimplesSemFormatacao() {
        InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("Hello World");
        assertEquals("Hello World", interpretador.interpretar());
    }

    @Test
    void deveRetornarExcecaoElementoInvalido() {
        try {
            InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("\\textup Hello");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoInvalida() {
        try {
            InterpretadorLatex interpretador = new InterpretadorExpressoesLatex("\\negrito");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        }
    }
}