package EX0502;

public class Container {
    private Poligono lst[] = new Poligono[100];
    private int tam = 0;

    public void addPoligono(Poligono p) {
        lst[tam++] = p;
        p.desenha();
    }
}