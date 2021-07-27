/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP10;

/**
 *
 * @author Usuario
 */
public class ListaEnlazada {
    private Nodo primero;
    private int size = 0;
//    private Nodo ultimo;
    
    class Nodo{
        private int numero;
        private Nodo siguiente;
        
        Nodo(int n){
            this.numero = n;
            this.siguiente = null;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
    
    private ListaEnlazada(){};
    
    public static ListaEnlazada crearLista(){
        return new ListaEnlazada();
    }
    
    public void insertarAlInicio(int n){
        Nodo aux = new Nodo(n);
        aux.setSiguiente(this.primero);
        this.primero = aux;
        size++;
    }
    
    public void insertarAlFinal(int x){
        Nodo n = new Nodo(x);
        if(esVacia())
            this.primero = n;
        else{
            Nodo aux = this.primero;                    //O(1)
            while( aux.getSiguiente() != null){ //O(n)
                aux = aux.getSiguiente();       //O(1)
            }
            aux.setSiguiente(n);                        //O(1)
        }
        size++; 
        
    }
    
    public void eliminarPrimero(){
        this.primero = this.primero.getSiguiente();
        size--;
    }
    
    Integer getPrimero(){
        return this.primero.getNumero();
    }
    
    public boolean esVacia(){
        return this.primero == null;
    }
    
    public void mostrar(){
        Nodo aux = this.primero;
//        System.out.println("");
        while(aux != null){
            System.out.print(" " + aux.getNumero());
            aux = aux.getSiguiente();
        }
        System.out.println("");
    };
    
    public void intercambio(){
        Nodo aux,ultimo=null;
        Integer swap;
        
        aux = primero;
        while(aux != ultimo){
            while(aux.getSiguiente() !=ultimo ){
                if(aux.getNumero() > aux.getSiguiente().getNumero()){
                    swap = aux.getNumero();
                    aux.setNumero(aux.getSiguiente().getNumero());
                    aux.getSiguiente().setNumero(swap);
                }
                aux = aux.getSiguiente();
            }
            ultimo = aux;
            aux = primero;
        }
    }
    
    
   public ListaEnlazada mezclarLista(){
       ListaEnlazada izq,der;
       izq = crearLista();
       der = crearLista();
       Nodo aux;
       if(this.primero.getSiguiente() == null)
           return this;
       else{
           dividirLista(izq, der);
           //izq.mostrar();
           //der.mostrar();
           return combinarLista(izq.mezclarLista(), der.mezclarLista());
       }
   }
   
   public ListaEnlazada combinarLista(ListaEnlazada a, ListaEnlazada b){
       ListaEnlazada aux = crearLista();
       while(!a.esVacia() || !b.esVacia()){
           if(!a.esVacia() && !b.esVacia()){
                if(a.getPrimero() > b.getPrimero()){
                    aux.insertarAlFinal(b.getPrimero());
                    b.eliminarPrimero();
                }
                else{
                    aux.insertarAlFinal(a.getPrimero());
                    a.eliminarPrimero();
                }
           }
           else if(a.esVacia() && !b.esVacia()){
               aux.insertarAlFinal(b.getPrimero());
               b.eliminarPrimero();
           }
           else{
               aux.insertarAlFinal(a.getPrimero());
               a.eliminarPrimero();
           }
       }
       return aux;
   }
   
   public void dividirLista(ListaEnlazada izq, ListaEnlazada der){
       Nodo aux = this.primero;
       int i=0;
       while(i<size/2){
           izq.insertarAlFinal(aux.getNumero());
           aux=aux.getSiguiente();
           i++;
       }
       while(i<size){
           der.insertarAlFinal(aux.getNumero());
           aux=aux.getSiguiente();
           i++;
       }
   }
   
   
}
