/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

/**
 *
 * @author Usuario
 */
public class Funciones {
    public static void invertirNumeroMostrar(int num){
        System.out.print(num %10);
        if(num > 9)
            invertirNumeroMostrar(num/10);
    }
    
    public static int invertirNumeroRetornar(int num){
        return invRetorno(num, 0);
    }
    
    private static int invRetorno(int num, int resultado){
        if(num < 10)
            return resultado*10 + num;
        else
            return invRetorno(num/10, resultado*10 + num%10);
    }
    
    public static int invRetorno2(int num){
        if(num/10 != 0)
            return invRetorno2(num/10) + num%10*10;
        else
            return num;
            
    }
    
    public static int cantidadDigitos(int num){
        if(num < 10)
            return 1;
        else
            return 1+ cantidadDigitos(num/10);
    }
    
    public static int cantidadDigitoPar(int num){
        if(num < 10){
            if(num%2 == 0 & num != 0)
                return 1;
            else
                return 0;
        }
        else{
            if(num%2 == 0& num != 0)
                return 1 + cantidadDigitoPar(num/10);
            else
                return 0 + cantidadDigitoPar(num/10);
        }
    }
    
    public static int cantidadDigitoPar2(int num){
        if(num %2 == 0 & num/10==0)
            return 1;
        else if(num %2 == 1 & num/10==0)
            return 0;
        else if(num %2 == 0 & num/10 != 0)
            return 1 + cantidadDigitoPar2(num/10);
        else
            return cantidadDigitoPar2(num/10);
    }
    
    public static boolean isPalimdrome(char[] v, int longitud){
//        return esPalimdrome(v,longitud,0,longitud-1);
        return esPalimdrome2(v,0,longitud-1);
    }
    private static boolean esPalimdrome(char[] v, int longRestante,int pos1,int pos2){
        if(longRestante>=2){
            if(v[pos1] == v[pos2])
                return esPalimdrome(v,longRestante-2, pos1+1, pos2-1);
            else
                return false;
        }
        return v[pos1] == v[pos2];
    }
    
    private static boolean esPalimdrome2(char[] v,int inf,int sup){
        if(sup-inf > 1 && v[inf] == v[sup])
            return esPalimdrome2(v, inf+1, sup -1);
        else if(sup-inf > 1 & v[inf] != v[sup])
            return false;
        else if(v[inf] == v[sup])
            return true;
        else
            return false;
    }
    
    //multiplica los digitos del numero ingresado
    public static int misterio1(int n){
        if(n==0)
            return 1;
        else
            return (n % 10)*misterio1(n/10);
    }
    
    public static int misterio11(int n){
        int x = 1;
        while(n!=0){
            x = x * (n % 10);
            n = n/10;
        }
        return x;
    }
    
    //division entera del primer entero por el segundo entero
    public static int misterio2(int a, int b){
        if(a<b)
            return 0;
        else
            return 1 + misterio2(a-b, b);
    }
    
    public static int misterio22(int a, int b){
        int x = 0;
        while(a>=b){
            x = x +1 ;
            a = a-b;
        }
        return x;
    }
    
    public static int misterio3(int[] A, int cant,int pos){
        if(pos >= cant)
            return 0;
        else if(A[pos] % 2 == 0)
            return 1 + misterio3(A, cant, pos+1);
        else
            return -1 + misterio3(A, cant, pos+1);
    }
    
    static public boolean pert(int x){
        if(x % 10 == 5)
            return true;
        else if(x/10 != 0)
            return pert(x/10);
        else
            return false;
    }
}
