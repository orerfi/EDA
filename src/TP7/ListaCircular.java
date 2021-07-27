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
public class ListaCircular {
    private Nodo ventana;
    private Nodo lc;
    
    private class Nodo{
        private Nodo siguiente;
        private int N;
        
        Nodo(int n){
            this.N = n;
            this.siguiente = null;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public int getN() {
            return N;
        }

        public void setN(int N) {
            this.N = N;
        }
    }
    
    private ListaCircular(){};
    
    public static ListaCircular lcVacia(){
        return new ListaCircular();
    }
    
    public void lcInsertar(int numero){
        Nodo aux = new Nodo(numero);
        if(ventana == null || lc == null){
            aux.setSiguiente(aux);
            this.ventana = aux;
            this.lc = aux;
        }
        else{
            aux.setSiguiente(this.ventana);
            this.ventana = aux;
            this.lc.setSiguiente(aux);
        }
    }
    
    public Integer lcValor(){
        return this.ventana.getN();
    }
    
    public boolean esLcVacia(){
        return this.ventana == null;
    }
    
    public void lcBorrar(){
        if(this.lc != this.ventana){
            this.ventana = this.ventana.siguiente;
            this.lc.setSiguiente(this.ventana);
        }
        else{
            this.lc = null;
            this.ventana = null;
        }
    }
    
    public void lcRotar(){
        if(!esLcVacia()){
            this.ventana = this.ventana.getSiguiente();
            this.lc = this.lc.getSiguiente();
        }
    }
    
    void lcMostrar(){
        if(!esLcVacia()){
            Nodo aux = this.ventana;
            do{
                System.out.print(" " + aux.getN());
                aux = aux.getSiguiente();
            }while(aux != this.ventana);
        }
        System.out.println("");
    }
}
