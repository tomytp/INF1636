package EX0302;

public class Xpto {
    private static int contInst;

    public Xpto() {
        contInst++;
    }

    public static int getQtdInst() {
        return contInst;
    }
}
