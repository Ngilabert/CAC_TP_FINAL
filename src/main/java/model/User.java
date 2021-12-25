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
public class User {
    private static int id_usuario;
    private String nombre,password;
    private int rol;
    private Sucursal sucursal;
/**    private static int id_usuario;
    private String nombre,password;
    private int rol;
    private Sucursal sucursal;*/
    public User(int id_usuario, String nombre, String password, int rol, Sucursal sucursal) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.sucursal = sucursal;
    }
    public User(int id_usuario, String nombre, String password, int rol, int idSucursal) {
        SucursalDAO sdao = new SucursalDAO();
        
        User.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.sucursal = sdao.getSucursalByID(idSucursal);
    }
    public static int getId_usuario() {
        return id_usuario;
    }
    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    public int getRol() {
        return rol;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
