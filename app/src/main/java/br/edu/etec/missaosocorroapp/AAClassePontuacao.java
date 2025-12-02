package br.edu.etec.missaosocorroapp;

public class AAClassePontuacao {

    private static double total = 0;

    public static void adicionar(double pontos) {
        total += pontos;
    }

    public static double getTotal() {
        return total;
    }

    public static void reset() {
        total = 0;
    }
}
