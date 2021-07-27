/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1Adicional;

/**
 *
 * @author Usuario
 */
public class PrincipalTP1Adicional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacion e1 = Estacion.nuevaEstacion();
        Estacion e2 = Estacion.nuevaEstacion();
        Estacion e3 = Estacion.nuevaEstacion();
        
        System.out.println("\tEstacion 1:");
        e1.insertarInicio(4, 26);
        e1.insertarInicio(1, 24);
        e1.insertarAlFinal(5, 27);
        e1.insertarAlFinal(7,26);
        e1.insertarAlFinal(10, 23);
        e1.insertarAlFinal(15, 22);
        e1.mostrarMediciones();
        System.out.println("Temperatura minima: " + e1.temperaturaMinima());
        System.out.println("Temperatura maxima: " + e1.temperaturaMaxima());
        System.out.println("Temperatura promedio: " + e1.temperaturaPromedio());
        System.out.println("Amplitud de T.: " + e1.amplitudTermica());
        
        System.out.println("");
        
        System.out.println("\tEstacion 2:");
        e2.insertarInicio(2, 25);
        e2.insertarAlFinal(4, 26);
        e2.insertarAlFinal(5, 28);
        e2.insertarAlFinal(6,26);
        e2.insertarAlFinal(10, 23);
        e2.insertarAlFinal(12, 21);
        e2.mostrarMediciones();
        System.out.println("Temperatura minima: " + e2.temperaturaMinima());
        System.out.println("Temperatura maxima: " + e2.temperaturaMaxima());
        System.out.println("Temperatura promedio: " + e2.temperaturaPromedio());
        System.out.println("Amplitud de T.: " + e2.amplitudTermica());
        
        System.out.println("");
        
        System.out.println("\tEstacion 3:");
        e3.insertarInicio(2, 24);
        e3.insertarAlFinal(3, 26);
        e3.insertarAlFinal(5, 27);
        e3.insertarAlFinal(7,26);
        e3.insertarAlFinal(10, 24);
        e3.insertarAlFinal(15, 22);
        e3.mostrarMediciones();
        System.out.println("Temperatura minima: " + e3.temperaturaMinima());
        System.out.println("Temperatura maxima: " + e3.temperaturaMaxima());
        System.out.println("Temperatura promedio: " + e3.temperaturaPromedio());
        System.out.println("Amplitud de T.: " + e3.amplitudTermica());
    }
    
}
