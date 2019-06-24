package com.math.epidemic.Controller;

import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Services.LocacityService;
import com.math.epidemic.Services.VirusService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;


public class AddVirusController {

    @Autowired
    private VirusService virusService;

    public TextField nameField;
    public TextField stainField;
    public TextField lethalField;
    public TextField influenceField;
    public TextField evol_rateField;
    public TextField enduranceField;
    public TextField cure_rateField;
    public TextField chanceField;



    public void initialize() {
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        Pattern s = Pattern.compile("(\\D*)?");
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!s.matcher(newValue).matches()) nameField.setText(oldValue);
        });
        stainField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!s.matcher(newValue).matches()) stainField.setText(oldValue);
        });
        lethalField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) lethalField.setText(oldValue);
        });
        influenceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) influenceField.setText(oldValue);
        });
        evol_rateField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) evol_rateField.setText(oldValue);
        });
        enduranceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) enduranceField.setText(oldValue);
        });
        cure_rateField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) cure_rateField.setText(oldValue);
        });
        chanceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) chanceField.setText(oldValue);
        });
    }

    public void onAdd(ActionEvent actionEvent) {

        try {
            if (nameField.getText() == null || nameField.getText().trim().isEmpty() || stainField.getText() == null || stainField.getText().trim().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Virus add pane");
                alert.setHeaderText("Результат:");
                alert.setContentText("Ошибка ввода названия или штамма вируса");
                alert.showAndWait();
                return;
            }

            Virus virus = new Virus();
            virus.setName(nameField.getText());
            virus.setStrain(stainField.getText());
            virus.setLethal(Float.parseFloat(lethalField.getText()));
            virus.setInfluence(Float.parseFloat(influenceField.getText()));
            virus.setEvol_rate(Float.parseFloat(evol_rateField.getText()));
            virus.setEndurance(Float.parseFloat(enduranceField.getText()));
            virus.setCure_rate(Float.parseFloat(cure_rateField.getText()));
            virus.setChance(Float.parseFloat(chanceField.getText()));
            virusService.add(virus);
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
        alert.setContentText("Вирусное заболевание успешно добавлено");
        alert.showAndWait();
    }
}