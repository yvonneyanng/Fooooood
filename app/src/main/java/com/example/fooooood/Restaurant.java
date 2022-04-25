package com.example.fooooood;

public class Restaurant {


    private int id;
    private String name;
    private int image;


    private double score;

    public Restaurant(){
        super();
    }

    public Restaurant(int id,int image,String name,double score){
        super();
        this.id = id;
        this.image = image;
        this.name = name;
        this.score=score;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getScore() {
        return String.valueOf(score);
    }

    public void setScore(double score) {
        this.score = score;
    }

}
