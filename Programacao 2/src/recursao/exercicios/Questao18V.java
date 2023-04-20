package recursao.exercicios;

public class Questao18V {
    public static boolean isPalindromo(String palavra, int a, int b) {
        if (a == b) {
            return true;
        } else {
            char a_char = palavra.charAt(a);
            char b_char = palavra.charAt(b);
            if (a_char != b_char) {
                return false;
            }
            return isPalindromo(palavra.substring(a + 1, b), a, b - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindromo("oravaoavaro", 0, 10));
    }
}
