/*
 Realiza un programa que sea capaz de insertar un número en una posición
concreta de un array. En primer lugar, el programa generará un array de 12
números enteros aleatorios entre 0 y 200 ambos incluidos. A continuación se
debe mostrar el contenido de ese array junto al índice (0 – 11). Seguidamente
el programa preguntará por el número que se quiere insertar y por la posición
donde será insertado. Los números del array se desplazan a la derecha para
dejar sitio al nuevo. El último número (el que se encuentra en la posición 11)
siempre se perderá.

//Nuevo comentario..
 */
package Arrays;

import Mensaje.mensajes;

public class RemplazarDato_05 {

    public static mensajes ms = new mensajes();

    public static void main(String[] args) {
        imprimir();

    }

    public static int[] llenarArray(int alcance) {
        int array[] = new int[alcance];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 201);
        }
        return array;
    }


    public static boolean validarIndice(String cadena) {
        //return cadena.matches("[0-9]+") && Integer.parseInt(cadena) > 0 && Integer.parseInt(cadena) < 12;
        return cadena.matches("([0-9]|10|11)");
    }

    public static boolean validarNumero(String cadena) {
        return cadena.matches("[0-9]+");
    }

    public static int datoNumerico() {
        while (true) {
            String numero = ms.entrada("Ingrese el nuevo numero para el arreglo: ");
            if (validarNumero(numero)) {
                return Integer.parseInt(numero);
            } else {
                System.out.println("Dato invalido");
            }
        }
    }

    public static int datoIndice() {
        while (true) {
            String numero = ms.entrada("Ingrese la posicion: ");
            if (validarIndice(numero)) {
                return Integer.parseInt(numero);
            } else {
                System.out.println("Desborde de indice.");
            }
        }
    }

    public static void rotarHaciaDerecha(int[] array, int posicion, int dato) {
        for (int i = array.length - 1; i > posicion; i--) {
            array[i] = array[i - 1];
        }
        array[posicion] = dato;
    }

    public static void imprimirArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void imprimir() {
        System.out.println("Array original: ");

        int[] array = llenarArray(12);
        imprimirArray(array);

        int dato = datoNumerico();

        int posicion = datoIndice();

        System.out.println("Nuevo arreglo: ");
        rotarHaciaDerecha(array, posicion, dato);
        imprimirArray(array);

    }
}
