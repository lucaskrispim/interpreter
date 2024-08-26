package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DocumentoLatexTest {

    @Test
    void deveCompilarTextoComMultiplasExpressoes() {
        DocumentoLatex documento = new DocumentoLatex();
        documento.adicionarExpressao("\\negrito Hello");
        documento.adicionarExpressao("\\sublinhado World");
        documento.adicionarExpressao("\\itálico Java");

        assertEquals("\\textbf{Hello} \\underline{World} \\textit{Java}", documento.compilarDocumento());
    }

    @Test
    void deveCompilarTextoSimples() {
        DocumentoLatex documento = new DocumentoLatex();
        documento.adicionarExpressao("Hello World");

        assertEquals("Hello World", documento.compilarDocumento());
    }

    @Test
    void deveCompilarTextoVazio() {
        DocumentoLatex documento = new DocumentoLatex();

        assertEquals("", documento.compilarDocumento());
    }
}