/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Principal {
    private static final String NOMBRE_ARCHIVO1 = "./modevents.res";
    private static final String NOMBRE_ARCHIVO2 = "./c.txt";
    private static final String NOMBRE_ARCHIVO3 = "./list.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ListaEnlazada l1 = ListaEnlazada.crearLista();
//        ListaEnlazada izq = ListaEnlazada.crearLista();
//        ListaEnlazada der = ListaEnlazada.crearLista();
//        ListaEnlazada comb = ListaEnlazada.crearLista();
        
//        for(int i=1 ; i<=15 ; i++){
//            l1.insertarAlInicio(i);
//        }
//        l1.insertarAlInicio(22);
//        l1.insertarAlInicio(7);
//        l1.insertarAlInicio(34);
//        l1.insertarAlInicio(89);
//        l1.insertarAlInicio(42);
//        l1.insertarAlInicio(51);
//        l1.insertarAlInicio(70);
//        l1.insertarAlInicio(32);
//        l1.insertarAlInicio(61);
//        l1.insertarAlInicio(82);
//        l1.insertarAlInicio(18);
//        l1.insertarAlInicio(25);
//        l1.insertarAlInicio(84);
//        l1.insertarAlInicio(67);
//        for(int i=2 ; i<=10 ; i = i+2){
//            izq.insertarAlInicio(i);
//        }
//        
//        for(int i=1 ; i<=10 ; i = i+2){
//            der.insertarAlInicio(i);
//        }
        
//        l1.mostrar();
//        l1.dividirLista(izq, der);
//        izq.mostrar();
//        der.mostrar();
//        izq.intercambio();
//        der.intercambio();
//        izq.mostrar();
//        der.mostrar();
//        comb = comb.combinarLista(izq, der);
//        comb.mostrar();
        
//        l1.intercambio();
//        l1=l1.mezclarLista();
//        l1.mostrar();
        
        //leerArchivo();
//        System.out.println(extraerEvents());
//        System.out.println(extraer());
//        System.out.println(armarlista());
    }
    static private String extraerEvents() {
        File file = new File(NOMBRE_ARCHIVO1);
        boolean initModEvents = false;
        boolean abreparentesis = false;
        
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                int cantE = 0;
                for(int i=1 ; (cadena = br.readLine()) != null ; i++){
//                while((cadena = br.readLine()) != null) {
                    //System.out.println("L: " + i + " " + cadena.contains("ModEvents"));
//                    String[] vector = cadena.split(Character.toString(SEPARADOR));
//                    String cadenaTitulo = vector[0];
//                    
//                    //LEO LA DURACION Y LA CONVIERTO A INT
//                    String cadenaDuracion = vector[1];
//                    int duracion = Integer.parseInt(cadenaDuracion);
//                    
//                    //LEO LA CANTIDAD DE AREAS QUE HAY Y LA CONVIERTO A INT
//                    String cadenaCantAreas = vector[2];
//                    int cantAreas = Integer.parseInt(cadenaCantAreas);
                    
                    if(cadena.contains("ModEvents")){
                        System.out.println("L: " + i + " Encontrado inicio de ModEvents.");
                    }
                    else if(cadena.contains("{") && initModEvents == false){
                        initModEvents = true;
                    }
                    else if(initModEvents == true){
                        
                        String[] vector = cadena.split("\"");
                        
                        if(cadena.contains("{")){
                            abreparentesis = true;
                        }
                        if(abreparentesis == false && !cadena.trim().equals("")){
                            //System.out.println("L: " + i + " " +"E: " + (++cantE) + " " + cadena.trim());
                            
                            if(cadena.trim().toCharArray()[0] == '\"'){
//                                System.out.println("L: " + i + " " +"E: " + (++cantE) + " " + cadena.trim());
//                                System.out.print("L: " + i + " " +"E: " + (++cantE) + " ");
                                ++cantE;
                                System.out.print("\tHookEvent(\"");
                                for(int k = 1 ;cadena.trim().toCharArray()[k] != '\"' ;k++){
                                    System.out.print(cadena.trim().toCharArray()[k]);
                                }
                                System.out.print("\",Event_Event);");
                                System.out.println("");
                            }
                        }
                        if(cadena.contains("}")){
                            abreparentesis = false;
                        }
                    }
                }
                System.out.println("Eventos encontrados: " + cantE);
                return "Archivo leido con exito";
            }
            catch (IOException ioe) {
                return "Error al leer el archivo";
            }
        }
        return "Archivo no entonctrado";
    }
    
    
    static private String extraer() {
        File file = new File(NOMBRE_ARCHIVO2);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                int cantE = 0;
                int cantL = 0;
                String linea;
                for(int i=1 ; (cadena = br.readLine()) != null ; i++){
//                while((cadena = br.readLine()) != null) {
                    linea = cadena.trim();
                    //System.out.println("L: " + i + " " + cadena.contains("ModEvents"));
//                    String[] vector = cadena.split(Character.toString(SEPARADOR));
//                    String cadenaTitulo = vector[0];
//                    
//                    //LEO LA DURACION Y LA CONVIERTO A INT
//                    String cadenaDuracion = vector[1];
//                    int duracion = Integer.parseInt(cadenaDuracion);
//                    
//                    //LEO LA CANTIDAD DE AREAS QUE HAY Y LA CONVIERTO A INT
//                    String cadenaCantAreas = vector[2];
//                    int cantAreas = Integer.parseInt(cadenaCantAreas);
                    if(control(linea)){
                        System.out.println(linea);
                        cantE++;
                    }
                    cantL= i;
                }
                System.out.println("Lineas leidas: " + cantL);
                System.out.println("Lineas en concidencia: " + cantE);
                return "Archivo leido con exito";
            }
            catch (IOException ioe) {
                return "Error al leer el archivo";
            }
        }
        return "Archivo no entonctrado";
    }
    
    static boolean control(String linea){
//        if(!linea.contains("(type integer)")) return false;
//        if(!linea.contains("(bits 32)")) return false;
//        if(linea.contains("Render")) return false;
//        if(linea.contains("Raw")) return false;
        if(!linea.contains("(type string)")) return false;
        return true;
    }
    
    static private String armarlista() {
        File file = new File(NOMBRE_ARCHIVO3);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String cadena;
                while((cadena = br.readLine()) != null){
                    String[] split1 = cadena.split(".pop");
                    //System.out.println("String lengt: " + split1.length);
                    System.out.println("new String:" + split1[0] + "[] = \"scripts/population/" + cadena + "\";");
                }
                return "Archivo leido con exito";
            }
            catch (IOException ioe) {
                return "Error al leer el archivo";
            }
        }
        return "Archivo no entonctrado";
    }
}
