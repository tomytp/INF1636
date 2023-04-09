package EX0404;

public class Voo {
    private Assento[][] assentos;
    private int nFila;
    private int nAssentos;


    public Voo(int nf, int na) {
        char as;
        nFila = nf;
        nAssentos = na;
        assentos = new Assento[nf][na];

        for (int f = 0; f < nf; f++) {
            for (int i = 0; i < na; i++) {
                assentos[f][i] = new Assento(f, (char) (i + 'A'));
            }
        }
    }

    public boolean reserva(int f, char a) {
        Assento temp = assentos[f - 1][a - 'A'];
        boolean estado = temp.getEstado();
        temp.reserva();

        return estado;
    }

    public void imprimeMapa() {
        StringBuilder builder = new StringBuilder("    ");
        for (int i = 0; i < nAssentos; i++) {
            builder.append(" ").append((char) (i + 'A'));
        }
        System.out.println(builder);

        for (int i = 0; i < nFila; i++) {
            builder = new StringBuilder(String.format("%,02d", i + 1));
            builder.append(" -");

            for (int j = 0; j < nAssentos; j++) {
                builder.append(" ");

                char c = assentos[i][j].getEstado() ? 'L' : 'X';
                builder.append(c);
            }

            System.out.println(builder);
        }
    }
}
