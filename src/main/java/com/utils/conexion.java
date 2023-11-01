/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author administrator
 */
public class conexion {
    
    public Connection conexionBD;
    public final String bd = "tareaAPI";
    public final String urlConexion = String.format("jdbc:mysql://localhost:9906/%s",bd);
    public final String usuario = "root";
    public final String contra = "root";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
          //  JOptionPane.showMessageDialog(null,"Conexion Exitosa.....","Exito",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            System.out.println("Error...."+ ex.getMessage());
            
        }
    }
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error...."+ ex.getMessage());
        }
    }
    
}
