package com.math.epidemic;

import com.math.epidemic.Controller.AboutLayoutController;
import com.math.epidemic.Controller.AllModelController;
import com.math.epidemic.Controller.RootLayoutController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {

    AllModelController mainController = null;
    AboutLayoutController aboutLayoutController = null;
    RootLayoutController rootLayoutController = null;
    private Stage primaryStage;
    private AnchorPane rootLayout;
    @Value("${ui.title:JavaFX приложение}")//
    private String windowTitle;
    @Autowired
    @Qualifier("mainView")
    private ConfigurationControllers.View viewMain;
    @Autowired
    @Qualifier("aboutView")
    private ConfigurationControllers.View viewAbout;

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle(windowTitle);
        this.primaryStage.setScene(new Scene(viewMain.getView()));
        this.primaryStage.setResizable(false);
        this.primaryStage.centerOnScreen();
        this.primaryStage.show();
        mainController = (AllModelController) viewMain.getController();
        rootLayoutController = (RootLayoutController) viewMain.getRootController();
        rootLayoutController.setApp(this);
        /*aboutLayoutController = (AboutLayoutController) viewAbout.getController();
        aboutLayoutController.setApp(this);*/
        mainController.setApp(this);
    }

    public void showLayoutAbout() {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("ABOUT");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(viewAbout.getView());
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        dialogStage.centerOnScreen();
        dialogStage.showAndWait();
    }

}
