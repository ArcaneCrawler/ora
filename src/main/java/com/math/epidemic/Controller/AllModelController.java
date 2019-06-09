package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Services.VirusService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

public class AllModelController {
    //sir
    public TextField susceptibleField;
    public TextField infectedField;
    public TextField recoveredField;
    public TextField contactField;
    public TextField influenceTimeField;
    //SIRmod
    public TextField modSusceptibleField;
    public TextField modInfectedField;
    public TextField modRecoveredField;
    public TextField modContactField;
    public TextField modInfluenceTimeField;
    public TextField modDeathRation;
    //SIS
    public TextField sisSusceptibleField;
    public TextField sisInfectedField;
    public TextField sisContactField;
    public TextField sisInfluenceTimeField;
    public TextField sisDeathRation;
    //SIRS
    public TextField sirsSusceptibleField;
    public TextField sirsInfectedField;
    public TextField sirsRecoveredField;
    public TextField sirsContactField;
    public TextField sirsInfluenceTimeField;
    public TextField sirsDeathRation;
    public TextField sirsLossOfImmunity;
    //VerModel
    public TextField verSusceptibleField;
    public TextField verInfectedField;
    public TextField verRecoveredField;
    public TextField verPopulationField;
    public TextField verBornField;
    public TextField verDeathField;
    public TextField verDeathVirField;
    public TextField verLambdaField;
    public TextField verChanceField;
    public TextField verSpeedField;
    public TextField verContactField;
    //base Model
    public TextField baseSusceptibleField;
    public TextField baseInfectedField;
    public TextField baseRecoveredField;
    public TextField basePopulationField;
    public TextField baseBornField;
    public TextField baseDeathField;
    public TextField baseDeathVirField;
    public TextField baseDeltaField;
    public TextField baseContactField;
    public TextField baseSpeedField;

    public Label dead_label;
    public Label s_label;
    public Label l_label;
    public Label e_label;

    public Label dead_label1;
    public Label s_label1;
    public Label l_label1;
    public Label e_label1;

    public Pane sirPane;
    public Pane sirModPane;
    public Pane sisPane;
    public Pane sirsPane;
    public Pane verPane;
    public Pane basePane;

    public ComboBox<Virus> virusBox;
    public String name;
    Dif dif = new Dif();
    int n = 100;

    private ObservableList<Virus> listVirus = FXCollections.observableArrayList();
    @Autowired
    private VirusService virusService;

    private NumberAxis xAxisSir = new NumberAxis();
    private NumberAxis yAxisSir = new NumberAxis();
    private LineChart<Number, Number> sirLineChart = new LineChart<>(xAxisSir, yAxisSir);
    private NumberAxis xAxisMod = new NumberAxis();
    private NumberAxis yAxisMod = new NumberAxis();
    private LineChart<Number, Number> modLineChart = new LineChart<>(xAxisMod, yAxisMod);
    private NumberAxis xAxisSis = new NumberAxis();
    private NumberAxis yAxisSis = new NumberAxis();
    private LineChart<Number, Number> sisLineChart = new LineChart<>(xAxisSis, yAxisSis);
    private NumberAxis xAxisSirs = new NumberAxis();
    private NumberAxis yAxisSirs = new NumberAxis();
    private LineChart<Number, Number> sirsLineChart = new LineChart<>(xAxisSirs, yAxisSirs);
    private NumberAxis xAxisVer = new NumberAxis();
    private NumberAxis yAxisVer = new NumberAxis();
    private LineChart<Number, Number> verLineChart = new LineChart<>(xAxisVer, yAxisVer);
    private NumberAxis xAxisBase = new NumberAxis();
    private NumberAxis yAxisBase = new NumberAxis();
    private LineChart<Number, Number> baseLineChart = new LineChart<>(xAxisBase, yAxisBase);
    private Application app;

    public void sirClickEnter() {
        float susceptible = Float.parseFloat(susceptibleField.getText());
        float infected = Float.parseFloat(infectedField.getText());
        float recovered = Float.parseFloat(recoveredField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float influenceTime = Float.parseFloat(influenceTimeField.getText());

        float sum = ((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIR(susceptible, infected, recovered, contact, influenceTime);
            sirLineChart.getData().clear();
            sirLineChart.setData(getData(3, result, n));
        }
    }

    private ObservableList<XYChart.Series<Number, Number>> getData(int count, double[][] result, int n) {
        ObservableList<XYChart.Series<Number, Number>> answer = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> sSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> iSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> rSeries = new XYChart.Series<>();
        sSeries.setName("L");
        iSeries.setName("I");
        rSeries.setName("S");
        if (count == 3) {
            for (int i = 0; i < n - 1; i = i + 5) {
                sSeries.getData().add(new XYChart.Data(i, result[0][i]));
                iSeries.getData().add(new XYChart.Data(i, result[1][i]));
                rSeries.getData().add(new XYChart.Data(i, result[2][i]));
            }
            answer.addAll(sSeries, iSeries, rSeries);
            return answer;
        } else {
            for (int i = 0; i < n - 1; i = i + 5) {
                sSeries.getData().add(new XYChart.Data(i, result[0][i]));
                iSeries.getData().add(new XYChart.Data(i, result[1][i]));

            }
            answer.addAll(sSeries, iSeries);
            return answer;
        }


    }

    public void modClickEnter() {
        float susceptible = Float.parseFloat(modSusceptibleField.getText());
        float infected = Float.parseFloat(modInfectedField.getText());
        float recovered = Float.parseFloat(modRecoveredField.getText());
        float contact = Float.parseFloat(modContactField.getText());
        float influenceTime = Float.parseFloat(modInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(modDeathRation.getText());
        float sum = ((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIRmod(susceptible, infected, recovered, contact, influenceTime, deathRation);
            modLineChart.getData().clear();
            modLineChart.setData(getData(3, result, n));
        }

    }


    public void sisClickEnter() {
        float susceptible = Float.parseFloat(sisSusceptibleField.getText());
        float infected = Float.parseFloat(sisInfectedField.getText());
        float contact = Float.parseFloat(sisContactField.getText());
        float influenceTime = Float.parseFloat(sisInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(sisDeathRation.getText());
        float sum = ((susceptible + infected));
        System.out.println((susceptible + infected));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIS(susceptible, infected, contact, influenceTime, deathRation);
            sisLineChart.getData().clear();
            sisLineChart.setData(getData(2, result, n));
        }
    }

    public void sirsClickEnter() {
        float susceptible = Float.parseFloat(sirsSusceptibleField.getText());
        float infected = Float.parseFloat(sirsInfectedField.getText());
        float recovered = Float.parseFloat(sirsRecoveredField.getText());
        float contact = Float.parseFloat(sirsContactField.getText());
        float influenceTime = Float.parseFloat(sirsInfluenceTimeField.getText());
        float deathRation = Float.parseFloat(sirsDeathRation.getText());
        float lossOfImmunity = Float.parseFloat(sirsLossOfImmunity.getText());
        float sum = ((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered));


        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIRS(susceptible, infected, recovered, contact, influenceTime, deathRation, lossOfImmunity);
            sirsLineChart.getData().clear();
            sirsLineChart.setData(getData(3, result, n));
        }

    }

    public void verClickEnter() {
        float susceptible = Float.parseFloat(verSusceptibleField.getText());
        float infected = Float.parseFloat(verInfectedField.getText());
        float recovered = Float.parseFloat(verRecoveredField.getText());
        float population = Float.parseFloat(verPopulationField.getText());
        float born = Float.parseFloat(verBornField.getText());
        float death = Float.parseFloat(verDeathField.getText());
        float deathvirus = Float.parseFloat(verDeathVirField.getText());
        float lambda = Float.parseFloat(verLambdaField.getText());
        float p = Float.parseFloat(verChanceField.getText());
        float ratio = Float.parseFloat(verSpeedField.getText());
        float contact = Float.parseFloat(verContactField.getText());


        float sum = ((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.Ver(susceptible, infected, recovered, population, born, death, deathvirus, lambda, p, ratio, contact);
            verLineChart.getData().clear();
            verLineChart.setData(getData(3, result, n));

            float current_population = dif.getPopulation();
            float dead_label_text = (population - current_population);
            float s_label_text = (float) ((population) * result[1][n - 1]) / 100;
            float l_label_text = (float) ((population) * result[2][n - 1] / 100);
            float e_label_text = (float) ((population) * result[0][n - 1]) / 100;
            float sumator = s_label_text + l_label_text + e_label_text;
            System.out.println(sumator);

            dead_label.setText(String.valueOf(dead_label_text));
            s_label.setText(String.valueOf(s_label_text));
            l_label.setText(String.valueOf(l_label_text));
            e_label.setText(String.valueOf(e_label_text));
        }

    }

    public void baseClickEnter() {

        float susceptible = Float.parseFloat(baseSusceptibleField.getText());
        float infected = Float.parseFloat(baseInfectedField.getText());
        float recovered = Float.parseFloat(baseRecoveredField.getText());
        float population = Float.parseFloat(basePopulationField.getText());
        float born = Float.parseFloat(baseBornField.getText());
        float death = Float.parseFloat(baseDeathField.getText());
        float deathvirus = Float.parseFloat(baseDeathVirField.getText());
        float delta = Float.parseFloat(baseDeltaField.getText());
        float ratio = Float.parseFloat(baseSpeedField.getText());
        float contact = Float.parseFloat(baseContactField.getText());


        float sum = ((susceptible + infected + recovered));
        System.out.println((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.Base(susceptible, infected, recovered, population, born, death, deathvirus, delta, ratio, contact);
            baseLineChart.getData().clear();
            baseLineChart.setData(getData(3, result, n));

            float current_population = dif.getPopulation();
            float dead_label_text = (population - current_population);
            float s_label_text = (float) ((population) * result[1][n - 1]) / 100;
            float l_label_text = (float) ((population) * result[2][n - 1] / 100);
            float e_label_text = (float) ((population) * result[0][n - 1]) / 100;
            float sumator = s_label_text + l_label_text + e_label_text;
            System.out.println(sumator);

            dead_label1.setText(String.valueOf(dead_label_text));
            s_label1.setText(String.valueOf(s_label_text));
            l_label1.setText(String.valueOf(l_label_text));
            e_label1.setText(String.valueOf(e_label_text));
        }

    }

    public void onBaseClick(ActionEvent actionEvent) {
        app.showBase();
    }

    public void initialize() {


        sirLineChart.setTitle("SIR");
        sirLineChart.setPrefWidth(450.0);
        sirPane.getChildren().add(sirLineChart);
        xAxisSir.setLabel("Time, 1/4 year");
        yAxisSir.setLabel("Population, %");

        sisLineChart.setTitle("SIS");
        sisLineChart.setPrefWidth(450.0);
        sisPane.getChildren().add(sisLineChart);
        xAxisSis.setLabel("Time, 1/4 year");
        yAxisSis.setLabel("Population, %");


        modLineChart.setTitle("SIR with modification");
        modLineChart.setPrefWidth(450.0);
        sirModPane.getChildren().add(modLineChart);
        xAxisMod.setLabel("Time, 1/4 year");
        yAxisMod.setLabel("Population, %");


        sirsLineChart.setTitle("SIRS");
        sirsLineChart.setPrefWidth(450.0);
        sirsPane.getChildren().add(sirsLineChart);
        xAxisSirs.setLabel("Time, 1/4 year");
        yAxisSirs.setLabel("Population, %");


        verLineChart.setTitle("Упрощённая модель");
        verLineChart.setPrefWidth(450.0);
        verPane.getChildren().add(verLineChart);
        xAxisVer.setLabel("Time, 1/4 year");
        yAxisVer.setLabel("Population, %");

        baseLineChart.setTitle("Базовая модель");
        baseLineChart.setPrefWidth(450.0);
        basePane.getChildren().add(baseLineChart);
        xAxisBase.setLabel("Time, 1/4 year");
        yAxisBase.setLabel("Population, %");


        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        susceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) susceptibleField.setText(oldValue);
        });
        infectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) infectedField.setText(oldValue);
        });

        recoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) recoveredField.setText(oldValue);
        });

        contactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) contactField.setText(oldValue);
        });

        influenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) influenceTimeField.setText(oldValue);
        });

        modSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modSusceptibleField.setText(oldValue);
        });

        modInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modInfectedField.setText(oldValue);
        });

        modRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modRecoveredField.setText(oldValue);
        });

        modContactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modContactField.setText(oldValue);
        });

        modInfluenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modInfluenceTimeField.setText(oldValue);
        });

        modDeathRation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modDeathRation.setText(oldValue);
        });

        sisSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisSusceptibleField.setText(oldValue);
        });

        sisInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisInfectedField.setText(oldValue);
        });

        sisContactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisContactField.setText(oldValue);
        });

        sisInfluenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisInfluenceTimeField.setText(oldValue);
        });

        sisDeathRation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisDeathRation.setText(oldValue);
        });

        sirsSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsSusceptibleField.setText(oldValue);
        });

        sirsInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsInfectedField.setText(oldValue);
        });

        sirsRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsRecoveredField.setText(oldValue);
        });

        sirsContactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsContactField.setText(oldValue);
        });

        sirsInfluenceTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsInfluenceTimeField.setText(oldValue);
        });

        sirsDeathRation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsDeathRation.setText(oldValue);
        });

        sirsLossOfImmunity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sirsLossOfImmunity.setText(oldValue);
        });
    }

    public void setApp(Application application) {
        this.app = application;
    }

    private void getSumAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Warning");
        alert.setContentText("The sum of the shares of suspected, infected and recovered should be 100! \n");
        alert.showAndWait();
    }

    public void connect() {
        System.out.println("Начало процесса");
        listVirus.clear();
        listVirus.addAll(virusService.findAll());
        virusBox.setItems(listVirus);
    }
}




