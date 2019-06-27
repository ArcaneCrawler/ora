package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import com.math.epidemic.Entities.Journal;
import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Services.JournalService;
import com.math.epidemic.Services.LocacityService;
import com.math.epidemic.Services.VirusService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Date;
import java.util.regex.Pattern;

public class AllModelController {

    @FXML
    public ImageView virusView;
    @FXML
    public ImageView locacityView;

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
    public Label sir_dead;
    public Label sir_s;
    public Label sir_i;
    public Label sir_r;

    //SIRmod
    public TextField modSusceptibleField;
    public TextField modInfectedField;
    public TextField modRecoveredField;
    public Pane sirModPane;
    private NumberAxis xAxisMod = new NumberAxis();
    private NumberAxis yAxisMod = new NumberAxis();
    private LineChart<Number, Number> modLineChart = new LineChart<>(xAxisMod, yAxisMod);
    public Label mod_dead;
    public Label mod_s;
    public Label mod_i;
    public Label mod_r;

    //SIS
    public TextField sisSusceptibleField;
    public TextField sisInfectedField;
    public Pane sisPane;
    private NumberAxis xAxisSis = new NumberAxis();
    private NumberAxis yAxisSis = new NumberAxis();
    private LineChart<Number, Number> sisLineChart = new LineChart<>(xAxisSis, yAxisSis);
    public Label sis_dead;
    public Label sis_s;
    public Label sis_i;

    //SIRS
    public TextField sirsSusceptibleField;
    public TextField sirsInfectedField;
    public TextField sirsRecoveredField;
    public Pane sirsPane;
    private NumberAxis xAxisSirs = new NumberAxis();
    private NumberAxis yAxisSirs = new NumberAxis();
    private LineChart<Number, Number> sirsLineChart = new LineChart<>(xAxisSirs, yAxisSirs);
    public Label sirs_dead;
    public Label sirs_s;
    public Label sirs_i;
    public Label sirs_r;


    //SEIR
    public TextField seirSusceptibleField;
    public TextField seirInfectedField;
    public TextField seirExposeddField;
    public TextField seirRecoveredField;
    public Pane seirPane;
    private NumberAxis xAxisSeir = new NumberAxis();
    private NumberAxis yAxisSeir = new NumberAxis();
    private LineChart<Number, Number> seirLineChart = new LineChart<>(xAxisSeir, yAxisSeir);
    public Label seir_dead;
    public Label seir_s;
    public Label seir_i;
    public Label seir_r;
    public Label seir_e;


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
    public Label seirs_dead;
    public Label seirs_s;
    public Label seirs_e;
    public Label seirs_i;
    public Label seirs_r;


    //VerModel
    public TextField verSusceptibleField;
    public TextField verInfectedField;
    public TextField verLatentField;
    public Pane verPane;
    private NumberAxis xAxisVer = new NumberAxis();
    private NumberAxis yAxisVer = new NumberAxis();
    private LineChart<Number, Number> verLineChart = new LineChart<>(xAxisVer, yAxisVer);
    public Label sli_dead;
    public Label sli_i;
    public Label sli_l;
    public Label sli_s;

    //base Model
    public TextField baseSusceptibleField;
    public TextField baseInfectedField;
    public TextField baseLatentField;
    public Pane basePane;
    private NumberAxis xAxisBase = new NumberAxis();
    private NumberAxis yAxisBase = new NumberAxis();
    private LineChart<Number, Number> baseLineChart = new LineChart<>(xAxisBase, yAxisBase);
    public Label base_dead;
    public Label base_s;
    public Label base_l;
    public Label base_i;

    //SLIPC Model
    public TextField slpicSusceptibleField;
    public TextField slpicInfectedField;
    public TextField slpicLatentField;
    public Pane slpicPane;
    private NumberAxis xAxisSlpic = new NumberAxis();
    private NumberAxis yAxisSlpic = new NumberAxis();
    private LineChart<Number, Number> slpicLineChart = new LineChart<>(xAxisSlpic, yAxisSlpic);
    public Label slpic_dead;
    public Label slpic_s;
    public Label slpic_l;
    public Label slpic_i;
    public Label slpic_p;
    public Label slpic_c;

    //Journal label
    Date date;
    int popul_left;
    int popul_daed;
    int suspected;
    int latent;
    int infected;
    int cured;
    int chem;
    String model_type;
    Virus virus;
    Locacity locacity;

    //Lables
    int dead_label_text = 0;
    int i_label_text = 0;
    int s_label_text = 0;
    int r_label_text = 0;
    int e_label_text = 0;
    int l_label_text = 0;
    int p_label_text = 0;
    int c_label_text = 0;
    int current_population = 0;


    Dif dif = new Dif();
    int n = 100;
    private int percent = 100;
    int q = 0;

    double[] test1 = new double[]{0.0, 1.9, 3.87, 5.9, 7.98, 10.1, 12.24, 14.41, 16.58, 18.75, 20.9, 23.03, 25.13, 27.2, 29.21, 31.18, 33.08, 34.93, 36.71, 38.42, 40.07, 41.64, 43.14, 44.57, 45.92, 47.21, 48.42, 49.57, 50.64, 51.66, 52.6, 53.49, 54.32, 55.09, 55.81, 56.47, 57.08, 57.65, 58.17, 58.65, 59.09, 59.49, 59.85, 60.17, 60.47, 60.73, 60.96, 61.17, 61.35, 61.5, 62.77, 62.89, 62.98, 63.05, 63.11, 63.14, 63.16, 63.17, 63.16, 63.14, 63.11, 63.06, 63.01, 62.94, 62.87, 62.78, 62.69, 62.59, 62.49, 62.37, 62.26, 62.13, 62.0, 61.87, 61.73, 61.59, 61.44, 61.29, 61.13, 60.98, 60.82, 60.66, 60.49, 60.33, 60.16, 59.99, 59.82, 59.64, 59.47, 59.29, 59.11, 58.94, 58.76, 58.58, 58.4, 58.22, 58.03, 57.85, 57.67, 57.49};
    double[] test2 = new double[]{0.0, 2.71, 5.32, 7.83, 10.25, 12.58, 14.83, 16.99, 19.06, 21.05, 22.96, 24.79, 26.54, 28.21, 29.8, 31.31, 32.75, 34.11, 35.41, 36.63, 37.79, 38.88, 39.91, 40.87, 41.78, 42.63, 43.43, 44.17, 44.87, 45.52, 46.12, 46.68, 47.2, 47.68, 48.12, 48.53, 48.9, 49.24, 49.56, 49.84, 50.1, 50.33, 50.54, 50.72, 50.89, 51.03, 51.16, 51.26, 51.35, 51.43, 50.25, 50.29, 50.32, 50.35, 50.35, 50.35, 50.34, 50.32, 50.29, 50.25, 50.21, 50.15, 50.09, 50.03, 49.96, 49.88, 49.8, 49.71, 49.62, 49.52, 49.42, 49.32, 49.21, 49.1, 48.98, 48.87, 48.75, 48.63, 48.5, 48.38, 48.25, 48.12, 47.99, 47.86, 47.72, 47.59, 47.45, 47.32, 47.18, 47.04, 46.9, 46.76, 46.62, 46.48, 46.33, 46.19, 46.05, 45.9, 45.76, 45.62};
    double[] test3 = new double[]{7.0, 10.29, 13.23, 15.83, 18.1, 20.08, 21.78, 23.23, 24.45, 25.48, 26.33, 27.03, 27.58, 28.03, 28.36, 28.61, 28.78, 28.89, 28.93, 28.93, 30.53, 29.62, 30.32, 30.17, 29.99, 29.79, 29.58, 29.35, 29.1, 28.85, 28.58, 28.31, 28.03, 27.75, 27.46, 27.17, 26.88, 26.58, 27.0, 27.04, 27.08, 27.11, 27.14, 27.15, 26.83, 26.51, 26.19, 25.88, 25.56, 25.25, 24.94, 24.64, 24.33, 24.03, 23.74, 23.44, 23.15, 22.86, 22.57, 22.19, 21.85, 21.48, 21.16, 20.89, 20.62, 20.35, 20.09, 19.83, 19.58, 19.32, 19.07, 18.83, 18.58, 18.34, 18.1, 17.87, 17.64, 17.41, 17.18, 17.31, 17.14, 16.97, 16.8, 16.59, 16.38, 16.17, 15.97, 15.77, 15.57, 15.37, 15.17, 14.98, 14.79, 14.61, 14.42, 14.24, 14.06, 13.88, 13.71};
    double[] test4 = new double[]{10, 12.91, 16.56, 19.77, 22.55, 24.94, 26.96, 28.65, 30.06, 31.21, 32.14, 32.87, 33.43, 33.86, 34.16, 34.36, 34.46, 34.5, 34.47, 34.38, 35.96, 34.93, 35.57, 35.33, 35.07, 34.79, 34.49, 34.17, 33.85, 33.51, 33.17, 32.82, 32.47, 32.11, 31.75, 31.39, 31.03, 30.67, 31.03, 31.38, 32.06, 32.72, 33.35, 33.62, 33.88, 33.46, 33.05, 32.64, 32.23, 31.83, 31.43, 31.03, 30.64, 30.25, 29.87, 29.49, 29.11, 28.74, 28.38, 27.01, 26.33, 25.34, 24.48, 24.13, 23.78, 23.44, 23.1, 22.76, 22.43, 22.1, 21.78, 21.46, 21.14, 20.83, 20.52, 20.22, 19.92, 19.62, 19.33, 22.54, 22.54, 22.56, 22.78, 22.52, 22.25, 21.99, 21.73, 21.47, 21.22, 20.97, 20.73, 20.48, 20.24, 20.01, 19.77, 19.54, 19.32, 19.09, 18.87};
    @Autowired
    private VirusService virusService;
    @Autowired
    private LocacityService locacityService;
    @Autowired
    private JournalService journalService;

    private Application app;

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

    public void sirSave(ActionEvent actionEvent) {
        safeToJournal("SIR");
    }

    public void sirmSave(ActionEvent actionEvent) {
        safeToJournal("SIRm");
    }

    public void sisSave(ActionEvent actionEvent) {
        safeToJournal("SIS");
    }

    public void sirsSave(ActionEvent actionEvent) {
        safeToJournal("SIRS");
    }

    public void seirSave(ActionEvent actionEvent) {
        safeToJournal("SEIR");
    }

    public void seirsSave(ActionEvent actionEvent) {
        safeToJournal("SEIRS");
    }

    public void sliSave(ActionEvent actionEvent) {
        safeToJournal("SLI");
    }

    public void slisSave(ActionEvent actionEvent) {
        safeToJournal("SLIs");
    }

    public void slpicSave(ActionEvent actionEvent) {
        safeToJournal("SLPIC");
    }


    public void safeToJournal(String model_type) {
         try {
        if (s_label_text == 0 && i_label_text == 0 && p_label_text == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning!");
            alert.setHeaderText("Ошибка!");
            alert.setContentText("Перед сохранением требуется произвести расчёт!");
            alert.showAndWait();
            return;
        }
        Date date = new Date();
        Journal journal = new Journal();
        if (model_type.matches("SLPIC|SLI|SLIs")) {
            journal.setLatent(l_label_text);
            journal.setCured(c_label_text);
        } else {
            journal.setLatent(e_label_text);
            journal.setCured(r_label_text);
        }
        journal.setDate(date.toString());
        journal.setPopul_left(current_population);
        journal.setPopul_daed(dead_label_text);

        journal.setSuspected(s_label_text);
        journal.setInfected(i_label_text);
        journal.setChem(p_label_text);

        Virus virus = virusBox.getSelectionModel().getSelectedItem();
        String nameForJournal = virus.getName() + " " + virus.getStrain();
        journal.setVirus(nameForJournal);
        Locacity locacity = locacityBox.getSelectionModel().getSelectedItem();
        journal.setLocacity(locacity.getName());

        journal.setModel_type(model_type);
        journalService.add(journal);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Выполнено!");
        alert.setContentText("Результат для модели " + model_type + " успешно сохранён!");
        alert.showAndWait();

        l_label_text = c_label_text = e_label_text = r_label_text = current_population = dead_label_text = s_label_text = i_label_text = p_label_text = 0;
    }
       catch (DataIntegrityViolationException exception){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Warning!");
           alert.setHeaderText("Ошибка!");
           alert.setContentText("Требуется выбрать заболевание и населённый пункт");
           alert.showAndWait();
           return;
       }
    }
//PropertyValueException

    public void setApp(Application application) {
        this.app = application;
    }


    private ObservableList<XYChart.Series<Number, Number>> getData(int count, double[][] result, int n) {
        ObservableList<XYChart.Series<Number, Number>> answer = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> sSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> iSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> rSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> pSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> cSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> eSeries = new XYChart.Series<>();
        sSeries.setName("L - латентные больные");
        iSeries.setName("I - активно больные");
        rSeries.setName("S - неинфицированные");
        pSeries.setName("P - прошедшие химиотерапию");
        cSeries.setName("C - прошедшие медикаментозное лечение");
        eSeries.setName("E - латентно больные");
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
                sSeries.setName("S - неинфицированные");
                iSeries.setName("I - активно больные");
                for (int i = 0; i < n - 1; i = i + 4) {
                    sSeries.getData().add(new XYChart.Data(q, result[0][i]));
                    iSeries.getData().add(new XYChart.Data(q, result[1][i]));
                    q++;
                }
                q = 0;
                answer.addAll(sSeries, iSeries);
                return answer;
            case 3:
                sSeries.setName("S - неинфицированные");
                iSeries.setName("I - активно больные");
                rSeries.setName("R - исцелившиеся");
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
                sSeries.setName("S - неинфицированные");
                iSeries.setName("I - активно больные");
                rSeries.setName("R - исцелившиеся");
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
        try {
            float susceptible = Float.parseFloat(susceptibleField.getText());
            float infected = Float.parseFloat(infectedField.getText());
            float recovered = Float.parseFloat(recoveredField.getText());
            float contact = Float.parseFloat(contactField.getText());
            float cure = Float.parseFloat(cureField.getText());
            float population = Float.parseFloat(populationField.getText());
            float sum = ((susceptible + infected + recovered));


            if (sum != 100.0) {
                getSumAlert();
            } else {
                double[][] result = dif.SIR(susceptible, infected, recovered, contact, cure);
                sirLineChart.getData().clear();
                sirLineChart.setData(getData(3, result, n));


                dead_label_text = (int) (population - population);
                s_label_text = (int) ((population) * result[0][n - 1]) / percent;
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                r_label_text = (int) ((population) * result[2][n - 1] / percent);

                sir_dead.setText(String.valueOf(dead_label_text));
                sir_s.setText(String.valueOf(s_label_text));
                sir_i.setText(String.valueOf(i_label_text));
                sir_r.setText(String.valueOf(r_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
    }

    public void modClickEnter() {
        try {
            float susceptible = Float.parseFloat(modSusceptibleField.getText());
            float infected = Float.parseFloat(modInfectedField.getText());
            float recovered = Float.parseFloat(modRecoveredField.getText());
            float contact = Float.parseFloat(contactField.getText());
            float cure = Float.parseFloat(cureField.getText());
            float deathRation = Float.parseFloat(deathField.getText());
            float bornRation = Float.parseFloat(bornField.getText());
            float deathVirus = Float.parseFloat(deathVirField.getText());
            float population = Float.parseFloat(populationField.getText());
            float ratio = (bornRation + deathVirus + deathRation) / 3;
            float sum = ((susceptible + infected + recovered));

            if (sum != 100.0) {
                getSumAlert();
            } else {
                double[][] result = dif.SIRmod(susceptible, infected, recovered, contact, cure, ratio);
                modLineChart.getData().clear();
                modLineChart.setData(getData(3, result, n));


                dead_label_text = (int) (population - population);
                s_label_text = (int) ((population) * result[0][n - 1]) / percent;
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                r_label_text = (int) ((population) * result[2][n - 1] / percent);

                mod_dead.setText(String.valueOf(dead_label_text));
                mod_s.setText(String.valueOf(s_label_text));
                mod_i.setText(String.valueOf(i_label_text));
                mod_r.setText(String.valueOf(r_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
    }

    public void sisClickEnter() {
        try {
            float susceptible = Float.parseFloat(sisSusceptibleField.getText());
            float infected = Float.parseFloat(sisInfectedField.getText());
            float contact = Float.parseFloat(contactField.getText());
            float cure = Float.parseFloat(cureField.getText());
            float deathRation = Float.parseFloat(deathField.getText());
            float bornRation = Float.parseFloat(bornField.getText());
            float deathVirus = Float.parseFloat(deathVirField.getText());
            float population = Float.parseFloat(populationField.getText());
            float ratio = (bornRation + deathVirus + deathRation) / 3;
            float sum = ((susceptible + infected));

            if (sum != 100.0) {
                getSumAlert();
            } else {
                double[][] result = dif.SIS(susceptible, infected, contact, cure, ratio);
                sisLineChart.getData().clear();
                sisLineChart.setData(getData(2, result, n));

                dead_label_text = (int) (population - population);
                s_label_text = (int) ((population) * result[0][n - 1]) / percent;
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;

                sis_dead.setText(String.valueOf(dead_label_text));
                sis_s.setText(String.valueOf(s_label_text));
                sis_i.setText(String.valueOf(i_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
    }

    public void sirsClickEnter() {
        try {
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
            float population = Float.parseFloat(populationField.getText());
            float sum = ((susceptible + infected + recovered));

            if (sum != 100.0) {
                getSumAlert();
            } else {
                double[][] result = dif.SIRS(susceptible, infected, recovered, contact, cure, ratio, lossOfImmunity, population);
                sirsLineChart.getData().clear();
                sirsLineChart.setData(getData(3, result, n));
                current_population = (int) dif.getPopulation();
                dead_label_text = (int) (population - current_population);
                s_label_text = (int) ((population) * result[0][n - 1]) / percent;
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                r_label_text = (int) ((population) * result[2][n - 1] / percent);

                sirs_dead.setText(String.valueOf(dead_label_text));
                sirs_s.setText(String.valueOf(s_label_text));
                sirs_i.setText(String.valueOf(i_label_text));
                sirs_r.setText(String.valueOf(r_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
    }

    public void seirClickEnter() {
        try {
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
            float population = Float.parseFloat(populationField.getText());
            float sum = ((susceptible + infected + recovered + exposed));

            if (sum != 100.0) {
                getSumAlert();
            } else {
                double[][] result = dif.SEIR(susceptible, exposed, infected, recovered, contact, cure, ratio, endurance, population);
                seirLineChart.getData().clear();
                seirLineChart.setData(getData(4, result, n));

                current_population = (int) dif.getPopulation();
                dead_label_text = (int) (population - current_population);
                s_label_text = (int) ((population) * result[0][n - 1]) / percent;
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                r_label_text = (int) ((population) * result[2][n - 1] / percent);
                e_label_text = (int) ((population) * result[3][n - 1] / percent);

                seir_dead.setText(String.valueOf(dead_label_text));
                seir_s.setText(String.valueOf(s_label_text));
                seir_i.setText(String.valueOf(i_label_text));
                seir_r.setText(String.valueOf(r_label_text));
                seir_e.setText(String.valueOf(e_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
    }

    public void seirsClickEnter() {
        try {
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
            float population = Float.parseFloat(populationField.getText());
            float sum = ((susceptible + infected + recovered + exposed));

            if (sum != 100.0) {
                getSumAlert();
            } else {
                double[][] result = dif.SEIRS(susceptible, exposed, infected, recovered, contact, cure, ratio, IncubTime, endurance, population);
                seirsLineChart.getData().clear();
                seirsLineChart.setData(getData(4, result, n));

                current_population = (int) dif.getPopulation();
                dead_label_text = Math.round(population - current_population);
                s_label_text = (int) ((population) * result[0][n - 1]) / percent;
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                r_label_text = (int) ((population) * result[2][n - 1] / percent);
                e_label_text = (int) ((population) * result[3][n - 1] / percent);

                seirs_dead.setText(String.valueOf(dead_label_text));
                seirs_s.setText(String.valueOf(s_label_text));
                seirs_i.setText(String.valueOf(i_label_text));
                seirs_r.setText(String.valueOf(r_label_text));
                seirs_e.setText(String.valueOf(e_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
    }

    public void verClickEnter() {
        try {
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

                current_population = (int) dif.getPopulation();
                dead_label_text = (int) (population - current_population);
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                s_label_text = (int) ((population) * result[2][n - 1] / percent);
                l_label_text = (int) ((population) * result[0][n - 1]) / percent;

                sli_dead.setText(String.valueOf(dead_label_text));
                sli_s.setText(String.valueOf(s_label_text));
                sli_l.setText(String.valueOf(l_label_text));
                sli_i.setText(String.valueOf(i_label_text));
            }
        } catch (NumberFormatException e) {
            nullPointAlert();
        }
    }

    public void baseClickEnter() {
        try {
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

                current_population = (int) dif.getPopulation();
                dead_label_text = (int) (population - current_population);
                i_label_text = (int) ((population) * result[1][n - 1]) / percent;
                s_label_text = (int) ((population) * result[2][n - 1] / percent);
                l_label_text = (int) ((population) * result[0][n - 1]) / percent;

                base_dead.setText(String.valueOf(dead_label_text));
                base_s.setText(String.valueOf(s_label_text));
                base_l.setText(String.valueOf(l_label_text));
                base_i.setText(String.valueOf(i_label_text));
            }
        } catch (NumberFormatException e) {
            nullPointAlert();
        }
    }

    public void slpicClickEnter() {
        // try {
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

            current_population = (int) dif.getPopulation();
            dead_label_text = (int) (population - current_population);
            i_label_text = (int) ((population) * result[1][n - 1]) / percent;
            s_label_text = (int) ((population) * result[2][n - 1] / percent);
            l_label_text = (int) ((population) * result[0][n - 1]) / percent;
            p_label_text = (int) ((population) * result[3][n - 1]) / percent;
            c_label_text = (int) ((population) * result[4][n - 1]) / percent;

            slpic_dead.setText(String.valueOf(dead_label_text));
            slpic_s.setText(String.valueOf(s_label_text));
            slpic_l.setText(String.valueOf(l_label_text));
            slpic_i.setText(String.valueOf(i_label_text));
            slpic_p.setText(String.valueOf(p_label_text));
            slpic_c.setText(String.valueOf(c_label_text));
        }
       /* } catch (NullPointerException e) {
            nullPointAlert();
        }*/
    }

    void nullPointAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText("Возникла ошибка");
        alert.setContentText("Ошибка ввода коэффициентов");
        alert.showAndWait();
        return;
    }

    private void getSumAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Warning");
        alert.setContentText("Сумма численностей групп должна быть равна 100! \n");
        alert.showAndWait();
    }

    public void initialize() {

        Image image1 = new Image("https://images11.popmeh.ru/upload/img_cache/ee2/ee2f260cae78083fb97ce3ae05d14444_ce_700x400x0x0_cropped_800x427.jpg");
        virusView.setImage(image1);

        Image image2 = new Image("http://karty-mira.ru/maps/1.jpg");
        locacityView.setImage(image2);

        sirLineChart.setTitle("Модель SIR");
        sirLineChart.setPrefWidth(645.0);
        sirLineChart.setPrefHeight(350.0);
        sirPane.getChildren().add(sirLineChart);
        xAxisSir.setLabel("Время, сутки");
        yAxisSir.setLabel("Популяция, %");

        sisLineChart.setTitle("Модель SIS");
        sisLineChart.setPrefWidth(645.0);
        sisLineChart.setPrefHeight(350.0);
        sisPane.getChildren().add(sisLineChart);
        xAxisSis.setLabel("Время, сутки");
        yAxisSis.setLabel("Популяция, %");

        modLineChart.setTitle("Модель SIRm");
        modLineChart.setPrefWidth(645.0);
        modLineChart.setPrefHeight(350.0);
        sirModPane.getChildren().add(modLineChart);
        xAxisMod.setLabel("Время, сутки");
        yAxisMod.setLabel("Популяция, %");

        sirsLineChart.setTitle("Модель SIRS");
        sirsLineChart.setPrefWidth(645.0);
        sirsLineChart.setPrefHeight(350.0);
        sirsPane.getChildren().add(sirsLineChart);
        xAxisSirs.setLabel("Время, сутки");
        yAxisSirs.setLabel("Популяция, %");

        seirLineChart.setTitle("Модель SEIR");
        seirLineChart.setPrefWidth(645.0);
        seirLineChart.setPrefHeight(350.0);
        seirPane.getChildren().add(seirLineChart);
        xAxisSeir.setLabel("Время, сутки");
        yAxisSeir.setLabel("Популяция, %");

        seirsLineChart.setTitle("Модель SEIRS");
        seirsLineChart.setPrefWidth(645.0);
        seirsLineChart.setPrefHeight(350.0);
        seirsPane.getChildren().add(seirsLineChart);
        xAxisSeirs.setLabel("Время, сутки");
        yAxisSeirs.setLabel("Популяция, %");

        verLineChart.setTitle("Упрощённая модель");
        verLineChart.setPrefWidth(645.0);
        verLineChart.setPrefHeight(350.0);
        verPane.getChildren().add(verLineChart);
        xAxisVer.setLabel("Время, год");
        yAxisVer.setLabel("Популяция, %");

        baseLineChart.setTitle("Базовая модель");
        baseLineChart.setPrefWidth(645.0);
        baseLineChart.setPrefHeight(350.0);
        basePane.getChildren().add(baseLineChart);
        xAxisBase.setLabel("Время, год");
        yAxisBase.setLabel("Популяция, %");

        slpicLineChart.setTitle("Модель SLPIC");
        slpicLineChart.setPrefWidth(645.0);
        slpicLineChart.setPrefHeight(370.0);
        slpicPane.getChildren().add(slpicLineChart);
        xAxisSlpic.setLabel("Время, год");
        yAxisSlpic.setLabel("Популяция, %");

        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");

        deathVirField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) deathVirField.setText(oldValue);
        });
        lambdaField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) lambdaField.setText(oldValue);
        });

        chanceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) chanceField.setText(oldValue);
        });

        speedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) speedField.setText(oldValue);
        });

        cureField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) cureField.setText(oldValue);
        });
        enduranceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) enduranceField.setText(oldValue);
        });
        populationField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) populationField.setText(oldValue);
        });
        bornField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) bornField.setText(oldValue);
        });
        deathField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) deathField.setText(oldValue);
        });
        contactField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) contactField.setText(oldValue);
        });
        vaccineField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) vaccineField.setText(oldValue);
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
        susceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) susceptibleField.setText(oldValue);
        });

        infectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) infectedField.setText(oldValue);
        });

        recoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) recoveredField.setText(oldValue);
        });
        seirSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirSusceptibleField.setText(oldValue);
        });

        seirInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirInfectedField.setText(oldValue);
        });
        seirExposeddField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirExposeddField.setText(oldValue);
        });

        seirRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirRecoveredField.setText(oldValue);
        });
        seirsSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirsSusceptibleField.setText(oldValue);
        });

        seirsInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirsInfectedField.setText(oldValue);
        });

        seirsExposeddField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirsExposeddField.setText(oldValue);
        });
        seirsRecoveredField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirsRecoveredField.setText(oldValue);
        });

        seirsIncubTime.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) seirsIncubTime.setText(oldValue);
        });
        verSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) verSusceptibleField.setText(oldValue);
        });

        verInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) verInfectedField.setText(oldValue);
        });

        verLatentField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) verLatentField.setText(oldValue);
        });
        baseSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) baseSusceptibleField.setText(oldValue);
        });

        baseInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) baseInfectedField.setText(oldValue);
        });

        baseLatentField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) baseLatentField.setText(oldValue);
        });
        slpicSusceptibleField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) slpicSusceptibleField.setText(oldValue);
        });

        slpicInfectedField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) slpicInfectedField.setText(oldValue);
        });

        slpicLatentField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) slpicLatentField.setText(oldValue);
        });
    }
}