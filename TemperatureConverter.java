import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame {

    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> conversionBox;

    public TemperatureConverter() {

        setTitle("Temperature Converter");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        JLabel title = new JLabel(
            "TEMPERATURE CONVERTER",
            SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel inputLabel = new JLabel("Enter Temperature:");

        inputField = new JTextField();

        conversionBox = new JComboBox<>(new String[]{
            "Celsius to Fahrenheit",
            "Fahrenheit to Celsius",
            "Celsius to Kelvin",
            "Kelvin to Celsius",
            "Fahrenheit to Kelvin",
            "Kelvin to Fahrenheit"
        });

        JButton convertButton = new JButton("Convert");

        resultLabel = new JLabel(
            "Result will appear here",
            SwingConstants.CENTER
        );

        convertButton.addActionListener(e -> convertTemperature());

        panel.add(title);
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(conversionBox);
        panel.add(convertButton);

        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void convertTemperature() {

        try {
            double temperature =
                Double.parseDouble(inputField.getText());

            String choice =
                (String) conversionBox.getSelectedItem();

            double result = 0;
            String unit = "";

            switch (choice) {

                case "Celsius to Fahrenheit":
                    result = (temperature * 9 / 5) + 32;
                    unit = "°F";
                    break;

                case "Fahrenheit to Celsius":
                    result = (temperature - 32) * 5 / 9;
                    unit = "°C";
                    break;

                case "Celsius to Kelvin":
                    result = temperature + 273.15;
                    unit = "K";
                    break;

                case "Kelvin to Celsius":
                    result = temperature - 273.15;
                    unit = "°C";
                    break;

                case "Fahrenheit to Kelvin":
                    result = (temperature - 32) * 5 / 9 + 273.15;
                    unit = "K";
                    break;

                case "Kelvin to Fahrenheit":
                    result = (temperature - 273.15) * 9 / 5 + 32;
                    unit = "°F";
                    break;
            }

            if ((choice.contains("Kelvin") && temperature < 0) ||
                (choice.contains("Celsius") && choice.startsWith("Celsius")
                    && temperature < -273.15) ||
                (choice.contains("Fahrenheit") &&
                    choice.startsWith("Fahrenheit") &&
                    temperature < -459.67)) {

                JOptionPane.showMessageDialog(
                    this,
                    "Temperature is below absolute zero!",
                    "Invalid Temperature",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            resultLabel.setText(
                String.format("Converted Temperature: %.2f %s",
                result, unit)
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid numeric temperature!",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            () -> new TemperatureConverter()
        );
    }
}

