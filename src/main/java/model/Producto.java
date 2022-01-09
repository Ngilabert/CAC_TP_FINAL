/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.SucursalDAO;

/**
 *
 * @author nicol
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private float precio;
    private int cantidad_stock, cantidad_alerta;
    private Sucursal sucursal;
    SucursalDAO sdao = new SucursalDAO();

    public Producto(int idProducto, String nombreProducto, float precio, int cantidad_stock, int cantidad_alerta, int idSucursal) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.cantidad_alerta = cantidad_alerta;
        this.sucursal = sdao.getSucursalByID(idSucursal);
    }

    public  int getIdProducto() {
        return idProducto;
    }

    public  void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public int getCantidad_alerta() {
        return cantidad_alerta;
    }

    public void setCantidad_alerta(int cantidad_alerta) {
        this.cantidad_alerta = cantidad_alerta;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
    public int getIDSucursal() {
        return Sucursal.getId_sucursal();
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombreProducto=" + nombreProducto + ", precio=" + precio + ", cantidad_stock=" + cantidad_stock + ", cantidad_alerta=" + cantidad_alerta + ", sucursal=" + sucursal.getNombre_sucursal() + '}';
    }
    public void Update(Producto prodUpdate){
        
        this.nombreProducto = prodUpdate.getNombreProducto();
        this.precio = prodUpdate.getPrecio();
        this.cantidad_stock = prodUpdate.getCantidad_stock();
        this.cantidad_alerta = prodUpdate.getCantidad_alerta();
    }
}
