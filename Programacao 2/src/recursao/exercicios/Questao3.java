package recursao.exercicios;

public class Questao3 {
    public static int inverter(int n, int casaDecimal) {
        if (casaDecimal < 10) {
            return n;
        } else {
            int resto = n % 10;
            int numInteiro = n / 10;
            return casaDecimal * resto + inverter(numInteiro, casaDecimal / 10);
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(inverter(-412786, 100000));
        long tempoTotal = System.currentTimeMillis() - time;
        System.out.println("Tempo de processamento em milissegundos: " + tempoTotal);
    }
}

