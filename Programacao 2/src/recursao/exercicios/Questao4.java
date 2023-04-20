package recursao.exercicios;

import java.util.Arrays;

public class Questao4 {
    public static int somarVetor(int[] vetor) {
        if (vetor.length == 1) {
            return vetor[0];
        } else {
            int[] novoVetor = Arrays.copyOf(vetor, vetor.length - 1);
            return vetor[vetor.length - 1] + somarVetor(novoVetor);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{11, 3, 7, 0, 9, 6, 42};
        System.out.println(somarVetor(array));
    }
}
