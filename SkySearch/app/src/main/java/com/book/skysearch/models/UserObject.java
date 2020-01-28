package com.book.skysearch.models;

/**
 * Created by Farina Ali
 * hold user data
 */
public class UserObject {

    private String name;
    private String id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String emailId;

    /**
     * used to authenticate user with the system
     */
    public void login(){
        System system = new System();
        system.Authenticate(name,password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param name
     * @param email
     * @param country
     * @param age
     * @param password
     */
    public void signUp(String name,String email,String country,String age,String password){
        //todo : will be used for first time user signup to system's database
    }

    /**
     *
     * @param emailId
     */
    public void deleteAccount(String emailId){
        //todo : make delete account in System class to remove account from database
    }
}
