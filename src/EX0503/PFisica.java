package EX0503;

public class PFisica extends Contribuinte {
    protected String cpf;

    public PFisica(String n, double r, String c) {
        nome = n;
        rendaBrt = r;
        cpf = c;
    }

    public double calcImposto() {
        double aliquota, deducao;
        if (rendaBrt <= 1400) {
            aliquota = 0;
            deducao = 0;
        } else if (rendaBrt <= 2100) {
            aliquota = 0.1;
            deducao = 100;
        } else if (rendaBrt <= 2800) {
            aliquota = 0.15;
            deducao = 270;
        } else if (rendaBrt <= 3600) {
            aliquota = 0.25;
            deducao = 500;
        } else {
            aliquota = 0.3;
            deducao = 700;
        }
        return rendaBrt * aliquota - deducao;
    }
}

