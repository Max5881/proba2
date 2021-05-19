package ru.sapteh;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import ru.sapteh.DAO.DAO;

import ru.sapteh.Model.Fpa;
import ru.sapteh.Model.Status;
import ru.sapteh.Model.Student;
import ru.sapteh.Service.FpaService;
import ru.sapteh.Service.StatusService;
import ru.sapteh.Service.StudentService;

import javax.swing.*;
import java.awt.*;

import static javafx.application.Application.launch;
public class Program extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/signInWindow.fxml"));
        stage.setTitle("Авторизация");
        Image image = new Image("/image/icon.jpg");
        stage.getIcons().add(image);
        stage.setScene(new Scene(root));
        stage.show();

}

    public static void main(String[] args) {
        launch(args);
    }
}
