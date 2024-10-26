/*
Ejemplo de como se va imprimiendo una arreglo bidimensional
 */
package ArrayBidimensionales;

public class RetardoImpresion_01 {
    public static void main(String[] args) throws InterruptedException {
        arrayBidimensional();
        
    }
    public static void arrayBidimensional() throws InterruptedException{
        int[][]array ={{24,23},{12,56},{12,56},{51,74}};
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%10d",array[i][j]);
                Thread.sleep(1000);
            }
            System.out.println("");
        }
    }
}
