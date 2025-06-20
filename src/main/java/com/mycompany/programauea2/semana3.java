package com.mycompany.programauea2;

/**
 *
 * @author Will Mzzl
 */

import java.util.Scanner;

public class semana3 {
    public static void main(String[] args) {
        // PROGRAMACIÓN TRADICIONAL
        System.out.println("### Programación Tradicional ###");
        Tradicional.ejecutar();

        // PROGRAMACIÓN ORIENTADA A OBJETOS
        System.out.println("\n### Programación Orientada a Objetos ###");
        ClimaSemana semana = new ClimaSemana();
        semana.ingresarTemperaturas();
        double promedio = semana.calcularPromedio();
        System.out.println("El promedio semanal de temperaturas (POO) es: " + promedio);
    }
}

// Programación Tradicional
class Tradicional {
    public static void ingresarTemperaturas(double[] temperaturas) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            System.out.print("Ingresa la temperatura del día " + (i + 1) + ": ");
            temperaturas[i] = sc.nextDouble();
        }
    }

    public static double calcularPromedio(double[] temperaturas) {
        double suma = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i];
        }
        return suma / temperaturas.length;
    }

    public static void ejecutar() {
        double[] temperaturas = new double[7];
        ingresarTemperaturas(temperaturas);
        double promedio = calcularPromedio(temperaturas);
        System.out.println("El promedio semanal de temperaturas (Tradicional) es: " + promedio);
    }
}

// Programación Orientada a Objetos

class DiaClima {
    private double temperatura;

    // Constructor
    public DiaClima() {
        temperatura = 0;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }
}

class ClimaSemana {
    private DiaClima[] dias;

    public ClimaSemana() {
        dias = new DiaClima[7];
        for (int i = 0; i < 7; i++) {
            dias[i] = new DiaClima();
        }
    }

    public void ingresarTemperaturas() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < dias.length; i++) {
            System.out.print("Ingresa la temperatura del día " + (i + 1) + ": ");
            double temp = sc.nextDouble();
            dias[i].setTemperatura(temp);
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < dias.length; i++) {
            suma += dias[i].getTemperatura();
        }
        return suma / dias.length;
    }
}
