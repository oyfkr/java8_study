package interface_change.sec;

import java.util.*;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();

        name.add("hyeok");
        name.add("son");
        name.add("ezreal");
        name.add("jane");

        //Iterable 기본 메소드
        //foreach
        name.forEach(System.out::println);
        System.out.println("=============");

        //spliterator
        Spliterator<String> spliterators = name.spliterator();
        Spliterator<String> spliterator1 = spliterators.trySplit();
        while (spliterators.tryAdvance(System.out::println));
        System.out.println("=============");
        while (spliterator1.tryAdvance(System.out::println));

        System.out.println("=============");

        //Collection 기본 메소드
        //stream
        Long k = name.stream().map(String::toUpperCase)
                    .filter(s -> s.startsWith("H"))
                    .count();
        System.out.println(k);

        //removeIf
        name.removeIf(s -> s.startsWith("h"));
        name.forEach(System.out::println);
        System.out.println("==============");

        name.add("hyeok");
        //Comparator 기본 메소드
        //reversed
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}
