package recursao.exercicios;

public class Questao18U {
    public static String reverterString(String palavra, String acum) {
        if (palavra.length() == 1) {
            acum += palavra.charAt(0);
            return acum;
        } else {
            acum += palavra.charAt(palavra.length() - 1);
            return reverterString(palavra.substring(0, palavra.length() - 1), acum);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverterString("naruto", ""));
    }
}
