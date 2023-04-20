package recursao.exercicios;

public class Questao15 {
    public static int fatorialDuplo(int n) {
        if (n == 1) {
            return 1;
        } else {
            if (n % 2 == 0) {
                n--;
            }
            return n * fatorialDuplo(n - 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(fatorialDuplo(8));
    }
}
