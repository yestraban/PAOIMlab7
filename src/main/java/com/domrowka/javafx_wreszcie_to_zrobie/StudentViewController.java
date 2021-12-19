package com.domrowka.javafx_wreszcie_to_zrobie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StudentViewController {
    @FXML
    public ComboBox<String> subjectCombo;
    @FXML
    public TextField meanTextField;
    @FXML
    public Button wypiszButton;
    @FXML
    public Button zapiszButton;
    @FXML
    public ListView<Double> listview;
    @FXML
    public TextField conditionTextField;
    @FXML
    public Button zmienButton;
    @FXML
    public ComboBox<String> allSubjectsCombo;
    @FXML
    public Button przepiszButton;
    @FXML
    public TextField stdStatusTextBox;
    @FXML
    public ComboBox<StudentCondition> chooseStdCond;

    Student currentStudent;
    public void launch(Student std){
        currentStudent = std;
        subjectCombo.setItems(FXCollections.observableArrayList(currentStudent.classes.keySet()));
        allSubjectsCombo.setItems(FXCollections.observableArrayList(DataClass.getInstance().classes.classes.keySet()));
        stdStatusTextBox.setText(String.valueOf(currentStudent.condition));
        chooseStdCond.setItems(FXCollections.observableArrayList(StudentCondition.values()));
    }

    public void subjectChange(ActionEvent e){
        String item = subjectCombo.getValue();
        listview.setItems(FXCollections.observableArrayList(currentStudent.grades.get(item)));
        double mean = currentStudent.meanGrade(subjectCombo.getValue());
        meanTextField.setText(String.valueOf(mean));
        conditionTextField.setText(String.valueOf(currentStudent.classConditionMap.get(subjectCombo.getValue())));
    }

    public void changeStudentCondition(ActionEvent e){
        currentStudent.condition = chooseStdCond.getValue();
        stdStatusTextBox.setText(String.valueOf(currentStudent.condition));
    }

    public void setPrzepiszButton(){
        currentStudent.classConditionMap.put(subjectCombo.getValue(), ClassCondition.PRZEPISANY);
        conditionTextField.setText(String.valueOf(currentStudent.classConditionMap.get(subjectCombo.getValue())));
    }

    public void setWypiszButton(){
        currentStudent.classConditionMap.put(subjectCombo.getValue(), ClassCondition.WYPISANY);
        conditionTextField.setText(String.valueOf(currentStudent.classConditionMap.get(subjectCombo.getValue())));
    }

    public void setZapiszButton(){
        String name = allSubjectsCombo.getValue();
        Class cll = DataClass.getInstance().classes.classes.get(name);
        if(currentStudent.classes.get(cll.name)==cll){
            if (currentStudent.classConditionMap.get(cll.name)==ClassCondition.WYPISANY){
                currentStudent.classConditionMap.put(cll.name, ClassCondition.ZAPISANY);
                conditionTextField.setText(String.valueOf(currentStudent.classConditionMap.get(subjectCombo.getValue())));
            }
            if (currentStudent.classConditionMap.get(cll.name)==ClassCondition.PRZEPISANY){
                currentStudent.classConditionMap.put(cll.name, ClassCondition.ZAPISANY);
                conditionTextField.setText(String.valueOf(currentStudent.classConditionMap.get(subjectCombo.getValue())));
            }
        }
        else {
            currentStudent.classes.put(cll.name, cll);
            currentStudent.classConditionMap.put(cll.name, ClassCondition.ZAPISANY);
            currentStudent.grades.put(cll.name, new ArrayList<>());
            subjectCombo.setItems(FXCollections.observableArrayList(currentStudent.classes.keySet()));

        }
    }
}
