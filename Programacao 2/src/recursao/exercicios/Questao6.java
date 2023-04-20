package recursao.exercicios;

public class Questao6 {
    public static int exponenciar(int k, int n) {
        return n == 1 ? k : k * exponenciar(k, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(exponenciar(2, 10));
    }
}
