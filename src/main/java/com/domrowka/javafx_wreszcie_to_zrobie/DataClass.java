package com.domrowka.javafx_wreszcie_to_zrobie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataClass {
    List<Student> studentList = new ArrayList<Student>();
    ClassContainer classes = new ClassContainer();
    static private DataClass instance;
    private DataClass(){
        Student st1 = new Student("Dominik", "Mrowka", StudentCondition.present, 2000);
        Student st2 = new Student("Michal", "Krzemien", StudentCondition.present, 1998);
        studentList.add(st1);
        studentList.add(st2);


        Class cl1 = new Class("PAOIM", 10);
        Class cl2 = new Class("MES", 10);
        Class cl3 = new Class("Programowanie równoległe", 10);

        classes.addClass(cl1);
        classes.addClass(cl2);
        classes.addClass(cl3);

        st1.addSubject(cl1);
        st1.addSubject(cl2);
        List<Double> oc1 = new ArrayList<Double>(Arrays.asList(3.0, 5.0, 4.0));
        st1.grades.put("PAOIM", oc1);
        List<Double> oc2 = new ArrayList<Double>(Arrays.asList(2.0, 5.0, 4.0, 3.5));
        st1.grades.put("MES", oc2);
        st1.classConditionMap.put("PAOIM", ClassCondition.ZAPISANY);
        st1.classConditionMap.put("MES", ClassCondition.ZAPISANY);
    }
    public static DataClass getInstance(){
        if (instance==null){
            instance = new DataClass();
        }
        return instance;
    }
}
