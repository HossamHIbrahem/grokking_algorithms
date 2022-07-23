package chapter_05;

import java.util.HashMap;

public class Hashtable {
    public static void main(String[] args) {
        HashMap<String, Float> book = new HashMap<String, Float>();
        book.put("apple", 0.67F);
        book.put("milk", 1.49F);
        book.put("avocado", 1.49F);
        System.out.println(book);
        System.out.println(book.get("avocado"));

        HashMap<String, Boolean> voted = new HashMap<String, Boolean>();
        check_voter(voted, "tom");
        check_voter(voted, "mike");
        check_voter(voted, "mike");
    }

    private static void check_voter(HashMap<String, Boolean> voted, String name) {
        if (voted.get(name) != null && voted.get(name)) {
            System.out.println("kick them out!");
        } else {
            voted.put(name, true);
            System.out.println("let them vote");
        }
    }
}
