import java.util.Scanner;

public class Ludoteca {
        public static void main(String[] args) {
                Ludoteca ludoteca = new Ludoteca();
                ludoteca.simular();
        }

        private Monitor aisha;
        private Monitor lydia;
        private Monitor dalsy;

        private void simular() {
                titulo();
                opciones();
        }

        private void opciones() {
                String[] opciones = {
                                "Simular llegada de niño",
                                "Simular intento de inicio de juego",
                                "Aisha se presenta y pide a los niños que se presenten",
                                "Aisha pide que se presenten los niños mayores de 5 años",
                                "Aisha pide que se presenten los niños cuyo nombre empieza por letra",
                                "Aisha pide que se presenten los cinco primeros niños",
                                "Aisha pide que se presenten los cinco últimos niños",
                                "Aisha y Lydia dicen cuántos niños hay en cola",
                                "Aisha dice la edad promedio de los niños en cola",
                                "Simular intento de inicio del juego de la rana",
                                "Paso de niños menores de 5 años a monitora Dalsy",
                                "Alarma contra incendios y protocolo de emergencia",
                                "Mostrar monitoras y niños"
                };
                mostrarOpciones(opciones);
                int opcion = preguntarOpcion(opciones.length);
                ejecutarOpcion(opcion);
        }

        private void ejecutarOpcion(int opcion) {
                switch (opcion) {
                        case 1 -> simularLlegadaNiño();
                        case 2 -> simularInicioJuego();
                        case 3 -> {
                                aisha.presentarse();
                                aisha.presentaNiños();
                        }
                        case 4 -> {
                                final int EDAD_MINIMA = 5;
                                aisha.pideNiñosPresentarseMayoresDe(EDAD_MINIMA);
                        }
                        case 5 -> aisha.presentaNiñosCuyoNombreEmpizaPor(pedirLetra());
                        case 6 -> {
                                final int NIÑOS_POR_PRESENTAR = 5;
                                aisha.presentaLosPrimerosNiños(NIÑOS_POR_PRESENTAR);
                        }
                        case 7 -> {
                                final int NIÑOS_POR_PRESENTAR = 5;
                                aisha.presentaLosUltimosNiños(NIÑOS_POR_PRESENTAR);
                        }
                        case 8 -> {
                                aisha.diceCuantosNiñosHayEnCola();
                                lydia.diceCuantosNiñosHayEnCola();
                        }
                        case 9 -> aisha.diceLaEdadPromedioNiñosEnCola();
                        case 10 -> simularIntentoInicioJuegoRana();
                        case 11 -> {
                                int edad = 5;
                                pasarNiñosMenoresDe(edad, dalsy);
                        }
                        case 12 -> alarmaContraIncendiosYProtocoloEmergencia();
                        case 13 -> mostrarMonitorasYNiños();
                }
        }

        private void mostrarMonitorasYNiños() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mostrarMonitorasYNiños'");
        }

        private void alarmaContraIncendiosYProtocoloEmergencia() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException(
                                "Unimplemented method 'alarmaContraIncendiosYProtocoloEmergencia'");
        }

        private void pasarNiñosMenoresDe(int edad, Monitor monitorACualPasar) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'pasarNiñosMenoresDe'");
        }

        private void simularIntentoInicioJuegoRana() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'simularIntentoInicioJuegoRana'");
        }

        private char pedirLetra() {
                Console.imprimirln("Ingrese la letra por la cual deben empezar los nombres de los niños: ");
                char letra = preguntarPorChar();
                return letra;
        }

        private char preguntarPorChar() {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                scanner.close();
                return input.charAt(0);
        }

        private void simularInicioJuego() {
                String mensaje = "";
                if (aisha.estaJugando()) {
                        mensaje = "Ya está jugando!";
                } else {
                        lydia.entregar(aisha);
                        aisha.jugar();
                        mensaje = "Empieza el juego!";
                        if (!aisha.estaJugando()) {
                                aisha.entregar(lydia);
                                mensaje = "No hay suficientes niños!";
                        }
                }
                Console.imprimirln(mensaje);
        }

        private void simularLlegadaNiño() {
                Niño niño = new Niño(darNombre(), darEdad());
                Console.imprimirln("Llega");
                niño.presentarse();
                Console.saltarLinea();
                niño.decirNombre();
                Console.imprimir(" pasa a la cola de Lydia");
                lydia.recibe(niño);
        }

        private int darEdad() {
                final int EDAD_MINIMA = 3, EDAD_MAXIMA = 16;
                return (int) (Math.random() * (EDAD_MAXIMA - EDAD_MINIMA + 1)) + EDAD_MINIMA;
        }

        private String darNombre() {
                final String[] LISTA_DE_NOMBRES = {
                                "Ana", "Luis", "María", "Carlos", "Lucía",
                                "Jorge", "Sofía", "Miguel", "Elena", "Pedro"
                };
                return LISTA_DE_NOMBRES[(int) (Math.random() * LISTA_DE_NOMBRES.length)];
        }

        private int preguntarOpcion(int length) {
                Console.imprimirln("Seleccione una opción: ");
                int resultado = Console.preguntarPorInt();
                while (resultado < 1 || resultado > length) {
                        Console.imprimirln("Opción inválida. Seleccione una opción válida: ");
                        resultado = Console.preguntarPorInt();
                }
                return resultado;
        }

        private void mostrarOpciones(String[] opciones) {
                Console.imprimirln("Opciones disponibles:");
                for (int i = 0; i < opciones.length; i++) {
                        Console.imprimirln((i + 1) + ". " + opciones[i]);
                }
        }

        private void titulo() {
                Console.imprimirln("========================================");
                Console.imprimirln("         LUDOTECA - SIMULACIÓN          ");
                Console.imprimirln("========================================");
        }
}
