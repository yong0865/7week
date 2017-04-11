package com.example.yo.a6week;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yo on 2017-04-06.
 */

public class Data implements Parcelable {
    private String name = "";
    private int number = 0;
    private String menu1 = "";
    private String menu2 = "";
    private String menu3 = "";
    private String homepage = "";
    private String date = "";
    private int cata = 1;

    public Data(String name){
        this.name = name;
    }

    protected Data(Parcel in) {
        name = in.readString();
        number = in.readInt();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        homepage = in.readString();
        date = in.readString();
        cata = in.readInt();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getMenu1() {
        return menu1;
    }
    public String getMenu2() {
        return menu2;
    }
    public String getMenu3() {
        return menu3;
    }
    public int getCata() {
        return cata;
    }
    public int getNumber() {
        return number;
    }
    public String getHomepage() {
        return homepage;
    }
    public String getDate() {
        return date;
    }

    public Data(String name, int number, String menu1, String menu2, String menu3, String homepage, String date, int cata) {
        this.name = name;
        this.number = number;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.homepage = homepage;
        this.date = date;
        this.cata = cata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(number);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(homepage);
        dest.writeString(date);
        dest.writeInt(cata);
    }
}

