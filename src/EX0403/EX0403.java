package EX0403;

import EX0403.lista.Lista;
import EX0402.Vetor;

public class EX0403 {
    public static void main(String[] args) {
        Vetor v1 = new Vetor(1, 0);
        Vetor v2 = new Vetor(2, 0);
        Vetor v3 = new Vetor(3, 0);
        Vetor v4 = new Vetor(4, 0);
        Vetor v5 = new Vetor(5, 0);

        Lista<Vetor> lista = new Lista<Vetor>();
        lista.insIni(v3);
        lista.insIni(v2);
        lista.insIni(v1);
        lista.insFin(v4);
        lista.insFin(v5);

        lista.posIni();
        Vetor v = lista.prox();
        while (v != null) {
            System.out.println(v);
            v = lista.prox();
        }

        System.out.println("-----------------------");

        lista.retFin();
        lista.retIni();
        lista.posIni();
        v = lista.prox();
        while (v != null) {
            System.out.println(v);
            v = lista.prox();
        }
    }
}
