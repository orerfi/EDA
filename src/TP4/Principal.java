/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4;

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
        
        Club a = Club.clubVacio();
        a.altaSocio(1);
        a.altaSocio(2);
        a.altaSocio(3);
        a.altaSocio(4);
        a.altaSocio(5);
        a.altaSocio(6);
        
        System.out.println("Club A:");
        a.mostrar();
        
        Club b = Club.clubVacio();
        b.altaSocio(6);
        b.altaSocio(7);
        b.altaSocio(8);
        
        System.out.println("\nClub B:");
        b.mostrar();
        
        Club c = Club.clubVacio();
        System.out.println("\nClub C:");
        c.mostrar();
        
        System.out.println("El club A esta vacio: " + a.estaVacio());
        System.out.println("El club B esta vacio: " + b.estaVacio());
        System.out.println("El club C esta vacio: " + c.estaVacio());
        
        System.out.println("\nCantidad en el club A: " + a.cantidad());
        System.out.println("Cantidad en el club B: " + b.cantidad());
        System.out.println("Cantidad en el club C: " + c.cantidad());
        
        int esta = 2; 
        System.out.println("\nEl socio " + esta + " en el club A: " + a.esta(esta));
        System.out.println("El socio " + esta + " en el club B: " + b.esta(esta));
        System.out.println("El socio " + esta + " en el club C: " + c.esta(esta));
        
        System.out.println("\nUltimo socio en el club A: " + a.ultimoSocio());
        System.out.println("Ultimo socio en el club A: " + b.ultimoSocio());
        System.out.println("Ultimo socio en el club A: " + c.ultimoSocio());
        
        int comun = 6;
        System.out.println("\nEl socio " + comun + " es comun en los clubs A y B: " + a.esSocioComun(b, comun));
        System.out.println("El socio " + comun + " es comun en los clubs A y C: " + a.esSocioComun(c, comun));
        
        int eliminar = 6;
        System.out.println("\nEliminando el socio " + eliminar + " del Club A");
        a.misterio(eliminar);
        a.mostrar();
        
        System.out.println("\nEl socio " + comun + " es comun en los clubs A y B: " + a.esSocioComun(b, comun));
        System.out.println("El socio " + comun + " es comun en los clubs A y C: " + a.esSocioComun(c, comun));
        
        
        //Unificando el los clubs A y B en uno solo (suponiendo tambien que no existan socios repetidos en un mismo club)
        int i = 1;
        int socio;
        int cantB = b.cantidad();
        while(cantB>0){
            socio = b.ultimoSocio();
            if(a.esta(socio)) //control para evitar que se duplique
                a.altaSocio(socio);
            b.misterio(socio);
            cantB = cantB - 1;
        }
        System.out.println("\nUnificando el club A y B" );
        a.mostrar();
    }
    
}
