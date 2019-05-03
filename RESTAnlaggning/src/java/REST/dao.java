package REST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class dao {
    
    // Create a formula Sensor with the info that I get from the SQL. First, it connects to my SQL
    public Tempratur getLatestTempSQL() throws ClassNotFoundException, SQLException {
        
        Tempratur t = new Tempratur();
        // Try catch. In case something messes up.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                                            p.getProperty("name"),
                                            p.getProperty("password"));
            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM klimatanlaggning.tempratur ORDER BY created DESC limit 1");
            
            while (res.next()) {
                t.setTemp(res.getInt("temp"));                
                t.setRead(res.getDate("created"));
                }
            
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return t;
    }
    
    public Kostnad getLatestKostnad() throws ClassNotFoundException, SQLException {
        Kostnad k = new Kostnad();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                Properties p = new Properties();
                p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                                            p.getProperty("name"),
                                            p.getProperty("password"));
            
                Statement stmt = con.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM klimatanlaggning.kostnad ORDER BY created DESC limit 1");
            
                while (res.next()) {
                    k.setRead(res.getDate("created"));
                    k.setKr(res.getInt("kr"));
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        return k;
    }
    
    public Forbruk getLatestWatt() throws ClassNotFoundException, SQLException {
        Forbruk f = new Forbruk();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                Properties p = new Properties();
                p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                                            p.getProperty("name"),
                                            p.getProperty("password"));
            
                Statement stmt = con.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM klimatanlaggning.forbrukning ORDER BY created DESC limit 1");
            
                while (res.next()) {
                    f.setRead(res.getDate("created"));
                    f.setWatt(res.getInt("watt"));
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }    
        return f;
    }
    
    public List<Tempratur> getAllTempSQL() {
        List<Tempratur> tempList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                                            p.getProperty("name"),
                                            p.getProperty("password"));
            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM klimatanlaggning.tempratur");
            
            while (res.next()) {
                Tempratur t = new Tempratur();
                t.setTemp(res.getInt("temp"));                
                t.setRead(res.getDate("created"));
                
                tempList.add(t);
                }
            
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return tempList;
    }
    
    public List<Forbruk> getAllWattSQL() {
        List<Forbruk> wattList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                                            p.getProperty("name"),
                                            p.getProperty("password"));
            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM klimatanlaggning.forbrukning");
            
            while (res.next()) {
                Forbruk f = new Forbruk();
                f.setWatt(res.getInt("watt"));                
                f.setRead(res.getDate("created"));
                
                wattList.add(f);
                }
            
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return wattList;
    }
    
    public List<Kostnad> getAllKrSQL() {
        List<Kostnad> krList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                                            p.getProperty("name"),
                                            p.getProperty("password"));
            
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM klimatanlaggning.forbrukning");
            
            while (res.next()) {
                Kostnad k = new Kostnad();
                k.setKr(res.getInt("watt"));                
                k.setRead(res.getDate("created"));
                
                krList.add(k);
                }
            
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return krList;
    }
    
    public void addTemp(Tempratur t) throws FileNotFoundException, IOException, ClassNotFoundException {       
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties p = new Properties();
        p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        try {
            
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO klimatanlaggning.tempratur (temp) VALUES (?)");
            
            stmt.setInt(1, t.getTemp());
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addKr(Kostnad k) throws FileNotFoundException, IOException, ClassNotFoundException {       
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties p = new Properties();
        p.load(new FileInputStream("C:\\Users\\Brekab Åsa Ek\\Documents\\NetBeansProjects\\RESTAnlaggning\\src\\java\\REST\\Settings.properties"));
        try {
            
            Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO klimatanlaggning.kostnad (kr) VALUES (?)");
            
            stmt.setInt(1, k.getKr());
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
