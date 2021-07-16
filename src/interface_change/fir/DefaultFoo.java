package interface_change.fir;

public class DefaultFoo implements Foo{

    String name;

    public DefaultFoo(String name){
        this.name = name;
    }

    /*
    *재정의를 할 수도 있음
   @Override
    public void printNameUpperCase(){
        System.out.println(this.name.toUpperCase());
    }
    */

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
