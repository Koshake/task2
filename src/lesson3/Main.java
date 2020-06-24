package lesson3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // 1
        String [] words = new String[] {
                "apple",
                "cherry",
                "blueberry",
                "banana",
                "apple",
                "orange",
                "pineapple",
                "kiwi",
                "orange",
                "cherry",
                "strawberry",
                "banana"
        };

        Map<String, Integer> wordsCount = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Integer count = wordsCount.getOrDefault(words[i], 0);

            wordsCount.put(words[i], count + 1);
        }

        System.out.println(wordsCount);

        // 2
        Phonebook book = new Phonebook();
        book.add("Ivan", "89217777777");
        book.add("Kate", "89216677885");
        book.add("Bob", "89112345678");
        book.add("Kate", "3456700");
        book.add("Kate", "89296678989");
        book.add("Ivan", "3567821");

        System.out.println("Kate " + book.get("Kate"));
        System.out.println("Bob " + book.get("Bob"));
        System.out.println("Ivan " + book.get("Ivan"));

    }
}
