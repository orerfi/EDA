/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

/**
 *
 * @author Usuario
 */
public class LISTA {
    NODO primero;
    int cant = 0;
    
    private LISTA(){};
    
    static LISTA crearLista(){
        return new LISTA();
    }
    
    boolean esVacia(){
        
//        //Metodo 1
//        if(primero == null)
//            return true;
//        else
//            return false;
        
//        //Metodo 2 usando otra variable 
//        if(cant == 0)
//            return true;
//        else
//            return false;
        
        //Metodo 3
        return this.primero == null;
    }
    
    void insertarInicio(int x){
        NODO n = new NODO(x);
        n.setSiguiente(this.primero);
        this.primero = n;
        cant++;
    }
    
    void insertarFinal(int x){
        NODO n = new NODO(x);
        if(esVacia())
            this.primero = n;
        else{
            NODO aux = this.primero;                    //O(1)
            while( aux.getSiguiente() != null){ //O(n)
                aux = aux.getSiguiente();       //O(1)
            }
            aux.setSiguiente(n);                        //O(1)
        }
        cant++;        
    }
    
    void mostrar(){
        NODO n = this.primero;
        while( n != null){
            System.out.print(String.valueOf(n.getNumero()) + " ");
            n = n.getSiguiente();
        }
        System.out.println("");
    }
    
    int cantidad(){
        //Metodo 1
        int cantidad = 0;
        if(!esVacia()){
            cantidad++;
            NODO aux = this.primero;
            while( aux.siguiente != null){
                cantidad++;
                aux = aux.getSiguiente();
            }
        }
        return cantidad;
        
//        //Metodo 2, usando ya una variable en la lista
//        return this.cant;
    }
    
    void borrarPrimero(){
        if(cantidad()>0){ //tambien es valido comprobar si (primero != null)
//            //Metodo 1
//            this.primero = this.primero.getSiguiente();

            //Metodo 2
            NODO n = this.primero.getSiguiente();
            this.primero = n;
            cant--;
        }
    }
    
    void borrarUltimo(){
        if(this.primero != null){
            if(this.primero.getSiguiente() == null)
                this.primero = null;
            else{
                NODO aux = this.primero;
                while( aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
            }
        }
            
    }
    
    void borarConValores(int Buscado){
        int posicion = 1;
        while(posicion <= cantidad()){
            int valor = this.dameValorEnposicion(posicion);
            if(valor == Buscado){
                borrarEnPosicion(posicion);
            }
            else{
                posicion++;
            }
            
        }
    }
    
    void borrarEnPosicion(int posicion){
        if(posicion > 0){
            if(posicion == 1 )
                borrarPrimero();
            if(posicion == cantidad())
                borrarUltimo();
            if( 1 < posicion && posicion < cantidad()){
                int posAux = 1;
                NODO n = this.primero;
                while(posAux < cantidad()){
                    if(posAux+1 == posicion){
                        NODO aux = n.getSiguiente().getSiguiente();
                        n.setSiguiente(aux);
                    }
                    if(n.getSiguiente()!= null)
                        n = n.getSiguiente();
                    posAux = posAux +1;
                }
            }
        }
    }
    
    int dameValorEnposicion(int posicion){
        if(posicion > 0 && posicion <= cantidad()){
            NODO n = this.primero;
            int posAux = 1;
            try{
                while(posAux <= cantidad()){
                if(posAux == posicion)
                    return n.getNumero();
                n= n.getSiguiente();
                posAux = posAux + 1;
            }
            }
            catch(Exception e){
                e.printStackTrace();
            }
//            while(posAux <= cantidad()){
//                if(posAux == posicion)
//                    return n.getNumero();
//                n= n.getSiguiente();
//                posAux = posAux + 1;
//            }
        }
        return 0;
    }
    
    void modificarValorEnposicion(int valor,int posicion){
        if(posicion > 0 && posicion <= cantidad()){
            NODO n = this.primero;
            int posAux = 1;
            while(posAux <= cantidad()){
                if(posAux == posicion)
                    n.setNumero(valor);
                n= n.getSiguiente();
                posAux = posAux + 1;
            }
        }
    }
    
    void insertarEnposicion(int valor,int posicion){
        if(posicion > 0){
            if(posicion <= 1 )
                insertarInicio(valor);
//            if(posicion == cantidad())
//                insertarFinal(valor);
            if( 1 < posicion && posicion <= cantidad()){
                int posAux = 1;
                NODO n = this.primero;
                while(posAux < cantidad()){
                    if(posAux+1 == posicion){
                        NODO aux = new NODO(valor);
                        aux.setSiguiente(n.getSiguiente());
                        n.setSiguiente(aux);
                    }
                    if(n.getSiguiente()!= null)
                        n = n.getSiguiente();
                    posAux = posAux +1;
                }
            }
            if(posicion > cantidad())
                insertarFinal(valor);
        }
    }
    
    int suma(){
int numero = 0;
NODO n = this.primero;
while(n!= null){

numero = numero + n.getNumero();

n = n.getSiguiente();

}

return numero;
}
    
    void misterio(){
    NODO aux, aux2;
   this.primero = new NODO(1);
   aux = this.primero;
   for(int i=2; i<6 ; i++){
        aux2 = new NODO(i);
        aux2.setSiguiente(aux);
        aux = aux2;
    }
   this.primero = aux;
   //this.primero.setSiguiente(this.primero.getSiguiente().getSiguiente());
   this.mostrar();
    }
}
