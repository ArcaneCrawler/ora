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


    Dif dif = new Dif();
    int n = 100;
    private int percent = 100;
    int q = 0;

    @Autowired
    private VirusService virusService;
    @Autowired
    private LocacityService locacityService;

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


                float dead_label_text = (population - population);
                float s_label_text = (float) ((population) * result[0][n - 1]) / percent;
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                float r_label_text = (float) ((population) * result[2][n - 1] / percent);

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


                float dead_label_text = (population - population);
                float s_label_text = (float) ((population) * result[0][n - 1]) / percent;
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                float r_label_text = (float) ((population) * result[2][n - 1] / percent);

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

                float dead_label_text = (population - population);
                float s_label_text = (float) ((population) * result[0][n - 1]) / percent;
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;

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
                float current_population = dif.getPopulation();
                float dead_label_text = (population - current_population);
                float s_label_text = (float) ((population) * result[0][n - 1]) / percent;
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                float r_label_text = (float) ((population) * result[2][n - 1] / percent);

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

                float current_population = dif.getPopulation();
                float dead_label_text = (population - current_population);
                float s_label_text = (float) ((population) * result[0][n - 1]) / percent;
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                float r_label_text = (float) ((population) * result[2][n - 1] / percent);
                float e_label_text = (float) ((population) * result[3][n - 1] / percent);

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

                float current_population = dif.getPopulation();
                float dead_label_text = Math.round(population - current_population);
                System.out.println(dead_label_text);
                float s_label_text = (float) ((population) * result[0][n - 1]) / percent;
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                System.out.println(i_label_text);
                float r_label_text = (float) ((population) * result[2][n - 1] / percent);
                float e_label_text = (float) ((population) * result[3][n - 1] / percent);

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

                float current_population = dif.getPopulation();
                float dead_label_text = (population - current_population);
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                float s_label_text = (float) ((population) * result[2][n - 1] / percent);
                float l_label_text = (float) ((population) * result[0][n - 1]) / percent;

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

                float current_population = dif.getPopulation();
                float dead_label_text = (population - current_population);
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                float s_label_text = (float) ((population) * result[2][n - 1] / percent);
                float l_label_text = (float) ((population) * result[0][n - 1]) / percent;

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
        try {
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
                float i_label_text = (float) ((population) * result[1][n - 1]) / percent;
                System.out.println(i_label_text);
                float s_label_text = (float) ((population) * result[2][n - 1] / percent);
                System.out.println(s_label_text);
                float l_label_text = (float) ((population) * result[0][n - 1]) / percent;
                System.out.println(l_label_text);
                float p_label_text = (float) ((population) * result[3][n - 1]) / percent;
                float c_label_text = (float) ((population) * result[4][n - 1]) / percent;

                slpic_dead.setText(String.valueOf(dead_label_text));
                slpic_s.setText(String.valueOf(s_label_text));
                slpic_l.setText(String.valueOf(l_label_text));
                slpic_i.setText(String.valueOf(i_label_text));
                slpic_p.setText(String.valueOf(p_label_text));
                slpic_c.setText(String.valueOf(c_label_text));
            }
        } catch (NullPointerException e) {
            nullPointAlert();
        }
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