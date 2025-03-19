package com.eva.src;

import com.eva.Main;
import com.eva.src.encrypt.Generate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Controller {

    public TextField D;
    public TextField DD;
    public TextField SelectedFileToEncrypt;
    private Scene scene;
    private Stage stage;
    public TextField publicKey;
    public TextField privateKey;


    public void ex(ActionEvent e){
        System.out.println("Exiting.");
        System.exit(0);
    }

    public void FilesD(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            D.setText(selectedFile.getPath());

        } else  {
            System.out.println("D: File not selected");
        }
    }

    public void FilesDD(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            DD.setText(selectedFile.getPath());

        } else  {
            System.out.println("DD: File not selected");
        }
    }

    public void Files(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            SelectedFileToEncrypt.setText(selectedFile.getPath());

        } else  {
            System.out.println("E: File not selected");
        }
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

    public void EncryptFile(){
        //dir in user.home
        String path = System.getProperty("user.home") + File.separator + "EVA";
        File dir = new File(path);
        if(dir.exists()){
            System.out.println(dir + " is already exists.");
        } else if(dir.mkdirs()){
            System.out.println(dir + " was created.");
        } else {
            System.out.println(dir + " was not created.");
        }

        //creating publicKey file
        File publicKeyFile = new File(path + File.separator + publicKey.getText());
        if(publicKeyFile.exists()){
            System.out.println(publicKeyFile + " is already exists.");
        } else if(publicKeyFile.mkdirs()){
            System.out.println(publicKeyFile + " was created.");
        } else {
            System.out.println(publicKeyFile + " was not created.");
        }

        File privateKeyFile = new File(path + File.separator + privateKey.getText());
        if(privateKeyFile.exists()){
            System.out.println(privateKeyFile + " is already exists.");
        } else if(privateKeyFile.mkdirs()){
            System.out.println(privateKeyFile + " was created.");
        } else {
            System.out.println(privateKeyFile + " was not created.");
        }


    }
}
