/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConnectionClass;
import com.sun.xml.ws.transport.tcp.client.ClientConnectionSession;
import entity.citytable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HakanBey
 */
public class citytableDAO {
    public List<citytable> getCityTable()
    {
        List<citytable> clist = new ArrayList();
        ConnectionClass db = new ConnectionClass();
        Connection c = db.Connect();
        
        try {
               Statement st = c.createStatement();
               ResultSet rs = st.executeQuery("select * from citytable");
               while ( rs.next() )
               {
                   citytable tmp = new citytable(rs.getInt("CityId"), rs.getString("CityName"));
                   clist.add(tmp);
               }
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
        return clist;
    }
}
