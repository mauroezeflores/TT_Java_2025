package pedidos;

import productos.Producto;

public class LineaPedido {
    private Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return cantidad * producto.getPrecio();
    }

    @Override
    public String toString() {
        return String.format("Producto: %s -- Cantidad: %d -- Valor: $%.2f" , producto, cantidad, getSubTotal());
    }
}
