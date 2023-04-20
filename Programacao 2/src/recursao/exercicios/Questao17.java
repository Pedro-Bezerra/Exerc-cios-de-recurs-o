package recursao.exercicios;

public class Questao17 {
    public static int tetranacci(int n) {
        if (n < 4) {
            return 0;
        } else if (n == 4) {
            return 1;
        } else {
            return tetranacci(n - 4) + tetranacci(n - 3) + tetranacci(n - 2) + tetranacci(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(tetranacci(9));
    }
}
