/*
Un restaurante nos ha encargado una aplicación para colocar a los clientes en
sus mesas. En una mesa se pueden sentar de 0 (mesa vacía) a 4 comensales
(mesa llena). Cuando llega un cliente se le pregunta cuántos son. De momento
el programa no está preparado para colocar a grupos mayores a 4, por tanto, si
un cliente dice por ejemplo que son un grupo de 6, el programa dará el mensaje
“Lo siento, no admitimos grupos de 6, haga grupos de 4 personas
como máximo e intente de nuevo”. Para el grupo que llega, se busca
siempre la primera mesa libre (con 0 personas). Si no quedan mesas libres, se
busca donde haya un hueco para todo el grupo, por ejemplo si el grupo es de
dos personas, se podrá colocar donde haya una o dos personas. Inicialmente,
las mesas se cargan con valores aleatorios entre 0 y 4. Cada vez que se sientan
nuevos clientes se debe mostrar el estado de las mesas. Los grupos no se
pueden romper aunque haya huecos sueltos suficientes  
 */
package Arrays;

import Mensaje.mensajes;

public class MesasDisponibles_01 {

    public static mensajes ms = new mensajes();

    public static void main(String[] args) {
        //boolean a = comprobar_Ncomensales();
        acomodar();
    }

    public static boolean datosValidos(String clientes) {
        return clientes.matches("[0-4]");
    }

    public static int comprobar_Ncomensales() {
        String clientes ;
        int cantidad = 0;
        while(true){
            try {
                clientes = ms.entrada("Cuantos clientes son? - Presione -1 para salir ");
                 cantidad = Integer.parseInt(clientes);
                if (cantidad == -1 || (datosValidos(clientes) && cantidad<=4)){
                    return cantidad;
                }else{
                    ms.mostrar("Datos invalidos o cantidad mayor a 4");
                }
            } catch (NumberFormatException e) {
                ms.mostrar("Entrada no valida, ingrese un numero");
            }
        }
    }

    public static int[] llenar_array() {
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 5);
        }
        return array;
    }

    public static void imprimir(int[]array) {
        System.out.println("mesa n°: ");
        for (int i = 1; i <= array.length; i++) {
            System.out.printf("|%2d", i);
        }
        System.out.println("\nocupacion: ");
        for (int mesas : array) {
            System.out.printf("|%2d", mesas);
        }
        System.out.println("");
    }
    
    public static int mesas_vacias(int [] array){
        for (int i = array.length-1; i >= 0; i--) {
            if(array[i]==0){
                return i;
            }
        }
        return -1;
    }
    public static int encontrar_hueco(int[]array,int clientes){
        for (int i = array.length-1; i >= 0; i--) {
            if(clientes<=(4-array[i])){
                return i;
            }
        }
        return -1;
    }
    public static void acomodar() {
        int[]array = llenar_array();
        while(true){
            imprimir(array);
            int clientes = comprobar_Ncomensales();
            if(clientes==-1){
                break;
            }
            if(clientes <= 4){
                int mesa_vacia = mesas_vacias(array);
                if(mesa_vacia != -1){
                    array[mesa_vacia] = clientes;
                    System.out.println("Sientese en la mesa: " + (mesa_vacia+1));
                }else{
                    int indice_hueco = encontrar_hueco(array, clientes);
                    if(indice_hueco != -1){
                        array[indice_hueco] += clientes;
                        System.out.println("Podra sentarse en la mesa: " + (indice_hueco +1));
                    }else{
                        System.out.println("No hay mesas disponibles");
                    }
                }
            }else{
                System.out.println("Solo se aceptan 4 personas por ahora");
            }
        }
        
        
        
//        boolean indice_vacio = false;
//        int clientes;
//        int x = 0;
//        int[] array = llenar_array();
//        do {
//            int m_vacia = 0;
//            imprimir(array);
//            clientes = comprobar_Ncomensales();
//            if (clientes == -1) {
//                break;
//            }
//            if(clientes <= 4){
//                //indice con datos cero
//                for (int i = array.length-1; i >= 0; i--) {
//                    if (array[i] == 0) {
//                        m_vacia = i;
//                        indice_vacio = true;
//                        break;
//                    }
//                }
//                if (indice_vacio) {
//                    array[m_vacia] = clientes;
//                    System.out.println("Sientese en la mesa: " + (m_vacia + 1));
//                    indice_vacio = false;
//                } else {
//                    int indice_hueco = 0;
//                    boolean hay_hueco = false;
//                    for (int j = array.length-1; j >= 0; j--) {
//                        if (clientes <= (4 - array[j])) {
//                            indice_hueco = j;
//                            hay_hueco = true;
//                            break;
//                        }
//                    }
//
//                    if (hay_hueco) {
//                        array[indice_hueco] += clientes; //coloca a los clientes en el primer hueco que encuentre
//                        System.out.println("podra sentarse en la mesa numero: " + (indice_hueco + 1));
//                    } else {
//                        System.out.println("No hay mas mesas disponibles");
//                    }
//                }
//
//            }else{
//                System.out.println("Cantidad sobreexigida");
//            }
//        } while (true);

    }

}
