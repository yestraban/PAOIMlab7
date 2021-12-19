package com.domrowka.javafx_wreszcie_to_zrobie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    public CheckBox zalogujAdminaCheck;

    private Stage stage;
    private Parent parent;
    private Scene scene;

    @FXML
    public TextField imie;

    @FXML
    public TextField nazw;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onLoginButtonClick(ActionEvent e) throws IOException {
        for (Student std: DataClass.getInstance().studentList) {

          if(Objects.equals(imie.getText(), std.firstName) && Objects.equals(nazw.getText(), std.lastName)){
                FXMLLoader loader = new FXMLLoader(StudentViewController.class.getResource("student-view.fxml"));
                parent = loader.load();
                StudentViewController controller = loader.getController();
                controller.launch(std);

                stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}

