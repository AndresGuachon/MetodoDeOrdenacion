/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class Ordenacion {

    private Integer matriz[];
    private static Integer SIZE = 10000;

    public Integer[] getMatriz() {
        return matriz;
    }

    public void llenarArchivo() {
        try {
            FileWriter file = new FileWriter("datos" + File.separatorChar + "numero.txt");
            for (int i = 0; i < SIZE; i++) {
                Integer aux = (int) (Math.random() * 1000);
                file.write(aux.toString() + "\n");
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

    public void llenarMatriz() {
        try {
            matriz = new Integer[SIZE];
            FileReader fr = new FileReader("datos" + File.separatorChar + "numero.txt");
            BufferedReader entrada = new BufferedReader(fr);
            String aux = entrada.readLine();
            Integer cont = 0;
            while (aux != null) {
                matriz[cont] = Integer.parseInt(aux);
                aux = entrada.readLine();
                cont++;
            }
            fr.close();
            entrada.close();
        } catch (Exception e) {
        }

    }

   /* public void imprimir() {
        System.out.println("***********************");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + "\t");
        }
        System.out.println("");
        System.out.println("***********************");
    }*/
    public void mostrar(int [] arreglo ){
        System.out.println("***********************");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + "\t");
            
        }
        System.out.println("");
        System.out.println("***********************");
    }

    public void burbuja(Integer[] matriz) {
        Integer cont = 0;
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length - 1; j++) {
//                if (matriz[j] > matriz[j + 1]) {
//                    Integer aux = matriz[j];
//                    matriz[j] = matriz[j + 1];
//                    matriz[j + 1] = aux;
//                    cont++;
//                }
//
//            }
//        }
        for (int i = matriz.length; i > 1; i--) {

            for (int j = 0; j < i - 1; j++) {
                if (matriz[j] > matriz[j + 1]) {
                    Integer aux = matriz[j];
                    matriz[j] = matriz[j + 1];
                    matriz[j + 1] = aux;
                    cont++;
                }

            }
        }
        System.out.println("INTERCAMBIOS " + cont);
    }

    public void shakeSort(Integer[] matriz) {
        Integer cont = 0;
        Integer i, j, izq, der;
        izq = 1;
        der = matriz.length - 1;
        j = matriz.length - 1;
        do {

            for (i = der; i >= izq; i--) {
                if (matriz[i - 1] > matriz[i]) {
                    Integer aux = matriz[i];
                    matriz[i] = matriz[i - 1];
                    matriz[i - 1] = aux;
                    j = i;
                    cont++;
                }

            }
            izq = j + 1;
            for (i = izq; i <= der; i++) {
                if (matriz[i - 1] > matriz[i]) {
                    Integer aux = matriz[i];
                    matriz[i] = matriz[i - 1];
                    matriz[i - 1] = aux;
                    j = i;
                    cont++;
                }

            }
            der = j - 1;
        } while (izq <= der);

        System.out.println("INTERCAMBIOS " + cont);
    }

    public  void shellA(int[] arreglo) {
        int salto, i,j,k,aux;
     salto = arreglo.length/2;
        

        while (salto > 0) {
         
                for (i=salto; i < arreglo.length; i++ ) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                

                if (arreglo[j] <= arreglo[k]) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = aux;
                    j -= salto;

                }

            }
        }
        salto=salto/2;
        
      } 
        mostrar(arreglo);
    }
    public  void shellD(int[] arreglo) {
        int salto, i,j,k,aux;
     salto = arreglo.length/2;
        

        while (salto > 0) {
         
                for (i=salto; i < arreglo.length; i++ ) {
                j = i - salto;
                while (j >= 0) {
                    k = j + salto;
                

                if (arreglo[j] >= arreglo[k]) {
                    j = -1;
                } else {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[k];
                    arreglo[k] = aux;
                    j -= salto;

                }

            }
        }
        salto=salto/2;
        
      } 
        mostrar(arreglo);
    }
    public void quicksortA(int[] arreglo, int primero, int ultimo) {
        int i, j, pivote, aux;
        i = primero;
        j = ultimo;
        pivote = arreglo[(primero + ultimo) / 2];
        do {
            while (arreglo[i] < pivote) {
                i++;

            }
            while (arreglo[j] > pivote) {
                j--;

            }
            if (i <= j) {
                aux = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
                i++;
                j--;
            }

        } while (i <= j);
        if (primero < j) {
            quicksortA(arreglo, primero, j);
        }
        if (i < ultimo) {
            quicksortA(arreglo, i, ultimo);
        }
        mostrar(arreglo);
    }
    public  void quicksortD(int[] arreglo, int primero, int ultimo) {
        int i, j, pivote, aux;
        i = primero;
        j = ultimo;
        pivote = arreglo[(primero + ultimo) / 2];
        do {
            while (arreglo[i] < pivote) {
                i++;

            }
            while (arreglo[j] > pivote) {
                j--;

            }
            if (i >= j) {
                aux = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
                i++;
                j--;
            }

        } while (i > j);
        if (primero > j) {
            quicksortD(arreglo, primero, j);
        }
        if (i > ultimo) {
            quicksortD(arreglo, i, ultimo);
        }
        mostrar(arreglo);
    }
    


    public static void main(String[] args) {
        //int n;
       // int [] arreglo =  {1562913427,1303753618,1706172648,1704997012,1713627071,1715241434,0601646623,1713580221,1305267542,1303292583,1708706306};
        
            
    

        //Ordenacion o = new Ordenacion();

      //  o.llenarArchivo();
       // o.llenarMatriz();
       // System.out.println("Arreglo Original");
        //o.mostrar(arreglo);
       // System.out.println("Ordenado");
       // o.shellA(arreglo);
        
       // System.out.println("METODO SHELL");
//      Integer 
        //Integer pos = o.getMatriz()/2;
        //System.out.println(o.getMatriz().length);
        //o.quicksort(o.getMatriz(), 0, ((int)(o.getMatriz().length/2)));
        //o.seleccion(o.getMatriz());
       
        //o.imprimir();
    }
}
