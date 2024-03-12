package com;

public class Notes {

    private String title;
    private String content;


    public void Note(){

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public void Note(String title, String content){
        this.title = title;
        this.content = content;
    }

}
