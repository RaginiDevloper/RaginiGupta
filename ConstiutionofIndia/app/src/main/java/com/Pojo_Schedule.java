package com;

import com.google.gson.annotations.SerializedName;

public class Pojo_Schedule {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("small_description")
    String smallDescription;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }
    public String getSmallDescription() {
        return smallDescription;
    }

}

