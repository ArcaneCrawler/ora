package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Services.LocacityService;
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

    //Locality Fields
    public TextField populationField;
    public TextField bornField;
    public TextField deathField;
    public TextField contactField;
    public TextField vaccineField;
    public ComboBox<Locacity> locacityBox;
    private ObservableList<Locacity> listLocacity = FXCollections.observableArrayList();

    //Virus
    public TextField deathVirField;
    public TextField lambdaField;
    public TextField chanceField;
    public TextField speedField;
    public TextField cureField;
    public TextField enduranceField;
    public ComboBox<Virus> virusBox;
    private ObservableList<Virus> listVirus = FXCollections.observableArrayList();

    //sir
    public TextField susceptibleField;
    public TextField infectedField;
    public TextField recoveredField;
    public Pane sirPane;
    private NumberAxis xAxisSir = new NumberAxis();
    private NumberAxis yAxisSir = new NumberAxis();
    private LineChart<Number, Number> sirLineChart = new LineChart<>(xAxisSir, yAxisSir);

    //SIRmod
    public TextField modSusceptibleField;
    public TextField modInfectedField;
    public TextField modRecoveredField;
    public Pane sirModPane;
    private NumberAxis xAxisMod = new NumberAxis();
    private NumberAxis yAxisMod = new NumberAxis();
    private LineChart<Number, Number> modLineChart = new LineChart<>(xAxisMod, yAxisMod);

    //SIS
    public TextField sisSusceptibleField;
    public TextField sisInfectedField;
    public Pane sisPane;
    private NumberAxis xAxisSis = new NumberAxis();
    private NumberAxis yAxisSis = new NumberAxis();
    private LineChart<Number, Number> sisLineChart = new LineChart<>(xAxisSis, yAxisSis);

    //SIRS
    public TextField sirsSusceptibleField;
    public TextField sirsInfectedField;
    public TextField sirsRecoveredField;
    public Pane sirsPane;
    private NumberAxis xAxisSirs = new NumberAxis();
    private NumberAxis yAxisSirs = new NumberAxis();
    private LineChart<Number, Number> sirsLineChart = new LineChart<>(xAxisSirs, yAxisSirs);

    //SEIR
    public TextField seirSusceptibleField;
    public TextField seirInfectedField;
    public TextField seirExposeddField;
    public TextField seirRecoveredField;
    public Pane seirPane;
    private NumberAxis xAxisSeir = new NumberAxis();
    private NumberAxis yAxisSeir = new NumberAxis();
    private LineChart<Number, Number> seirLineChart = new LineChart<>(xAxisSeir, yAxisSeir);

    //SEIRS
    public TextField seirsSusceptibleField;
    public TextField seirsInfectedField;
    public TextField seirsExposeddField;
    public TextField seirsRecoveredField;
    public TextField seirsIncubTime;
    public Pane seirsPane;
    private NumberAxis xAxisSeirs = new NumberAxis();
    private NumberAxis yAxisSeirs = new NumberAxis();
    private LineChart<Number, Number> seirsLineChart = new LineChart<>(xAxisSeirs, yAxisSeirs);

    //VerModel
    public TextField verSusceptibleField;
    public TextField verInfectedField;
    public TextField verLatentField;
    public Pane verPane;
    private NumberAxis xAxisVer = new NumberAxis();
    private NumberAxis yAxisVer = new NumberAxis();
    private LineChart<Number, Number> verLineChart = new LineChart<>(xAxisVer, yAxisVer);

    //base Model
    public TextField baseSusceptibleField;
    public TextField baseInfectedField;
    public TextField baseLatentField;
    public Pane basePane;
    private NumberAxis xAxisBase = new NumberAxis();
    private NumberAxis yAxisBase = new NumberAxis();
    private LineChart<Number, Number> baseLineChart = new LineChart<>(xAxisBase, yAxisBase);

    //SLIPC Model
    public TextField slpicSusceptibleField;
    public TextField slpicInfectedField;
    public TextField slpicLatentField;
    public Pane slpicPane;
    private NumberAxis xAxisSlpic = new NumberAxis();
    private NumberAxis yAxisSlpic = new NumberAxis();
    private LineChart<Number, Number> slpicLineChart = new LineChart<>(xAxisSlpic, yAxisSlpic);


    public Label dead_label;
    public Label s_label;
    public Label l_label;
    public Label e_label;

    public Label dead_label1;
    public Label s_label1;
    public Label l_label1;
    public Label e_label1;

    public Label dead_label2;
    public Label s_label2;
    public Label l_label2;
    public Label e_label2;
    public Label c_label;
    public Label p_label;

    Dif dif = new Dif();
    int n = 100;
    private int percent = 100;
    int q = 0;

    @Autowired
    private VirusService virusService;
    @Autowired
    private LocacityService locacityService;

    private Application app;

    //Добавление графиков

    private ObservableList<XYChart.Series<Number, Number>> getData(int count, double[][] result, int n) {
        ObservableList<XYChart.Series<Number, Number>> answer = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> sSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> iSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> rSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> pSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> cSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> eSeries = new XYChart.Series<>();
        sSeries.setName("L");
        iSeries.setName("I");
        rSeries.setName("S");
        pSeries.setName("P");
        cSeries.setName("C");
        eSeries.setName("E");
        switch (count) {
            case 0:
                for (int i = 0; i < n - 1; i = i + 5) {
                    sSeries.getData().add(new XYChart.Data(q, result[0][i]));
                    iSeries.getData().add(new XYChart.Data(q, result[1][i]));
                    rSeries.getData().add(new XYChart.Data(q, result[2][i]));
                    q++;
                }
                q = 0;
                answer.addAll(sSeries, iSeries, rSeries);
                return answer;
            case 2:
                sSeries.setName("S");
                iSeries.setName("I");
                for (int i = 0; i < n - 1; i = i + 4) {
                    sSeries.getData().add(new XYChart.Data(q, result[0][i]));
                    iSeries.getData().add(new XYChart.Data(q, result[1][i]));
                    q++;
                }
                q = 0;
                answer.addAll(sSeries, iSeries);
                return answer;
            case 3:
                sSeries.setName("S");
                iSeries.setName("I");
                rSeries.setName("R");
                for (int i = 0; i < n - 1; i = i + 4) {
                    sSeries.getData().add(new XYChart.Data(q, result[0][i]));
                    iSeries.getData().add(new XYChart.Data(q, result[1][i]));
                    rSeries.getData().add(new XYChart.Data(q, result[2][i]));
                    q++;
                }
                q = 0;
                answer.addAll(sSeries, iSeries, rSeries);
                return answer;
            case 4:
                sSeries.setName("S");
                iSeries.setName("I");
                rSeries.setName("R");
                for (int i = 0; i < n - 1; i = i + 4) {
                    sSeries.getData().add(new XYChart.Data(q, result[0][i]));
                    iSeries.getData().add(new XYChart.Data(q, result[1][i]));
                    rSeries.getData().add(new XYChart.Data(q, result[2][i]));
                    eSeries.getData().add(new XYChart.Data(q, result[3][i]));
                    q++;
                }
                q = 0;
                answer.addAll(sSeries, iSeries, rSeries, eSeries);
                return answer;
            case 5:
                for (int i = 0; i < n - 1; i = i + 5) {
                    sSeries.getData().add(new XYChart.Data(q, result[0][i]));
                    iSeries.getData().add(new XYChart.Data(q, result[1][i]));
                    rSeries.getData().add(new XYChart.Data(q, result[2][i]));
                    pSeries.getData().add(new XYChart.Data(q, result[3][i]));
                    cSeries.getData().add(new XYChart.Data(q, result[4][i]));
                    q++;
                }
                q = 0;
                answer.addAll(sSeries, iSeries, rSeries, pSeries, cSeries);
                return answer;
        }
        return answer;
    }

    public void sirClickEnter() {
        float susceptible = Float.parseFloat(susceptibleField.getText());
        float infected = Float.parseFloat(infectedField.getText());
        float recovered = Float.parseFloat(recoveredField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float sum = ((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIR(susceptible, infected, recovered, contact, cure);
            sirLineChart.getData().clear();
            sirLineChart.setData(getData(3, result, n));
        }
    }

    public void modClickEnter() {
        float susceptible = Float.parseFloat(modSusceptibleField.getText());
        float infected = Float.parseFloat(modInfectedField.getText());
        float recovered = Float.parseFloat(modRecoveredField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float deathRation = Float.parseFloat(deathField.getText());
        float bornRation = Float.parseFloat(bornField.getText());
        float deathVirus = Float.parseFloat(deathVirField.getText());
        float ratio = (bornRation + deathVirus + deathRation) / 3;
        float sum = ((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIRmod(susceptible, infected, recovered, contact, cure, ratio);
            modLineChart.getData().clear();
            modLineChart.setData(getData(3, result, n));
        }
    }

    public void sisClickEnter() {
        float susceptible = Float.parseFloat(sisSusceptibleField.getText());
        float infected = Float.parseFloat(sisInfectedField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float deathRation = Float.parseFloat(deathField.getText());
        float bornRation = Float.parseFloat(bornField.getText());
        float deathVirus = Float.parseFloat(deathVirField.getText());
        float ratio = (bornRation + deathVirus + deathRation) / 3;
        float sum = ((susceptible + infected));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIS(susceptible, infected, contact, cure, ratio);
            sisLineChart.getData().clear();
            sisLineChart.setData(getData(2, result, n));
        }
    }

    public void sirsClickEnter() {
        float susceptible = Float.parseFloat(sirsSusceptibleField.getText());
        float infected = Float.parseFloat(sirsInfectedField.getText());
        float recovered = Float.parseFloat(sirsRecoveredField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float deathRation = Float.parseFloat(deathField.getText());
        float bornRation = Float.parseFloat(bornField.getText());
        float deathVirus = Float.parseFloat(deathVirField.getText());
        float ratio = (bornRation + deathVirus + deathRation) / 3;
        float lossOfImmunity = Float.parseFloat(enduranceField.getText());
        float sum = ((susceptible + infected + recovered));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SIRS(susceptible, infected, recovered, contact, cure, ratio, lossOfImmunity);
            sirsLineChart.getData().clear();
            sirsLineChart.setData(getData(3, result, n));
        }
    }

    public void seirClickEnter() {
        float susceptible = Float.parseFloat(seirSusceptibleField.getText());
        float infected = Float.parseFloat(seirInfectedField.getText());
        float recovered = Float.parseFloat(seirRecoveredField.getText());
        float exposed = Float.parseFloat(seirExposeddField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float deathRation = Float.parseFloat(deathField.getText());
        float bornRation = Float.parseFloat(bornField.getText());
        float deathVirus = Float.parseFloat(deathVirField.getText());
        float ratio = (bornRation + deathVirus + deathRation) / 3;
        float endurance = Float.parseFloat(enduranceField.getText());
        float sum = ((susceptible + infected + recovered + exposed));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SEIR(susceptible, exposed, infected, recovered, contact, cure, ratio, endurance);
            seirLineChart.getData().clear();
            seirLineChart.setData(getData(4, result, n));
        }
    }

    public void seirsClickEnter() {
        float susceptible = Float.parseFloat(seirsSusceptibleField.getText());
        float infected = Float.parseFloat(seirsInfectedField.getText());
        float recovered = Float.parseFloat(seirsRecoveredField.getText());
        float exposed = Float.parseFloat(seirsExposeddField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float deathRation = Float.parseFloat(deathField.getText());
        float bornRation = Float.parseFloat(bornField.getText());
        float deathVirus = Float.parseFloat(deathVirField.getText());
        float ratio = (bornRation + deathVirus + deathRation) / 3;
        float IncubTime = Float.parseFloat(seirsIncubTime.getText());
        float endurance = Float.parseFloat(enduranceField.getText());
        float sum = ((susceptible + infected + recovered + exposed));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SEIRS(susceptible, exposed, infected, recovered, contact, cure, ratio, IncubTime, endurance);
            seirsLineChart.getData().clear();
            seirsLineChart.setData(getData(4, result, n));
        }
    }

    public void verClickEnter() {
        float latent = Float.parseFloat(verLatentField.getText());
        float infected = Float.parseFloat(verInfectedField.getText());
        float susceptible = Float.parseFloat(verSusceptibleField.getText());
        float population = Float.parseFloat(populationField.getText());
        float born = Float.parseFloat(bornField.getText());
        float death = Float.parseFloat(deathField.getText());
        float deathvirus = Float.parseFloat(deathVirField.getText());
        float lambda = Float.parseFloat(lambdaField.getText());
        float p = Float.parseFloat(chanceField.getText());
        float ratio = Float.parseFloat(speedField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float sum = ((susceptible + infected + latent));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.Ver(latent, infected, susceptible, population, born, death, deathvirus, lambda, p, ratio, contact);
            verLineChart.getData().clear();
            verLineChart.setData(getData(0, result, n));

            float current_population = dif.getPopulation();
            float dead_label_text = (population - current_population);
            float s_label_text = (float) ((population) * result[1][n - 1]) / percent;
            float l_label_text = (float) ((population) * result[2][n - 1] / percent);
            float e_label_text = (float) ((population) * result[0][n - 1]) / percent;

            dead_label.setText(String.valueOf(dead_label_text));
            s_label.setText(String.valueOf(s_label_text));
            l_label.setText(String.valueOf(l_label_text));
            e_label.setText(String.valueOf(e_label_text));
        }
    }

    //done
    public void baseClickEnter() {
        float latent = Float.parseFloat(baseLatentField.getText());
        float infected = Float.parseFloat(baseInfectedField.getText());
        float susceptible = Float.parseFloat(baseSusceptibleField.getText());
        float population = Float.parseFloat(populationField.getText());
        float born = Float.parseFloat(bornField.getText());
        float death = Float.parseFloat(deathField.getText());
        float deathvirus = Float.parseFloat(deathVirField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float ratio = Float.parseFloat(speedField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float sum = ((susceptible + infected + latent));

        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.Base(latent, infected, susceptible, population, born, death, deathvirus, cure, ratio, contact);
            baseLineChart.getData().clear();
            baseLineChart.setData(getData(0, result, n));

            float current_population = dif.getPopulation();
            float dead_label_text = (population - current_population);
            float s_label_text = (float) ((population) * result[1][n - 1]) / percent;
            float l_label_text = (float) ((population) * result[2][n - 1] / percent);
            float e_label_text = (float) ((population) * result[0][n - 1]) / percent;

            dead_label1.setText(String.valueOf(dead_label_text));
            s_label1.setText(String.valueOf(s_label_text));
            l_label1.setText(String.valueOf(l_label_text));
            e_label1.setText(String.valueOf(e_label_text));
        }
    }

    public void slpicClickEnter() {
        float latent = Float.parseFloat(slpicLatentField.getText());
        float infected = Float.parseFloat(slpicInfectedField.getText());
        float susceptible = Float.parseFloat(slpicSusceptibleField.getText());
        float population = Float.parseFloat(populationField.getText());
        float born = Float.parseFloat(bornField.getText());
        float death = Float.parseFloat(deathField.getText());
        float deathvirus = Float.parseFloat(deathVirField.getText());
        float lambda = Float.parseFloat(lambdaField.getText());
        float p = Float.parseFloat(chanceField.getText());
        float ratio = Float.parseFloat(speedField.getText());
        float contact = Float.parseFloat(contactField.getText());
        float cure = Float.parseFloat(cureField.getText());
        float vaccine = Float.parseFloat(vaccineField.getText());
        float sum = ((susceptible + infected + latent));


        if (sum != 100.0) {
            getSumAlert();
        } else {
            double[][] result = dif.SLPIC(latent, infected, susceptible, population, born, death, deathvirus, lambda, p, ratio, contact, cure, vaccine);
            slpicLineChart.getData().clear();
            slpicLineChart.setData(getData(5, result, n));

            float current_population = dif.getPopulation();
            float dead_label_text = (population - current_population);
            float s_label_text = (float) ((population) * result[1][n - 1]) / percent;
            float l_label_text = (float) ((population) * result[2][n - 1] / percent);
            float e_label_text = (float) ((population) * result[0][n - 1]) / percent;
            float p_label_text = (float) ((population) * result[3][n - 1]) / percent;
            float c_label_text = (float) ((population) * result[4][n - 1]) / percent;

            dead_label2.setText(String.valueOf(dead_label_text));
            s_label2.setText(String.valueOf(s_label_text));
            l_label2.setText(String.valueOf(l_label_text));
            e_label2.setText(String.valueOf(e_label_text));
            p_label.setText(String.valueOf(p_label_text));
            c_label.setText(String.valueOf(c_label_text));
        }
    }

    /*public void onBaseClick(ActionEvent actionEvent) {
        app.showBase();
    }*/

    public void onBaseClick(ActionEvent actionEvent) {
        app.showAddL();
    }

    public void initialize() {

        sirLineChart.setTitle("Модель SIR");
        sirLineChart.setPrefWidth(450.0);
        sirPane.getChildren().add(sirLineChart);
        xAxisSir.setLabel("Время, сутки");
        yAxisSir.setLabel("Популяция, %");

        sisLineChart.setTitle("Модель SIS");
        sisLineChart.setPrefWidth(450.0);
        sisPane.getChildren().add(sisLineChart);
        xAxisSis.setLabel("Время, сутки");
        yAxisSis.setLabel("Популяция, %");

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

        seirLineChart.setTitle("SEIR");
        seirLineChart.setPrefWidth(450.0);
        seirPane.getChildren().add(seirLineChart);
        xAxisSeir.setLabel("Time, 1/4 year");
        yAxisSeir.setLabel("Population, %");

        seirsLineChart.setTitle("SEIRS");
        seirsLineChart.setPrefWidth(450.0);
        seirsPane.getChildren().add(seirsLineChart);
        xAxisSeirs.setLabel("Time, 1/4 year");
        yAxisSeirs.setLabel("Population, %");

        verLineChart.setTitle("Упрощённая модель");
        verLineChart.setPrefWidth(450.0);
        verPane.getChildren().add(verLineChart);
        xAxisVer.setLabel("Время, год");
        yAxisVer.setLabel("Популяция, %");

        baseLineChart.setTitle("Базовая модель");
        baseLineChart.setPrefWidth(450.0);
        basePane.getChildren().add(baseLineChart);
        xAxisBase.setLabel("Time, 1/4 year");
        yAxisBase.setLabel("Population, %");

        slpicLineChart.setTitle("SLPIC модель");
        slpicLineChart.setPrefWidth(450.0);
        slpicPane.getChildren().add(slpicLineChart);
        xAxisSlpic.setLabel("Time");
        yAxisSlpic.setLabel("Population, %");


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

        modSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modSusceptibleField.setText(oldValue);
        });

        modInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modInfectedField.setText(oldValue);
        });

        modRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) modRecoveredField.setText(oldValue);
        });

        sisSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisSusceptibleField.setText(oldValue);
        });

        sisInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) sisInfectedField.setText(oldValue);
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

        enduranceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) enduranceField.setText(oldValue);
        });
    }

    public void setApp(Application application) {
        this.app = application;
    }

    private void getSumAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Warning");
        alert.setContentText("Сумма численностей групп должна быть равна 100! \n");
        alert.showAndWait();
    }

    public void connectVirus() {

        listVirus.clear();
        listVirus.addAll(virusService.findAll());
        virusBox.setItems(listVirus);

        listLocacity.clear();
        listLocacity.addAll(locacityService.findAll());
        locacityBox.setItems(listLocacity);
    }

    public void virusSelect(ActionEvent actionEvent) {
        Virus virus = virusBox.getSelectionModel().getSelectedItem();
        deathVirField.setText(String.valueOf(virus.getLethal()));
        lambdaField.setText(String.valueOf(virus.getInfluence()));
        chanceField.setText(String.valueOf(virus.getChance()));
        speedField.setText(String.valueOf(virus.getEvol_rate()));
        cureField.setText(String.valueOf(virus.getCure_rate()));
        enduranceField.setText(String.valueOf(virus.getEndurance()));
    }

    public void locacitySelect(ActionEvent actionEvent) {
        Locacity locacity = locacityBox.getSelectionModel().getSelectedItem();
        populationField.setText(String.valueOf(locacity.getPopulation()));
        bornField.setText(String.valueOf(locacity.getBirth_rate()));
        deathField.setText(String.valueOf(locacity.getDeath_rate()));
        contactField.setText(String.valueOf(locacity.getContact()));
        vaccineField.setText(String.valueOf(locacity.getVaccine()));
    }
}