package recursao.exercicios;

public class Questao10 {
    public static int multiplicarRecursivo(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a + multiplicarRecursivo(a, b - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(multiplicarRecursivo(4, 7));
    }
}
