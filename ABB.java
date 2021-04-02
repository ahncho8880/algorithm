import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ABB {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        int ans = solution("ababcd");
        ArrayList<String> result = new ArrayList<String>();
        for(String a : list){
            if(!result.contains(a)){
                result.add(a);
            }
        }
        System.err.println(result);
        System.out.println(result.size());
    }
    public static int solution(String s) {
        System.out.println(Pattern.matches("[b{2,}]", "abcb"));
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        int cnt = 0;
        for(int i=0;i<sb.length();i++){
            for(int j=i+1;j<=sb.length();j++){
                String str = sb.substring(i,j);
                if(isValid(str)){
                    cnt++;
                }
            }
        }
        int answer = cnt;
        return answer;
    }
    public static boolean isValid(String str){
        for(int k=0;k<str.length();k++){
            char tmp = str.charAt(k);
            for(int h=0;h<str.length();h++){
                if(h!=k && tmp==str.charAt(h)){
                    return false;
                }
            }
        }
        list.add(str);
        return true;
    }
}
