package com.math.epidemic.Controller;

import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Services.LocacityService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

public class AddLocacityController {

    @Autowired
    private LocacityService locacityService;

    public TextField nameField;
    public TextField populationField;
    public TextField contactField;
    public TextField birth_rateField;
    public TextField death_rateField;
    public TextField vaccineField;

    public void initialize() {
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        Pattern s = Pattern.compile("(\\D*)?");
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!s.matcher(newValue).matches()) nameField.setText(oldValue);
        });
        populationField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) populationField.setText(oldValue);
        });
        contactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) contactField.setText(oldValue);
        });
        birth_rateField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) birth_rateField.setText(oldValue);
        });
        death_rateField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) death_rateField.setText(oldValue);
        });
        vaccineField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) vaccineField.setText(oldValue);
        });
    }

    public void onAdd(ActionEvent actionEvent) {

        try {
            if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Locacity add pane");
                alert.setHeaderText("Результат:");
                alert.setContentText("Ошибка ввода имени");
                alert.showAndWait();
                return;
            }

            Locacity locacity = new Locacity();
            locacity.setName(nameField.getText());
            locacity.setPopulation(Integer.parseInt(populationField.getText()));
            locacity.setContact(Float.parseFloat(contactField.getText()));
            locacity.setBirth_rate(Float.parseFloat(birth_rateField.getText()));
            locacity.setDeath_rate(Float.parseFloat(death_rateField.getText()));
            locacity.setVaccine(Float.parseFloat(vaccineField.getText()));
            locacityService.add(locacity);
        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Locacity add pane");
            alert.setHeaderText("Результат:");
            alert.setContentText("Ошибка ввода коэффициентов");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Locacity add pane");
        alert.setHeaderText("Результат:");
        alert.setContentText("Населённый пункт успешно добавлен");
        alert.showAndWait();


    }


}
