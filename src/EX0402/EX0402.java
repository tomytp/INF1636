package EX0402;

public class EX0402 {
    public static void main(String[] args) {
        Vetor x = new Vetor(10, 20);
        Vetor y = x.clone();
        System.out.println(y.toString());
        System.out.println(x == y);
    }
}
