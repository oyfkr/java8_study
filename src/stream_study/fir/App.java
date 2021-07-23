package stream_study.fir;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("son");
        names.add("kane");
        names.add("pogba");
        names.add("mata");

        // 스트림은 데이터가 아닌 데이터의 흐름이라고 생각할 수 있다.

        // stream을 이용해도 원래 names의 값은 변하지 않는다. -> funtional in nature
        Stream<String> name1 = names.stream().map(String::toUpperCase);

        //map은 중개 오퍼레이션 -> 출력 x -> 종료형 오퍼레이터가 없다면 map을 시작을 안함
        // 밑에를 실행하면 한번만 맨 마지막 출력문만 실행됨
        names.stream().map((s)->{
            System.out.println(s);
            return s.toUpperCase();
        });
        System.out.println("==================");
        names.forEach(System.out::println);

        System.out.println("===종료형 오퍼레이션 사용 후===");
        // 종료형 오퍼레이션(Collections)를 사용할 경우 map 실행
        List<String> collect = names.stream().map((s)->{
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("===대문자로 바뀐거 확인===");
        //대문자로 바뀐 것도 확인할 수 있다.
        collect.forEach(System.out::println);

        // 병럴처리
        List<String> collect1 = names.parallelStream().map((s)->{
            System.out.println(s+" " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect1.forEach(System.out::println);
    }
}
