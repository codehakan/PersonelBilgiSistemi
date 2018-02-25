/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.citytableDAO;
import entity.citytable;
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
public class CityController implements Serializable {

    private List<citytable> clist;
    private citytableDAO cdao;

    public CityController() {
        this.clist = new ArrayList();
        cdao = new citytableDAO();
    }

    public List<citytable> getClist() {
        this.clist = this.getCdao().getCityTable();
        return clist;
    }

    public void setClist(List<citytable> clist) {
        this.clist = clist;
    }

    public citytableDAO getCdao() {
        return cdao;
    }

    public void setCdao(citytableDAO cdao) {
        this.cdao = cdao;
    }


}
