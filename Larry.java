import java.util.ArrayList;
import java.util.Arrays;

public class Larry {
    public static void main(String[] args) {
        int[] array = {2,6,7,1,5,3,6,7,8,9};
        int N = 7;
        max = ascending(array);
        recursive(array, N, 0);
        System.out.println(max);
    }
    static int max=0;
    private static void recursive(int[] array, int n, int s){
        for(int a : array){
            if(a==0){
                System.out.println(Arrays.toString(array));
                int temp = ascending(array);
                max = max < temp? temp : max;
                return;
            }
        }
        for(int i=s;i<array.length;i++){
            int tmp = array[i];
            array[i] = 0;
            recursive(array, n, s+1);
            array[i] = tmp;
        }
    }
    private static int ascending(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : array){
            if(a!=0)
                list.add(a);
        }
        int cnt=1;
        for(int i=0;i<list.size();i++){
                if(i!=0 && list.get(i)>list.get(i-1)){
                    cnt++;
                }else if(i!=0 && list.get(i)<=list.get(i-1)){
                    return 0;
                }
        }
        return cnt;
    }
}
