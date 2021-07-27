/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP7;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircular lc = ListaCircular.lcVacia();
        
        int n = 7;
        for(int i = n; i > 0;i--)
            lc.lcInsertar(i);
//        for(int i = 1; i <= n;i++)
//            lc.lcInsertar(i);
        
//        lc.lcMostrar();
        for(int i = 1; i <= n;i++){
            System.out.print(" " + lc.lcValor());
            lc.lcRotar();
        }
        System.out.println("");
        
        
        
//        lc.lcBorrar();
//        n--;
//        for(int i = 1; i <= n;i++){
//            System.out.print(" " + lc.lcValor());
//            lc.lcRotar();
//        }
//        System.out.println("");
        
//        
//        lc.lcRotar();
//        lc.lcMostrar();
//        
//        lc.lcRotar();
//        lc.lcMostrar();
        
        josefo(lc,n,5);
    }
    
    static void josefo(ListaCircular lc,int n, int k){
        while(n>2){
            for(int i = 1 ; i<k;i++)
                lc.lcRotar();
            System.out.println("Elimino: " + lc.lcValor());
            lc.lcBorrar();
            n--;
            System.out.println("Mienbros restantes: ");
            for(int i = 1; i <= n;i++){
                System.out.print(" " + lc.lcValor());
                lc.lcRotar();
            }
            System.out.println("\n");
        }
        System.out.print(" " + lc.lcValor());
        lc.lcRotar();
        System.out.print(" " + lc.lcValor());
        lc.lcRotar();
        System.out.println("");
    }
}
