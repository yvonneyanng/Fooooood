package com.example.fooooood;

public class Client {
    int status;
    String name;
    String number;
    String time;

    public Client(int status, String name, String number, String time) {
        this.status = status;
        this.name = name;
        this.number = number;
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
