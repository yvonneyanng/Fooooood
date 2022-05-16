package com.example.fooooood;

public class Menu {
    int Image;
    String Name;
    String Price;

    public Menu(int image, String name, String price) {
        Image = image;
        Name = name;
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
