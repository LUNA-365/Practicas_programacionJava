/*
Escribe un programa que muestre por pantalla un array de 10 números enteros
generados al azar entre 0 y 100. A continuación, el programa debe pedir un
número al usuario. Se debe comprobar que el número introducido por teclado
se encuentra dentro del array, en caso contrario se mostrará un mensaje por
pantalla y se volverá a pedir un número; así hasta que el usuario introduzca uno
correctamente. A continuación, el programa rotará el array hacia la derecha
las veces que haga falta hasta que el número introducido quede situado en la
posición 0 del array. Por último, se mostrará el array rotado por pantalla.

 */
package Arrays;

import Mensaje.mensajes;

public class RotarHaciaDerechaDato_03 {

    public static mensajes ms = new mensajes();

    public static void main(String[] args) {
        posicion();
    }

    public static int[] llenarArray(int dimension) {
        int array[] = new int[dimension];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public static boolean validarDato(String dato) {
        return dato.matches("[0-9]+");
    }

    public static int pedirDato() {
        while (true) {
            String dato = ms.entrada("Ingrese el dato");
            if (validarDato(dato)) {
                return Integer.parseInt(dato);
            } else {
                System.out.println("Dato invalido");
            }
        }
    }

    public static void imprimir(int[] array) {
        for (int m : array) {
            System.out.print(m + " ");
        }
        System.out.println("");
    }

    public static boolean verificar(int[] array, int dato) {
        for (int num : array) {
            if (num == dato) {
                return true;
            }
        }
        return false;
    }
    
    public static void rotarHaciaDerecha(int [] array, int dato){
        while(array[0]!=dato){
            int ultimo = array[array.length-1];
            for (int i = array.length-1; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = ultimo;
        }
    }
    public static void posicion() {
        int[] array = llenarArray(10);
        
        System.out.println("Arreglo original: ");
        imprimir(array);
        
        int dato = pedirDato();
        
        while(!verificar(array, dato)){
            System.out.println("El dato no existe, ingrese un dato almacenado en el array");
            dato = pedirDato();
        }
        
        System.out.println("Nuevo arreglo: ");
        rotarHaciaDerecha(array, dato);
        imprimir(array);

    }
    
    public static void metodoCorrecto() {
    int [] n = llenarArray(10);
        System.out.println("Array original: ");
        imprimir(n);
        int numeroIntroducido = pedirDato();
        while (n[0] != numeroIntroducido) {
            int aux = n[9];
            // Rotación a la derecha
            for (int i = 9; i > 0; i--) {
                n[i] = n[i - 1];
            }
            n[0] = aux;
        }
        System.out.println("Array ordenado: ");
        imprimir(n);
    }

}
