import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorRecetas gestor = new GestorRecetas();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n========= MENÚ =========");
            System.out.println("1. Agregar receta");
            System.out.println("2. Buscar receta");
            System.out.println("3. Eliminar receta");
            System.out.println("4. Ver todas las recetas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.println("\n--- Agregar Receta ---");
                    System.out.print("Nombre de la receta: ");
                    String nombre = scanner.nextLine().trim();

                    System.out.print("Ingredientes (separados por coma): ");
                    String[] ingredientes = scanner.nextLine().split(",");
                    for (int i = 0; i < ingredientes.length; i++) {
                        ingredientes[i] = ingredientes[i].trim(); // Limpiar espacios
                    }

                    System.out.print("Instrucciones: ");
                    String instrucciones = scanner.nextLine().trim();

                    Receta nuevaReceta = new Receta(nombre, ingredientes, instrucciones);
                    gestor.agregarReceta(nuevaReceta);
                    System.out.println("✅ Receta agregada exitosamente.");
                    break;

                case "2":
                    System.out.println("\n--- Buscar Receta ---");
                    System.out.print("Nombre de la receta a buscar: ");
                    String nombreBuscar = scanner.nextLine().trim();

                    Receta recetaEncontrada = BuscarRecetas.buscarPorNombre(gestor.obtenerRecetas(), nombreBuscar);

                    if (recetaEncontrada != null) {
                        System.out.println("\n📄 Receta encontrada:");
                        System.out.println("Nombre: " + recetaEncontrada.getNombre());
                        System.out.println("Ingredientes: " + String.join(", ", recetaEncontrada.getIngredientes()));
                        System.out.println("Instrucciones: " + recetaEncontrada.getInstrucciones());
                    } else {
                        System.out.println("❌ Receta no encontrada.");
                    }
                    break;

                case "3":
                    System.out.println("\n--- Eliminar Receta ---");
                    System.out.print("Nombre de la receta a eliminar: ");
                    String nombreEliminar = scanner.nextLine().trim();

                    boolean eliminada = EliminarRecetas.eliminarPorNombre(gestor.obtenerRecetas(), nombreEliminar);
                    if (eliminada) {
                        System.out.println("🗑 Receta eliminada correctamente.");
                    } else {
                        System.out.println("⚠ No se encontró la receta.");
                    }
                    break;

                case "4":
                    System.out.println("\n--- Listado de Recetas ---");
                    List<Receta> todas = gestor.obtenerRecetas();

                    if (todas.isEmpty()) {
                        System.out.println("📭 No hay recetas registradas.");
                    } else {
                        for (Receta r : todas) {
                            System.out.println("- " + r.getNombre());
                        }
                    }
                    break;

                case "5":
                    System.out.println("👋 Gracias por usar el gestor de recetas.");
                    continuar = false;
                    break;

                default:
                    System.out.println("⚠ Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
