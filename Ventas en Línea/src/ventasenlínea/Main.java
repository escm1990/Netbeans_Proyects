package ventasenlínea;

import Clases.Carrito;
import Clases.Producto;

public class Main {

    public static void main(String[] args) {

        Carrito carrito = new Carrito();
        Producto producto1 = new Producto("1", "Producto1", 20, Producto.NUEVO);
        Producto producto2 = new Producto("2", "Producto2", 30, Producto.USADO);
        Producto producto3 = new Producto("3", "Producto3", 50, Producto.USADO);
        Producto producto4 = new Producto("4", "Producto4", 60, Producto.NUEVO);

        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);
        carrito.agregarProducto(producto4);

        carrito.obtenerProducto(0).setNombre("Producto1");
        carrito.cambiarProductos(2, producto4);
        carrito.eliminarProducto(3);

        System.out.println("Productos Agragados: " + carrito.obtenerCantidadProductosAgregados());
        System.out.println("Productos Nuevos: " + carrito.obtenerCantidadProductosNuevos());
        System.out.println("Total: " + carrito.getTotal());

        System.out.println("Codigo\tNombre\tValor\tCondición");
        for (int index = 0; index <= carrito.obtenerCantidadProductosAgregados(); index++) {
            System.out.println(carrito.obtenerProducto(index).toString());
        }
    }
}
