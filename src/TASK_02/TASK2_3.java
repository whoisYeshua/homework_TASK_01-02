package TASK_02;
/*Напишите класс BaseConverter для конвертации из градусов по Цельсию в
Кельвины, Фаренгейты, и так далее. Все конвертации реализовать через
имплементацию интерфейса и собственные классы.*/

import java.util.Scanner;

public class TASK2_3 {
    public static void main(String[] args) {

        System.out.print("Введите температуру в °C, которую нужно перевести: ");
        Scanner scan = new Scanner(System.in);
        double celsius = scan.nextDouble();

        double K = new Kelvin().getValue(celsius);
        double F = new Fahrenheit().getValue(celsius);
        double R = new Reaumur().getValue(celsius);


        System.out.println("K = " + K);
        System.out.println("°F = " + F);
        System.out.println("°R = " + R);
        System.out.println("°N = " + new Newton().getValue(celsius));

    }
}

interface Converter {
    double getValue(double celsius);
}

class Kelvin implements Converter {

    @Override
    public double getValue(double celsius) {
        return celsius + 273.15;
    }
}

class Fahrenheit implements Converter {

    @Override
    public double getValue(double celsius) {
        return 1.8 * celsius + 32;
    }
}

class Reaumur implements Converter {

    @Override
    public double getValue(double celsius) {
        return 0.8 * celsius;
    }
}

class Newton implements Converter {

    @Override
    public double getValue(double celsius) {
        return 0.33 * celsius;
    }
}

