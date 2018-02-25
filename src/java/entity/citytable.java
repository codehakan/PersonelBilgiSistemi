/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HakanBey
 */
public class citytable {
    private int CityId;
    private String CityName;

    public citytable() {
    }

    public citytable(int CityId, String CityName) {
        this.CityId = CityId;
        this.CityName = CityName;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    @Override
    public String toString() {
        return "citytable{" + "CityId=" + CityId + ", CityName=" + CityName + '}';
    }
    
    
}
