//package com;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.*;
//
//public class ImportLocation {
//    private static final String jdbcUrl = "jdbc:oracle:thin:@(DESCRIPTION =\\\n" +
//            "   (ADDRESS=(PROTOCOL=TCP)(HOST=10.84.70.116)(PORT = 1521))\\\n" +
//            "   (ADDRESS=(PROTOCOL=TCP)(HOST=10.84.70.116)(PORT=1521))\\\n" +
//            "   (LOAD_BALANCE=yes)\\\n" +
//            "   (CONNECT_DATA=(SERVER=DEDICATED)\\\n" +
//            "\t   (SERVICE_NAME=devmkt)\\\n" +
//            "\t   (FAILOVER_MODE=\\\n" +
//            "\t   (TYPE=SELECT)\\\n" +
//            "\t   (METHOD=BASIC)\\\n" +
//            "\t   (RETRIES = 180)(DELAY = 5)\\\n" +
//            "\t\t)\\\n" +
//            "\t)\\\n" +
//            "   )";
//    public static void main(String[] args) {
//        try ( BufferedReader reader =  new BufferedReader(new FileReader("D:\\province_id.csv"))){
//            String line = reader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                // read next line
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void saveDistrict(int id, int name){
//        CallableStatement cstmt = null;
//        ResultSet rs = null;
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(jdbcUrl, "SMS_ADS", "sms123");
//            String sql = "insert into lba_district(district_id, district_name, province_id) \n " +
//                    " values(1,'abc',2) ";
//            cstmt = conn.prepareCall(sql);
//            cstmt.setInt();
//            int result  = cstmt.executeUpdate();
//            System.out.println("Update result: " + result);
//        } catch (Exception e) {
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) { /* ignored */
//
//                }
//            }
//            if (cstmt != null) {
//                try {
//                    cstmt.close();
//                } catch (SQLException e) { /* ignored */
//
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) { /* ignored */
//
//                }
//            }
//        }
//    }
//
//    public static void saveProvince(int id, int name){
//        try (Connection con = DriverManager.getConnection(jdbcUrl, "SMS_ADS", "sms123")){
//        } catch (SQLException e) {
//
//        }
//
//    }
//}
