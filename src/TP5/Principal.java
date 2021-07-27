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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String precadena1 = "a+b=";  
        String precadena2 = "(a+b)-c=";
        String precadena3 = "a-(b+c)=";
        String precadena4 = "a+b*a=";
        String precadena5 = "a*(b+c)+a/e="; 
        String precadena6 = "(b-a)/(c+d)=";
        String precadena7 = "a+b/(d-a)*e="; 
        
        String precadena8 = "9+2*(5*4-6)/7-(8+3*1)=";
        String precadena88 = "~a+b=";
        String precadena89 = "(a+(~b))*c=";
        String precadena101 = "2 + 3 * 4 =";
        char[] cadena = precadena8.toCharArray();
        

        System.out.println("Cadena: " + String.valueOf(cadena));
        char[] postfija = convertir(cadena);
        System.out.println("Postfija: " + String.valueOf(postfija));
        System.out.println("Resultado evaluando la postfija: " + evaluar(postfija));

        
    }
    static char[] convertir(char[] cadena){
        Pila p = Pila.pilaVacia();
        char c,t;
        char[] postfija = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        int posPost = 0;
        int i = 0;
        c = cadena[i];
//        postfija[0] = c;
//        System.out.println(sd.concat(String.valueOf(c)));
        while(c != '='){
            System.out.print( String.valueOf(c) + "  ");
            
            if(Character.isLetterOrDigit(c))
                postfija[posPost++] = c;
            else if( c == '(')
                p.push(c);
            else if(c == ')'){
                t = (char)p.top();
                while(t != '('){
                    postfija[posPost++] = t;
                    p.pop();
                    if(!p.esPilaVacia())
                    t = (char)p.top();
                }
                p.pop();
            }
            else if(c == '*' || c == '/'){
                while(!p.esPilaVacia() && (char)p.top() != '+' && (char)p.top() != '-'&& (char)p.top() != '('){
                    postfija[posPost++] = (char)p.top();
                    p.pop();
                }
                p.push(c);
            }
            else if(c == '+' || c == '-'){
                while(!p.esPilaVacia() && (char)p.top() != '('){
                    postfija[posPost++] = (char)p.top();
                    p.pop();
                }
                p.push(c);
            }
            else if(c == '~'){
                if(!p.esPilaVacia() && (char)p.top() == '~')
                    postfija[posPost++] = (char)p.top();
                p.push(c);
            }
            c = cadena[++i];
            p.mostrar();
            System.out.print("\t\t" + String.valueOf(postfija));
            System.out.println("");
        }
        while(!p.esPilaVacia()){
            t= (char)p.top();
            postfija[posPost++] = t;
            p.pop();
        }
        postfija[posPost++] = '=';
        return postfija;
    }
    
    static float evaluar(char[] postfija){
        Pila p = Pila.pilaVacia();
        char c ;
        int i = 0;
        float num1;
        float num2;
        c = postfija[i];
        while(c != '='){
            if(Character.isDigit(c)){
                p.push(c);
//                System.out.println("Añado " + c + " a la pila");
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
//                System.out.println("Operador encontrado: " + c);
                num1 = Float.valueOf(String.valueOf(p.top()));
                p.pop();
                num2 = Float.valueOf(String.valueOf(p.top()));
                p.pop();
                if(c == '+'){
                    p.push(num2 + num1);
                }
                else if(c == '-'){
                    p.push(num2 - num1);
                }
                else if(c == '*'){
                    p.push(num2 * num1);
                }
                else if(c == '/'){
                    p.push(num2 / num1);
                }
            }
            else if(c == ' '){
                num1 = (float)p.top();
                p.pop();
                p.push(-num1);
            }
            c = postfija[++i];
            p.mostrar();
            System.out.println("");
        }
        return (float)p.top(); 
    }
}
