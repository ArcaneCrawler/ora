package com.math.epidemic;

import com.math.epidemic.Controller.*;
import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Entities.Virus;
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
    private BaseController baseController = null;
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
    @Qualifier("addVirusView")
    private ConfigurationControllers.View viewVirusAdd;
    @Autowired
    @Qualifier("updateVirusView")
    private ConfigurationControllers.View viewVirusUpdate;
    @Autowired
    @Qualifier("addLocacityView")
    private ConfigurationControllers.View viewLocacityAdd;
    @Autowired
    @Qualifier("updateLocacityView")
    private ConfigurationControllers.View viewLocacityUpdate;
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


        mainController.connectVirus();
        //mainController.connectLocacity();
    }

    public void showLayoutAbout() {
        setScene(viewAbout, "О программе");
    }


    public void showAddV() {
        setScene(viewVirusAdd, "Добавить заболевание");
    }

    public void showUpdV(Virus virus) {
        UpdateVirusController updateVirusController = (UpdateVirusController) viewVirusUpdate.getController();
        updateVirusController.setVirus(virus);
        updateVirusController.init();
        setScene(viewVirusUpdate, "Изменить заболевание");
    }

    public void showAddL() {
        setScene(viewLocacityAdd, "Добавить населённый пункт");
        return;
    }

    public void showUpdL(Locacity locacity) {
        UpdateLocacityController updateLocacityController = (UpdateLocacityController) viewLocacityUpdate.getController();
        updateLocacityController.setLocacity(locacity);
        updateLocacityController.init();
        setScene(viewLocacityUpdate, "Изменить населённый пункт");
    }

    public void connectVirus(){
       AllModelController a = (AllModelController) viewMain.getController();
       a.connectVirus();

    }

    public void showBase(Application app) {

        BaseController b = (BaseController) viewBase.getController();
        b.setApp(app);
        b.init();

        setScene(viewBase, "База");
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
