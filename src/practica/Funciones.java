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
public class Funciones {
    public static boolean estaOrdenado(int n){
        System.out.println("Test: " + (n/10)%10 + " < " + n%10 + ": " + ((n/10)%10 < n %10));
        if((n/10)%10 < n %10){
            System.out.println("Digitos restentes: " + n/100);
            if(n/100 == 0) {
                return true;
            }
            else
                return estaOrdenado(n/10);
        }
        else
            return false;
    }
}
