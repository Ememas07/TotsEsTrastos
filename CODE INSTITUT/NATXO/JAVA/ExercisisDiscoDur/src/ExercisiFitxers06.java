import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExercisiFitxers06 {
    private static final String RUTA_FICHERO = "vehiculos.dat";

    public static void main(String[] args) {
        // Pedir datos del vehículo
        String matricula = JOptionPane.showInputDialog("Matrícula:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String tamanoDepositoStr = JOptionPane.showInputDialog("Tamaño del depósito:");
        double tamanoDeposito = Double.parseDouble(tamanoDepositoStr);
        String modelo = JOptionPane.showInputDialog("Modelo:");

        try {
            // Añadir vehículo
            añadirVehiculo(matricula, marca, tamanoDeposito, modelo);
            // Mostrar todos los vehículos
            mostrarVehiculos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para añadir un vehículo al fichero
    private static void añadirVehiculo(String matricula, String marca, double tamanoDeposito, String modelo)
            throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(RUTA_FICHERO, true))) {
            dos.writeUTF(matricula);
            dos.writeUTF(marca);
            dos.writeDouble(tamanoDeposito);
            dos.writeUTF(modelo);
        }
    }

    // Método para mostrar todos los vehículos
    private static void mostrarVehiculos() throws IOException {
        File fichero = new File(RUTA_FICHERO);
        if (!fichero.exists())
            return;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(RUTA_FICHERO))) {
            while (dis.available() > 0) {
                String matricula = dis.readUTF();
                String marca = dis.readUTF();
                double tamanoDeposito = dis.readDouble();
                String modelo = dis.readUTF();
                String mensaje = "Vehículo:\nMatrícula: " + matricula + "\nMarca: " + marca +
                        "\nTamaño Depósito: " + tamanoDeposito + "\nModelo: " + modelo;
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }
    }
}