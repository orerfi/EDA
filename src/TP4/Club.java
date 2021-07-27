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
public class Club {
    private Nodo primero;
    
    private class Nodo{
        private int socio;
        private Nodo siguiente;

        public Nodo(int socio){
            this.socio = socio;
            this.siguiente = null;
        }
        
        public int getSocio() {
            return socio;
        }

        public void setSocio(int socio) {
            this.socio = socio;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
    
    private Club(){};
    
    public static Club clubVacio(){
        return new Club();
    }
    
    public void altaSocio(int s){
        Nodo n = new Nodo(s);
        if(this.primero == null)
            this.primero = n;
        else{
            Nodo aux = this.primero;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(n);
        }
    }
    
    public boolean estaVacio(){
        if(primero == null)
            return true;
        else
            return false;
    }
    
    public int cantidad(){
        return cantidad(this.primero);
    }
    
    private int cantidad(Nodo n){
        if(n == null)
            return 0;
        else
            return 1 + cantidad(n.getSiguiente());
    }
    
    public boolean esta(int socio){
        return esta(socio,this.primero);
    }
    
    private boolean esta(int socio, Nodo n){
        if(n == null)
            return false;
        else if(n.socio == socio)
            return true;
        else
            return esta(socio, n.getSiguiente());
    }
    
    public Integer ultimoSocio(){
        return ultimoSocio(this.primero);
    }
    
    private Integer ultimoSocio(Nodo n){
        if(this.primero == null)
            return null;
        else if(n.getSiguiente() != null)
            return ultimoSocio(n.getSiguiente());
        else
            return n.getSocio();
    }
    
    void mostrar(){
        Nodo n = this.primero;
        if(this.primero == null)
            System.out.println("-");
        while( n != null){
            System.out.print(String.valueOf(n.getSocio()) + " ");
            n = n.getSiguiente();
        }
        System.out.println("");
    }
    
    public boolean esSocioComun(Club c, int s){
        return esta(s) && c.esta(s);
    }
    
    //se encarga de borrar un socio (y sus repetidos si existieran)
    public void misterio(int socio){
        if(!estaVacio()){
            Nodo n = this.primero;
            while(n != null && n .getSiguiente() != null){
                if(n.getSocio() == socio){
                    n = n.getSiguiente();
                    this.primero = n;
                }
                else if(n.getSiguiente().socio == socio){
                    n.setSiguiente(n.getSiguiente().getSiguiente());
                }
                else 
                    n = n.getSiguiente();
            }
        }
    }
    
}