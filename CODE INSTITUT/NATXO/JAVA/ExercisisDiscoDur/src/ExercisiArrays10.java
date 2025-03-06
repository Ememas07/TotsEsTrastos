public class ExercisiArrays10 {
    // 10) Crea un array de números y otro de String de 10 posiciones donde
    // insertaremos notas entre 0 y 10 (debemos controlar que inserte una nota
    // valida), pudiendo ser decimal la nota en el array de números, en el de
    // Strings se insertaran los nombres de los alumnos.Después, crearemos un array
    // de String donde insertaremos el resultado de la nota con palabras. Si la nota
    // esta entre 0 y 4,99 , sera un suspenso Si esta entre 5 y 6,99 , sera un bien.
    // Si esta entre 7 y 8,99 sera un notable. Si esta entre 9 y 10 sera un
    // sobresaliente. Muestra por pantalla, el alumno su nota y su resultado en
    // palabras. Crea los métodos que creas conveniente.

    public static void main(String[] args) {
        double[] notas = new double[10];
        String[] alumnos = new String[10];
        String[] resultados = new String[10];

        // Datos de ejemplo para demostración
        alumnos[0] = "Ana";
        notas[0] = 6.5;
        alumnos[1] = "Bob";
        notas[1] = 4.8;
        alumnos[2] = "Clara";
        notas[2] = 9.2;
        alumnos[3] = "David";
        notas[3] = 7.5;
        alumnos[4] = "Emma";
        notas[4] = 3.2;
        alumnos[5] = "Frank";
        notas[5] = 5.8;
        alumnos[6] = "Grace";
        notas[6] = 8.7;
        alumnos[7] = "Henry";
        notas[7] = 10.0;
        alumnos[8] = "Iris";
        notas[8] = 6.9;
        alumnos[9] = "John";
        notas[9] = 4.5;

        // Rellenar array de resultados
        for (int i = 0; i < notas.length; i++) {
            resultados[i] = obtenerNotaEnPalabras(notas[i]);
        }

        // Mostrar resultados
        mostrarResultados(alumnos, notas, resultados);
    }

    // Método para convertir nota numérica a palabras
    private static String obtenerNotaEnPalabras(double nota) {
        if (!esNotaValida(nota)) {
            return "Nota Inválida";
        }

        if (nota >= 0 && nota <= 4.99) {
            return "Suspenso";
        } else if (nota <= 6.99) {
            return "Bien";
        } else if (nota <= 8.99) {
            return "Notable";
        } else { // 9 a 10
            return "Sobresaliente";
        }
    }

    // Método para validar que la nota esté entre 0 y 10
    private static boolean esNotaValida(double nota) {
        return nota >= 0 && nota <= 10;
    }

    // Método para mostrar todos los resultados
    private static void mostrarResultados(String[] alumnos, double[] notas, String[] resultados) {
        System.out.println("Resultados:");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.printf("Alumno: %-10s Nota: %-5.2f Resultado: %s%n",
                    alumnos[i], notas[i], resultados[i]);
        }
    }
}
