package com.crady;

/**
 * author:Crady
 * date:2019/1/7 17:16
 * desc:
 **/
public class User {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = new User();
        user.setName(this.getName());
        user.setAge(this.getAge());
        return user;
    }
}
