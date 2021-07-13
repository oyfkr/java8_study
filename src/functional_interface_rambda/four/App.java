package functional_interface_rambda.four;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        //static 메소드 레퍼런스
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("근혁"));

        // hello 메소드 레퍼런스스
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("근혁"));

        //매개변수가 없는 생성자 레퍼런스
        Supplier<Greeting> newGreeting = Greeting::new;

        //매개변수가 string인 생성자 래퍼런스
        Function<String,Greeting> greet = Greeting::new;
        Greeting geun = greet.apply("근혁");
        System.out.println(geun.getName());

        String[] name = {"geun","son","kane"};

        Arrays.sort(name,String::compareTo);
        System.out.println(Arrays.toString(name));
    }
}
