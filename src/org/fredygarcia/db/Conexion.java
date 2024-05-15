/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fredygarcia.db;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexa
 */
public class Conexion {
    private Connection conexion;
    private static Conexion instancia;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBEasybuy_2023012?useSS=false","root","admin");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (SQLException e){
           e.printStackTrace(); 
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        
        public static Conexion getInstance(){
            if(instancia == null){
                instancia = new Conexion();
            }
            return instancia;
        }
        
        public Connection getConexion(){
            return conexion;
        }
        
        public void setConexion(Connection conexion){
            this.conexion = conexion;
        }
}
