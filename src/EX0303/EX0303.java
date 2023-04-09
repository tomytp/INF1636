package EX0303;

public class EX0303 {
    public static void main(String[] args) {
        System.out.println(obtemPi(2000000));
    }


    public static double obtemPi(int n) {
        return Matematica.pi(n);
    }
}
