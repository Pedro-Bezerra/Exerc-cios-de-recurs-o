package recursao.exercicios;

import java.util.Arrays;

public class Questao24 {
    public static String vetorComEspaco(int[] vetor, String acum) {
        if (vetor.length == 1) {
            return acum + vetor[0];
        } else {
            int[] newVetor = Arrays.copyOfRange(vetor, 1, vetor.length);
            return vetor[0] + " " + acum + vetorComEspaco(newVetor, acum);
        }
    }
    public static void main(String[] args) {
        System.out.println(vetorComEspaco(new int[] {1, 2, 3, 4, 5}, ""));
    }
}
