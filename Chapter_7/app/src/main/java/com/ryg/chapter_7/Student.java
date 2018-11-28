package com.ryg.chapter_7;

/**
 * Created by liumeng on 2017/3/24 on 10:57
 */

public class Student {
    public String name;

    @Override
    public boolean equals(Object o) {

        return ((Student)(o)).name.equals(name);
    }

    public int age;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
