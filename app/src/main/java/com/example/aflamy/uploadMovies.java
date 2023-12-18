package com.example.aflamy;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.Exclude;

public class uploadMovies {
    private String image;
    private String act1Image;
    private String act2Image;
    private String act3Image;
    private String movieName;
    private String country;
    private String rate;
    private String year;
    private String min;
    private String genre1;
    private String genre2;
    private String genre3;
    private String genre4;
    private String desc;
    private String act1;
    private String act2;
    private String act3;
    private String name1;
    private String name2;
    private String name3;


    public String getImage() {
        return image;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getCountry() {
        return country;
    }

    public String getRate() {
        return rate;
    }

    public String getYear() {
        return year;
    }

    public String getMin() {
        return min;
    }

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public String getGenre4() {
        return genre4;
    }

    public String getDesc() {
        return desc;
    }

    public String getAct1() {
        return act1;
    }

    public String getAct2() {
        return act2;
    }

    public String getAct3() {
        return act3;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public String getAct1Image() { return act1Image; }

    public String getAct2Image() { return act2Image; }

    public String getAct3Image() { return act3Image; }

    public uploadMovies() {
    }

    public uploadMovies(String image, String act1Image, String act2Image, String act3Image , String movieName, String country, String rate, String year, String min, String genre1, String genre2, String genre3, String genre4, String desc, String act1, String act2, String act3, String name1, String name2, String name3) {
        this.image = image;
        this.act1Image=act1Image;
        this.act2Image=act2Image;
        this.act3Image=act3Image;
        this.movieName = movieName;
        this.country = country;
        this.rate = rate;
        this.year = year;
        this.min = min;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.genre4 = genre4;
        this.desc = desc;
        this.act1 = act1;
        this.act2 = act2;
        this.act3 = act3;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
    }




}
