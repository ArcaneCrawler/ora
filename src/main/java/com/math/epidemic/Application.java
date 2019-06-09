package com.math.epidemic;

import com.math.epidemic.Controller.AboutLayoutController;
import com.math.epidemic.Controller.AllModelController;
import com.math.epidemic.Controller.BaseController;
import com.math.epidemic.Controller.RootLayoutController;
import javafx.scene.Scene;
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

    private AllModelController mainController = null;
    private AboutLayoutController aboutLayoutController = null;
    private Scene scene = null;
    private RootLayoutController rootLayoutController = null;
    private Stage primaryStage;

    @Value("${ui.title:JavaFX приложение}")//
    private String windowTitle;
    @Autowired
    @Qualifier("mainView")
    private ConfigurationControllers.View viewMain;
    @Autowired
    @Qualifier("aboutView")
    private ConfigurationControllers.View viewAbout;
    @Autowired
    @Qualifier("addLocacityView")
    private ConfigurationControllers.View viewLocacityAdd;
    @Autowired
    @Qualifier("baseView")
    private ConfigurationControllers.View viewBase;

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
        mainController.setApp(this);
        mainController.connect();
    }

    public void showLayoutAbout() {
        setScene(viewAbout, "О программе");
    }

    public void showLayoutAddLocacity() {
        setScene(viewLocacityAdd, "Добавить");
    }

    public void showBase() {
        setScene(viewBase, "База");
        BaseController b = (BaseController) viewBase.getController();
        b.init();
    }

    private void setScene(ConfigurationControllers.View view, String title) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(this.primaryStage);
        if (scene != null) {
            scene.setRoot(view.getView());
        } else {
            scene = new Scene(view.getView());
        }
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        dialogStage.centerOnScreen();
        dialogStage.showAndWait();
    }
}
