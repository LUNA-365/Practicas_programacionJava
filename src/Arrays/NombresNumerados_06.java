/*
Implementa un programa que calcule la denominación ordinal de los reyes de
una secuencia histórica. El programa solicitará la cantidad de reyes que se
van a introducir, y a continuación recibirá los nombres de los reyes. Presentará
por pantalla dichos nombres, pero colocándoles el ordinal correspondiente. Así,
por ejemplo, si hay dos Felipes en los nombres de los reyes, el primero debería
aparecer como Felipe 1º y el segundo como Felipe 2º.
 */
package Arrays;
import Mensaje.mensajes;
import java.util.Arrays;

public class NombresNumerados_06 {
    public static mensajes ms = new mensajes();
    
    public static void main(String[] args) {
        imprimir();
    }
    
    public static boolean validarLetras(String cadena){
        return cadena.matches("[a-zA-Z]+");
    }
    
    public static boolean validarNumeros(String cadena){
        return cadena.matches("[0-9]+");
    }
    
    public static int datosNumericos(){
        while(true){
            String cadena = ms.entrada("Cantidad de Reyes a ingresar: ");
            if(validarNumeros(cadena)) return Integer.parseInt(cadena);
            else System.out.println("Datos incorrectos");
        }
    }
    
    public static String datosLetras(){
        while(true){
            String cadena = ms.entrada("Reyes: ");
            if(validarLetras(cadena)) return cadena;
            else System.out.println("Datos incorrectos");
        }
    }
    
    public static void imprimirArray(String [] array){
        for(String i : array){
            System.out.println(i);
        }
        System.out.println("");
    }
    
    public static void imprimir(){
        
        String [] reyes = {"Joan","Eli","Eli","Jack","Tomas","Tomas","Joan","Erick"};
        
        System.out.println("Reyes ingresados: ");
        
        for (int i = 0; i < reyes.length; i++) {
            int contador = 1;
            for (int j = 0; j < i; j++) {
                if(reyes[i].equals(reyes[j])){
                    contador++;
                }
            }
            System.out.println(reyes[i] + " " + contador + "°");
        }
        
    }
}
