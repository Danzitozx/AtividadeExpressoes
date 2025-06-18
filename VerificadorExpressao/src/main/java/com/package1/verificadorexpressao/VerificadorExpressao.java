/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.package1.verificadorexpressao;

/**
 *
 * @author okmen
 */
import java.util.LinkedList;
import java.util.Scanner;

public class VerificadorExpressao {

    public static boolean saoCorrespondentes(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
               (abre == '[' && fecha == ']') ||
               (abre == '{' && fecha == '}');
    }

    public static boolean expressaoCorreta(String expressao) {
        LinkedList<Character> pilha = new LinkedList<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) {
                    return false;
                }

                char topo = pilha.pop();

                if (!saoCorrespondentes(topo, c)) {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão a ser verificada:");
        String expressao = scanner.nextLine();

        if (expressaoCorreta(expressao)) {
            System.out.println("Expressão correta!");
        } else {
            System.out.println("Expressão incorreta!");
        }

        scanner.close();
    }
}

