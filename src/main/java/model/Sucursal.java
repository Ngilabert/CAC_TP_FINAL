/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nicol
 */
public class Sucursal {
        private static int id_sucursal;
        private String nombre_sucursal;

    public Sucursal(int id_sucursal, String nombre_sucursal) {
        this.id_sucursal = id_sucursal;
        this.nombre_sucursal = nombre_sucursal;
    }

    public static int getId_sucursal() {
        return id_sucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }


}
