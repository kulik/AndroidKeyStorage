package com.kulik.keystore;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class KeyItem {

    private String mTitle;
    private String mPassword;
    private String mLogin;
    private String mNote;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    @Override
    public String toString() {
        return "Title: " + mTitle + "; Login: " + mLogin + "; Pass: " + ((mPassword == null) ? "null" : "***")
                + "; Note: " + mNote;
    }
}
