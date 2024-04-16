package org.example;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class GastoCaloricoTela extends JFrame {
    private JTextField fieldWeight, fieldHeight, fieldAge;
    private JComboBox<String> comboActivity;
    private JLabel labelResult;

    public GastoCaloricoTela() {
        setTitle("Cálculo de Gasto Calórico");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Peso (kg):"));
        fieldWeight = new JTextField();
        add(fieldWeight);

        add(new JLabel("Altura (cm):"));
        fieldHeight = new JTextField();
        add(fieldHeight);

        add(new JLabel("Idade:"));
        fieldAge = new JTextField();
        add(fieldAge);

        add(new JLabel("Nível de atividade:"));
        comboActivity = new JComboBox<>(new String[] {"Sedentário", "Levemente ativo", "Moderadamente ativo", "Muito ativo", "Extremamente ativo"});
        add(comboActivity);

        JButton btnCalculate = new JButton("Calcular");
        btnCalculate.addActionListener(e -> calculateCalories());
        add(btnCalculate);

        labelResult = new JLabel("Resultado: ");
        add(labelResult);
    }

    private void calculateCalories() {
        try {
            double weight = Double.parseDouble(fieldWeight.getText());
            double height = Double.parseDouble(fieldHeight.getText());
            int age = Integer.parseInt(fieldAge.getText());
            int activityIndex = comboActivity.getSelectedIndex();

            double bmr = 10 * weight + 6.25 * height - 5 * age + (comboActivity.getSelectedIndex() == 0 ? 5 : -161);
            double factor = switch (activityIndex) {
                case 0 -> 1.2;
                case 1 -> 1.375;
                case 2 -> 1.55;
                case 3 -> 1.725;
                case 4 -> 1.9;
                default -> 1.0;
            };
            double calories = bmr * factor;
            DecimalFormat df = new DecimalFormat("#.##");
            labelResult.setText("Resultado: " + df.format(calories));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.");
        }
    }
}
