package com.analyzaSkladu;

import com.analyzaSkladu.Connection.DbConnection;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        DbConnection dbcon = new DbConnection();
        Connection con = dbcon.pripojSeKDb();
        if(con != null){
            System.out.println("Db funguje ");
        }



    }
}

