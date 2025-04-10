// BuscarRecetas.java
import java.util.List;

public class BuscarRecetas {
    public static Receta buscarPorNombre(List<Receta> recetas, String nombre) {
        for (Receta r : recetas) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                return r;
            }
        }
        return null;
    }
}
