package EX0301;

public class EX0301 {
    public static void main(String[] args) {
        Vetor v1 = new Vetor(3, 4);
        Vetor v2 = new Vetor(7, 6);
        Vetor v3 = Vetor.soma(v1, v2);

        v1.exibe();
        v1.soma(v2);
        v1.exibe();
        v3.exibe();

    }
}
