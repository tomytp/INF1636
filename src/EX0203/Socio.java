package EX0203;

public class Socio {
    private String nome;
    private String endereco;
    private String dNasc;
    private int matric;
    public Socio(int x) {
        matric=x;
    }

    public String getMatric(){
        int start = matric / 10;
        int end = matric % 10;

        return Integer.toString(start) + '-' + Integer.toString(end);
    }

}
