package recursao.exercicios;

public class Questao13 {
    public static int paresOrdemCrescente(int n, int acum) {
        if (n == acum) {
            if (acum % 2 == 0) {
                System.out.println(acum);
            }
            return n;
        } else {
            if (acum % 2 == 0) {
                System.out.println(acum);
            }
            return paresOrdemCrescente(n, ++acum);
        }
    }
    public static void main(String[] args) {
        paresOrdemCrescente(10, 0);
    }
}
