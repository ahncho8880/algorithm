package sol;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String xa = sc.next();
        String xb = sc.next();
        sc.nextLine();
        long x = 0;
        long a=0, b=0;
        long _x = 0;
        int _a=0, _b=0;
        ArrayList<Long> lista = new ArrayList<Long>();
        ArrayList<Long> listb = new ArrayList<Long>();
        boolean isMulti = false;
        String comment = "";
        int starta = 2, startb = 2;
        for(int i = 0;i < xa.length();i++){
            int ascci = (int)xa.charAt(i);
            if(ascci>=97)
                starta = (starta<ascci-86) ? ascci-86 : starta;
            else
                starta =  (starta<ascci-48) ? ascci-48 : starta;
        }
        for(int i = 0;i < xb.length();i++){
            int ascci = (int)xb.charAt(i);
            if(ascci>=97)
                startb = (startb<ascci-86) ? ascci-86 : startb;
            else
                startb =  (startb<ascci-48) ? ascci-48 : startb;
        }

        for(int j=starta;j<=36;j++){
            a=0;
            for(int i =0;i<xa.length();i++){
                a += ((long)xa.charAt(xa.length()-1-i)>=97) ? ((long)xa.charAt(xa.length()-1-i)-87)*Math.pow(j,i) : ((long)xa.charAt(xa.length()-1-i)-'0')*Math.pow(j,i); 
            }
            lista.add(a);
        }
        for(int j=startb;j<=36;j++){
            b=0;
            for(int i =0;i<xb.length();i++){
                b += ((long)xb.charAt(xb.length()-1-i)>=97) ? ((long)xb.charAt(xb.length()-1-i)-87)*Math.pow(j,i) : ((long)xb.charAt(xb.length()-1-i)-'0')*Math.pow(j,i); 
            }
            listb.add(b);
            for(int k =0;k<lista.size();k++){
                if(!isMulti && lista.get(k)==b && j!=starta+k && b<Math.pow(2, 63)){
                    isMulti = true;
                    _x = b;
                    _a = starta+k;
                    _b = j;
                }else if(isMulti && lista.get(k)==b &&j!=starta+k){
                    comment = "Multiple";
                }
            }
        }
        if(!isMulti)
            comment = "Impossible";
        if(!comment.equals(""))
            System.out.println(comment);
        else
            System.out.println(_x+" "+_a+" "+_b);
        // System.out.println(lista);
        // System.out.println(listb);
    }
}