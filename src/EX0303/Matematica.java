package EX0303;

public class Matematica {

    public static double pi(int n) {
        double sequenceSum = 0;
        double aux = 1;
        for (int i = 0; i < n; i++) {
            sequenceSum += ((float) 1 / (i * 2 + 1)) * aux;
            aux *= -1;
        }
        return 4 * sequenceSum;
    }
}
