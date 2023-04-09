package EX0403.lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T> {
    private int tam = 0;
    private No<T> ini = null;
    private No<T> fin = null;
    private No<T> corr = null;

    public boolean vazio() {
        return tam == 0;
    }

    public void insIni(T x) {
        tam++;

        No<T> node = new No<T>(x, ini);
        if (fin == null) {
            fin = node;
        }
        ini = node;
    }

    public void insFin(T x) {
        tam++;

        No<T> node = new No<T>(x, null);
        if (ini == null) {
            ini = node;
        }

        if (fin != null) {
            fin.setProx(node);
        }

        fin = node;
    }

    public T retIni() {
        if (tam == 0) {
            return null;
        }

        No<T> temp = ini;
        ini = ini.getProx();
        tam--;
        return temp.getElem();
    }

    public T retFin() {
        if (tam == 0) {
            return null;
        }

        No<T> temp = fin;
        fin = null;

        No<T> el = ini;
        if (tam > 1) {
            for (int i = 0; i < tam - 2; i++) {
                el = el.getProx();
            }
            el.setProx(null);
        }

        tam--;
        return temp.getElem();
    }

    public void posIni() {
        corr = ini;
    }

    public T prox() {
        if (corr == null) {
            return null;
        }

        T temp = corr.getElem();
        corr = corr.getProx();

        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaIterator();
    }

    private class ListaIterator implements Iterator<T> {

        private No<T> corr = ini;

        @Override
        public boolean hasNext() {
            return corr != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T dado = corr.getElem();
                corr = corr.getProx();
                return dado;
            }
            throw new NoSuchElementException("No more elements in list");
        }
    }
}