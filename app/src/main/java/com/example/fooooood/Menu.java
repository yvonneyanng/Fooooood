package com.example.fooooood;

public class Menu {
    private String mealName;
    private String mealPrice;
    private Integer mealImg;

    public Menu(String mealName, String mealPrice, Integer mealImg) {
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.mealImg = mealImg;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Integer getMealImg() {
        return mealImg;
    }

    public void setMealImg(Integer mealImg) {
        this.mealImg = mealImg;
    }
}
