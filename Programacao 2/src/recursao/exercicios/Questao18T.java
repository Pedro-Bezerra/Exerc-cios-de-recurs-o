package recursao.exercicios;

public class Questao18T {
    public static int multiplicarRecursivo(int m, int n) {
        if (n == 1) {
            return m;
        } else {
            return m + multiplicarRecursivo(m, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(multiplicarRecursivo(5, 4));
    }
}
