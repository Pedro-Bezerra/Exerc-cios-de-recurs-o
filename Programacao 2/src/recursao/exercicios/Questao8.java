package recursao.exercicios;

public class Questao8 {
    public static int calcularMDC(int x, int y) {
        return y == 0 ? x : calcularMDC(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(calcularMDC(24, 16));
    }
}
