package com.ryg.chapter_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by liumeng on 2017/3/24 on 10:56
 */

public class Test {
    public static void main(String args[]){
        Map<String, Student> map = new HashMap<String, Student>();
        ArrayList<Student> studentsList = new ArrayList<Student>();
        studentsList.add(new Student("马详见", 18));
        studentsList.add(new Student("刘蒙", 25));
        studentsList.add(new Student("小明", 19));
        studentsList.add(new Student("马详见", 18));
//        for (Student student : studentsList) {
//            if (!map.containsKey(student.name)) {
//                map.put(student.name, student);
//            }
//        }
        LinkedHashSet<Student> students = new LinkedHashSet<Student>();
        boolean b = students.addAll(studentsList);
        System.out.println(students);
        for (Student student : students) {
            System.out.println(student.name);
        }
//        System.out.println(map);
    }
}
