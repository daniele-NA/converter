package net.Temperature.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Monitor extends JFrame {

    public final JComboBox<String> measurementScale = new JComboBox<>(new String[]{"celsius", "kelvin", "fahrenheit"});
    public final JLabel temperature = new JLabel("temperature : ");
    public final JTextField inputT = new JTextField(7);
    public final JButton BtnConvert = new JButton("  convert  ");
    public final JButton BtnReset = new JButton("  reset  ");
    public final JTextArea result = new JTextArea();

    public Monitor() throws IOException {
        super("DataProcessor converter");
        BufferedImage imageLogoBI= ImageIO.read(Objects.requireNonNull(getClass().getResource("/Logo_Termometro.png")));
        ImageIcon icon=new ImageIcon(imageLogoBI);
        setIconImage(icon.getImage());
    }

    public void see() {
        setLayout(new BorderLayout(10, 10));

        Container buttonBar = new Container();
        buttonBar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        measurementScale.setBackground(Color.LIGHT_GRAY);
        measurementScale.setForeground(Color.BLUE);
        temperature.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        inputT.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        inputT.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        inputT.setForeground(Color.magenta);
        BtnConvert.setBackground(Color.LIGHT_GRAY);
        BtnConvert.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        BtnReset.setBackground(Color.LIGHT_GRAY);
        BtnReset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        buttonBar.add(measurementScale);
        buttonBar.add(temperature);
        buttonBar.add(inputT);
        buttonBar.add(BtnConvert);
        buttonBar.add(BtnReset);

        result.setEditable(false);
        result.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        result.setForeground(Color.BLUE);
        result.setPreferredSize(new Dimension(200, 50));
        result.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));




        JPanel tableContainer=new JPanel(new BorderLayout());
        JTable table = new JTable(4, 4);
        table.setBackground(Color.LIGHT_GRAY);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        table.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        table.setEnabled(false);
        table.getTableHeader().setEnabled(false);
        setBackground(Color.LIGHT_GRAY);
        table.setRowHeight(29);

        /**
         * scrittura di tutte le formule
         */
        table.setValueAt("Result in Celsius", 0, 1);
        table.setValueAt("Result in kelvin", 0, 2);
        table.setValueAt("Result in Fahrenheit", 0, 3);

        table.setValueAt("Celsius", 1, 0);
        table.setValueAt("           -", 1, 1);
        table.setValueAt("Celsius + 273.15", 1, 2);
        table.setValueAt("(Celsius *9/5)+32", 1, 3);

        table.setValueAt("kelvin", 2, 0);
        table.setValueAt("Kelvin-273.15", 2, 1);
        table.setValueAt("           -", 2, 2);
        table.setValueAt("K * 9/5-459.67", 2, 3);

        table.setValueAt("Fahrenheit", 3, 0);
        table.setValueAt("(F-32)*5/9", 3, 1);
        table.setValueAt("5/9*(F-32)+273.15", 3, 2);
        table.setValueAt("           -", 3, 3);
        tableContainer.add(table, BorderLayout.CENTER);



        this.add(tableContainer, BorderLayout.CENTER);
        this.add(buttonBar, BorderLayout.PAGE_END);
        this.add(result, BorderLayout.LINE_END);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setSize(630, 230);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }


}
