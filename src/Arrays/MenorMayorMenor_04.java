/*
 Realiza un programa que genere 10 números enteros aleatorios entre 0 y 200
ambos incluidos y que los almacene en un array. A continuación, el programa
debe mostrar el contenido de ese array junto al índice (0 – 9). Seguidamente el
programa debe colocar de forma alterna y en orden los menores o iguales de
100 y los mayores de 100: primero menor, luego mayor, luego menor, luego
mayor… Cuando se acaben los menores o los mayores, se completará con los
números que queden.
 */
package Arrays;

import java.util.Arrays;

public class MenorMayorMenor_04 {

    public static void main(String[] args) {
        imprimir();
        
    }
    
    public static int[] llenarArray(int alcance) {
        int num[] = new int[alcance];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 201);
        }
        return num;
    }

    public static int [] clasificar(int [] array) {
        int menores = 0;
        int mayores = 0;
        
        for(int i : array){
            if(i<=100) menores++;
            else mayores++;
        }
        
        
        int contarMenores [] = new int[menores];
        int contarMayores [] = new int[mayores];
        
        menores = 0;
        mayores = 0;
        
        for (int i : array) {
            if(i<= 100) contarMenores[menores++] = i;
            else contarMayores[mayores++] = i;
        }
        
//        Arrays.sort(contarMenores);
//        Arrays.sort(contarMayores);
        
        ordenarArreglo(contarMenores);
        ordenarArreglo(contarMayores);
        
        int resultadoIndice = 0;
        int resultado [] = new int[array.length];
        
        int menorIdx = 0;
        int mayorIdx = 0;
        
        while(resultadoIndice < array.length){
            if(menorIdx < contarMenores.length) resultado[resultadoIndice++] = contarMenores[menorIdx++];
            if(mayorIdx < contarMayores.length) resultado[resultadoIndice++] = contarMayores[mayorIdx++];
        }

        return resultado;
        
    }
    // Método para ordenar un arreglo manualmente (Bubble Sort)
    public static void ordenarArreglo(int[] arr) {
    int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar arr[j] y arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void imprimirArray(int [] array){
        for(int m : array){
            System.out.print(m + " ");
        }
        System.out.println("");
    }
    
    public static void imprimir() {
        System.out.println("Array original: ");
        int array[] = llenarArray(10);
        imprimirArray(array);
        
        System.out.println("Array nuevo (Menor - Mayor - Menor...): ");
        int [] nuevoArray = clasificar(array);
        imprimirArray(nuevoArray);
        
        System.out.println("Array con la funcion OrdenarArreglo: ");
        ordenarArreglo(array);
        imprimirArray(array);
    }
    
}
