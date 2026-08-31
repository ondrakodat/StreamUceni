package com.analyzaSkladu;

import com.analyzaSkladu.Connection.DbConnection;
import com.analyzaSkladu.repository.ProduktRepository;
import main.java.com.analyzaSkladu.entity.Produkt;

import java.sql.*;

public class Main {
    static void main() {
        DbConnection dbcon = new DbConnection();
        Connection con = dbcon.pripojSeKDb();
        if(con != null){
            System.out.println("Db funguje ");
        }

        ProduktRepository rep = new ProduktRepository();
        rep.dejProdukty(con);

        var filtr = rep.filtrovaneProdukty(con, 5000);

        System.out.println("Filtrovane produkty \n");
        for (Produkt p : filtr){
            System.out.println(p.toString());
        }
        System.out.println("Nazvy filtrovanych produktu \n");
        for (String nazev : rep.dejNazvy(filtr)){
            System.out.println(nazev);
        }




    }
}

