package recursao.exercicios;

public class Questao11 {
    public static int ordemCrescente(int n, int acum) {
        if (acum == n) {
            System.out.println(acum);
            return n;
        } else {
            System.out.println(acum);
            return ordemCrescente(n, ++acum);
        }
    }
    public static void main(String[] args) {
        ordemCrescente(5, 0);
    }
}
