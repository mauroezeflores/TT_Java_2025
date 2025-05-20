package productos;


import excepciones.PrecioInvalidoException;
import excepciones.StockInvalidoException;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductoService {

    private ArrayList<Producto> productoList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void agregarProducto()  {
        try{
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            if(precio < 0){
                throw new PrecioInvalidoException("El precio de un producto no puede ser negativo");
            }

            System.out.println("Cantidad de stock: ");
            int stock = Integer.parseInt(scanner.nextLine());

            if(stock < 0){
                throw new StockInvalidoException("El stock de un producto no puede ser negativo");
            }

            System.out.println("Ingrese el descripcion del producto: ");
            String descripcion = scanner.nextLine();

            Producto nuevoProducto = new Producto(nombre, precio, stock, descripcion);
            productoList.add(nuevoProducto);
            System.out.println("Producto agregado correctamente");

        }catch(NumberFormatException e){
            System.out.println("Formato del precio o stock invalidos, ingrese un numero.");
        } catch (PrecioInvalidoException | StockInvalidoException e){
            System.out.println("Error " + e.getMessage());
        }
    }

    public void listarProductos() {
        if(productoList.isEmpty()) {
            System.out.println("No existen productos en la base de datos.");
        }else {
            System.out.println("LISTADO DE PRODUCTOS");
            for(Producto producto: productoList) {
                System.out.println(producto.toString());
            }
        }
    }

    public void modificarProducto() {//Posible implementacion futura, map de productos para mejorar busqueda por ID

        try{
            System.out.println("Ingrese el ID del producto a modificar");
            int id = Integer.parseInt(scanner.nextLine());

            Producto producto = buscarProductoPorId(id);
            if(producto == null) {
                System.out.println("El ID del producto no existe");
                return;
            }

            System.out.println("Producto encontrado: " + producto);

            System.out.println("¿Quiere modificar el precio? Ingrese S para si o N para no");
            String modificarPrecio = scanner.nextLine();

            if(modificarPrecio.equalsIgnoreCase("s")) {
                System.out.println("Ingrece el nuevo precio ");
                double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                if(nuevoPrecio < 0) {
                    throw new PrecioInvalidoException("El nuevo precio no puede ser negativo");
                }else {
                    producto.setPrecio(nuevoPrecio);
                }
            }

            System.out.println("¿Quiere modificar el stock? Ingrese S para si o N para no");
            String modificarStock = scanner.nextLine();

            if(modificarStock.equalsIgnoreCase("s")) {
                System.out.println("Ingrese el nuevo stock");

                int nuevoStock = Integer.parseInt(scanner.nextLine());

                if(nuevoStock < 0) {
                    throw new StockInvalidoException("El nuevo stock no puede ser  negativo");
                }else {
                    producto.setStock(nuevoStock);
                }
            }

            System.out.println("Saliendo de modificar " + producto);

        }catch(NumberFormatException e){
            System.out.println("Debe ingresar un numero valido" + e.getMessage());
        }catch (PrecioInvalidoException | StockInvalidoException e){
            System.out.println("Error " + e.getMessage());
        }
    }

    public void eliminarProducto() {

        try{
            System.out.println("Ingrese el ID del producto a eliminar");
            int id = Integer.parseInt(scanner.nextLine());

            Producto producto = buscarProductoPorId(id);

            if(producto == null) {
                System.out.println("El ID del producto no existe");
                return;
            }

            System.out.println("Esta por eliminar el producto " + producto);
            System.out.println("Escriba SI para confirmar");

            String confirmar = scanner.nextLine();
            if(confirmar.equalsIgnoreCase("si")) {
                productoList.remove(producto);
                System.out.println("El producto ha sido eliminado exitosamente");
            }else {
                System.out.println("El producto no se elimino.");
            }

        }catch(NumberFormatException e){
            System.out.println("Debe ingresar un numero valido" + e.getMessage());
        }
    }

    public Producto buscarProductoPorId(int id){
        for(Producto producto: productoList) {
            if(producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }


}
