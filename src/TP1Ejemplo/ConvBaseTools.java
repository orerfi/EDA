package TP1Ejemplo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class ConvBaseTools {
    public static String DecimalABinario(double numero,int base){
        int entero = ((int) numero);
        double decimal = numero - entero;
//        double base = 2;
        
        System.out.println("NUmero Ingresado: " + numero);
        System.out.println("Parte entera: " + entero);
        System.out.println("Parte deciml: " + decimal);
        
        String resultado;
        String resultEntero = "";
        String resultdecimal = "";
        if(entero == 0)
            resultEntero = "0";
        if(decimal != 0)
            resultdecimal = ",";
        
        
        do{
            decimal = decimal*base;
//            System.out.println(aux);
            if(decimal >= 1){
                if((int) decimal <10)
                    resultdecimal += String.valueOf((int) decimal);
                else{
                    switch((int) decimal){
                        case 10: resultdecimal += "A";
                        break;
                        case 11: resultdecimal += "B";
                        break;
                        case 12: resultdecimal += "C";
                        break;
                        case 13: resultdecimal += "D";
                        break;
                        case 14: resultdecimal += "E";
                        break;
                        default: resultdecimal += "F";
                    }
                }
                //resultdecimal.concat(String.valueOf((int) decimal));
                decimal = decimal - ((int) decimal);
            }
            else
//                System.out.print("0");
//                resultdecimal.concat("0");
                resultdecimal += "0";
        }while(decimal !=0);

        resultado = resultEntero.concat(resultdecimal);
        return resultado;
    }
}
