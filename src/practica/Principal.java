/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num = 12545;
        System.out.println("Numero ingresado: " + num);
        System.out.println("");
        System.out.println("\nEsta ordenado: " + Funciones.estaOrdenado(num));
    }
    
}
