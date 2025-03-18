package com.eva.src;

import com.eva.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Controller {

    private Scene scene;
    private Stage stage;

    public void ex(ActionEvent e){
        System.out.println("Exiting.");
        System.exit(0);
    }

    public void Files(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println(selectedFile.getPath());
    }

    public void SwitchToScene2(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Encription-page.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 701, 474);
        stage.setTitle("EVA");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene3(ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Decryption-page.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 701, 474);
        stage.setTitle("EVA");
        stage.setScene(scene);
        stage.show();
    }
}
