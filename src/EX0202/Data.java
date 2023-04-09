package EX0202;

public class Data {
    private final int dia, mes, ano;

    public Data(int d,int m,int a) {
        dia=d;
        mes=m;
        ano=a;
    }

    public int get(int e) {
        return switch (e) {
            case 1 -> dia;
            case 2 -> mes;
            case 3 -> ano;
            default -> -1;
        };
    }

    public String getString()
    {
        return Integer.toString(dia)+ "/" + Integer.toString(mes) + '/' + Integer.toString(ano);
    }

}
