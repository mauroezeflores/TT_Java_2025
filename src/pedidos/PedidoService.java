package pedidos;

import productos.Producto;
import productos.ProductoService;
import excepciones.StockInsuficienteException;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void crearPedido(ProductoService productoService) {
        Pedido pedido = new Pedido();
        boolean flagPedido = true;

        try{
            while(flagPedido){
                System.out.println("Ingrese el ID de producto");

                String inputId = scanner.nextLine();
                int idProducto;

                try{
                    idProducto = Integer.parseInt(inputId);
                }catch(NumberFormatException e){
                    System.out.println("El ID debe ser un numero entero");
                    return;
                }

                Producto producto = productoService.buscarProductoPorId(idProducto);
                if(producto == null){
                    System.out.println("No se encontro el producto");
                    return;
                }

                System.out.println("Ingrese la cantidad de " + producto.getNombre() + " deseada");
                String intputCantDeseada = scanner.nextLine();
                int cantidadDeseada;

                try{
                    cantidadDeseada = Integer.parseInt(intputCantDeseada);
                }catch(NumberFormatException e){
                    System.out.println("El stock debe ser un numero entero");
                    return;
                }

                if(producto.getStock() < cantidadDeseada){
                    throw new StockInsuficienteException("Stock insuficiente del producto " + producto.getNombre());
                }

                LineaPedido linea = new LineaPedido(producto, cantidadDeseada);
                pedido.agregarLinea(linea);
                producto.setStock(producto.getStock() - cantidadDeseada);

                System.out.println("¿Desea seguir agregando productos? S/N");
                String seguirAgregando = scanner.nextLine();

                if(seguirAgregando.equalsIgnoreCase("n")) {
                    flagPedido = false;
                    System.out.println("Saliendo..");
                }
            }

            pedidos.add(pedido);
            System.out.println("Pedido agregado exitosamente");
            System.out.println(pedido);

        }catch (StockInsuficienteException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listarPedidos(){
        if(pedidos.isEmpty()){
            System.out.println("No hay pedidos en el sistema");
        }else {
            System.out.println("LISTADO DE PEDIDOS");
            for(Pedido pedido : pedidos){
                System.out.println(pedido);
                System.out.println("********************");
            }
        }
    }

}
