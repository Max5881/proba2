package ru.sapteh.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.SignIn;
import ru.sapteh.Service.SignInService;

import java.io.IOException;
import java.util.List;

public class SignInWindowController {

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button enterButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label status;

    @FXML
    public void initialize() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<SignIn, Integer> signInIntegerDAO = new SignInService(factory);
        List<SignIn> signIns = signInIntegerDAO.readByAll();
        enterButton.setOnAction(event -> {
            for (SignIn signIn : signIns) {
                if (loginTextField.getText().equals(signIn.getLogin())) {
                    if(passwordTextField.getText().equals(signIn.getPassword())){
                        Stage stage = new Stage();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/View/loginWindow.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Image image = new Image("/image/icon.jpg");
                        stage.getIcons().add(image);
                        stage.setTitle("Диплом СПО");
                        stage.setScene(new Scene(root));
                        stage.show();
                        enterButton.getScene().getWindow().hide();
                    }
                }else
                    status.setText("Логин или пороль введен неверно");
            }
        });
        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
        });
    }
}
