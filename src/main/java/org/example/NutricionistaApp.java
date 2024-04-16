package org.example;
import javax.swing.*;
import java.awt.*;

public class NutricionistaApp extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                NutricionistaApp frame = new NutricionistaApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public NutricionistaApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        setTitle("Sindicato dos Nutricionistas");

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel lblNewLabel = new JLabel("Selecione uma opção:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JButton btnIMC = new JButton("IMC");
        btnIMC.addActionListener(e -> new IMCTela().setVisible(true));
        contentPane.add(btnIMC);

        JButton btnGastoCalorico = new JButton("Gasto Calórico");
        btnGastoCalorico.addActionListener(e -> new GastoCaloricoTela().setVisible(true));
        contentPane.add(btnGastoCalorico);

        JButton btnRecomendacoes = new JButton("Recomendações");
        btnRecomendacoes.addActionListener(e -> new RecomendacoesTela().setVisible(true));
        contentPane.add(btnRecomendacoes);
    }
}
