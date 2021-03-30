import java.util.Arrays;
import java.util.Scanner;

public class Newnie {
    static int N,M;
    static int[][] person;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0;i<N;i++){
            M = sc.nextInt();
            person = new int[M][2];
            for(int j=0;j<M;j++){
                person[j][0] = sc.nextInt();
                person[j][1] = sc.nextInt();
            }
            int cnt=0;
            for(int k=0;k<M;k++){
                for(int h=0;h<M;h++){
                    if(person[k][0] < person[h][0]){
                        if(person[k][1] < person[h][1]){

                        }
                    }
                }
            }

        }
        
        System.out.println(Arrays.toString(person));
        
    }
}
