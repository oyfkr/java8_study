package functional_interface_rambda.sec;

import java.util.function.Function;

public class Foo {
    public static void main(String[] args) {
        Function<Integer,Integer> plus10 = (i) -> i+10;
        System.out.println(plus10.apply(1));

        Function<Integer,Integer> mul2 = (i) -> i*2;
        System.out.println(mul2.apply(1));

        System.out.println(plus10.compose(mul2).apply(2));
        System.out.println(plus10.andThen(mul2).apply(2));

        Runnable run = ()-> System.out.println("asd");
        run.run();

    }

}
