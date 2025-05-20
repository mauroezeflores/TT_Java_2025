package pedidos;

import java.util.ArrayList;

public class Pedido {

    private static int contador = 1;
    private int id;
    private ArrayList<LineaPedido> productosDelPedido;

    public Pedido() {
        this.id = contador++;
        this.productosDelPedido = new ArrayList<LineaPedido>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<LineaPedido> getProductosDelPedido() {
        return productosDelPedido;
    }

    public void setProductosDelPedido(ArrayList<LineaPedido> productosDelPedido) {
        this.productosDelPedido = productosDelPedido;
    }

    public void agregarLinea(LineaPedido linea){
        productosDelPedido.add(linea);
    }

    public double getTotal(){
        double total = 0;
        for(LineaPedido producto: productosDelPedido){
            total += producto.getSubTotal();
        }
        return total;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pedido: ").append(this.id).append("\n");
        for(LineaPedido producto: productosDelPedido){
            sb.append(producto.toString()).append("\n");
        }
        sb.append(String.format("Valor total del pedido: $%.2f", getTotal()));
        return sb.toString();
    }
}
