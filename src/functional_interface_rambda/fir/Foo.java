package functional_interface_rambda.fir;

import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args) {
        int i = 10;

        IntConsumer printInt = (a) -> {
            System.out.println(a+i);
        };


        // 익명 내부 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doit() {
                System.out.println("출력1");
            }
        };

        RunSomething runSomething2 = () -> System.out.println("출력2");

        RunSomething runSomething3 = () -> {
            System.out.println("출력3-1");
            System.out.println("출력3-2");
        };

        runSomething.doit();
        runSomething2.doit();
        runSomething3.doit();
    }
}
