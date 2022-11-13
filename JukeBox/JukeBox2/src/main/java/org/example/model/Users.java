package org.example.model;

public class Users {
    private int userId;
    private String userName;
    private String mobileNo;
    private String passwords;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Users(int userId, String userName, String mobileNo, String passwords) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.passwords = passwords;
    }

    public Users() {
    }
}
