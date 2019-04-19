package com.math.epidemic.Controller;

public class Dif {
    int arrayLenght = 3;
    int n = 100;
    double[][] model = new double[arrayLenght][n];
    float step = (float) 0.333;
    float population;



    public void Null() {

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= arrayLenght - 1; j++) {
                model[j][i] = 0;
            }
        }
    }

    public void initialize() {

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= arrayLenght; j++) {
                model[j][i] = 0;
            }
        }
    }

    public double[][] SIR(float startS, float startI, float startR, float contact, float influenceTime) {

        Null();
        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;

            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (influenceTime * model[1][i - 1]);
                }

        }

        Round();
        return (model);
    }

    public double[][] SIRmod(float startS, float startI, float startR, float contact, float influenceTime, float birthCoef) {
        Null();
        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                population = startS + startI + startR;
            } else {

                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] + birthCoef * (population - model[0][i - 1]));
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1] - birthCoef * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (influenceTime * model[1][i - 1] - birthCoef * model[2][i - 1]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SIS(float startS, float startI, float contact, float influenceTime, float birthCoef) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                population = startS + startI;
            } else {
                model[0][i] = model[0][i - 1] + step * (-contact * model[0][i - 1] * model[1][i - 1] + birthCoef * (population - model[0][i - 1]) + influenceTime * model[1][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1] - birthCoef * model[1][i - 1]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SIRS(float startS, float startI, float startR, float contact, float influenceTime, float birthCoef, float lossOfImmunity) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                population = startS + startI + startR;

            } else {
                model[0][i] = model[0][i - 1] + step * (-contact * model[0][i - 1] * model[1][i - 1] + birthCoef * (population - model[0][i - 1]) + lossOfImmunity * model[2][i - 1]);
                model[1][i] = model[1][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] - influenceTime * model[1][i - 1] - birthCoef * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (influenceTime * model[1][i - 1] - birthCoef * model[2][i - 1] - lossOfImmunity * model[2][i - 1]);

            }
        }
        Round();
        return (model);
    }

    public void Round() {
        System.out.println("start round");
        for (int a = 0; a <= n - 1; a++) {
            for (int b = 0; b <= arrayLenght - 1; b++) {
                model[b][a] = Math.round(model[b][a] * 100.0) / 100.0;
            }
           /* System.out.print("a:" + model[0][a] + "; b:" + model[1][a] + "; c:" + model[2][a]);
            System.out.println();*/
        }
    }
}
