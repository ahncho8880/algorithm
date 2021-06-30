package codingtest;

public class Words {
    public static void main(String[] args) {
        String str1 = "ahngchulhyun";
        String str2 = "ahngjunghyun";
        System.out.println(searchDup(str1, str2));
    }

    private static String searchDup(String target, String str) {
        int num = 1;
        int len = str.length();
        String temp = "";
        while(len>0){
            for(int i=0;i<num;i++){
                temp = str.substring(i, i+len);
                if(target.contains(temp)){
                    return temp;
                }
            }
            num++;
            len--;
        }
        return "";
    }
    
}
