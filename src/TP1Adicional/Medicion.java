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
public class Medicion {
    private int numero;
    private int temperatura;
    private Medicion siguiente;

    public Medicion(int numero, int temperatura) {
        this.numero = numero;
        this.temperatura = temperatura;
        this.siguiente = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public Medicion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Medicion siguiente) {
        this.siguiente = siguiente;
    }
}
