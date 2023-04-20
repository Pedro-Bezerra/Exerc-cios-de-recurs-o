package recursao.exercicios;

public class Questao23 {
    public static int somatorioComIntervalo(int i, int j, int k) {
        if (i == j) {
            return i;
        } else if (i > j) {
            return 0;
        } else {
            return i + somatorioComIntervalo(i + k, j, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(somatorioComIntervalo(1, 10, 2));
    }
}
