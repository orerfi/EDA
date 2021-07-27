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
public class Estacion {
    Medicion primero;
    int cant = 0;
    
    private Estacion(){};
    
    static public Estacion nuevaEstacion(){
        return new Estacion();
    }
    
    boolean isVacia(){
        if(this.primero == null)
            return true;
        else
            return false;
    }
    
    int cantidad(){
        return this.cant;
    }
    
    void mostrarMediciones(){
        if(!this.isVacia()){
            Medicion m = this.primero;
            while(m != null){
                System.out.println("Medicion N°: " + m.getNumero());
                System.out.println("Temperatura: " + m.getTemperatura());
                System.out.println("");
                m = m.getSiguiente();
            }
        }
    }
    
    void insertarInicio(int numMedicion, int temperatura){
        Medicion m = new Medicion(numMedicion, temperatura);
        if(this.isVacia())
            this.primero = m;
        else{
            m.setSiguiente(this.primero);
            this.primero = m;
        }
        cant++;
    }
    
    void insertarAlFinal(int numMedicion, int temperatura){
        Medicion m = new Medicion(numMedicion, temperatura);
        if(this.isVacia())
            this.primero = m;
        else{
            Medicion aux = this.primero;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(m);
        }
        cant++;
    }
    
    float temperaturaMinima(){
        try{
            if(this.cantidad() >0){
                int numero;
                Medicion m = this.primero;
                numero = m.getTemperatura();
                while(m != null){
                    if(m.getTemperatura() < numero)
                    numero = m.getTemperatura();
                    m = m.getSiguiente();
                }
                return numero;
            }
            else
                throw new ExceptionInInitializerError("No hay mediciones.");
        }catch (Exception e){
//            e.getMessage();
            throw new ExceptionInInitializerError("No hay mediciones.");
        }
    }
    
    float temperaturaMaxima(){
        try{
            if(this.cantidad() >0){
                int numero;
                Medicion m = this.primero;
                numero = m.getTemperatura();
                while(m != null){
                    if(m.getTemperatura() > numero)
                    numero = m.getTemperatura();
                    m = m.getSiguiente();
                }
                return numero;
            }
            else
                throw new ExceptionInInitializerError("No hay mediciones.");
        }
        catch(Exception e){
//            e.getMessage();
            throw new ExceptionInInitializerError("No hay mediciones.");
        }
            
    }
    
    float temperaturaPromedio(){
        try{
            if(this.cantidad() > 0){
                float suma = 0;
                Medicion m = this.primero;
                while(m != null){
                    suma = suma + m.getTemperatura();
                    m = m.getSiguiente();
                }
                return suma/cantidad();
            }
            else
                throw new ExceptionInInitializerError("No hay mediciones.");
        }
        catch(Exception e){
            throw new ExceptionInInitializerError("No hay mediciones.");
        }
    }
    
    float amplitudTermica(){
        return this.temperaturaMaxima()-this.temperaturaMinima();
    }
}
