/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import entity.personalinfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HakanBey
 */
public class personalinfoDAO {

    public List<personalinfo> getPersonalInfo() {
        List<personalinfo> clist = new ArrayList();
        ConnectionClass db = new ConnectionClass();
        Connection c = db.Connect();
        System.out.println("test");
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select PInfoId,EName,ESurname,SocialSecurityNumber,CitizensShipNumber,Adress,BirthDate,Communication,Gender,MaritalStatus from personalinfo");
            while (rs.next()) {
                //System.out.println(rs.getString("EName"));
                personalinfo tmp = new personalinfo(rs.getInt("PInfoId"), rs.getString("EName"), rs.getString("ESurname"), rs.getString("SocialSecurityNumber"), rs.getString("CitizensShipNumber"), rs.getInt("Adress"), rs.getDate("BirthDate"), rs.getInt("Communication"), rs.getBoolean("Gender"), rs.getInt("MaritalStatus"));
                clist.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public List<personalinfo> searchPersonalName(String userName) {
        List<personalinfo> clist = new ArrayList();
        try {
            ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.Connect().prepareStatement("select PInfoId,EName,ESurname,SocialSecurityNumber,CitizensShipNumber,Adress,BirthDate,Communication,Gender,MaritalStatus from personalinfo where EName = ?");
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                /*System.out.println(rs.getInt("PInfoId"));
                System.out.println(rs.getString("EName"));
                System.out.println(rs.getString("ESurname"));
                System.out.println(rs.getString("SocialSecurityNumber"));
                System.out.println(rs.getString("CitizensShipNumber"));
                System.out.println(rs.getInt("Adress"));
                System.out.println(rs.getDate("BirthDate"));
                System.out.println(rs.getInt("Communication"));
                System.out.println(rs.getBoolean("Gender"));
                System.out.println(rs.getInt("MaritalStatus"));*/
                personalinfo tmp = new personalinfo(rs.getInt("PInfoId"), rs.getString("EName"), rs.getString("ESurname"), rs.getString("SocialSecurityNumber"), rs.getString("CitizensShipNumber"), rs.getInt("Adress"), rs.getDate("BirthDate"), rs.getInt("Communication"), rs.getBoolean("Gender"), rs.getInt("MaritalStatus"));
                clist.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }
    
    public void addPersonal(String EName, String ESurname, String SocialSecurityNumber, String CitizensShipNumber, String Adress, int City, int District, Date BirthDate, String PhoneNumber, String Email, boolean Gender, int MaritalStatus) {
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "insert into personalinfo (EName,ESurname, SocialSecurityNumber,CitizensShipNumber,Adress,BirthDate,Communication,Gender,MaritalStatus) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) connection.Connect().prepareStatement(sorgu);
            ps.setString(1, EName);
            ps.setString(2, ESurname);
            ps.setString(3, SocialSecurityNumber);
            ps.setString(4, CitizensShipNumber);
            ps.setInt(5, addAdress(Adress, City, District));
            ps.setDate(6, BirthDate);
            ps.setInt(7, addCommunication(PhoneNumber, Email));
            ps.setBoolean(8, Gender);
            ps.setInt(9, MaritalStatus);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePersonalInfo(String EName, String ESurname, String SocialSecurityNumber, String CitizensShipNumber, String Adress, int City, int District, Date BirthDate, String PhoneNumber, String  Email, boolean Gender, int MaritalStatus, int PInfoId)
    {
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "UPDATE personalinfo SET EName=?, ESurname=?, SocialSecurityNumber=?,CitizensShipNumber=?, Adress=?, BirthDate=?, Communication=?, Gender=?, MaritalStatus=? where PInfoId=?";
            PreparedStatement ps = (PreparedStatement) connection.Connect().prepareStatement(sorgu);
            ps.setString(1, EName);
            ps.setString(2, ESurname);
            ps.setString(3, SocialSecurityNumber);
            ps.setString(4, CitizensShipNumber);
            ps.setInt(5, updateAdress(Adress, City, District, PInfoId));
            ps.setDate(6, BirthDate);
            ps.setInt(7, updateCommunication(PhoneNumber, Email, PInfoId));
            ps.setBoolean(8, Gender);
            ps.setInt(9, MaritalStatus);
            ps.setInt(10, PInfoId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Hata:"+e.getMessage());
        }
    }
    
    public int addAdress(String Adress, int City, int District) {
        int AdressId = 0;
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "insert into adresstable (Adress,City,District) values(?,?,?)";
            PreparedStatement ps = (PreparedStatement) connection.Connect().prepareStatement(sorgu);
            ps.setString(1, Adress);
            ps.setInt(2, City);
            ps.setInt(3, District);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                AdressId = rs.getInt(1);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return AdressId;
    }
    
    public int updateAdress(String Adress, int City, int District, int AdressId)
    {
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "UPDATE adresstable SET Adress=?, City=?, District=? where AdressId=?";
            PreparedStatement ps = (PreparedStatement) connection.Connect().prepareStatement(sorgu);
            ps.setString(1, Adress);
            ps.setInt(2, City);
            ps.setInt(3, District);
            ps.setInt(4, AdressId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Hata:"+e.getMessage());
        }
        return AdressId;
    }
    
    public int addCommunication(String PhoneNumber, String Email) {
        int communicationId = 0;
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "insert into commtable (PhoneNumber,Email) values(?,?)";
            PreparedStatement ps = (PreparedStatement) connection.Connect().prepareStatement(sorgu);
            ps.setString(1, PhoneNumber);
            ps.setString(2, Email);
            ps.executeUpdate();
            ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                communicationId = rs.getInt(1);
            }
            //System.out.println(communicationId + " iletişim id budur.");
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return communicationId;
    }
    
    public int updateCommunication(String PhoneNumber, String Email, int CommId)
    {
        try {
            ConnectionClass connection = new ConnectionClass();
            String sorgu = "UPDATE commtable SET PhoneNumber=?, Email=? where CommId=?";
            PreparedStatement ps = (PreparedStatement) connection.Connect().prepareStatement(sorgu);
            ps.setString(1, PhoneNumber);
            ps.setString(2, Email);
            ps.setInt(3, CommId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Hata: "+e.getMessage());
        }
        return CommId;
    }

}
