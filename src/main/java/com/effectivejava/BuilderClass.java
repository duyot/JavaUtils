package com.effectivejava;

public class BuilderClass {
    private String userName;
    private String password;
    private int age;

    public BuilderClass(String userName) {
        this.userName = userName;
    }

    public BuilderClass setPassword(String password){
        this.password = password;
        return this;
    }

    public BuilderClass setAge(int age){
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "BuilderClass{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        BuilderClass  test = new BuilderClass("duyot").setAge(5).setPassword("abcd1234");
        System.out.println(test.toString());
    }
}
