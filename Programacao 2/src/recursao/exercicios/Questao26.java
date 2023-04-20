package recursao.exercicios;

public class Questao26 {
    public static String escreverIntervalo(int i, int j, int k, String acum) {
        if (i == j) {
           return acum + i;
        } else if (i > j) {
            return "";
        } else {
            return i + " " + acum + escreverIntervalo(i + k, j, k, acum);
        }
    }
    public static void main(String[] args) {
        System.out.println(escreverIntervalo(1, 10, 2, ""));
    }
}
