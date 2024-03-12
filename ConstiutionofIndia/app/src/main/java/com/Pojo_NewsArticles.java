package com;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Pojo_NewsArticles  {

        @SerializedName("id")
        String id;

        @SerializedName("title")
        String title;

        @SerializedName("date")
        String date;

        @SerializedName("small_description")
        String smallDescription;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }
}
