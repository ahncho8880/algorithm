package codingtest;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String str1 = "ksasdfsdsdasdfks";
        String str2 = "ksasdfsdasdfks";
        String str3 = "dddd";
        String str4 = "ddddd";
        System.out.println("hello world");
        int price = 11300;
        int discount = 30;
        float f1 = Float.MAX_VALUE;
        double d1 = Double.MAX_VALUE;
        double val = 1 - 0.3;
        double val2 =  70 * 0.01;
        System.out.println(val);
        System.out.println(val2);
        System.out.println(f1);
        System.out.println(d1);
        solution(str1);
        solution(str2);
        solution(str3);
        solution(str4);
    }

    public static String[] solution(String s) {
        int i = 0;
        int end = s.length();
        int len = 1;
        ArrayList<String> answerList = new ArrayList<>();
        do {
            if (s.substring(i, i + len).equals(s.substring(end - len, end))) {
                String str = s.substring(i, i + len);
                i += len;
                end -= len;
                len = 1;
                answerList.add(str);
            } else {
                len++;
            }
        } while (i < end);
        for(int j = answerList.size() - 1; j >= 0; j--){
            j -= j==answerList.size() - 1 && i != end ? 1 : 0;
            String tmp = answerList.get(j);
            answerList.add(tmp);
        }
        String[] answer = new String[answerList.size()];
        int number = 0;
        for(String ss : answerList){
            answer[number++] = ss;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
