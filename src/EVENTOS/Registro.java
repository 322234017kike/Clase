package EVENTOS;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Registro<T extends Clave> {
    private HashMap<String, T> elementos;

    public Registro() {
        elementos = new HashMap<>();
    }

    public boolean agregar(T objeto) {
        if (elementos.containsKey(objeto.getClave())) {
            return false;
        }
        elementos.put(objeto.getClave(), objeto);
        return true;
    }

    public T buscar(String clave) {
        return elementos.get(clave);
    }

    public boolean eliminar(String clave) {
        return elementos.remove(clave) != null;
    }

    public Collection<T> obtenerTodos() {
        return elementos.values();
    }

    public int obtenerCantidad() {
        return elementos.size();
    }

    public boolean existe(String clave) {
        return elementos.containsKey(clave);
    }

    public List<T> buscarVarios(String... claves) {
        List<T> encontrados = new ArrayList<>();
        for (String clave : claves) {
            T objeto = elementos.get(clave);
            if (objeto != null) {
                encontrados.add(objeto);
            }
        }
        return encontrados;
    }
}