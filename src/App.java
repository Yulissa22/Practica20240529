import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el ID del producto:");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la marca del producto:");
            String marca = scanner.nextLine();

            System.out.println("Ingrese el precio del producto:");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            Producto producto = new Producto(id, nombre, marca, precio);
            productos.add(producto);

            System.out.println("¿Desea ingresar otro producto? (s/n):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        
        Collections.sort(productos, Comparator.comparingInt(Producto::getId));

        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            System.out.println(producto);
        }

        scanner.close();
    }
}

