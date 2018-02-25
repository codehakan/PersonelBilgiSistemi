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
public class users {
    private int UserId;
    private String Username;
    private String Password;
    private int UserType;
    private int PersonId;

    public users() {
    }

    public users(int UserId, String Username, String Password, int UserType, int PersonId) {
        this.UserId = UserId;
        this.Username = Username;
        this.Password = Password;
        this.UserType = UserType;
        this.PersonId = PersonId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int PersonId) {
        this.PersonId = PersonId;
    }
    
    
    
}
