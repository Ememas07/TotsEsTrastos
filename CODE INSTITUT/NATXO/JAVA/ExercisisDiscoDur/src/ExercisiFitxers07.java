import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

// Clase Vehiculo con serialización
class Vehiculo implements Serializable {
    private String matricula;
    private String marca;
    private transient double tamanoDeposito; // No se serializa
    private String modelo;

    public Vehiculo(String matricula, String marca, double tamanoDeposito, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.tamanoDeposito = tamanoDeposito;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public double getTamanoDeposito() {
        return tamanoDeposito;
    }

    public String getModelo() {
        return modelo;
    }
}

// Clase para evitar sobrescritura en ObjectOutputStream
class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // No escribir cabecera si el fichero ya existe
        reset();
    }
}

public class ExercisiFitxers07 {
    private static final String RUTA_FICHERO = "vehiculos_serializados.dat";

    public static void main(String[] args) {
        // Pedir datos del vehículo
        String matricula = JOptionPane.showInputDialog("Matrícula:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String tamanoDepositoStr = JOptionPane.showInputDialog("Tamaño del depósito:");
        double tamanoDeposito = Double.parseDouble(tamanoDepositoStr);
        String modelo = JOptionPane.showInputDialog("Modelo:");

        Vehiculo vehiculo = new Vehiculo(matricula, marca, tamanoDeposito, modelo);

        try {
            // Añadir vehículo
            añadirVehiculo(vehiculo);
            // Mostrar todos los vehículos
            mostrarVehiculos();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para añadir un vehículo al fichero
    private static void añadirVehiculo(Vehiculo vehiculo) throws IOException {
        File fichero = new File(RUTA_FICHERO);
        ObjectOutputStream oos;

        if (fichero.exists()) {
            oos = new AppendableObjectOutputStream(new FileOutputStream(RUTA_FICHERO, true));
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO));
        }

        try (oos) {
            oos.writeObject(vehiculo);
        }
    }

    // Método para mostrar todos los vehículos
    private static void mostrarVehiculos() throws IOException, ClassNotFoundException {
        File fichero = new File(RUTA_FICHERO);
        if (!fichero.exists())
            return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_FICHERO))) {
            while (true) {
                try {
                    Vehiculo v = (Vehiculo) ois.readObject();
                    String mensaje = "Vehículo:\nMatrícula: " + v.getMatricula() + "\nMarca: " + v.getMarca() +
                            "\nTamaño Depósito: " + v.getTamanoDeposito() + "\nModelo: " + v.getModelo();
                    JOptionPane.showMessageDialog(null, mensaje);
                } catch (EOFException e) {
                    break; // Fin del fichero
                }
            }
        }
    }
}