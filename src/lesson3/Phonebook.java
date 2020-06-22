package lesson3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Phonebook {

    private  Map<String, List<String>> book;
    public Phonebook() {
        this.book = new HashMap<>();
    }

    public List<String> get(String name) {
       return book.get(name);
    }

    public void add(String name, String phone) {

        if (book.containsKey(name)) {
            List<String> phones = book.get(name);
            phones.add(phone);
        } else {
            List<String> phones = new LinkedList<>();
            phones.add(phone);
            book.put(name, phones);
        }
    }
}
