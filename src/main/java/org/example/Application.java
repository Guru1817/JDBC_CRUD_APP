package org.example;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class Application {
//    static Connection connection = null;
    public static Connection conn = null;
    public static Scanner sc  = new Scanner(System.in);

    public static void main(String[] args) {
        String userName = "root";
        String password = "******";
        String url = "jdbc:mysql://localhost:3306/jdbcDB";

        try {
            conn = DriverManager.getConnection(url , userName, password );
            insert();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private static void insert() throws SQLException{
        int choice;
        do {
            String sql = "insert into friends(name ,mobile_num) values (? , ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            System.out.println("Enter the friend name");
            stat.setString(1 ,sc.nextLine());
            System.out.println("Enter the friend mobile number");
            stat.setLong(2,sc.nextLong());
            sc.nextLine();
            int rows = stat.executeUpdate();
            if (rows > 0){
                System.out.println("record inserted successfully");
            }

            System.out.print("If you want to add more data, press 1 (any other key to exit): ");
            String input = sc.nextLine();
            choice = (input.equals("1")) ? 1 : 0;

        }while (choice == 1);

        System.out.println("Program ended.");
        sc.close();
    }
    private static void read() throws SQLException{
        String sql = "select * from friends";
        PreparedStatement stat = conn.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt(1) + "\t"+rs.getString(2) + " " + rs.getLong(3));
        }
    }
    private static void update() throws SQLException{
        String sql = "update friends set name = ? where mobile_num = ? ";
        PreparedStatement stat = conn.prepareStatement(sql);
        System.out.println("Enter friend new name");
        stat.setString(1,sc.nextLine());
        System.out.println("Enter the mobile number which name going to change");
        stat.setString(2,sc.nextLine());
        int rows = stat.executeUpdate();
        if (rows > 0){
            System.out.println("record inserted successfully");
        }

    }
    private static void delete() throws SQLException{
        String sql = "delete from friends where sl_num = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        System.out.println("Enter the sl number which you want to delete");
        stat.setString(1 ,sc.nextLine());

        int rows = stat.executeUpdate();
        if (rows > 0){
            System.out.println("record inserted successfully");
        }
    }
}

