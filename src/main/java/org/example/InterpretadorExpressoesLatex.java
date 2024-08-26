package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import java.util.*;

public class InterpretadorExpressoesLatex implements InterpretadorLatex {

    private final String expressaoFinal;

    public InterpretadorExpressoesLatex(String contexto) {

        Stack<InterpretadorLatex> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            List<String> palavrasRestantes = new ArrayList<>();

            switch (elemento) {
                case "\\negrito":
                    if (!iterator.hasNext()) throw new IllegalArgumentException("Expressão inválida");
                    palavrasRestantes.add(iterator.next());
                    Texto textoNegrito = new Texto(palavrasRestantes);
                    pilhaInterpretadores.push(new Negrito(textoNegrito));
                    break;

                case "\\sublinhado":
                    if (!iterator.hasNext()) throw new IllegalArgumentException("Expressão inválida");
                    palavrasRestantes.add(iterator.next());
                    Texto textoSublinhado = new Texto(palavrasRestantes);
                    pilhaInterpretadores.push(new Sublinhado(textoSublinhado));
                    break;

                case "\\itálico":
                    if (!iterator.hasNext()) throw new IllegalArgumentException("Expressão inválida");
                    palavrasRestantes.add(iterator.next());
                    Texto textoItalico = new Texto(palavrasRestantes);
                    pilhaInterpretadores.push(new Italico(textoItalico));
                    break;

                default:
                    if (elemento.startsWith("\\")) {
                        throw new IllegalArgumentException("Expressão com elemento inválido");
                    }
                    palavrasRestantes.add(elemento);
                    pilhaInterpretadores.push(new Texto(palavrasRestantes));
                    break;
            }
        }

        StringBuilder resultadoFinal = new StringBuilder();
        while (!pilhaInterpretadores.isEmpty()) {
            resultadoFinal.insert(0, pilhaInterpretadores.pop().interpretar() + " ");
        }

        this.expressaoFinal = resultadoFinal.toString().trim();
    }

    @Override
    public String interpretar() {
        return expressaoFinal;
    }
}
