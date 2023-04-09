package EX0403.lista;

class No<T> {
    private final T elem;
    private No<T> prox;

    public No(T e, No<T> p) {
        elem = e;
        prox = p;
    }

    public T getElem() {
        return elem;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> o) {
        prox = o;
    }
}