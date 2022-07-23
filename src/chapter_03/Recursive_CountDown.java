package chapter_03;

public class Recursive_CountDown {

    public static void main(String[] args) {
        countDown(5);
    }

    private static void countDown(int i) {
        System.out.println(i);
        if (i <= 0) {
            return;
        } else {
            countDown(i - 1);
        }
    }


}
