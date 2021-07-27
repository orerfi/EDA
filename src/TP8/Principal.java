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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArbolB morse = generarArbolB(5, ' ');
        
        morse = insertarMorse(morse, ".-", 'A');
        morse = insertarMorse(morse, "-...", 'B');
        morse = insertarMorse(morse, "-.-.", 'C');
        morse = insertarMorse(morse, "-..", 'D');
        morse = insertarMorse(morse, ".", 'E');
        morse = insertarMorse(morse, "..-.", 'F');
        morse = insertarMorse(morse, "--.", 'G');
        morse = insertarMorse(morse, "....", 'H');
        morse = insertarMorse(morse, "..", 'I');
        morse = insertarMorse(morse, ".---", 'J');
        morse = insertarMorse(morse, "-.-", 'K');
        morse = insertarMorse(morse, ".-..", 'L');
        morse = insertarMorse(morse, "--", 'M');
        morse = insertarMorse(morse, "-.", 'N');
        morse = insertarMorse(morse, "---", 'O');
        morse = insertarMorse(morse, ".--.", 'P');
        morse = insertarMorse(morse, "--.-", 'Q');
        morse = insertarMorse(morse, ".-.", 'R');
        morse = insertarMorse(morse, "...", 'S');
        morse = insertarMorse(morse, "-", 'T');
        morse = insertarMorse(morse, "..-", 'U');
        morse = insertarMorse(morse, "...-", 'V');
        morse = insertarMorse(morse, ".--", 'W');
        morse = insertarMorse(morse, "-..-", 'X');
        morse = insertarMorse(morse, "-.--", 'Y');
        morse = insertarMorse(morse, "--..", 'Z');
        morse = insertarMorse(morse, ".----", '1');
        morse = insertarMorse(morse, "..---", '2');
        morse = insertarMorse(morse, "...--", '3');
        morse = insertarMorse(morse, "....-", '4');
        morse = insertarMorse(morse, ".....", '5');
        morse = insertarMorse(morse, "-....", '6');
        morse = insertarMorse(morse, "--...", '7');
        morse = insertarMorse(morse, "---..", '8');
        morse = insertarMorse(morse, "----.", '9');
        morse = insertarMorse(morse, "-----", '0');
        morse = insertarMorse(morse, ".-.-.", '+');
//        morse = insertarMorse(morse, "", '-');
//        morse = insertarMorse(morse, "-----", '*');
//        morse = insertarMorse(morse, "-----", '/');
//        morse = insertarMorse(morse, "-...-", '=');
        System.out.println("");
        System.out.println(decodificarPalabraMorse("... --- ...", morse));
        System.out.println(decodificarFraseMorse("... --- ...  . ... -", morse));
    }
    
    static ArbolB generarArbolB(int altura, Character c){
        if(altura == 0)
            return ArbolB.armarAB(ArbolB.abVacio(), c, ArbolB.abVacio());
        else
            return ArbolB.armarAB(generarArbolB(altura-1, c), ' ', generarArbolB(altura-1, c));
    }
    
    static ArbolB insertarMorse(ArbolB arbol, String s, Character c){
        ArbolB aux = arbol;
//        System.out.print("\nLetra: " + c + " Codigo: ");
        for(int i = 0 ; i < s.length() ; i++){
//            System.out.print(" " + s.charAt(i));
            if(s.charAt(i) == '-')
                aux = aux.derecho();
            else
                aux = aux.izquierdo();
        }
        aux.raiz = c;
        return arbol;
    }
    
    static ArbolB insertarMorse2(ArbolB arbol, String s, Character c){
        ArbolB aux = arbol;
//        System.out.print("\nLetra: " + c + " Codigo: ");
        for(int i = 0 ; i < s.length() ; i++){
//            System.out.print(" " + s.charAt(i));
            if(s.charAt(i) == '-')
                aux = aux.derecho();
            else
                aux = aux.izquierdo();
        }
        aux.raiz = c;
        return arbol;
    }
    
    static Character decodificarLetraMorse(String codigo, ArbolB arbol){
        ArbolB aux = arbol;
        for(int i = 0 ; i < codigo.length() ; i++){
            if(codigo.charAt(i) == '-')
                aux = aux.derecho();
            else
                aux = aux.izquierdo();
        }
        return aux.raiz;
    }
    
    static Character decodificarLetraMorse2(String codigo, ArbolB arbol){
        ArbolB aux = arbol;
        for(int i = 0 ; i < codigo.length() ; i++){
            if(codigo.charAt(i) == '-')
                aux = aux.derecho();
            else
                aux = aux.izquierdo();
        }
        return aux.raiz;
    }
    
    static String decodificarPalabraMorse(String codigo, ArbolB arbol){
        String[] split = codigo.split(" ");
        String resultado = "";
        
        for(int i = 0; i < split.length ; i++){
            resultado = resultado.concat(String.valueOf(decodificarLetraMorse(split[i], arbol)));
        }
        return resultado;
    }
    
    static String decodificarPalabraMorse2(String codigo, ArbolB arbol){
        String[] split = codigo.split(" ");
        String resultado = "";
        
        for(int i = 0; i < split.length ; i++){
            resultado = resultado.concat(String.valueOf(decodificarLetraMorse(split[i], arbol)));
        }
        return resultado;
    }
    
    static String decodificarFraseMorse(String codigo, ArbolB arbol){
        String[] split = codigo.split("  ");
        String resultado = "";
        
        for(int i = 0; i < split.length ; i++){
            resultado = resultado.concat(" " + String.valueOf(decodificarPalabraMorse(split[i], arbol)));
        }
        return resultado;
    }
}
