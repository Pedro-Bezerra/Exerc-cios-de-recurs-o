package recursao.exercicios;

public class Questao30 {
    public static int somarComIncremento(int a, int b) {
        if (b <= 0) {
            return a;
        } else {
            return ++a + somarComIncremento(a, --b);
        }
    }

    public static void main(String[] args) {
        System.out.println(somarComIncremento(3, 2));
    }
}
