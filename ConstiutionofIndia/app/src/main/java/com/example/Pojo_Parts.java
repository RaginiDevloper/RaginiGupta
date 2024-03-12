package com.example;

import com.google.gson.annotations.SerializedName;

public class Pojo_Parts {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("small_description")
    String smallDescription;

    // Add a boolean variable to track selection
    boolean isSelected;

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

    // Implement isSelected() and setSelected() methods
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
