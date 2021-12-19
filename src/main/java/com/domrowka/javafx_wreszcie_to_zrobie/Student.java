package com.domrowka.javafx_wreszcie_to_zrobie;

import javafx.collections.transformation.TransformationList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student>{
    String firstName;
    String lastName;
    StudentCondition condition;
    int birthYear;
    Map<String, Class> classes = new HashMap<>();
    Map<String, List<Double>> grades = new HashMap<>();
    Map<String, ClassCondition> classConditionMap = new HashMap<>();

    public Student(String fN, String lN, StudentCondition con, int bY) {
        firstName=fN;
        lastName=lN;
        condition=con;
        birthYear=bY;
    }

    public Student(){
        firstName="Nowy";
        lastName="Student";
    }

    public void addSubject(Class toaddclass){
        classes.put(toaddclass.name, toaddclass);
    }

    public void addGrade(String classname, double grade){
        List<Double> gradeslist = grades.get(classname);
        gradeslist.add(grade);
    }

    public double meanGrade(String classname){
        double mean = 0;
        List<Double> tempGrades = grades.get(classname);
        for (double i: tempGrades) {
            mean+=i;
        }
        mean/=tempGrades.size();
        return mean;
    }

    public void setFirstName(String nm){
        firstName = nm;
    }

    public void setLastName(String nm){
        lastName = nm;
    }

    public void setCondition(StudentCondition stcnd){
        condition = stcnd;
    }

    public void setBirthYear(int y){
        birthYear = y;
    }

//    public void addPoints(double pts) {
//        points.add(pts);
//    }
//
//    public void removePoints(int index) {
//       points.remove(index);
//    }

    public void print() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Condition: " + condition);
        System.out.println("Birth year: " + birthYear);
//        System.out.println("Points: " + points);
    }

    @Override
    public int compareTo(Student o) {
        int compareNames = lastName.compareTo(o.lastName);
        if(compareNames==0) {
            return firstName.compareTo(o.firstName);
        }
        else {
            return compareNames;
        }
    }

    public void editStudent(){

    }
}
