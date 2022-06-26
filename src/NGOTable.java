import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NGOTable
{
    public static void main(String[] args)
    {
        String DB_URL = "jdbc:mysql://localhost/";
        final String USER = "root";
        final String PASS = "root";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = "CREATE DATABASE NGO";
            statement.executeUpdate(sql);
            System.out.println("DataBase Successfully created...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            DB_URL +="NGO";
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = conn.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS Donor(Donor_Id VARCHAR(50) NOT NULL PRIMARY KEY,First_Name VARCHAR(50)NOT NULL,Last_Name VARCHAR(50)NOT NULL,age INTEGER,Phone_Number VARCHAR(11)NOT NULL,City VARCHAR(50))";
//            statement.executeUpdate(sql);
//            System.out.println("Created table in given database....");
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DB_URL +="NGO";
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = conn.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS Donor_Send(D_Id INTEGER NOT NULL AUTO_INCREMENT,Item VARCHAR(50)NOT NULL,Amount INTEGER NOT NULL,Send_Location VARCHAR(50)NOT NULL,Donor_Id VARCHAR(50)NOT NULL,PRIMARY KEY(D_Id))";
//            statement.executeUpdate(sql);
//            System.out.println("Created table in given database...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DB_URL +="NGO";
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = conn.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS Needy_People(Needy_Id VARCHAR(50) NOT NULL,First_Name VARCHAR(50)NOT NULL,Last_Name VARCHAR(50)NOT NULL,Age INTEGER,Occupation VARCHAR(50) NOT NULL,Phone_Number VARCHAR(50)NOT NULL,City VARCHAR(55) NOT NULL,PRIMARY KEY(Needy_Id))";
//            statement.executeUpdate(sql);
//            String sql1 = "CREATE TABLE IF NOT EXISTS Needy_Receive(Receive_Id INTEGER NOT NULL AUTO_INCREMENT,Needy_Id VARCHAR(50) NOT NULL,Item VARCHAR(50),Amount VARCHAR(50),Account_Holder_Name VARCHAR(50),Account_Number VARCHAR(50),IFSC_Code VARCHAR(15),Branch_Name VARCHAR(255),Bank_Name VARCHAR(20),UPI_ID VARCHAR(15),Receive_Location VARCHAR(55)NOT NULL,PRIMARY KEY(Receive_Id),FOREIGN KEY(Needy_Id) REFERENCES Needy_People(Needy_Id))";
//            statement.executeUpdate(sql1);
//            System.out.println("Created table in given database...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DB_URL +="NGO";
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = conn.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS volunteer_Info(Volunteer_Id VARCHAR(50)NOT NULL,First_name VARCHAR(55)NOT NULL,Last_name VARCHAR(25)NOT NULL,age INTEGER,Gender VARCHAR(10)NOT NULL,Phone_Number VARCHAR(50)NOT NULL,City VARCHAR(50)NOT NULL,Availability VARCHAR(15)NOT NULL,Work_Location VARCHAR(55)NOT NULL,PRIMARY KEY(Volunteer_Id))";
//            statement.executeUpdate(sql);
//            System.out.println("Created table in given database....");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try
//        {
//            DB_URL +="NGO";
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement statement = conn.createStatement();
//            String sql1 = "CREATE TABLE IF NOT EXISTS Donor_Needy(DonorNeedy_Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,Donor_Id VARCHAR(50) NOT NULL,Needy_Id VARCHAR(50) NOT NULL,FOREIGN KEY(Donor_Id) REFERENCES Donor(Donor_Id),FOREIGN KEY(Needy_Id) REFERENCES Needy_People(Needy_Id))";
//            statement.executeUpdate(sql1);
//            System.out.println("Created table in given database....");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
    }
}
