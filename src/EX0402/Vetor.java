package EX0402;

import java.util.Locale;

public class Vetor {
    private double x, y;

    public Vetor(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private Vetor() {
    }

    public Vetor clone() {
        Vetor v = new Vetor();
        v.x = this.x;
        v.y = this.y;

        return v;
    }

    public String toString() {
        return String.format(Locale.FRANCE, "( %,.2f , %,.2f )", x, y);
    }
}
