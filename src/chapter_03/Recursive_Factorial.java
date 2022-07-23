package chapter_03;

public class Recursive_Factorial {

    public static void main(String[] args) {
        int n = factorial(5);
        System.out.println(n);
    }

    private static int factorial(int x) {
        if (x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }

}
