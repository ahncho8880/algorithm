import java.util.Scanner;

public class Tax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        if(n%1000==0 && n<=10000000){
            System.out.println((int)(n*0.78)+" "+(int)(n - n*0.2*0.22));
        }
    }
}
