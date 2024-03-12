package com;

import com.google.gson.annotations.SerializedName;

public class Pojo_Article {

    @SerializedName("id")
    String id;

    @SerializedName("part_id")
    String partId;

    @SerializedName("title")
    String title;

    @SerializedName("small_description")
    String smallDescription;

    @SerializedName("description")
    String description;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }
    public String getPartId() {
        return partId;
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

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}
