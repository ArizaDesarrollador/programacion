package programacion.programacion;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Principal {
//TRABAJO REALIZADO POR JESÚS Y RIDOUAN.
    //MÉTODO MAIN
    public static void main(String[] args) {

        // Opciones del menu
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(" <(^.^)> Bienvenido al menú. Elige una opcion. <(^.^)>\n"
                + "1 Generar Equipo.\n"
                + "2 Generar Equipo desordenado.\n"
                + "3 Buscar un jugador (Busqueda binaria).\n"
                + "4 Ordenar equipo desordenado con Bubble-Sort.\n"
                + "5 Ordenar equipo desordenado con Quick-Sort.\n"
                + "6 Comparar algoritmos de orden Quick & Bubble mediante tiempos de ejecución.\n"
                + "7 Comparar algoritmos de ornden Quick & bubble mediante pasos"));

        menu(opcion); //MÉTODO DEL MENU QUE EJECUTARÁ TODOS LOS MÉTODOS DE LA OPCIÓN ELEGIDA

    }

    //MÉTODO PARA GENERAR EL MENU
    public static void menu(int opcion) {
        switch (opcion) {
            //OPCIÓN DE GENERAR EL EQUIPO 
            case 1:
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores:"));
                Jugador[] equipo = generarEquipo(cantidad);
                imprimirEquipo(equipo);
                break;
            //OPCIÓN DE DESORDENAR EL EQUIPO ORDENADO
            case 2:
                int cantidad2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
                equipo = generarEquipo(cantidad2);
                desordenarEquipo(equipo);
                imprimirEquipo(equipo);
                break;
            //OPCIÓN DE BUSCAR UN JUGADOR DE UN EQUIPO ORDENADO MEDIANTE SU DORSAL
            case 3:
                int cantidad3 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
                equipo = generarEquipo(cantidad3);
                imprimirEquipo(equipo);
                System.out.println();
                System.out.println("RESULTADOS DEL JUGADOR BUSCADO");
                imprimirJugadorBuscado(equipo);
                break;
            //OPCIÓN PARA ORDENAR UN EQUIPO DESORDENADO MEDIANTE EL ALGORITMO DE BUBBLE-SORT
            case 4:
                int cantidad4 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores"));
                equipo = generarEquipo(cantidad4);
                System.out.println("****DESORDENADO****");
                desordenarEquipo(equipo);
                imprimirEquipo(equipo);
                System.out.println();
                System.out.println("****ORDENADO DE NUEVO CON BUBBLE-SORT****");
                equipoBubble(equipo);
                imprimirEquipo(equipo);
                break;
            //OPCIÓN PARA ORDENAR UN EQUIPO DESORDENADO MEDIANTE EL ALGORITMO DE BUBBLE-SORT
            case 5:
                int cantidad5 = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad de jugadores:"));
                Jugador[] equipo5 = generarEquipo(cantidad5);

                desordenarEquipo(equipo5);
                System.out.println("****EQUIPO DESORDENADO****");
                imprimirEquipo(equipo5);
                System.out.println();
                System.out.println("****EQUIPO ORDENADO POR QUICK-SORT****");
                quick(equipo5, 0, equipo5.length - 1);
                imprimirEquipo(equipo5);
                break;
            //OPCIÓN PARA COMPARA BUBBLE,QUICK & QUICK-RAFA CON NANO
            case 6:
                comparacionNanoSystem();
                break;
            //OPCIÓN PARA COMPARAR BUBBLE,QUICK & QUICK-RADA MEDIANTE PASOS
            case 7:
                sorterStepsWinner();
                break;
            // EN EL CASO DE QUE EL USUARIO INSERTE UN NUMERO SIN CASE APARECERA EL SIGUIENT MENSAJE
            default:
                JOptionPane.showMessageDialog(null, "Solo hay 6 opciones posibles.");
        }

    }

    //MÉTODO PARA ORDENAR CON QUICK-SORT
    public static Jugador[] quick(Jugador[] equipo, int primero, int ultimo) {

        int pivote = equipo[(primero + ultimo) / 2].getDorsal();

        int i = primero;
        int j = ultimo;
        Jugador aux;

        while (i < j) {
            while (equipo[i].getDorsal() < pivote && i < j) {
                i++;
            }

            while (equipo[j].getDorsal() > pivote) {
                j--;
            }

            if (i < j) {
                aux = equipo[i];
                equipo[i] = equipo[j];
                equipo[j] = aux;
            }
        }

        if (primero < j - 1) {
            quick(equipo, primero, j);
        }

        if (i + 1 < ultimo) {
            quick(equipo, i, ultimo);
        }

        return equipo;

    }

    //MÉTODO PARA RETORNAS LOS PASOS DE QUICKSORT
    public static int pasosQuick(Jugador[] equipo, int primero, int ultimo) {
        //MÉTODO PARA ORDENAR CON QUICK-SORT
        int contador = 0;
        int pivote = equipo[(primero + ultimo) / 2].getDorsal();

        int i = primero;
        int j = ultimo;
        Jugador aux;

        while (i < j) {
            while (equipo[i].getDorsal() < pivote && i < j) {
                i++;
            }

            while (equipo[j].getDorsal() > pivote) {
                j--;
            }

            contador++;
            if (i < j) {
                aux = equipo[i];
                equipo[i] = equipo[j];
                equipo[j] = aux;

            }
        }
        contador++;
        if (primero < j - 1) {
            quick(equipo, primero, j);
        }
        contador++;
        if (i + 1 < ultimo) {
            quick(equipo, i, ultimo);
        }

        return contador;
    }

    //MÉTODO PARA ORDENAR UN EQUIPO DESORDENADO CON BUBBLE
    public static Jugador[] equipoBubble(Jugador[] equipo) {
        Jugador aux;
        for (int i = 0; i < equipo.length - 1; i++) {
            for (int j = 0; j < equipo.length - 1 - i; j++) {

                if (equipo[j].getDorsal() > equipo[j + 1].getDorsal()) {
                    aux = equipo[j];
                    equipo[j] = equipo[j + 1];
                    equipo[j + 1] = aux;

                }

            }
        }

        return equipo;
    }

    //MÉTODO BUBBLE PARA SACAR SOLO LOS PASOS
    public static int pasosBubble(Jugador[] equipo) {
        int contador = 0;
        Jugador aux;
        for (int i = 0; i < equipo.length - 1; i++) {
            for (int j = 0; j < equipo.length - 1 - i; j++) {
                contador++;
                if (equipo[j].getDorsal() > equipo[j + 1].getDorsal()) {
                    aux = equipo[j];
                    equipo[j] = equipo[j + 1];
                    equipo[j + 1] = aux;

                }

            }
        }

        return contador;
    }

    //METODO PARA IMPRIMIR EL JUGADOR BUSCADO MEDIANTE EL METODO "BUSCARJUGADOR" QUE NOS DEVUELVE LA POSICIÓN
    public static void imprimirJugadorBuscado(Jugador[] equipo) {
        int jugador = buscarJugador(equipo);
        if (jugador == -1) {
            System.out.println("El jugador no ha sido encontrado ");
        } else {
            equipo[jugador].imprimir();
        }

    }

    //MÉTODO QUE NOS DEVUELVE LA POSICIÓN DE EL JUGADOR BUSCADO, ESTO SE APLICARÁ EN OTRA FUNCIÓN PARA IMPRIMIR EL JUGADOR
    public static int buscarJugador(Jugador[] equipo) {
        int numero = (int) Integer.parseInt(JOptionPane.showInputDialog("¿Qué número de dorsal estas buscando?"));

        int izq = equipo[0].getDorsal();
        int der = equipo[equipo.length - 1].getDorsal();
        boolean encontrado = false;

        for (int i = 0; i < equipo.length; i++) {

            int posicion = (izq + der) / 2;
            if (posicion == numero) {
                encontrado = true;
                return posicion;

            } else if (numero < equipo[posicion].getDorsal()) {

                der = equipo[posicion].getDorsal() - 1;

            } else {
                izq = equipo[posicion].getDorsal() + 1;
            }

        }

        if (encontrado == false) {
            return -1;
        } else {
            return -1;
        }

    }

    //MÉTODO PARA IMPRIMIR EL EQUIPO
    public static void imprimirEquipo(Jugador[] equipo) {

        for (Jugador jugador : equipo) {
            jugador.imprimir();
        }

    }

    //MÉTODO QUE GENERA EL EQUIPO
    public static Jugador[] generarEquipo(int cantidad) {
        Jugador[] equipo = new Jugador[cantidad];
        for (int i = 0; i < cantidad; i++) {
            String nombre = nombreJugador();
            String apellidos = apellidosJugador();
            String posicion = posicionJugador();
            int dorsal = i;
            equipo[i] = new Jugador(nombre, apellidos, posicion, dorsal);
        }
        return equipo;
    }

    //MÉTODO PARA DESORDENAR EL EQUIPO
    public static Jugador[] desordenarEquipo(Jugador[] equipo) {
        Jugador aux;
        for (int i = 0; i < equipo.length; i++) {
            int contador = (int) Math.floor(Math.random() * equipo.length);
            aux = equipo[i];
            equipo[i] = equipo[contador];
            equipo[contador] = aux;

        }
        return equipo;

    }

    // MÉTODO PARA SACAR 1 NOMBRE ALEATORIO DE UN ARRAY
    public static String nombreJugador() {

        String[] nombre = {"Paco", "Manuela", "Jesús", "Naomi", "Marcos", "Naroa", "Rosa", "rubén", "Antonio", "Robber"};

        return nombre[(int) Math.floor(Math.random() * nombre.length)];

    }

    // MÉTODO PARA SACAR 1 APELLIDO ALEATORIO DE DOS ARRAY CONCATENANDOLOS
    public static String apellidosJugador() {

        String[] apellido1 = {"Ariza ", "Melero", "Baena ", "Ruíz ", "Reyes ", "Garcés ", "González ", "Martín ", "Ortega ", "Garcia "};
        String[] apellido2 = {"Rosa ", "Díaz ", "Valverde ", "Roldán ", "Fernández ", "Romero ", "Padilla ", "Santaella ", "Bueno", "Ferreiro "};

        return apellido1[(int) Math.floor(Math.random() * apellido1.length)]
                + apellido2[(int) Math.floor(Math.random() * apellido2.length)];

    }

    //MÉTODO PARA SACAR LA POSICIÓN DEL JUGADOR
    public static String posicionJugador() {

        String[] posiciones = {"Portero", "Defensa", "Centro-Campista", "Delantero"};

        return posiciones[(int) Math.floor(Math.random() * posiciones.length)];
    }

    //COMPARAR LOS ALGORITMOS DE ORDENACIÓN CON NANO-TIME
    public static void comparacionNanoSystem() {
        int cantidad = 0;
        do {
            //Input para introducir la cantidad de jugadores
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad", "Mínimo 30.000 Jugadores"));
        } while (cantidad < 30000);
        Jugador[] equipo = generarEquipo(cantidad);//generar el equipo
        desordenarEquipo(equipo); // desordenar el equipo

        //USANDO NANOTIME PARA SABER EL TIEMPO DE EJECUCIÓN
        //QUICK-SORT NANOTIME
        Jugador[] copiaEquipo = Arrays.copyOf(equipo, equipo.length); //Creamos una copia del array.
        desordenarEquipo(copiaEquipo); //Volvemos a desordenar el equipo
        System.out.println();
        long inicio2 = System.nanoTime();
        quick(copiaEquipo, 0, copiaEquipo.length - 1);
        long fin2 = System.nanoTime();
        double resultado2 = (double) (fin2 - inicio2) / 1e+9; //Lo dividimos por 1e+9 para obtener los segundos.
        System.out.println("Quick-Sort ha tardado " + resultado2 + " segundos en ejecutarse");

        //QUICK-SORT-PROFESOR NANOTIME
        Jugador[] copiaEquipo2 = Arrays.copyOf(equipo, equipo.length); //Creamos una copia del array.
        desordenarEquipo(copiaEquipo2); //Volvemos a desordenar el equipo
        System.out.println();
        long inicio3 = System.nanoTime();
        quick(copiaEquipo2, 0, copiaEquipo2.length - 1);
        long fin3 = System.nanoTime();
        double resultado3 = (double) (fin3 - inicio3) / 1e+9; //Lo dividimos por 1e+9 para obtener los segundos.
        System.out.println("Quick-Sort-Profesor ha tardado " + resultado3 + " segundos en ejecutarse");

        //BUBBLE NANOTIME
        long inicio1 = System.nanoTime();
        equipoBubble(equipo);
        long fin1 = System.nanoTime();
        double resultado1 = (double) (fin1 - inicio1) / 1e+9; //Lo dividimos por 1e+9 para obtener los segundos.
        System.out.println("Bubble-Sort ha tardado " + resultado1 + " segundos en ejecutarse");

        //MOSTRAR RESULTADOS DE QUICK SORT
        System.out.println("********************* AND THE WINNER IS *********************");
        if (resultado1 < resultado2) {
            System.out.println("¡¡¡¡¡¡BUBBLE-SORT!!!!!!");
        } else {
            System.out.println("¡¡¡¡¡¡QUICK-SORT!!!!!!");
        }

    }

    //METODO PARA COMPARAR LOS PASOS QUE DA CADA ALGORITMO Y MOSTRAR EL GANADOR
    public static void sorterStepsWinner() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Escribe una cantidad"));//Input para introducir la cantidad de jugadores
        Jugador[] equipo = generarEquipo(cantidad);
        desordenarEquipo(equipo);
        System.out.println("QUICK-SORT HA DADO UNA CANTIDAD DE PASOS DE: ");
        System.out.println(pasosQuick(equipo, 0, equipo.length - 1));

        //QUICK-SORT-PROFESOR
        System.out.println();
        Jugador[] copiaEquipo2 = Arrays.copyOf(equipo, equipo.length); //Creamos una copia del array.
        desordenarEquipo(copiaEquipo2);
        System.out.println("QUICK-SORT-PROFESOR HA DADO UNA CANTIDAD DE PASOS DE: ");
        System.out.println(quickSortProfesor(copiaEquipo2, 0, copiaEquipo2.length - 1));
        System.out.println();

        //BUBBLE-SORT
        System.out.println();
        Jugador[] copiaEquipo = Arrays.copyOf(equipo, equipo.length); //Creamos una copia del array.
        desordenarEquipo(copiaEquipo);
        System.out.println("BUBBLE-SORT HA DADO UNA CANTIDAD DE PASOS DE: ");
        System.out.println(pasosBubble(copiaEquipo));
        System.out.println();

        System.out.println("********************* AND THE WINNER IS *********************");
        if (pasosBubble(copiaEquipo) < pasosQuick(copiaEquipo, 0, copiaEquipo.length - 1)) {
            System.out.println("¡¡¡¡¡¡BUBBLE-SORT!!!!!!");
        } else {
            System.out.println("¡¡¡¡¡¡QUICK-SORT!!!!!!");
        }

    }

    //MÉTODO PROFESOR QUICK-SORT.
    public static int quickSortProfesor(Jugador[] equipo, int izq, int der) {
        Jugador pivote = equipo[izq];
        int contador = 0;
        // Jugador pivoteJugador = equipo[izq];

        int i = izq;
        int j = der;
        Jugador temp;

        while (i < j) {
            while (equipo[i].getDorsal() <= pivote.getDorsal() && i < j) {
                i++;
            }
            while (equipo[j].getDorsal() > pivote.getDorsal()) {
                j--;
            }
            contador++;
            if (i < j) {
                temp = equipo[i];
                equipo[i] = equipo[j];
                equipo[j] = temp;
            }
        }
        equipo[izq] = equipo[j];
        equipo[j] = pivote;

        contador++;
        if (izq < j - 1) {
            quickSortProfesor(equipo, izq, j - 1);
        }
        contador++;
        if (der > j + 1) {
            quickSortProfesor(equipo, j + 1, der);
        }

        return contador;
    }

}
