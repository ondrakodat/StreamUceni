package com.analyzaSkladu.repository;

import com.analyzaSkladu.Connection.DbConnection;
import main.java.com.analyzaSkladu.entity.Produkt;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduktRepository {


    public List<Produkt> dejProdukty(Connection con){
        if(con != null)
            System.out.println("Pripojeni se zdarilo");

        var sql = "SELECT * FROM PRODUKT";
        List<Produkt> produtky = new ArrayList<>();
        try {
            var statement = con.prepareStatement(sql);
            var result = statement.executeQuery();

            while(result.next()){
                var produkt = new Produkt();

                produkt.setCena(result.getBigDecimal("cena"));
                produkt.setEan(result.getString("ean"));
                produkt.setHmotnost(result.getDouble("hmotnost"));
                produkt.setKategorieId(result.getLong("kategorie_id"));
                produkt.setMinimalniSkladovaneMnozstvi(result.getInt("minimalni_skladovane_mnozstvi"));
                produkt.setNakupniCena(result.getBigDecimal("nakupni_cena"));
                produkt.setNazev(result.getString("nazev"));
                produkt.setPopis(result.getString("popis"));
                produtky.add(produkt);
            }

            for(Produkt p : produtky){
                System.out.println(p.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtky;
    }

    public List<Produkt> filtrovaneProdukty(Connection con, int cena){
        List<Produkt> produkty = dejProdukty(con);
        var filtrovane = produkty
                .stream()
                .filter(produkt -> produkt.getCena().intValue() > cena)
                .toList();
        return filtrovane;
    }

    public List<String> dejNazvy(List<Produkt> produkty){
        return produkty.stream().map(produkt -> produkt.getNazev()).toList();
    }






}
