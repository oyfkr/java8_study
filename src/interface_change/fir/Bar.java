package interface_change.fir;

public interface Bar extends Foo{

    // 기본 메서드로 제공되는 기능을 추상메소드로 바꿔준다
    // 기존의 기능을 수행하지 않음
    void printNameUpperCase();
}
