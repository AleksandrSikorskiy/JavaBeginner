package org.example;

import java.sql.*;

public class Mssqltojtable {
//    public static void main(String[] args) {
//        Mssqltojtable guisql = new Mssqltojtable();
//        guisql.go();
//    }
    String mssqlsrv;
    String mssqlport;
    String mssqldatabase;
    String mssqlusrname;
    String mssqlusrpass;
    String sqlqueryitog;
    String connectionUrl;

    public void createsqlurl(String tsvr, String tport, String tbd, String tusr, String tpass) {
        mssqlsrv=tsvr;
        mssqlport=tport;
        mssqldatabase=tbd;
        mssqlusrname=tusr;
        mssqlusrpass=tpass;
        connectionUrl = "jdbc:sqlserver://" + tsvr + ":" + tport + ";databaseName=" + tbd + ";user=" + tusr + ";password=" + tpass;
    }
    public boolean testconnection() {
        boolean conenable;
        conenable = false;
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            conenable = true;
        } catch (SQLException e) {
            conenable = false;
            e.printStackTrace();
        }
        return conenable;
    }

    public String runsqlquery(String sqlquery) {
        String result="";
        try (Connection con = DriverManager.getConnection(connectionUrl);Statement stmt = con.createStatement();) {
            String SQL = sqlquery;
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs != null) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String name = rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i);
                    result += name + "\t";
                }
                result += "\n";
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        result += rs.getString(i) + "\t";
                    }
                }
                result += "\n";
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void go() {
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM [dbo].[ACT_ID_USER]";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString("ID_") + " " + rs.getString("EMAIL_") + " " + rs.getString("FIRST_") + " " + rs.getString("LAST_"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

