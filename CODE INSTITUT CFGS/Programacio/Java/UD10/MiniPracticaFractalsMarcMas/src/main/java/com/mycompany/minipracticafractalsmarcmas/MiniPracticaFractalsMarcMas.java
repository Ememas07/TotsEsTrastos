/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.minipracticafractalsmarcmas;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Marc Mas
 */
public class MiniPracticaFractalsMarcMas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniPracticaFractalsMarcMas().createUI());
    }

    private void createUI() {
        JFrame frame = new JFrame("Fractals");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Icon
        Image icon = Toolkit.getDefaultToolkit().getImage(
                MiniPracticaFractalsMarcMas.class.getResource("/icon.png")
        );
        frame.setIconImage(icon);

        // ---------------------------
        // GUI
        // ---------------------------
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] fractalTypes = {
            "Canopy",
            "Koch line",
            "Koch snowflake",
            "Sierpiński triangle"
        };
        JComboBox<String> fractalSelector = new JComboBox<>(fractalTypes);

        SpinnerNumberModel iterationModel
                = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner iterationSpinner = new JSpinner(iterationModel);

        topPanel.add(new JLabel("Fractal:"));
        topPanel.add(fractalSelector);
        topPanel.add(Box.createHorizontalStrut(20));
        topPanel.add(new JLabel("Iterations:"));
        topPanel.add(iterationSpinner);

        // ---------------------------
        // DRAW AREA
        // ---------------------------
        FractalPanel drawPanel = new FractalPanel();

        fractalSelector.addActionListener(e -> {
            drawPanel.setFractalType((String) fractalSelector.getSelectedItem());
            drawPanel.repaint();
        });

        iterationSpinner.addChangeListener(e -> {
            drawPanel.setIterations((int) iterationSpinner.getValue());
            drawPanel.repaint();
        });

        drawPanel.setFractalType((String) fractalSelector.getSelectedItem());
        drawPanel.setIterations((int) iterationSpinner.getValue());

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(drawPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

class FractalPanel extends JPanel {

    private String fractalType = "Canopy";
    private int iterations = 1;

    public void setFractalType(String type) {
        this.fractalType = type;
    }

    public void setIterations(int it) {
        this.iterations = it;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        switch (fractalType) {
            case "Canopy" ->
                drawCanopy(g2, iterations);

            case "Koch line" ->
                drawKochLine(g2, iterations);

            case "Koch snowflake" ->
                drawKochSnowflake(g2, iterations);

            case "Sierpiński triangle" ->
                drawSierpinski(g2, iterations);
        }
    }

    // ---------------------------------------------------------
    // TODO FUNCTION TO DRAW A LINE USING POLAR COORDINATES
    // ---------------------------------------------------------
    private void drawPolarLine(
            Graphics2D g, double x, double y, double degrees, double length, float width, Color color) {

        // Must convert polar → cartesian and modify drawLine parameters
        // You have to use:
        // Math.toRadians(degrees);
        degrees = Math.toRadians(degrees);
        // Math.sin(degrees);
        // Math.cos(angle);

        g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g.setColor(color);

        //Example variables to draw a simple line
        int x1 = (int) x;
        int y1 = (int) y;
        int x2 = (int) (x1 + length * Math.cos(degrees));
        int y2 = (int) (y1 + length * Math.sin(degrees));

        g.drawLine(x1, y1, x2, y2);
    }

    // -----------------------------
    // (EMPTY) FRACTAL FUNCTIONS
    // -----------------------------
    private void drawCanopy(Graphics2D g, int depth, double x, double y, double a, double l, double w) {
        if (depth == 1) {
            drawPolarLine(g, x, y, a, l, (int) w, Color.decode("#00FF00"));
        } else {
            drawPolarLine(g, x, y, a, l, (int) w, Color.decode("#895129"));
        }
        if (depth > 1) {
            int angle = 30;
            int a1 = (int) (angle / 2);
            int a2 = (int) (360 - a1);
            drawCanopy(g, depth - 1, x + l * Math.cos(Math.toRadians(a)), y + l * Math.sin(Math.toRadians(a)), a - a1, l, w / 1.5);
            drawCanopy(g, depth - 1, x + l * Math.cos(Math.toRadians(a)), y + l * Math.sin(Math.toRadians(a)), a - a2, l, w / 1.5);
        }
    }

    private void drawCanopy(Graphics2D g, int depth) {
        // TODO: Implement fractal Canopy
        drawCanopy(g, depth, 450, 600, 270, 50, 20);
    }

    private void drawKochLine(Graphics2D g, int depth) {
        // TODO: Implement Koch line
        if (depth > 1) {
            drawKochLine(g, depth * 2, 350, 350, 0, 10, 5);
        } else {
            drawKochLine(g, depth, 350, 350, 0, 10, 5);
        }
    }

    private void drawKochLine(Graphics2D g, int depth, double x, double y, double a, double l, double w) {
        if (depth == 1) {
            drawPolarLine(g, x, y, a, l, (int) w, Color.decode("#FF0000"));
        } else {
            double x2 = x + l * Math.cos(Math.toRadians(a));
            double y2 = y + l * Math.sin(Math.toRadians(a));
            drawPolarLine(g, x2, y2, a + 45, l, (int) w, Color.decode("#FF0000"));
            double x3 = x2 + l * Math.cos(Math.toRadians(a));
            double y3 = y2 + l * Math.sin(Math.toRadians(a));
            drawPolarLine(g, x3, y3, a - 45, l, (int) w, Color.decode("#FF0000"));
            double x4 = x3 + l * Math.cos(Math.toRadians(a));
            double y4 = y3 + l * Math.sin(Math.toRadians(a));
            drawPolarLine(g, x4, y4, a, l, (int) w, Color.decode("#FF0000"));
        }
    }

    private void drawKochSnowflake(Graphics2D g, int depth) {
        // TODO: Implement Koch snowflake
    }

    private void drawSierpinski(Graphics2D g, int depth) {
        // TODO: Implementar Sierpiński triangle
    }
}
