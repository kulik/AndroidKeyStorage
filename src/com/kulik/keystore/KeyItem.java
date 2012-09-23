package com.kulik.keystore;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 12:40
 */
public class KeyItem implements Parcelable {

    private long mId = -1;
    private String mTitle;
    private String mPassword;
    private String mLogin;
    private String mNote;

//    public static final Parcelable.Creator<KeyItem> CREATOR
//            = new Parcelable.Creator<KeyItem>() {
//        public KeyItem createFromParcel(Parcel in) {
//            return new KeyItem(in);
//        }
//
//        public KeyItem[] newArray(int size) {
//            return new KeyItem[size];
//        }
//    };

    public  KeyItem() {
    }

    public KeyItem(Parcel parcel) {
        mId = parcel.readLong();
        mTitle = parcel.readString();
        mLogin = parcel.readString();
        mPassword = parcel.readString();
        mNote = parcel.readString();
    }

    public KeyItem(long id, String title, String login, String pass, String note) {
        mId = id;
        mTitle = title;
        mLogin = login;
        mPassword = pass;
        mNote = note;
    }

    public KeyItem(long id) {
        mId = id;
    }

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

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeString(mTitle);
        parcel.writeString(mLogin);
        parcel.writeString(mPassword);
        parcel.writeString(mNote);
    }
}
