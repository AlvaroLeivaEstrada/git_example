/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.dao.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fercholeiva
 */
public class DataBaseHandler {
    public Connection getConnection() throws SQLException{

        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("connection data base");
        Connection conn = null;
        String sURL = "jdbc:mysql://localhost:3306/solucion_ejercicio_1";
        conn = DriverManager.getConnection(sURL, "root", "soymillonario512");
        return conn;
    }

    
}
