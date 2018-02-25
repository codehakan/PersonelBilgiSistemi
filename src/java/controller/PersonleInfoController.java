/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.personalinfoDAO;
import entity.personalinfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author HakanBey
 */
@Named
@SessionScoped
public class PersonleInfoController implements Serializable{
    private List<personalinfo> clist;
    private personalinfoDAO cdao;

    public PersonleInfoController() {
        this.clist = new ArrayList();
        cdao = new personalinfoDAO();
    }

    public List<personalinfo> getClist() {
        this.clist = this.getCdao().getPersonalInfo();
        return clist;
    }

    public void setClist(List<personalinfo> clist) {
        this.clist = clist;
    }

    public personalinfoDAO getCdao() {
        return cdao;
    }

    public void setCdao(personalinfoDAO cdao) {
        this.cdao = cdao;
    }
    
    
}
