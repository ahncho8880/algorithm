import java.util.*;

class Solution {
    int[] left;
    int[] right;
    int[][] smartPhone;

    public String solution(int[] numbers, String hand) {
        smartPhone = new int[4][3];
        int number = 1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                smartPhone[i][j] = number++; 
            }
        }
        smartPhone[3][0] = -1; 
        smartPhone[3][1] = 0; 
        smartPhone[3][2] = -1;
        left = new int[]{3,0};
        right = new int[]{3,2};
        String answer = "";
        for(int i=0;i<numbers.length;i++){
            int target = number[i];
            answer += pushNumber(target, hand, answer);
        }
        return answer;
    }

    public String pushNumber(int target, String hand, String ans){
        if(target==1 || target ==4||target==7){
            setHand("L",target);
            ans="L";
        }else if(target==3 || target ==6||target==9){
            setHand("R",target);
            ans="R";
        }else if(target==2 || target ==5||target==8 || target ==0){
            ans=searchHand(target, left[0], left[1], right[0], right[1], hand);
        }
        return ans;
    }

    public String searchHand(int target, int leftX, int leftY, int rightX, int rightY, String hand){
        String ans="";
        int targetX=0;
        int targetY=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(smartPhone[i][j]==target){
                    targetX = i;
                    targetY = j;
                }
            }
        }
        int subL = Math.abs(leftX-targetX) + Math.abs(leftY-targetY);
        int subR = Math.abs(rightX-targetX) + Math.abs(rightY-targetY);
        if(subL > subR){
            setHand("R", target);
            ans="R";
        }else if(subL<subR){
            setHand("L", target);
            ans="L";
        }else{
            ans = hand.equals("right")?"R":"L";
            setHand(ans, target);
        }
        return ans;
    }

    public void setHand(String hand,int target){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(smartPhone[i][j]==target){
                    if(hand.equals("L")){
                        left[0]=i;
                        left[1]=j;
                    }else{
                        right[0]=i;
                        right[1]=j;
                    }
                }
            }
        }   
    }
}