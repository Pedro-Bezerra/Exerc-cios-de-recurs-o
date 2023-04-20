package recursao.exercicios;

public class Questao9 {
    public static int contarDigitos(int digito, int k, int acum) {
        if (k < 10) {
            if (digito == k) {
                acum++;
            }
            return acum;
        } else {
            int resto = k % 10;
            int novoK = k / 10;
            if (resto == digito) {
                acum++;
            }
            return contarDigitos(digito, novoK, acum);
        }

    }
    public static void main(String[] args) {
        System.out.println(contarDigitos(1, 280340140, 0));
    }
}
