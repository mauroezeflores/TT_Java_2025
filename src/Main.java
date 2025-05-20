import java.util.Scanner;
import pedidos.PedidoService;
import productos.ProductoService;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService();

        int opcion;

        do{
            System.out.println("\n===== MENÚ DE PRODUCTOS =====");
            System.out.println("1. Crear Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Modificar Productos");
            System.out.println("4. Eliminar Productos");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Salir");

            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion){
                case 1 -> productoService.agregarProducto();
                case 2-> productoService.listarProductos();
                case 3-> productoService.modificarProducto();
                case 4-> productoService.eliminarProducto();
                case 5-> pedidoService.crearPedido(productoService);
                case 6-> pedidoService.listarPedidos();
                case 7-> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida");
            }

        }while(opcion!=7);

        scanner.close();
    }
}