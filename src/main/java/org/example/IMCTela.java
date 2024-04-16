package org.example;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class IMCTela extends JFrame {
    private JTextField fieldHeight, fieldWeight;
    private JLabel labelResult, labelInterpretation;

    public IMCTela() {
        setTitle("Cálculo de IMC");
        setSize(300, 200);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Altura (m):"));
        fieldHeight = new JTextField();
        add(fieldHeight);

        add(new JLabel("Peso (kg):"));
        fieldWeight = new JTextField();
        add(fieldWeight);

        JButton btnCalculate = new JButton("Calcular");
        btnCalculate.addActionListener(e -> calculateIMC());
        add(btnCalculate);

        labelResult = new JLabel("Resultado: ");
        add(labelResult);

        labelInterpretation = new JLabel("Interpretação: ");
        add(labelInterpretation);
    }

    private void calculateIMC() {
        try {
            double height = Double.parseDouble(fieldHeight.getText());
            double weight = Double.parseDouble(fieldWeight.getText());
            double imc = weight / (height * height); // Certifique-se de que a altura e o peso são parseados como double
            DecimalFormat df = new DecimalFormat("#.##");
            labelResult.setText("Resultado: " + df.format(imc));
            labelInterpretation.setText("Interpretação: " + interpretIMC(imc));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.");
        }
    }

    private String interpretIMC(double imc) {
        if (imc < 18.5) {
            return "Magreza";
        } else if (imc >= 18.5 && imc <= 25) {
            return "Normal";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc <= 39.9) {
            return "Obesidade";
        } else {
            return "Obesidade grave";
        }
    }
}

