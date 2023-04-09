package EX0201;

public class Vetor {
    private double _x, _y;

    public Vetor(double x, double y) {
        _x = x;
        _y = y;
    }

    public double getMod() {
        return Math.sqrt(Math.pow(_x,2.0)+Math.pow(_y,2.0));
    }
}
