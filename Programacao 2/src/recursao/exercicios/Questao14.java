package recursao.exercicios;

public class Questao14 {
    public static int paresOrdemDecrescente(int n) {
        if (n  == 0) {
            System.out.println(n);
            return n;
        } else {
            if (n % 2 == 0) {
                System.out.println(n);
            }
            return paresOrdemDecrescente(n - 1);
        }
    }
    public static void main(String[] args) {
        paresOrdemDecrescente(10);
    }
}
