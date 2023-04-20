package recursao.exercicios;

public class Questao12 {
    public static int ordemDecrescente(int n) {
        if (n == 0) {
            System.out.println(n);
            return n;
        } else {
            System.out.println(n);
            return ordemDecrescente(n - 1);
        }
    }
    public static void main(String[] args) {
        ordemDecrescente(5);
    }
}
