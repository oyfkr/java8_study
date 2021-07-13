package functional_interface_rambda.third;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run(){
        int baseNumber = 10;

        //로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                System.out.println(baseNumber);
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        //람다
        IntConsumer printInt = (i) ->{
            System.out.println(i+baseNumber);
        };
        /*
        IntConsumer printInt = (baseNumber) ->{
            System.out.println(i+baseNumber);
        };

        */
    }
}
