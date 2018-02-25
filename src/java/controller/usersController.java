/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.usersDAO;
import entity.users;
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
public class usersController implements Serializable{
    
    private List<users> clist;
    private usersDAO cdao;

    public usersController() {
        this.clist = new ArrayList();
        cdao = new usersDAO();
    }

    public List<users> getClist() {
        this.clist = this.getCdao().getUsers();
        return clist;
    }

    public void setClist(List<users> clist) {
        this.clist = clist;
    }

    public usersDAO getCdao() {
        return cdao;
    }

    public void setCdao(usersDAO cdao) {
        this.cdao = cdao;
    }

    @Override
    public String toString() {
        return "usersController{" + "clist=" + clist + ", cdao=" + cdao + '}';
    }

    
    
    
    
    
}
