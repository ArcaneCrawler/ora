package com.math.epidemic.Controller;

public class Dif {
    int arrayLenght = 5;
    int n = 100;
    double[][] model = new double[arrayLenght][n];
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

    public double[][] SIRS(float startS, float startI, float startR, float contact, float cure, float ratio, float lossOfImmunity) {

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
        Round();
        return (model);
    }

    public double[][] SEIR(float startS, float startE, float startI, float startR, float contact, float cure, float ratio, float speed) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                model[3][i] = startE;
                pop = startS + startI + startR + startE;
            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]));
                model[1][i] = model[1][i - 1] + step * (speed *  model[3][i-1]- cure * model[1][i - 1] - ratio * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1] - ratio * model[2][i - 1]);
                model[3][i] = model[3][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - model[3][i - 1]*(speed+ratio)) ;
                pop = (float) (model[0][i] + model[1][i] + model[2][i] + model[3][i]);
            }
        }
        Round();
        return (model);
    }

    public double[][] SEIRS(float startS, float startE, float startI, float startR, float contact, float cure, float ratio, float speed, float lossOfImmunity) {

        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                model[0][i] = startS;
                model[1][i] = startI;
                model[2][i] = startR;
                model[3][i] = startE;
                pop = startS + startI + startR + startE;
            } else {
                model[0][i] = model[0][i - 1] + step * (-1 * contact * model[0][i - 1] * model[1][i - 1] / pop + ratio * (pop - model[0][i - 1]+ lossOfImmunity * model[2][i - 1]));
                model[1][i] = model[1][i - 1] + step * (speed *  model[3][i-1]- cure * model[1][i - 1] - ratio * model[1][i - 1]);
                model[2][i] = model[2][i - 1] + step * (cure * model[1][i - 1] - ratio * model[2][i - 1] - lossOfImmunity * model[2][i - 1]);
                model[3][i] = model[3][i - 1] + step * (contact * model[0][i - 1] * model[1][i - 1] / pop - model[3][i - 1]*(speed+ratio)) ;
                pop = (float) (model[0][i] + model[1][i] + model[2][i] + model[3][i]);
            }
        }
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
                model[2][i] = model[2][i - 1] + step * (born - death * model[2][i - 1] - contact * model[1][i - 1]);
                pop = (float) ((model[0][i] + model[1][i] + model[2][i]));
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

                System.out.println("Suspected " + i + " = " + model[2][i]);
                System.out.println("Latient " + i + " = " + model[0][i]);
                System.out.println("Infic " + i + " = " + model[1][i]);
                System.out.println("P " + i + " = " + model[3][i]);
                System.out.println("C " + i + " = " + model[4][i]);
            }
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