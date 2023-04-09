package EX0503;

public class EX0503 {
    public static void main(String[] args) {
        Contribuinte[] lst;
        lst = Contribuinte.listaContr();
        System.out.print("NOME IMPOSTO\n");
        System.out.print("==================== =======\n\n");
        for (Contribuinte ctr : lst) {
            System.out.printf("%-20s %9.2f\n", ctr.nome, ctr.calcImposto());
        }
    }
}