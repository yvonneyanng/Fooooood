package com.example.fooooood;

public class Analysis {
    String meal1;
    String meal2;
    String meal3;
    String quant1;
    String quant2;
    String quant3;
    String title;

    public Analysis(String meal1, String meal2, String meal3, String quant1, String quant2, String quant3, String title) {
        this.meal1 = meal1;
        this.meal2 = meal2;
        this.meal3 = meal3;
        this.quant1 = quant1;
        this.quant2 = quant2;
        this.quant3 = quant3;
        this.title = title;
    }

    public String getMeal1() {
        return meal1;
    }

    public String getMeal2() {
        return meal2;
    }

    public String getMeal3() {
        return meal3;
    }

    public String getQuant1() {
        return quant1;
    }

    public String getQuant2() {
        return quant2;
    }

    public String getQuant3() {
        return quant3;
    }

    public String getTitle() {
        return title;
    }
}
