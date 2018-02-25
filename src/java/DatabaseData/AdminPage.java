/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseData;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Syste
 */
@Named(value="DATA.AdminPage")
@SessionScoped
public class AdminPage {
     public int PersonalId = 0;
     public String PersonalName = "", PersonalSurname = "";

    public int getPersonalId() {
        return PersonalId;
    }

    public String getPersonalName() {
        return PersonalName;
    }


    public String getPersonalSurname() {
        return PersonalSurname;
    }

}
