package net.Temperature.controller;

import net.Temperature.InvalidValueException;
import net.Temperature.model.DataProcessor;
import net.Temperature.view.Monitor;

import java.io.IOException;

public class ActionManagement {
    private final Monitor m;
    //non si istanzia nulla della classe temperature

    /* measurementScale=new JComboBox<>(new String[]{"celsius", "kelvin", "fahrenheit"});
        JTextField input
        JButton convert
        JButton reset
        JTextArea result
    */

    public ActionManagement() throws IOException {
        m = new Monitor();
    }

    public final void start() {  //gestione bottoni
        m.see();
        m.BtnConvert.addActionListener(_ -> {
            try {
                float value = Float.parseFloat(m.inputT.getText());
                switch (m.measurementScale.getSelectedItem()+"") {
                    case "celsius" -> {
                        String k = DataProcessor.CtoK(value) + "";
                        String f = DataProcessor.CtoF(value) + "";
                        m.result.setText("Celsius = " + value
                                + "\nKelvin = " + k
                                + "\nFahrenheit = " + f);
                    }
                    case "kelvin" -> {
                        String c = DataProcessor.KtoC(value) + "";
                        String f = DataProcessor.KtoF(value) + "";
                        m.result.setText("Celsius = " + c
                                + "\nKelvin = " + value
                                + "\nFahrenheit = " + f);
                    }
                    case "fahrenheit" -> {
                        String c = DataProcessor.FtoC(value) + "";
                        String k = DataProcessor.FtoK(value) + "";
                        m.result.setText("Celsius = " + c
                                + "\nKelvin = " + k
                                + "\nFahrenheit = " + value);
                    }
                }
            } catch (InvalidValueException ex) {
                m.result.setText(ex.getMessage());
                m.inputT.setText("");
            } catch (Exception e) {
                m.result.setText("Something went wrong");
                m.inputT.setText("");
            }
        });

        m.BtnReset.addActionListener(_ -> {
            m.result.setText("");
            m.inputT.setText("");
        });  //pulizia campi



    }

}
