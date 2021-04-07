package com.study.appex01;

import java.io.Serializable;

public class BmiDTO implements Serializable {

    private String name;
    private int age;
    private double height;
    private double weight;
    private String bmi;
    private String result;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBmi() {
        return bmi;
    }

    public String getResult() {
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
