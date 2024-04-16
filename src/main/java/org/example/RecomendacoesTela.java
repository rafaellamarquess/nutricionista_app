package org.example;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class RecomendacoesTela extends JFrame {
    private JTextField fieldCalories;
    private JLabel labelCarbs, labelProtein, labelFat;

    public RecomendacoesTela() {
        setTitle("Recomendações Nutricionais");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Calorias totais:"));
        fieldCalories = new JTextField();
        add(fieldCalories);

        JButton btnCalculate = new JButton("Calcular");
        btnCalculate.addActionListener(e -> calculateNutrition());
        add(btnCalculate);

        labelCarbs = new JLabel("Carboidratos: ");
        add(labelCarbs);

        labelProtein = new JLabel("Proteínas: ");
        add(labelProtein);

        labelFat = new JLabel("Gorduras: ");
        add(labelFat);
    }

    private void calculateNutrition() {
        try {
            double calories = Double.parseDouble(fieldCalories.getText());
            double carbs = calories * 0.5 / 4; // 50% of calories from carbs
            double protein = calories * 0.2 / 4; // 20% of calories from protein
            double fat = calories * 0.3 / 9; // 30% of calories from fat

            DecimalFormat df = new DecimalFormat("#.##");
            labelCarbs.setText("Carboidratos: " + df.format(carbs) + "g");
            labelProtein.setText("Proteínas: " + df.format(protein) + "g");
            labelFat.setText("Gorduras: " + df.format(fat) + "g");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido para calorias.");
        }
    }
}
