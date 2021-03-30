import java.util.Scanner;
public class HunterOfPrize {
    static int N;
    static int FIRST_GRADE, SECOND_GRADE;
    static int[] money_2017 ={5000000,3000000,2000000,500000,300000,100000};
    static int[] count_2017 = {1,2,3,4,5,6};
    static int[] money_2018 ={5120000,2560000,1280000,640000,320000};
    static int[] count_2018 = {1,2,4,8,16};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        while(N>0){
            FIRST_GRADE = sc.nextInt();
            SECOND_GRADE = sc.nextInt();
            // sc.nextLine();
            int a = FIRST_GRADE!=0 ? getPrize(FIRST_GRADE, money_2017, count_2017) : 0;
            int b = SECOND_GRADE!=0 ? getPrize(SECOND_GRADE, money_2018, count_2018) : 0;
            N--;
            System.out.println(a+b);
        }
    }
    public static int getPrize(int grade, int[] money, int[] count){
        int sum=0;
        for(int i=0;i<count.length;i++){
            sum+=count[i];
            if(sum >= grade)
                return money[i];
        }
        return 0;
    }
}
