package com.domrowka.javafx_wreszcie_to_zrobie;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.Collections;


public class Class {
    String name;
    List<Student> studentList = new ArrayList<Student>();
    int maxCount;
    int count=0;

    public String getName(){
        return name;
    }
    public void setName(String nm){
        name = nm;
    }

    public void setMaxCount(int mc){
        maxCount = mc;
    }
    public int getMaxCount(){
        return maxCount;
    }


    public Class(String nameInit, int maxCountInit) {
        name = nameInit;
        maxCount = maxCountInit;
    }

    public Class() {
        name = "New class";
        maxCount = 10;
    }

    public void addStudent(Student student) {
        if(count==maxCount){
            System.err.println("Class capacity at max");
            return;
        }
        for(int i =0; i<studentList.size(); i++) {
            if(student.compareTo(studentList.get(i))==0){
                System.err.println("Student already exists");
                return;
            }
        }
        studentList.add(student);
        count++;
    }

//    public List<String[]> getData(){
//        List<String[]> data = new ArrayList<>();
//        //List<Student> tempList = searchPartial(filter);
//        for (Student name: studentList) {
//            //StudentCondition tempCond = name.condition;
//
//            String[] temp = {name.firstName, name.lastName, String.valueOf(name.points), String.valueOf(name.birthYear), String.valueOf(name.condition)};
//            data.add(temp);
//        }
//        return data;
//    }

//    public List<String[]> getFilteredData(String filter){
//        List<String[]> data = new ArrayList<>();
//        List<Student> tempList = searchPartial(filter);
//        for (Student name: tempList) {
//            String[] temp = {name.firstName, name.lastName, String.valueOf(name.points), String.valueOf(name.birthYear), String.valueOf(name.condition)};
//            data.add(temp);
//        }
//        return data;
//    }

    public void changeCondition(Student student, StudentCondition condition) {
        student.condition = condition;
    }

    public Student search(String firstName, String lastName) {
        for(int i =0; i<studentList.size(); i++) {
            if(firstName.compareTo(studentList.get(i).firstName)==0) {
                if(lastName.compareTo(studentList.get(i).lastName)==0) {
                    return studentList.get(i);
                }
            }
        }
        System.err.println("No such student found");
        return null;
    }

    public List<Student> searchPartial(String line) {
        List<Student> returnList = new ArrayList<Student>();
        for(int i =0; i<studentList.size(); i++) {
            if(studentList.get(i).firstName.contains(line) || studentList.get(i).lastName.contains(line)) {
                returnList.add(studentList.get(i));
            }
        }
        return returnList;
    }

    public int countByCondition(StudentCondition condition) {
        int count = 0;
        for(int i =0; i<studentList.size(); i++) {
            if(studentList.get(i).condition==condition) {
                count++;
            }
        }
        return count;
    }

    public void sortByName() {
        Collections.sort(studentList);
    }


    public Student max() {
        return Collections.max(studentList);
    }
}
