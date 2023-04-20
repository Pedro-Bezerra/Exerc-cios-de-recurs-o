package recursao.exercicios;

import java.util.Arrays;

public class Questao25 {
    public static int menorValor(int[] vetor) {
        if (vetor.length == 1) {
            return vetor[0];
        } else {
            int acum = vetor[vetor.length - 1];
            int[] newVetor = Arrays.copyOf(vetor, vetor.length - 1);
            if (acum < newVetor[newVetor.length - 1]) {
                newVetor[newVetor.length - 1] = acum;
            }
            return menorValor(newVetor);
        }
    }
    public static void main(String[] args) {
        System.out.println(menorValor(new int[] {2, 5, 6, 3, 9}));
    }
}
