import java.util.Scanner;

public class BoosterGame {
    static int N, Q, X;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        Q = input.nextInt();
        int[][] checkpoint = new int[N][2];
        int[][] quest = new int[Q][3];
        for(int i=0;i<checkpoint.length;i++){
            checkpoint[i][0] = input.nextInt();
            checkpoint[i][1] = input.nextInt();
        }
        for(int i=0;i<quest.length;i++){
            quest[i][0] = input.nextInt();
            quest[i][1] = input.nextInt();
            quest[i][2] = input.nextInt();
        }
        boolean[] visited = new boolean[N];
        check = visited;
        for(int i=0;i<quest.length;i++){
            isArrive(checkpoint, checkpoint[quest[i][0]-1][0], checkpoint[quest[i][0]-1][1], checkpoint[quest[i][1]-1], quest[i][2], quest[i][2]);       
        }
    }
    private static boolean isArrive(int[][] checkpoint, int sx, int sy, int[] goal, int hp, int maxHp) {
        int gx = goal[0];
        int gy = goal[1];
        System.out.println(sx+", "+sy+", "+hp);
        if(sx==gx && sy==gy)
            return true;
        if(hp<0)
            return false;
        // while(hp>=0){
            for(int i=0;i<checkpoint.length;i++){
                if(sx==checkpoint[i][0] && !check[i]){
                    check[i] = true;
                    isArrive(checkpoint, sx, checkpoint[i][1], goal, maxHp, maxHp);
                }
                if(sy==checkpoint[i][1] && !check[i]){
                    check[i] = true;
                    isArrive(checkpoint, checkpoint[i][0], sy, goal, maxHp, maxHp);
                }
            }
            if(hp>0){
                isArrive(checkpoint, sx+1, sy, goal, hp--, maxHp);
                isArrive(checkpoint, sx-1, sy, goal, hp--, maxHp);
                isArrive(checkpoint, sx, sy+1, goal, hp--, maxHp);
                isArrive(checkpoint, sx, sy-1, goal, hp--, maxHp);
            }
        // }        
        return false;
    }
}
