/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5;

/**
 *
 * @author Usuario
 */
public class Pila {
    private Nodo primero;
    
    class Nodo{
        private Object item;
        private Nodo siguiente;
        
        /**
         * Constructor del nodo
         * @param c 
         */
        Nodo(Object c){
            this.item = c;
            this.siguiente = null;
        }

        public Object getItem() {
            return this.item;
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
    
    private Pila(){};
    
    public static Pila pilaVacia(){
        return new Pila();
    }
    
    public boolean esPilaVacia(){
        return this.primero == null;
    }
    
    public Object top(){
        if(this.primero == null)
            return null;
        else
            return this.primero.getItem();
    }
    
    /**
     * Quita el ultimo elemento de la pila
     */
    public void pop(){
        if(this.primero != null)
            this.primero = this.primero.getSiguiente();
    }
    
    public void push(Object item){
        Nodo n = new Nodo(item);
        n.setSiguiente(this.primero);
        this.primero = n;
    }
    
    void mostrar(){
        Nodo n = this.primero;
        System.out.print("\t");
        while(n != null) {
            System.out.print(String.valueOf(n.getItem()) + " ");
            n = n.getSiguiente();
        }
//        System.out.println("");
    }
    
    int cantidad(){
        //Metodo 1
        int cantidad = 0;
        if(!esPilaVacia()){
            cantidad++;
            Nodo aux = this.primero;
            while( aux.siguiente != null){
                cantidad++;
                aux = aux.getSiguiente();
            }
        }
        return cantidad;
        
//        //Metodo 2, usando ya una variable en la lista
//        return this.cant;
    }
}
