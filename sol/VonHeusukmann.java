package sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class VonHeusukmann {
    static long X;
    static int A, B;
    static boolean isDup = false;
    static ArrayList<Long> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String aX = st.nextToken();
        String bX = st.nextToken();
        int aMin = calMin(aX);
        int bMin = calMin(bX);
        for(int i=aMin;i<=36;i++){
            for(int j=bMin;j<=36;j++){
                if(i!=j){
                    try{
                        int a = Integer.parseInt(aX, i);
                        int b = Integer.parseInt(bX, j);
                        if(a==b){
                            X = a;
                            A = i;
                            B = j;
                            ans.add(X);
                        }
                    }catch(NumberFormatException e){}
                }
            }
        }
        if(ans.size()==0)
            System.out.println("Impossible");
        else if(ans.size()==1)
            System.out.println(X+" "+A+" "+B);
        else
            System.out.println("Multiple");
    }
    private static int calMin(String str){
        int min = 2;
        for(int i=0;i<str.length();i++){
            int tmp = str.charAt(i);
            if(tmp>=97 && tmp<=122){
                tmp-=86;
            }else{
                tmp-=47;
            }
            min = tmp > min ? tmp : min;
        }
        return min;
    }
}