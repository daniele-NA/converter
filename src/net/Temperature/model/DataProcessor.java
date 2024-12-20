package net.Temperature.model;

import net.Temperature.InvalidValueException;

public class DataProcessor {
/*Celsius=C     Kelvin=K    Fahrenheit=F
    CtoK  / CtoF    Celsius>kelvin   / Celsius>Fahrenheit
    KtoC  / KtoF
    FtoC  / FtoK
     */


    private DataProcessor() {
    }   //non istanziabile

    private static void check(float value, String t) throws InvalidValueException {
        //C=999.99   K=1272.99    F=1830.99
        switch (t) {
            case "c" -> {
                if (value < -999.99 || value > 999.99) throw new InvalidValueException();
            }
            case "k" -> {
                if (value < -1272.99 || value > 1272.99) throw new InvalidValueException();
            }
            case "f" -> {
                if (value < -1830.99 || value > 1830.99) throw new InvalidValueException();
            }
        }
    }

    public static float CtoK(float value) throws InvalidValueException {
        check(value, "c");
        return (float) (value + 273.15);
    }
    public static float CtoF(float value) throws InvalidValueException {
        check(value, "c");
        return (float) ((value * 1.8) + 32);
    }


    public static float KtoC(float value) throws InvalidValueException {
        check(value, "k");
        return (float) (value - 273.15);
    }
    public static float KtoF(float value) throws InvalidValueException {
        check(value, "k");
        return (float) ((value * 1.8) - 459.67);
    }


    public static float FtoC(float value) throws InvalidValueException {
        check(value, "f");
        return (float) ((value - 32) * 0.5);
    }
    public static float FtoK(float value) throws InvalidValueException {
        check(value, "f");
        return (float) (0.5 * (value - 32) + 273.15);
    }



}
