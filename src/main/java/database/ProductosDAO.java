/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import config.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
import model.Sucursal;

public class ProductosDAO {

    Connection connection;

    public ProductosDAO() {
        DBConn conn = new DBConn();
        connection = conn.getConnection("tpcac", "root", "admin");
    }

    public List<Producto> getProductosByIDSucursal(int idSucursal) throws SQLException {
        System.out.println("Inicio busqueda productos por sucursal id= " + idSucursal);
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> productsDB = new ArrayList<>();

        ps = connection.prepareStatement("SELECT * FROM producto where sucursal = ?");
        System.out.println("Query busqueda productos por sucursal id= " + ps);

        ps.setInt(1, idSucursal);
        System.out.println("Query = " + ps);
        rs = ps.executeQuery();

        while (rs.next()) {
            productsDB.add(new Producto(rs.getInt("idproducto"), rs.getString("nombre_producto"), rs.getFloat("precio"), rs.getInt("cantidad_stock"), rs.getInt("cantidad_alerta"), idSucursal));
        }
        rs.close();
        ps.close();
        return productsDB;
    }

    public void venderProducto(int idProducto, int cantVendida) throws SQLException {
        System.out.println("Intento vender producto ID = " + idProducto);
        PreparedStatement ps;
        Producto productoVendido = getProductoByID(idProducto);

        int NvoStock = productoVendido.getCantidad_stock() - cantVendida;
        if (NvoStock < 0) {
            NvoStock = 0;

        }
        ps = connection.prepareStatement("UPDATE producto SET cantidad_stock = ? WHERE idproducto = ?");
        System.out.println("Query = " + ps);

        ps.setInt(1, NvoStock);
        ps.setInt(2, idProducto);
        System.out.println("Query = " + ps);

        ps.executeUpdate();
        ps.close();

    }

    public Producto getProductoByID(int idProducto) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        Producto productDB = null;

        ps = connection.prepareStatement("SELECT * FROM producto where idproducto = ?");
        System.out.println("Query busqueda productos por sucursal id= " + ps);

        ps.setInt(1, idProducto);
        System.out.println("Query = " + ps);
        rs = ps.executeQuery();

        if (rs.next()) {
            productDB = new Producto(rs.getInt("idproducto"), rs.getString("nombre_producto"), rs.getFloat("precio"), rs.getInt("cantidad_stock"), rs.getInt("cantidad_alerta"), rs.getInt("sucursal"));
        }

        rs.close();
        ps.close();

        return productDB;
    }

    public void insertarProducto(Producto producto) throws SQLException {
        PreparedStatement ps;

        ps = connection.prepareStatement("INSERT INTO producto (`nombre_producto`,`precio`,`cantidad_stock`,`cantidad_alerta`,`sucursal`) VALUES (?,?,?,?,?)");
        System.out.println("Query = " + ps);
        ps.setString(1, producto.getNombreProducto());
        ps.setFloat(2, producto.getPrecio());
        ps.setInt(3, producto.getCantidad_stock());
        ps.setInt(4, producto.getCantidad_alerta());
        ps.setInt(5, producto.getIDSucursal());
        System.out.println("Query = " + ps);

        ps.executeUpdate();
        ps.close();

    }

    public void updateProducto(Producto producto) throws SQLException {
        PreparedStatement ps;

        ps = connection.prepareStatement("UPDATE producto SET nombre_producto = ?, precio = ?, cantidad_stock = ?, cantidad_alerta = ? WHERE idproducto = ?");
        System.out.println("Query = " + ps);
        ps.setString(1, producto.getNombreProducto());
        ps.setFloat(2, producto.getPrecio());
        ps.setInt(3, producto.getCantidad_stock());
        ps.setInt(4, producto.getCantidad_alerta());
        ps.setInt(5, producto.getIdProducto());
        System.out.println("Query = " + ps);

        ps.executeUpdate();
        ps.close();

    }

    public void deleteProduct(int  idProducto) throws SQLException {
        PreparedStatement ps;
        ps = connection.prepareStatement("DELETE FROM producto WHERE idproducto = ?");
        System.out.println("Query = " + ps);
        ps.setInt(1,idProducto);
        ps.executeUpdate();
        ps.close();

    }
}
