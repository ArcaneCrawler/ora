package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import com.math.epidemic.Entities.Login;
import com.math.epidemic.Services.LoginService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginController {

    @Autowired
    private LoginService loginService;
    Login loginObject;
    private ObservableList<Login> listLogin = FXCollections.observableArrayList();
    public TextField loginField;
    public PasswordField passField;
    String login;
    String password;
    private Application app = null;

    public void authorization(ActionEvent actionEvent) {

        try {
            login = loginField.getText();
            password = passField.getText();
        } catch (NullPointerException e) {
            nullPointAlert();
        }

        if (login.equals("User") && password.equals(getPassword(1))) {

            app.showMain();
        } else if (login.equals("Admin") && password.equals(getPassword(0))) {

            app.showBase(app);
        } else {
            nullPointAlert();
        }
    }
    String getPassword (int index  ){
        listLogin.addAll(loginService.findAll());
        loginObject = listLogin.get(index);
        return loginObject.getPassword();
    }

    void nullPointAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText("Возникла ошибка");
        alert.setContentText("Неверный логин или пароль");
        alert.showAndWait();
        }

    public void setApp(Application application) {
        this.app = application;
    }
}