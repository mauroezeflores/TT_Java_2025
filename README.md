# TalentoTech - PreEntrega de Proyecto 

Este proyecto es una mini aplicación de consola desarrollada en Java que permite gestionar productos (crear, listar, modificar, eliminar) y generar pedidos con múltiples productos.


## 📦 Estructura del Proyecto

```plaintext
       src/
        ├── excepciones/
        │   ├── StockInsuficienteException.java
        │   └── PrecioInvalidoException.java
        │   └── StockInvalidoException.java
        │
        ├── productos/
        │   ├── Producto.java
        │   ├── ProductoService.java
        │
        ├── pedidos/
        │   ├── Pedido.java
        │   ├── LineaPedido.java
        │   ├── PedidoService.java
        │
        └── Main.java
