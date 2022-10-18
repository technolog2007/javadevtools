package com.shpp.logging;

public class MyMessage {
    String userName;

    public MyMessage(String userName) {
        this.userName = "Привіт " + userName + " !";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
