package chapter_06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        graph.put("you", new LinkedList<String>(Arrays.asList("alice", "bob", "claire")));
        graph.put("bob", new LinkedList<String>(Arrays.asList("anuj", "peggy")));
        graph.put("alice", new LinkedList<String>(List.of("peggy")));
        graph.put("claire", new LinkedList<String>(Arrays.asList("thom", "jonny")));
        graph.put("anuj", new LinkedList<String>());
        graph.put("peggy", new LinkedList<String>());
        graph.put("thom", new LinkedList<String>());
        graph.put("jonny", new LinkedList<String>());

        LinkedList<String> searched = new LinkedList<String>();

        LinkedList<String> search_queue = new LinkedList<String>(graph.get("you"));
        while (!search_queue.isEmpty()) {
            String person = search_queue.poll();
            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return;
                } else {
                    search_queue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        System.out.println("there is no mango seller!");
    }

    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }
}
