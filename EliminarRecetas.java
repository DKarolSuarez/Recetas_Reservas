// EliminarRecetas.java
import java.util.List;

public class EliminarRecetas {
    public static void eliminarPorNombre(List<Receta> recetas, String nombre) {
        recetas.removeIf(r -> r.getNombre().equalsIgnoreCase(nombre));
    }
}