package com.example.projectpkk.Databases;

public class UserHelperClass {

    String fullName, username, email, password, gender, date, phoneNo, level;

    public UserHelperClass(String fullName, String username, String email, String password, String gender, String date, String phoneNo, String level) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.date = date;
        this.phoneNo = phoneNo;
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
