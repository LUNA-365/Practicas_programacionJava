/*
 Escribe un programa que rellene un array de 20 elementos con números enteros
aleatorios comprendidos entre 0 y 400 (ambos incluidos). A continuación el
programa mostrará el array y preguntará si el usuario quiere resaltar los
múltiplos de 5 o los múltiplos de 7. Seguidamente se volverá a mostrar el array
escribiendo los números que se quieren resaltar entre corchetes
 */
package Arrays;

import Mensaje.mensajes;

public class MultiplosDel5y7_02 {

    public static mensajes ms = new mensajes();

    public static void main(String[] args) {
        proceso();
    }

    public static int[] llenarArray() {
        int array[] = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 400);
        }
        return array;
    }

    public static boolean validarDatos(String datos) {
        return datos.matches("[1|2]");
    }

    public static int pedir_datos() {
        String numero;
        while (true) {

            numero = ms.entrada("1 - Multiplos del 5 ; 2 - Multiplos del 7");
            if (validarDatos(numero)) {
                return Integer.parseInt(numero);
            } else {
                System.out.println("Dato invalido");
            }

        }
    }

    public static void imprimir(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static void imprimirMultiplos(int array[], int divisor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % divisor == 0) {
                System.out.print("[" + array[i] + "]");
            } else {
                System.out.print(" " + array[i] + " ");
            }
        }

    }

    public static void proceso() {
        int array[] = llenarArray();
        imprimir(array);
        int dato = pedir_datos();
        if (dato == 1) {
            imprimirMultiplos(array, 5);
        }
        if (dato == 2) {
            imprimirMultiplos(array, 7);
        }
        System.out.println("");
    }
}
