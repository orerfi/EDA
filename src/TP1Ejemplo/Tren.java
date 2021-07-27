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
public class Tren {
    Vagon primero;
    
    public void agregarAlInicio(String color){
        Vagon v = new Vagon(color);
        v.setSiguiente(this.primero);
        this.primero = v;
    }
        
        public void agregarAlUltimo(String color){
        Vagon v = new Vagon(color);
        Vagon aux = this.primero;
        while(aux.getSiguiente()!= null){
            aux=aux.getSiguiente();
        }
        aux.setSiguiente(v);
    }
    
    public void mostrarTren(){
        Vagon aux = this.primero;
        while(aux!= null){
            System.out.print("|"+aux.getColor()+"|->");
            aux=aux.getSiguiente();
        }
        System.out.println("");
    }
}
