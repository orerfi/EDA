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
public class Fila {
    private Nodo primero; //frente
    private Nodo ultimo; //fondo
    private class Nodo{
        private Nodo siguiente;
        private Peticion item;
        
        private Nodo(Peticion p){
            item = p;
            siguiente = null;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Peticion getItem() {
            return item;
        }

        public void setItem(Peticion item) {
            this.item = item;
        }
        
        
    }
    private int cantidad = 0;
    private int cantMaxima = 0;
    private int esperaMaxima = 0;
    
    private Fila(){};
    
    public static Fila filaVacia(){
        return new Fila();
    }
    
    boolean esFilaVacia(){
        return cantidad == 0;
    }
    
    /**
     * Devuelve la cantidad de elementos que hay en la fila
     * @return 
     */
    int logitud(){
        return cantidad;
    }
    
    /**
     * Devuelve la peticion que esta al frente (en este caso la primera de la lista)
     * @return 
     */
    public Peticion frente(){
        return this.primero.getItem();
    }
    
    /**
     * Elimina la peticion que esta al frente
     */
    public void defila(){
        if(!esFilaVacia()){
            if(this.primero.getItem().espera() > esperaMaxima)
                esperaMaxima = this.primero.getItem().espera();
            this.primero = this.primero.getSiguiente();
            cantidad--;
        }
    }
    
    public void enfila(Peticion p){
        Nodo n = new Nodo(p);
        if(esFilaVacia()){
            this.primero = n;
            this.ultimo = n;
        }
        else{
            this.ultimo.setSiguiente(n);
            this.ultimo = n;
        }
        cantidad++;
        if(cantidad > cantMaxima)
            cantMaxima = cantidad;
    }

    public int getCantMaxima() {
        return cantMaxima;
    }
    
    public int getEsperaMaxima(){
        return esperaMaxima;
    }
}
