/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6;

/**
 *
 * @author Usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor s = new Servidor(300000);
        
        s.procesar();
        int total = s.getPeticionesPrioritariasAtendidas()+ s.getPeticionesComunesAtendidas();
        System.out.println("Cantidad total de peticiones atentidas: " + total);
        System.out.println("Cantidad de peticiones prioritarias atentidas: " + s.getPeticionesPrioritariasAtendidas());
        System.out.println("Cantidad de peticiones comunes atentidas: " + s.getPeticionesComunesAtendidas());
        System.out.println("");
        System.out.println("Cantidad de peticiones prioritarias sin antender al finalizar: " + s.getPeticionesPrioritariasSinAtender());
        System.out.println("Cantidad de peticiones comunes sin antender al finalizar: " + s.getPeticionesComunesSinAtender());
        System.out.println("");
        System.out.println("Tiempo máximo de espera de las peticiones con prioridad: " + s.getEsperaMaximaPeticionPrioritaria());
        System.out.println("Tiempo máximo de espera de las peticiones comunes: " + s.getEsperaMaximaPeticionComun());
        System.out.println("Tiempo total del servidor inactivo: " + s.getTiempoInactivo());
        System.out.println("Tamaño máximo de la fila prioritaria: " + s.getCantidadMaximaPeticionesPrioritarias());
        System.out.println("Tamaño máximo de la fila común: " + s.getCantidadMaximaPeticionesComunes());
    }
    
}
