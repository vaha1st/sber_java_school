package com.sber.reflection;

public class MyClass {
    private int number;
    private String name = "default";

    public MyClass(){}
    private MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    private void printData(){
        System.out.println(number + name);
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @SuppressWarnings("unchecked")
    public void getUniqueCatName() {
    }
}