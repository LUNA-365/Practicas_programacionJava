/*
 Escribe un programa que rellene un array de 15 elementos con números enteros
comprendidos entre 0 y 500 (ambos incluidos). A continuación, se mostrará el
array “cincuerizado”, según el siguiente criterio: si el número que hay en una
posición del array es múltiplo de 5, se deja igual, y si no, se cambia por el
siguiente múltiplo de 5 que exista a partir de él.

 */
package Arrays;
public class Cincuerizado_07 {
    public static void main(String[] args) {
        imprimir();
    }
    
    public static int [] llenarArray(int alcance){
        int array [] = new int[alcance];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*501);
        }
        return array;
    }
    
    public static void imprimirArray(int [] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void cincueriar(int [] array){
         for (int i = 0; i < array.length; i++) {
            while(array[i]%5!=0){
                array[i]++;
            }
        }
    }
    
    public static void imprimir(){
        System.out.println("Array original: ");
        int [] array = llenarArray(15);
        imprimirArray(array);
       
        System.out.println("Array cincuerizado: ");
        cincueriar(array);
        imprimirArray(array);
    }
}
