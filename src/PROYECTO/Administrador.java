package PROYECTO;

import java.util.Map;
import java.util.Scanner;

public class Administrador {
    private String nombreUsuario;
    private String contrasena;
    private Scanner scanner = new Scanner(System.in);

    public Administrador(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public boolean iniciarSesion(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public void menuAdmin(Map<String, Vendedor> vendedores, Map<String, Producto> productos, Map<String, Administrador> admins) {
        while (true) {
            System.out.println("\n--- Menú Admin ---");
            System.out.println("1. Agregar administrador");
            System.out.println("2. Registrar nuevo producto");
            System.out.println("3. Añadir vendedor");
            System.out.println("4. Mostrar productos de venta");
            System.out.println("5. Registrar ventas");
            System.out.println("6. Visualizar conteo de ventas");
            System.out.println("7. Visualizar el conteo de puntos");
            System.out.println("8. Gestionar niveles de fidelización");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarAdministrador(admins);
                    break;
                case 2:
                    Producto.registrarProducto(productos);
                    break;
                case 3:
                    Vendedor.registrarVendedor(vendedores);
                    break;
                case 4:
                    Producto.mostrarProductos(productos);
                    break;
                case 5:
                    RegistroVentas.registrarVenta(vendedores, productos);
                    break;
                case 6:
                    RegistroVentas.visualizarConteoVentas(vendedores);
                    break;
                case 7:
                    RegistroVentas.visualizarPuntosVendedores(vendedores);
                    break;
                case 8:
                    gestionarNiveles(vendedores);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void gestionarNiveles(Map<String, Vendedor> vendedores) {
        while (true) {
            System.out.println("\n--- Gestión de Niveles ---");
            System.out.println("1. Cambiar puntos para nivel Plata");
            System.out.println("2. Cambiar puntos para nivel Oro");
            System.out.println("3. Regresar al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese los nuevos puntos para nivel Plata: ");
                    int nuevosPuntosPlata = scanner.nextInt();
                    NivelesFidelizacion.setPuntosPlata(nuevosPuntosPlata);
                    break;
                case 2:
                    System.out.print("Ingrese los nuevos puntos para nivel Oro: ");
                    int nuevosPuntosOro = scanner.nextInt();
                    NivelesFidelizacion.setPuntosOro(nuevosPuntosOro);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void agregarAdministrador(Map<String, Administrador> admins) {
        System.out.print("Ingrese el nombre de usuario del nuevo administrador: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        if (admins.containsKey(nombreUsuario)) {
            System.out.println("El administrador ya existe.");
            return;
        }

        admins.put(nombreUsuario, new Administrador(nombreUsuario, contrasena));
        System.out.println("Administrador agregado exitosamente.");
    }
}

