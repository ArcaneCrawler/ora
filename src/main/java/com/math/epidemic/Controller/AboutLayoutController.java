package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class AboutLayoutController {
    @FXML
    public ImageView sirView;
    @FXML
    public ImageView sirmView;
    @FXML
    public ImageView sisView;
    @FXML
    public ImageView sirsView;

    public void initialize() {
        File file1 = new File("src/main/resources/SIR.PNG");
        Image image1 = new Image(file1.toURI().toString());
        sirView.setImage(image1);

        File file2 = new File("src/main/resources/SIRM.PNG");
        Image image2 = new Image(file2.toURI().toString());
        sirmView.setImage(image2);

        File file3 = new File("src/main/resources/SIS.PNG");
        Image image3 = new Image(file3.toURI().toString());
        sisView.setImage(image3);

        File file4 = new File("src/main/resources/SIRS.PNG");
        Image image4 = new Image(file4.toURI().toString());
        sirsView.setImage(image4);
    }

    public void setApp(Application application) {
    }
}
