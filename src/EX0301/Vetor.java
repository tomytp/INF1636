package EX0301;

public class Vetor {
    private double x, y;

    public Vetor() {
        x = 0;
        y = 0;
    }

    public Vetor(double x) {
        this.x = x;
        y = 0;
    }

    public Vetor(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void exibe() {
        System.out.printf("X: %.1f, Y: %.1f\n", x, y);
    }

    public void soma(Vetor v) {
        x += v.x;
        y += v.y;
    }

    public static Vetor soma(Vetor v1, Vetor v2) {
        return new Vetor(v1.y + v2.y, v1.x + v2.x);
    }
}
