/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author administrator
 */
public class ejecutar {
    
    public boolean ejecutarQuery(String query){
    
        
        try{
            PreparedStatement st;
            ResultSet rs;
            
            conexion con = new conexion();
            con.abrir_conexion();
            
            st = (PreparedStatement) con.conexionBD.prepareStatement(query);
            st.executeUpdate();
            con.cerrar_conexion();
           // JOptionPane.showMessageDialog(null, "Operacion realizada con éxito");
            return true; 
             
            
        } catch(SQLException ex){
        
            System.out.println(ex.toString());
            return false;
        }
    }
    
    
    
    
    
      public  ResultSet ejecutarQuery2(String query){
    
         ResultSet rs = null;
         conexion con = new conexion();
        try{
            PreparedStatement st;
            
            con.abrir_conexion();
            
            st = (PreparedStatement) con.conexionBD.prepareStatement(query);
            rs = st.executeQuery();
           // JOptionPane.showMessageDialog(null, "Operacion realizada con éxito");
            return rs;
            
         
            
        } catch(SQLException ex){
        
            System.out.println(ex.toString());
              
            
            }
        con.cerrar_conexion();
        return rs;
        
        
    }

}
