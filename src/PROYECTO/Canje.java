/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROYECTO;

public class Canje {
    private Vendedor vendedor;
    private Producto producto;

    public Canje(Vendedor vendedor, Producto producto) {
        this.vendedor = vendedor;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Vendedor: " + vendedor.getNombre() +
               ", Producto: " + producto.getNombre();
    }
}
