import Util.ConnectionClass;
import dao.personalinfoDAO;

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
        //test.getPersonalInfo("Hakan");
        
        //test.addPersonal("Hakan","Akkaya","007","500","Sivas Merkez Diriliş Mahallesi",58,0,null,"5457247036","code.hakan@gmail.com",false,2);
        //test.addAdress("Deneme Adres olarak Ekliyorum", 58, 5);
        //test.addCommunication("5457247235", "code.hakan@gmail.com");
        //test.updatePersonalInfo("Hakan","Akkaya","007","500","Sivas Merkez Diriliş Mahallesi",58,0,null,"5457247036","code.hakan@gmail.com",false,2,1);
        test.searchPersonalName("melih kaan");
    }
    
}