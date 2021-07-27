/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP8;

/**
 *
 * @author Usuario
 */
public class ArbolB {
    private ArbolB derecho;
    private ArbolB izquierdo;
    Character raiz;
    
    private ArbolB(){}
    
    public static ArbolB abVacio(){
        return new ArbolB();
    }
    
    public static ArbolB armarAB(ArbolB iz, Character v, ArbolB der){
        if(v == null)
            return null;
        
        ArbolB ab = new ArbolB();
        ab.raiz = v;
        if(iz == null)
            ab.izquierdo = new ArbolB();
        else
            ab.izquierdo = iz;
        if(der == null)
            ab.derecho = new ArbolB();
        else
            ab.derecho = der;
        return ab;
    }
    
    public boolean esABVacio(){
        return raiz == null;
    }
    
    public ArbolB izquierdo(){
        return izquierdo;
    }
    
    public ArbolB derecho(){
        return derecho;
    }
    
    public boolean pertenece(Character v){
        if(raiz == v)
            return true;
        else if(!izquierdo.esABVacio() || !derecho.esABVacio())
            return izquierdo.pertenece(v) || derecho.pertenece(v);
        else 
            return false;
    }
    
    public Character raiz(){
        return raiz;
    }
    
    public void inorden(){
        if(!esABVacio()){
            izquierdo.inorden();
            System.out.print(" " + raiz);
            derecho.inorden();
        }
    }
    
    public void posorden(){
         if(!esABVacio()){
            izquierdo.posorden();
            derecho.posorden();
            System.out.print(" " + raiz);
        }
    }
    
    public void preorden(){
         if(!esABVacio()){
            System.out.print(" " + raiz);
            izquierdo.preorden();
            derecho.preorden();
        }
    }
    
    
}
