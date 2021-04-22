package samsungSW;

import java.util.Scanner;

public class ConveyorBelt {
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int[] durability = new int[N*2];
        boolean[] onRobot = new boolean[N];
        for(int i=0;i<N*2;i++){
            durability[i] = sc.nextInt();
        }
        rotateConveyor(onRobot, durability,0,0);
        sc.close();
    }
    private static void rotateConveyor(boolean[] robot, int[] durability, int useless,int cnt){
        if(K<=useless){
            System.out.println(cnt);
            return;
        }
        int temp=0;
        useless = 0;
        for(int i=2*N-1;i>=0;i--){
            if(i==0){
                durability[i] = temp;
                moveRobot(robot,durability);
                if(durability[i]>0){
                    durability[i]-=1;
                    robot[i] = true;
                }else robot[i] = false;
            }else if(i==2*N-1){
                temp = durability[i];
                durability[i] = durability[i-1];
            }else{
                if(i<N){
                    robot[i]= robot[i-1];
                }
                durability[i] = durability[i-1];
            }
        }
        
        for(int dura : durability){
            useless += dura==0 ? 1 : 0;
        }
        rotateConveyor(robot, durability, useless, cnt+1);
    }
    private static void moveRobot(boolean[] robot, int[] durability){
        for(int i=N-1;i>=1;i--){
            if(robot[i]){
                int k = i+1;
                if(k<N && durability[k]>0 && !robot[k]){
                    robot[k-1] = false;
                    durability[k] -= 1;
                    robot[k++] = true;
                }else if(k==N){
                    robot[k-1] = false;
                }
            }
        }
    }
}