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
import model.Sucursal;
import model.User;

public class UserDAO {

    Connection connection;

    public UserDAO() {
        DBConn conn = new DBConn();
        connection = conn.getConnection("tpcac", "root", "admin");
    }

    public List<User> getUsers(int limit) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        List<User> usersDB = new ArrayList<>();

        ps = connection.prepareStatement("SELECT * FROM usuario");

        rs = ps.executeQuery();

        while (rs.next()) {
            usersDB.add(new User(rs.getInt("idUsuario"), rs.getString("nombre_usuario"), rs.getString("password_usuario"), rs.getInt("rol"), new Sucursal(1, "25 de mayo")));
        }

        rs.close();
        ps.close();
        connection.close();

        return usersDB;
    }

    public boolean login(String username, String password) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        System.out.println(username + ":" + password);
        ps = connection.prepareStatement("SELECT nombre_usuario, password_usuario FROM usuario WHERE nombre_usuario = ? AND password_usuario = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        //System.out.println(rs.getInt("nombre_usuario")+ "-" + rs.getString("password_usuario"));
         return rs.next();
  
    }
}
