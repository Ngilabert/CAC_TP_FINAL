/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import config.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Sucursal;
import model.User;

/**
 *
 * @author nicol
 */
public class SucursalDAO {

    Connection connection;

    public SucursalDAO() {
        DBConn conn = new DBConn();
        connection = conn.getConnection("tpcac", "root", "admin");
    }

    public Sucursal getSucursalByID(int idSucursal) {
        PreparedStatement ps;
        ResultSet rs;
        Sucursal rta = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM locales where id_local = ?");
            ps.setInt(1, idSucursal);

            rs = ps.executeQuery();

            if (rs.next()) {
                rta = new Sucursal(rs.getInt("id_local"), rs.getString("nombre_local"));
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rta;
    }
}
