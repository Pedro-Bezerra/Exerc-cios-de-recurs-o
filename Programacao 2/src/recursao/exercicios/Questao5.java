package recursao.exercicios;

public class Questao5 {
    public static int somarValores(int n) {
        return n == 1 ? n : n + somarValores(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(somarValores(7));
    }
}
