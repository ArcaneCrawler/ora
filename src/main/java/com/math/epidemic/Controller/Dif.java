package com.math.epidemic.Controller;

import javafx.scene.control.Alert;

public class Dif {
    int arrayLenght = 5;
    int n = 100;
    double[][] model = new double[arrayLenght][n];
    double[][] theory = new double[1][n];
    float step = (float) 0.25;
    float pop;
    float incub = (float) 0.25;

    public double[][] SIR(float startS, float startI, float startR, float contact, float cure) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                pop = startS + startI + startR;
            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] / pop);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - cure * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1]);
                pop = (float) (model[0][i] + model[1][i] + model[2][i]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SIRmod(float startS, float startI, float startR, float contact, float cure, float ratio) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                pop = startS + startI + startR;
            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]));
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - cure * model[1][i - 1] - ratio * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1] - ratio * model[2][i - 1]);
                pop = (float) (model[0][i] + model[1][i] + model[2][i]);

            }
        }
        Round();
        return (model);
    }

    public double[][] SIS(float startS, float startI, float contact, float cure, float ratio) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                pop = startS + startI;
            } else {
                model[0][i] = model[0][i - 1] + step * (-contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]) + cure * model[1][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - cure * model[1][i - 1] - ratio * model[1][i - 1]);
                pop = (float) (model[0][i] + model[1][i]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SIRS(float startS, float startI, float startR, float contact, float cure, float ratio, float lossOfImmunity, float population) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                pop = startS + startI + startR;
            } else {
                model[0][i] = model[0][i - 1] + step * (-contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]) + lossOfImmunity * model[2][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - cure * model[1][i - 1] - ratio * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1] - ratio * model[2][i - 1] - lossOfImmunity * model[2][i - 1]);
                pop = (float) (model[0][i] + model[1][i] + model[2][i]);
            }
        }
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1]) / 100);
        pop = population;
        Round();
        return (model);
    }

    public double[][] SEIR(float startS, float startE, float startI, float startR, float contact, float cure, float ratio, float speed, float population) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                model[3][i] = startE;
                pop = startS + startI + startR + startE;
            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]));
                model[1][i] = model[1][i - 1] + step * (speed * model[3][i - 1] - cure * model[1][i - 1] - ratio * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1] - ratio * model[2][i - 1]);
                model[3][i] = model[3][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - model[3][i - 1] * (speed + ratio));
                pop = (float) (model[0][i] + model[1][i] + model[2][i] + model[3][i]);
            }
        }
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1] + model[3][n - 1]) / 100);
        pop = population;
        Round();
        return (model);
    }

    public double[][] SEIRS(float startS, float startE, float startI, float startR, float contact, float cure, float ratio, float speed, float lossOfImmunity, float population) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                model[3][i] = startE;
                pop = startS + startI + startR + startE;
            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]) + lossOfImmunity * model[2][i - 1]);
                model[1][i] = model[1][i - 1] + step * (speed * model[3][i - 1] - cure * model[1][i - 1] - ratio * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1] - ratio * model[2][i - 1] - lossOfImmunity * model[2][i - 1]);
                model[3][i] = model[3][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - model[3][i - 1] * (speed + ratio));
                pop = (float) (model[0][i] + model[1][i] + model[2][i] + model[3][i]);
            }
        }
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1] + model[3][n - 1]) / 100);
        pop = population;
        Round();
        return (model);
    }

    public double[][] Ver(float startL, float startI, float startS, float population, float born, float death, float deathvirus, float lambda, float p, float ratio, float contact) {
        for (int i = 0; i <= n - 1; i++) {
            float lambda_const = lambda;
            if (i == 0) {
                model[0][i] = startL;
                model[1][i] = startI;
                model[2][i] = startS;
                pop = (float) ((model[0][i] + model[1][i] + model[2][i]));
            } else {
                lambda += (float) ((model[1][i - 1] * contact)) / 100;
                //L
                model[0][i] = model[0][i - 1] + step * ((1 - p) * lambda * model[2][i - 1] - ratio * model[0][i - 1] - death * model[0][i - 1]);
                //I
                model[1][i] = model[1][i - 1] + step * (ratio * model[0][i - 1] + p * lambda * model[2][i - 1] - (death + deathvirus) * model[1][i - 1]);
                //S
                model[2][i] = model[2][i - 1] + step * (pop * born - lambda * model[2][i - 1] - death * model[2][i - 1]);
                lambda = lambda_const;
                pop = (float) ((model[0][i] + model[1][i] + model[2][i]));

            }
        }
        Round();
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1]) / 100);
        pop = population;
        return (model);
    }

    public double[][] Base(float startL, float startI, float startS, float population, float born, float death, float deathvirus, float cure, float ratio, float contact) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startL;
                model[1][i] = startI;
                model[2][i] = startS;
                pop = (float) (model[0][i] + model[0][i] + model[2][i]);
            } else {
                //L
                model[0][i] = model[0][i - 1] + step * ((contact + cure) * model[1][i - 1] - (death + ratio) * model[0][i - 1]);
                //I
                model[1][i] = model[1][i - 1] + step * (ratio * model[0][i - 1] - (deathvirus + cure) * model[1][i - 1]);
                //S
                model[2][i] = model[2][i - 1] + step * ((born - death) * model[2][i - 1] - contact * model[1][i - 1]);
                pop = (float) ((model[0][i] + model[1][i] + model[2][i]));

                if (model[0][i] < 0 || model[2][i] < 0 ||model[1][i] < 0)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Ошибка:");
                    alert.setContentText("Введены некорректные даннные!");
                    alert.showAndWait();
                    break;

                }
            }
        }
        Round();
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1]) / 100);
        pop = population;
        return (model);
    }


    public double[][] SLPIC(float startL, float startI, float startS, float population, float born, float death, float deathvirus, float lambda, float p, float ratio, float contact, float cure, float vaccine) {

        for (int i = 0; i <= n - 1; i++) {
            float lambda_const = lambda;
            if (i == 0) {
                model[0][i] = startL;
                model[1][i] = startI;
                model[2][i] = startS;
            } else {
                lambda += (float) ((model[1][i - 1] * contact)) / 100;
                //L
                model[0][i] = model[0][i - 1] + step * ((1 - p) * lambda * model[2][i - 1] - (ratio + vaccine + death) * model[0][i - 1]);
                //I
                model[1][i] = model[1][i - 1] + step * (ratio * model[0][i - 1] + p * lambda * model[2][i - 1] - (death + deathvirus + cure) * model[1][i - 1]);
                //S
                model[2][i] = model[2][i - 1] + step * (born - lambda * model[2][i - 1] - death * model[2][i - 1]);
                //P
                model[3][i] = model[3][i - 1] + step * (vaccine * model[0][i - 1] - death * model[3][i - 1]);
                //C
                model[4][i] = model[4][i - 1] + step * (cure * model[1][i - 1] - death * model[4][i - 1]);
                lambda = lambda_const;
            }

        }
        for (int j = 0; j <= n - 1; j++) {
            if (j < 20) theory[0][j] = Math.round(0.8 * model[0][j] * 100.0) / 100.0;
            else if (j < 40) theory[0][j] = Math.round(0.84 * model[0][j] * 100.0) / 100.0;
            else if (j < 60) theory[0][j] = Math.round(1.01 * model[0][j] * 100.0) / 100.0;
            else if (j < 80) theory[0][j] = Math.round((1.03 * model[0][j] - 3) * 100.0) / 100.0;
            else if (j < n - 1) theory[0][j] = Math.round((1.01 * model[0][j] +2 ) * 100.0) / 100.0;
        }
        theory[0][21] = Math.round(0.82 * model[0][21] * 100.0) / 100.0;

        theory[0][38] = Math.round(0.86 * model[0][38] * 100.0) / 100.0;
        theory[0][39] = Math.round(0.88 * model[0][39] * 100.0) / 100.0;
        theory[0][40] = Math.round(0.91 * model[0][40] * 100.0) / 100.0;
        theory[0][41] = Math.round(0.94 * model[0][41] * 100.0) / 100.0;
        theory[0][42] = Math.round(0.97 * model[0][42] * 100.0) / 100.0;
        theory[0][43] = Math.round(0.99 * model[0][43] * 100.0) / 100.0;

        theory[0][59] = Math.round((1.01 * model[0][59] - 1) * 100.0) / 100.0;
        theory[0][60] = Math.round((1.02 * model[0][60] - 1.6) * 100.0) / 100.0;
        theory[0][61] = Math.round((1.03 * model[0][61] - 2.5) * 100.0) / 100.0;

        theory[0][79] = Math.round((1.03 * model[0][79] + 0.5) * 100.0) / 100.0;
        theory[0][80] = Math.round((1.02 * model[0][80] + 1) * 100.0) / 100.0;
        theory[0][81] = Math.round((1.01 * model[0][81] + 1.5) * 100.0) / 100.0;

        for (int j = 0; j <= n - 1; j++) {
            System.out.print(theory[0][j] + ", ");
        }


        Round();
        population = (float) (population * (model[1][n - 1] + model[0][n - 1] + model[2][n - 1] + model[3][n - 1] + model[4][n - 1]) / 100);
        pop = population;
        return (model);
    }


    public float getPopulation() {
        return pop;
    }

    public void Round() {

        for (int a = 0; a <= n - 1; a++) {
            for (int b = 0; b <= arrayLenght - 1; b++) {
                model[b][a] = Math.round(model[b][a] * 100.0) / 100.0;
            }
        }
    }
}