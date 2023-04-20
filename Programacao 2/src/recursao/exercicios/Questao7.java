package recursao.exercicios;

import java.util.Arrays;

public class Questao7 {
    public static int[] inverterVetor(int[] vetor, int[] acum, int temp) {
        if (vetor.length > 1) {
            int[] vetorMenosUm = Arrays.copyOf(vetor, vetor.length - 1);
            acum[temp] = vetor[vetor.length - 1];
            return inverterVetor(vetorMenosUm, acum, temp + 1);
        } else {
            return acum;
        }
    }

    public static void main(String[] args) {
        int[] acum = new int[100];
        int[] v = new int[100];

        for(int i = 0; i < v.length; v[i] = i++) {
        }

        System.out.println(Arrays.toString(inverterVetor(v, acum, 0)));
    }
}
