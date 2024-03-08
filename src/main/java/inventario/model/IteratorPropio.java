package inventario.model;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorPropio<T> implements Iterator {

    private final ArrayList<T> lista;
    private int indice;

    public IteratorPropio(ArrayList<T> lista, int indice){
        this.lista= lista;
        this.indice= indice;
    }
    @Override
    public boolean hasNext() {
        return indice < lista.size();
    }

    @Override
    public T next() {
        T next = lista.get(indice);
        indice++;
        return next;
    }
}
