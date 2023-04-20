package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Projetinho.
 */
public class Principal {
  private static short option;
  private static ArrayList<Integer> idades = new ArrayList<Integer>();
  private static int menorDe18 = 0;
  private static int adultos = 0;
  private static int acimaDe50 = 0;

  /**
   * Método principal.
   * 
   */

  public static int getTotal() {
    return idades.size();
  }

  public static int getMenores() {
    return menorDe18;
  }

  public static void setMenores(int n) {
    menorDe18 = n;
  }

  public static int getAdultos() {
    return adultos;
  }

  public static void setAdultos(int n) {
    adultos = n;
  }

  public static int getAcimaDe50() {
    return acimaDe50;
  }

  public static void setAcimaDe50(int n) {
    acimaDe50 = n;
  }

  /**
   * .
   */
  public static void report() {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    System.out.println("Quantidade");
    System.out.println("Número total de pessoas que visitaram o estabelecimento: " + getTotal());
    System.out.println(
        "Número de pessoas menores de 18 anos que visitaram o estabelecimento: " + getMenores());
    System.out
        .println("Número de pessoas adultas (entre 18 e 49 anos) que visitaram o estabelecimento: "
            + getAdultos());
    System.out.println(
        "Número de pessoas a partir de 50 anos que visitaram o estabelecimento: " + getAcimaDe50());
    System.out.println();
    System.out.println("Porcentagem");
    System.out.println(
        "menores: " + decimalFormat.format(((float) getMenores() / getTotal()) * 100) + "%");
    System.out.println(
        "adultas: " + decimalFormat.format(((float) getAdultos() / getTotal()) * 100) + "%");
    System.out.println("a partir de 50: "
        + decimalFormat.format(((float) getAcimaDe50() / getTotal()) * 100) + "%");
  }

  /**
   * param args.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
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
          setMenores(getMenores() + 1);
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (idade <= 49) {
          setAdultos(getAdultos() + 1);
          System.out.println("Pessoa adulta, catraca liberada");
        } else {
          setAcimaDe50(getAcimaDe50() + 1);
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
      } else {
        report();
      }
      option = alternative;
    } while (option != 2);
    scan.close();
  }
}
