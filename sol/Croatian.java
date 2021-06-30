package sol;

import java.util.Scanner;

public class Croatian {
    static String[] before = {"c=","c-","dz=","d-","lj","nj","s=","z="};
    static String[] after = {"A","B","C","D","E","F","G","H"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        for(int i=0;i<8;i++){
            input = input.replace(before[i], after[i]);
        }
        System.out.println(input.length());
    }
}
