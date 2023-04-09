package EX0504;

import EX0402.Vetor;
import EX0403.lista.Lista;
import EX0503.Contribuinte;

public class EX0504 {
    public static void main(String[] args) {
        Contribuinte[] ctrsArray = Contribuinte.listaContr();
        Lista<Contribuinte> ctrsLista = new Lista<Contribuinte>();

        ctrsLista.insIni(ctrsArray[0]);
        ctrsLista.insFin(ctrsArray[1]);
        ctrsLista.insIni(ctrsArray[2]);
        ctrsLista.insFin(ctrsArray[3]);
        ctrsLista.insIni(ctrsArray[4]);
        ctrsLista.insFin(ctrsArray[5]);

        System.out.println("ITERADOR");
        for (Contribuinte ctr : ctrsLista) {
            System.out.printf("%-20s %9.2f\n", ctr.getNome(), ctr.calcImposto());
        }

        System.out.println("\ngetProx()");
        ctrsLista.posIni();
        Contribuinte ctr = ctrsLista.prox();
        while (ctr != null) {
            System.out.printf("%-20s %9.2f\n", ctr.getNome(), ctr.calcImposto());
            ctr = ctrsLista.prox();
        }

    }


}
