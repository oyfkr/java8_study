package interface_change.fir;

public interface Foo {

    void printName();

    /*
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 출력한다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    /*
    * Object가 제공하는 기능은 재정의를 할 수 없다!!
    * 컴파일 에러가 뜸
    default void toString(){

    }
    */

    String getName();
}
