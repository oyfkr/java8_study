package interface_change.fir;

public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("hyeok");
        foo.printName();
        foo.printNameUpperCase();
    }
}
