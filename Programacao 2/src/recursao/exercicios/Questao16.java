package recursao.exercicios;

public class Questao16 {
    public static int superFatorialAux(int n, int m) {
        if (m == 1) {
            return 1;
        }
        if (n == 1) {
            return superFatorialAux(m - 1, m - 1);
        }
        return n * superFatorialAux(n - 1, m);
        }

    public static int superFatorial(int n) {
        return superFatorialAux(n, n);
    }

    public static void main(String[] args) {
        System.out.println(superFatorial(5));
    }
}
