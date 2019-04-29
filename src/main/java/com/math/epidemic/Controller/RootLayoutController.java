package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class RootLayoutController {

    private Application app = null;

    public void clickAbout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The Epidemic Modeling");
        alert.setHeaderText("About program");
        alert.setContentText("Author: Ilya Rodionov\nGroup # 455\nSaint-Petersburg State Institute of Technology\n2018-2019");
        alert.showAndWait();

    }

    public void clickReadme(ActionEvent actionEvent) {
        app.showLayoutAbout();
    }

    public void initialize() {

    }

    public void setApp(Application application) {
        this.app = application;
    }
}
