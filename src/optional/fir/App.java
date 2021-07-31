package optional.fir;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring data jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core",false));
        springClasses.add(new OnlineClass(5,"rest api development",true));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = spring.isPresent();
        boolean present1 = jpa.isPresent();
        System.out.println(present);
        System.out.println(present1);

        //get()을 이용하여 값을 꺼낼 수 있음
        // 값이 있을 경우에는 문제가 없지만 값이 없다면 에러 발생생
        OnlineClass onlineClass = spring.get();
        System.out.println(onlineClass.getTitle());

        //에러 걱정 없이 출력하기
        jpa.ifPresent(oc-> System.out.println(oc.getTitle()));
        spring.ifPresent(oc-> System.out.println(oc.getTitle()));


        //있으면 그 값을 출력, 없으면 매소드 실행 후 그 값을 출력
        // 하지만 있으나 없으나 메소드를 실행함
        OnlineClass jpaclass = jpa.orElse(createNewClass());
        System.out.println(jpaclass.getTitle());

        //있으면 메소드 실행 안하는 경우
        OnlineClass onlineClass1 = spring.orElseGet(App::createNewClass);
        System.out.println(onlineClass1.getTitle());

        //map을 이용할 때
        // value값이 optional이면 복잡해짐
        // 이때 flatmap을 사용하면 좋음
        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);

        Optional<Optional<Progress>> progress1 = spring.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());


        //없을 때 아무것도 넘기지 않고 에러 출력
        OnlineClass onlineClass2 = jpa.orElseThrow(IllegalStateException::new);
        System.out.println(onlineClass2.getTitle());
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10,"New class",false);
    }
}
