package co.edu.udec.modelo;

import java.time.LocalDate;

public class CompraCliente {

    // Atributos de la compra
    private int numeroCompra;
    private String nombreCliente;
    private LocalDate fechaCompra;
    private int cantidadProductos;
    private double totalCompra;
    private String estado;

    // Constructor
    public CompraCliente(int numeroCompra, String nombreCliente, LocalDate fechaCompra, int cantidadProductos,
            double totalCompra, String estado) {
        this.numeroCompra = numeroCompra;
        this.nombreCliente = nombreCliente;
        this.fechaCompra = fechaCompra;
        this.cantidadProductos = cantidadProductos;
        this.totalCompra = totalCompra;
        this.estado = estado;
    }

    // Metodos GET
    public int getNumeroCompra() {
        return numeroCompra;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public String getEstado() {
        return estado;
    }

    // Metodos SET
    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Representacion del objeto
    @Override
    public String toString() {
        return "CompraCliente{" +
        "numeroCompra=" + numeroCompra +
        ", nombreCliente='" + nombreCliente + '\'' +
        ", fechaCompra=" + fechaCompra +
        ", cantidadProductos=" + cantidadProductos +
        ", totalCompra=" + totalCompra +
        ", estado='" + estado + '\'' +
        '}';
    }

    // Comparacion mediante el numero de compra
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CompraCliente)) {
            return false;
        }

        return numeroCompra == ((CompraCliente) obj).numeroCompra;
        
    }
    
}
