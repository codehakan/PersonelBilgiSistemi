
import Util.ConnectionClass;
import dao.personalinfoDAO;
import dao.usersDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HakanBey
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionClass db = new ConnectionClass();
        db.Connect();
        personalinfoDAO test = new personalinfoDAO();
        test.getPersonalInfo();
        
        usersDAO test1 = new usersDAO();
        test1.getUsers("hakan");
    }
    
}
