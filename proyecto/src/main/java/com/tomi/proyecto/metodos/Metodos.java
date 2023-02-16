

package com.tomi.proyecto.metodos;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class Metodos {
    
    public final HashMap<Character, Integer> abc = new HashMap<>();
    public final HashMap<Integer, Character> cba = new HashMap<>();
    public final ArrayList<Character> abcd = new ArrayList<>();
            
    public Metodos() {
        abcd.add('a');
        abcd.add('b');
        abcd.add('c');
        abcd.add('d');
        abcd.add('e');//5
        abcd.add('f');
        abcd.add('g');
        abcd.add('h');
        abcd.add('i');
        abcd.add('j');//10
        abcd.add('k');
        abcd.add('l');
        abcd.add('m');
        abcd.add('n');
        abcd.add('o');//15
        abcd.add('p');
        abcd.add('q');
        abcd.add('r');
        abcd.add('s');
        abcd.add('t');//20
        abcd.add('u');
        abcd.add('v');
        abcd.add('w');
        abcd.add('x');
        abcd.add('y');//25
        abcd.add('z');
        abcd.add('A');
        abcd.add('B');
        abcd.add('C');
        abcd.add('D');//30
        abcd.add('E');
        abcd.add('F');
        abcd.add('G');
        abcd.add('H');
        abcd.add('I');//35
        abcd.add('J');
        abcd.add('K');
        abcd.add('L');
        abcd.add('M');
        abcd.add('N');//40
        abcd.add('O');
        abcd.add('P');
        abcd.add('Q');
        abcd.add('R');
        abcd.add('S');//45
        abcd.add('T');
        abcd.add('U');
        abcd.add('V');
        abcd.add('W');
        abcd.add('X');//50
        abcd.add('Y');
        abcd.add('Z');
        abcd.add('1');
        abcd.add('2');
        abcd.add('3');//55
        abcd.add('4');
        abcd.add('5');
        abcd.add('6');
        abcd.add('7');
        abcd.add('8');//60
        abcd.add('9');
        abcd.add('0');
        for (int i = 0; i < abcd.size(); i++) {
            abc.put(abcd.get(i), i);
            cba.put(i,abcd.get(i));
        }

        
    }
    public String Encriptar(ArrayList<String> palabras,int clave){
        if (clave == 0) {
            clave =1;
        }
        String token = "";

        for(int i = 0;i<palabras.size();i++){
            
            String palabra = palabras.get(i);//agarro la palabra
            

            ArrayList<Integer> palabraint = new ArrayList<>();//la paso a numero 
            for(char letra:palabra.toCharArray()) {
                palabraint.add(abc.get(letra));
            }
            //la paso a numero
            
            String newpalabra="";//uno nuevo palabra
            
            for (int j = 0; j < palabraint.size(); j++) {
                palabraint.set(j, (palabraint.get(j))*clave);
            }
            //lo multiplico
        
            for(int k = 0; k < palabraint.size(); k++){
                int Nletra = palabraint.get(k);
                int contador = 0;
                while (Nletra>=abcd.size()) {                        
                        contador++;
                        Nletra-=abcd.size();
                    }
                newpalabra += "%" + contador +"#" + Character.toString(cba.get(Nletra));   
            }
            //paso a palabra
            token += newpalabra;
            token += "-";
       
        }
        token = token.substring(0, token.length()-1);
        return token;
    }
     
    public ArrayList<String> DesEncriptar(String palabra,int clave){
        if (clave == 0) {
            clave =1;
        }  
        ArrayList<String> devuelve = new ArrayList<>();
          
        String[] palabras = palabra.split("-");
        //separo las palabra
        for(String palabrita:palabras){
            //por cada palabra ej [%0a%1a%2a%51a%52a%61a]
            String[] a = palabrita.split("%");
            a = Arrays.copyOfRange(a, 1, a.length);
            //separo por % ej [0#a,1#a,2#a,51#a,5#1]
            StringBuilder palabraTraducida = new StringBuilder();
            for(int e = 0; e<a.length;e++){
                String le = "";//letra
                int nv;//numers
                String[] o = a[e].split("#");
                nv = Integer.parseInt(o[0]);
                le =o[1];
                int x = abc.get(le.toCharArray()[0]);
                x += nv*abcd.size();
                x = x/clave;
                palabraTraducida.append(cba.get(x));       
            }

            devuelve.add(palabraTraducida.toString());
        }
        return devuelve;
    }
    
    
    
}
