public class Mundo {

        static Tiempo tiempo;

        public static void main(String[] args) {
                Ludoteca ludoteca = new Ludoteca();
                tiempo = new Tiempo();
                ludoteca.abrir();
                do {
                        llegaNiño(ludoteca);
                        ludoteca.actualizar();
                        ludoteca.imprimir();
                        tiempo.pasarMinuto();
                } while (!tiempo.haTerminado());

        }

        private static void llegaNiño(Ludoteca ludoteca) {
                if (tiempo.getMinutosTotales() >= 10) {
                        final int MAXIMO = 2;
                        final int MINIMO = 0;
                        int repeticiones = (int) (Math.random() * (MAXIMO - MINIMO) + 1);
                        for (int i = 0; i < repeticiones; i++) {
                                ludoteca.recibir(nuevoNiño());
                        }
                        return;
                }
                if (tiempo.getMinutosTotales() >= 30) {
                        if ((tiempo.getMinutosTotales() % 10) % 3 == 0 &&
                                        Math.random() >= 0.5)
                                ludoteca.recibir(nuevoNiño());
                        return;
                }
        }

        private static Niño nuevoNiño() {
                return new Niño(nombreAleatorio());
        }

        private static String nombreAleatorio() {
                String[] nombres = {
                                "Ana", "Luis", "María", "Carlos", "Lucía", "Javier", "Sofía", "Miguel", "Elena",
                                "David",
                                "Carmen", "Pablo", "Laura", "Diego", "Marta", "Alberto", "Sara", "Fernando", "Isabel",
                                "Jorge", "Raquel", "Andrés", "Patricia", "Manuel", "Nuria", "Rubén", "Silvia", "Óscar",
                                "Verónica",
                                "Iván", "Lorena", "Sergio", "Cristina", "Alba", "Adrián", "Beatriz", "Víctor", "Rocío",
                                "Héctor",
                                "Natalia", "Joaquín", "Alicia", "Gonzalo", "Miriam", "Rubén", "Clara", "Santiago",
                                "Elisa", "Ramón",
                                "Inés", "Fabián", "Celia", "Óliver", "Noelia", "Julián", "Lara", "Emilio", "Irene",
                                "Simón", "Ariadna",
                                "Bruno", "Mónica", "Gema", "Tomás", "Esther", "Hugo", "Yolanda", "César", "Lidia",
                                "Mario", "Gloria"
                };
                int indice = (int) (Math.random() * nombres.length);
                return nombres[indice];
        }
}
