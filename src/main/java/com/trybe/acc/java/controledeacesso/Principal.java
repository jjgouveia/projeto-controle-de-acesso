package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Projetinho.
 */
public class Principal {
  /**
   * Método principal.
   */

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> idades = new ArrayList<Integer>();

    short option = 0;
    int menorDe18 = 0;
    int adultos = 0;
    int acimaDe50 = 0;



    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar sistema e mostrar relatório");
      short alternative = scan.nextShort();

      if (alternative != 1 && alternative != 2) {
        System.out.println("Entre com uma opção válida");
      } else if (alternative == 1) {
        System.out.println("Entre com a idade:");
        int idade = scan.nextInt();
        idades.add(idade);
        if (idade < 18) {
          menorDe18++;
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (idade <= 49) {
          adultos++;
          System.out.println("Pessoa adulta, catraca liberada");
        } else {
          acimaDe50++;
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
      } else {
        int total = idades.size();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("Quantidade");
        System.out.println("Número total de pessoas que visitaram o estabelecimento: " + total);
        System.out.println(
            "Número de pessoas menores de 18 anos que visitaram o estabelecimento: " + menorDe18);
        System.out.println(
            "Número de pessoas adultas (entre 18 e 49 anos) que visitaram o estabelecimento: "
                + adultos);
        System.out.println(
            "Número de pessoas a partir de 50 anos que visitaram o estabelecimento: " + acimaDe50);
        System.out.println();
        System.out.println("Porcentagem");
        System.out
            .println("menores: " + decimalFormat.format(((float) menorDe18 / total) * 100) + "%");
        System.out
            .println("adultas: " + decimalFormat.format(((float) adultos / total) * 100) + "%");
        System.out.println(
            "a partir de 50: " + decimalFormat.format(((float) acimaDe50 / total) * 100) + "%");
      }


      option = alternative;
    } while (option != 2);
    scan.close();
  }
}
