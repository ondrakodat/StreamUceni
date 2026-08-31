package com.analyzaSkladu.Connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DbConnection {
   private final String url = "jdbc:postgresql://localhost:5432/skladDb";
   private final String username = "postgres";
   String password;

   public Connection pripojSeKDb(){
       try{
           System.out.println("Zadejte heslo k databazi : \n");
           Scanner sc = new Scanner(System.in);
           password = sc.nextLine();
           Connection con = DriverManager.getConnection(url, username, password);

           System.out.println("Pripojeni se zdarilo");

           return con;

       } catch (SQLException e) {
           System.out.println("Pripojeni selhalo");
           e.printStackTrace();
           return null;
       }


   }
}
