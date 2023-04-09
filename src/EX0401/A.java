package EX0401;

public class A {
    int x, y;

    public A() {
        x *= x;
        y *= y;
    }


    public void exibe() {
        System.out.printf("x=%d y=%d", x, y);
    }
}
