package com.math.epidemic;

import com.math.epidemic.Controller.AboutLayoutController;
import com.math.epidemic.Controller.AddLocacityController;
import com.math.epidemic.Controller.AllModelController;
import com.math.epidemic.Controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Configuration
public class ConfigurationControllers {

    @Autowired
    private Environment env;
    private AnchorPane mainLayout;
    private BorderPane rootLayout;

    /*@Bean(name = "mainView")
    public View getMainView() throws IOException {
        return loadView("View/Main.fxml");
    }*/

    @Bean(name = "mainView")
    public View getMainView() throws IOException {
        return loadViewWithRoot("View/RootLayout.fxml", "View/AllModel.fxml");
    }

    @Bean(name = "aboutView")
    public View getAboutView() throws IOException {
        return loadView("View/AboutLayout.fxml");
    }


    @Bean(name = "addLocacityView")
    public View getAddLocacityView() throws IOException {
        return loadView("View/AddLocacityLayout.fxml");
    }

    @Bean(name = "baseView")
    public View getBaseView() throws IOException {
        return loadView("View/BaseLayout.fxml");
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        System.out.println("## DataSource1: " + dataSource);
        return dataSource;
    }

    /**
     * Именно благодаря этому методу мы добавили контроллер в контекст спринга,
     * и заставили его произвести все необходимые инъекции.
     */
    @Bean
    public AllModelController getMainController() throws IOException {
        return (AllModelController) getMainView().getController();
    }

    @Bean
    public AboutLayoutController getAboutController() throws IOException {
        return (AboutLayoutController) getAboutView().getController();
    }

    @Bean
    public AddLocacityController getAddLocacityController() throws IOException {
        return (AddLocacityController) getAddLocacityView().getController();
    }


    @Bean
    public BaseController getBaseController() throws IOException {

        return (BaseController) getBaseView().getController();
    }

    /**
     * Самый обыкновенный способ использовать FXML загрузчик.
     * Как раз-таки на этом этапе будет создан объект-контроллер,
     * произведены все FXML инъекции и вызван метод инициализации контроллера.
     */
    public View loadView(String url) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader();
            InputStream fxmlStream = null;
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            mainLayout = loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public View loadViewWithRoot(String urlRoot, String urlSecondary) throws IOException {

        try {
            FXMLLoader rootLoader = new FXMLLoader();
            FXMLLoader mainLoader = new FXMLLoader();
            InputStream fxmlStream = null;
            fxmlStream = getClass().getClassLoader().getResourceAsStream(urlRoot);
            rootLayout = rootLoader.load(fxmlStream);

            fxmlStream = getClass().getClassLoader().getResourceAsStream(urlSecondary);
            mainLayout = mainLoader.load(fxmlStream);
            rootLayout.setCenter(mainLayout);

            return new View(rootLoader.getRoot(), rootLoader.getController(), mainLoader.getController());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Класс - оболочка: контроллер мы обязаны указать в качестве бина,
     * а view - представление, нам предстоит использовать в точке входа {@link Application}.
     */
    public class View {
        private Parent view;
        private Object mainController;
        private Object rootController;

        public View(Parent view, Object mainController) {
            this.view = view;
            this.mainController = mainController;
        }

        public View(Parent view, Object rootController, Object mainController) {
            this.view = view;
            this.mainController = mainController;
            this.rootController = rootController;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return mainController;
        }

        public void setController(Object controller) {
            this.mainController = controller;
        }

        public Object getRootController() {
            return rootController;
        }

        public void setRootController(Object rootController) {
            this.rootController = rootController;
        }
    }

}
