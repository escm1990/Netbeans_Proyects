package Clases;

public class Carrito {

    private Producto[] productos;
    private double total;

    public Carrito() {
        productos = new Producto[0];
        total = 0.0;

    }

    /**
     * @return the productos
     */
    public Producto[] getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Producto[] productos) {
        this.setProductos(productos);
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public void agregarProducto(Producto producto) {
        Producto[] nuevaLista = new Producto[productos.length + 1];
        System.arraycopy(productos, 0, nuevaLista, 0, productos.length);
        nuevaLista[nuevaLista.length - 1] = producto;
    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.length) {
            Producto[] nuevaLista = new Producto[productos.length - 1];
            System.arraycopy(productos, 0, nuevaLista, 0, index);
            System.arraycopy(productos, index + 1, nuevaLista, index, productos.length - (index + 1));

            total -= productos[index].getValorUnitario();
            productos = nuevaLista;
        }
    }

    public Producto obtenerProducto(int index) {
        if (index < 0 || index >= productos.length) {
            return null;
        } else {
            return productos[index];
        }
    }

    public void cambiarProductos(int index, Producto producto) {
        if (index >= 0 && index <= productos.length) {
            total -= productos[index].getValorUnitario();
            productos[index] = producto;
            total += productos[index].getValorUnitario();
        }
    }

    public int obtenerCantidadProductosNuevos() {
        int contador = 0;
        for (int index = 0; index < productos.length; index++) {
            if (productos[index].getCondicion().compareTo(Producto.NUEVO) == 0) {
                contador++;
            }
        }
        return contador;
    }

    public int obtenerCantidadProductosAgregados() {
        return productos.length;
    }
}
