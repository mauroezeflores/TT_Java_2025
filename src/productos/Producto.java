package productos;

public class Producto {
    private static int contador=1; //Autoincremental, simulando funcionalidad base de datos
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String descripcion;

    public Producto(String nombre, double precio, int stock, String descripcion) {
        this.id = contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("ID: %3d | Nombre: %-20s | Precio: $%8.2f | Stock: %3d",id,nombre,precio,stock);
    }
}
