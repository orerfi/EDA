/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Servidor {
    private static int tiempoActual = 0;  //Contador para simular el paso del tiempo
    private int tiempoTotal;  //Cantidad total de milisegundos que durará la simulación
    private int tiempoInactivo = 0;  //Cantidad de milisegundos que el servidor estuvo inactivo
    private Fila filaprioridad = Fila.filaVacia();  //Objeto Fila de Peticiones prioritarias
    private Fila filaComun = Fila.filaVacia();  //Objeto Fila de Peticiones comunes
    private Peticion enCurso;  //Almacena la Petición que se está procesado
    private int peticionesPrioritariasAtendidas = 0;  //Cantidad de peticiones prioritaris se atendieron
    private int peticionesComunesAtendidas = 0;  //Cantidad de peticiones comunes se atendieron
    
    Servidor(int tiempo){this.tiempoTotal = tiempo;}
    
    /**
     * Devuelve el tiempo transcurrido
     * @return 
     */
    static public int tiempoActual(){
        return tiempoActual;
    }
    
    /**
     * Crea un objeto Petición con con probabilidad de 1%, sino devuelve null
     * @return 
     */
    Peticion nuevaPeticion(){
        Random r = new Random();
        
        if(r.nextInt(100) == 1){
            Peticion p = new Peticion();
            p.setDuracion(r.nextInt(251)+50);
            if(r.nextInt(100)== 10)
                p.setRegistrado(true);
            else
                p.setRegistrado(false);
            
           return p;
            //return new Peticion(r.nextInt(251)+50, r.nextInt(100)== 10) ;
        }
        return null;
    }
    
    /**
     * Proceso de simulación
     */
    void procesar(){
        while(tiempoActual < tiempoTotal){
            //Enfilar peticiones
            Peticion p = this.nuevaPeticion();
            if(p != null){
                if(p.esRegistrado())
                    this.filaprioridad.enfila(p);
                else
                    this.filaComun.enfila(p);
            }
            
            //procesar peticiones
            if(this.enCurso == null || enCurso.procesar() <= 0){
                if(!this.filaprioridad.esFilaVacia()){
                    this.filaprioridad.frente().setComienzaAtencion(tiempoActual);
                    this.enCurso = filaprioridad.frente();
                    this.filaprioridad.defila();
                    this.peticionesPrioritariasAtendidas++;
                }
                else if(!this.filaComun.esFilaVacia()){
                    this.filaComun.frente().setComienzaAtencion(tiempoActual);
                    this.enCurso = filaComun.frente();
                    this.filaComun.defila();
                    this.peticionesComunesAtendidas++;
                }
                else
                    tiempoInactivo++;
            }
            else
                this.enCurso.procesar();
            tiempoActual++;
        }
    }

    public int getTiempoInactivo() {
        return tiempoInactivo;
    }

    public int getPeticionesPrioritariasAtendidas() {
        return peticionesPrioritariasAtendidas;
    }

    public int getPeticionesComunesAtendidas() {
        return peticionesComunesAtendidas;
    }

    public static int getTiempoActual() {
        return tiempoActual;
    }
    
    public int getPeticionesPrioritariasSinAtender() {
        return filaprioridad.logitud();
    }

    public int getPeticionesComunesSinAtender() {
        return filaComun.logitud();
    }
    
    public int getCantidadMaximaPeticionesPrioritarias(){
        return filaprioridad.getCantMaxima();
    }
    public int getCantidadMaximaPeticionesComunes(){
        return filaComun.getCantMaxima();
    }
    
    public int getEsperaMaximaPeticionPrioritaria(){
        return filaprioridad.getEsperaMaxima();
    }
    
    public int getEsperaMaximaPeticionComun(){
        return filaComun.getEsperaMaxima();
    }
}
