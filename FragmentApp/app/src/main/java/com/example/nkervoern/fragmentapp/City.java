package com.example.nkervoern.fragmentapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nkervoern on 18/02/15.
 */
public class City implements Parcelable {
    public String name;
    public String country;
    public int cityCode;
    public double temp;
    public double windSpeed;

    public City(Parcel source) {
        name = source.readString();
        country = source.readString();
        cityCode = source.readInt();
        temp = source.readInt();
        windSpeed = source.readInt();
    }


    public City() {
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
        this.cityCode = (int)Math.random()*(100);
    }

    public City(String name, String country, double temp, double windSpeed) {
        this.country = country;
        this.name = name;
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.cityCode = (int)Math.random()*(100);
    }

    public City(String name, String country, int cityCode, double temp, double windSpeed) {
        this.name = name;
        this.country = country;
        this.cityCode = cityCode;
        this.temp = temp;
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 5;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(country);
        dest.writeInt(cityCode);
        dest.writeDouble(temp);
        dest.writeDouble(windSpeed);
    }

    public static final Creator<City> CREATOR = new Creator<City>()  {

        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
