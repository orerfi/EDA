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
public class Peticion {
    private int ingreso;  //Momento en el que ingresa la petición a la fila
    private int duracion; //Cantidad de tiempo que demora en procesarse la petición
    private int tiempoRestante; //Cantidad de tiempo que demora en procesarse la petición
    private int comienzaAtencion; //Momento en el que comienza a ser atendida la petición
    private boolean registrado; //Indica si la peditición es de un usuario registrado
    
    public Peticion(int duracion, boolean registrado){
        this.ingreso = Servidor.getTiempoActual();
        this.duracion = duracion;
        this.registrado = registrado;
    }
    
    public Peticion(){
        this.ingreso = Servidor.getTiempoActual();
    }
    
    /**
     * Determina si la petición es prioritaria o no
     * @return registrado
     */
    public boolean esRegistrado(){
        return this.registrado;
    }
    
    /**
     * Decrementa en uno el timpo de procesamiento y devuelve el valor restante
     * @return 
     */
    public int procesar(){
        return --duracion;
    }
    
    public void setComienzaAtencion(int n){
        this.comienzaAtencion = n;
    }
    
    /**
     * Cantidad de tiempo trascurrido desde la creacion
     * @return 
     */
    public int espera(){
        return comienzaAtencion - ingreso;
    }

    /**
     * Establece la duracion que tendra la peticion
     * @param duracion 
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Establece si la peticion es de un usario registrado
     * @param registrado 
     */
    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }
    
    
}
