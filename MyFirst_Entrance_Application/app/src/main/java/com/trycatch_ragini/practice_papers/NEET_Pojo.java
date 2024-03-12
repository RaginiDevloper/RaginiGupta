package com.trycatch_ragini.practice_papers;

import com.google.gson.annotations.SerializedName;

public class NEET_Pojo {

    @SerializedName("id")
    String id;

    @SerializedName("year")
    String year;

    @SerializedName("file")
    String file;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getYear() {
        return year;
    }

    public void setFile(String file) {
        this.file = file;
    }
    public String getFile() {
        return file;
    }


}
