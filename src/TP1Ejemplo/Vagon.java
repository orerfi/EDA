/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1Ejemplo;

/**
 *
 * @author Usuario
 */
public class Vagon {
    public String color;
    public Vagon siguiente;
    
    Vagon(String color){
        this.color=color;
        this.siguiente=null;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vagon getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Vagon siguiente) {
        this.siguiente = siguiente;
    }
}
