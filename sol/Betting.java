import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Betting{
    static double[] rate = new double[6];
    static int[] points = new int[4];
    static int[][] teams = new int[6][2];
    static double[] wins = new double[6];
    static double[] draws = new double[6];
    static double[] loses = new double[6];
    static double[] ans = {0,0,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] countrys = sc.nextLine().split(" ");
        for(int i=0;i<6;i++){
            String team1 = sc.next();
            String team2 = sc.next();
            for(int j=0;j<4;j++){
                if(team1.equals(countrys[j])){
                    teams[i][0] = j;
                }
                if(team2.equals(countrys[j]))
                    teams[i][1] = j;
            }
            wins[i] = sc.nextDouble();
            draws[i] = sc.nextDouble();
            loses[i] = sc.nextDouble();
        }
        
        boolean[] visited = new boolean[6];
        DFS(visited, 0, 6, 1);
        for(int i=0;i<ans.length;i++){
            System.out.println(String.format("%.10f", ans[i]));
        }

    }

    public static void DFS(boolean[] visited , int n, int r, double rate){
        if(r==0){
            refree2(points, rate);
            return ;
        }
        for(int i=n;i<6;i++){
            if(wins[i]*rate != 0 && !visited[i]){
                points[teams[i][0]] += 3;
                visited[i] = true;
                DFS(visited, n+1, r-1, wins[i]*rate);
                visited[i] = false;
                points[teams[i][0]] -= 3;
            }
            if(loses[i]*rate != 0 && !visited[i]){
                points[teams[i][1]] += 3;
                visited[i] = true;
                DFS(visited, n+1, r-1, loses[i]*rate);
                visited[i] = false;
                points[teams[i][1]] -= 3;
            }
            if(draws[i]*rate != 0 && !visited[i]){
                points[teams[i][0]] += 1;
                points[teams[i][1]] += 1;
                visited[i] = true;
                DFS(visited, n+1, r-1, draws[i]*rate);
                visited[i] = false;
                points[teams[i][1]] -= 1;
                points[teams[i][0]] -= 1;
            }
        }
    }

    private static void refree2(int[] points2, double rate2) {
        HashMap<Integer, Integer> pointTable = new HashMap<>();
        HashMap<Integer, Double> probability = new HashMap<>();

        for (int p : points2) {
            pointTable.put(p, pointTable.getOrDefault(p, 0) + 1);
        }

        int[] pointGroup = pointTable.keySet().stream().mapToInt(i -> i).toArray();

        Arrays.sort(pointGroup);

        int chance = 2;
        for (int i = pointGroup.length - 1; i >= 0; i--) {
            if (chance >= pointTable.get(pointGroup[i])) {
                chance -= pointTable.get(pointGroup[i]);
                probability.put(pointGroup[i], (double) 1 * rate2);
            } else if (chance == 0) {
                probability.put(pointGroup[i], (double) 0);
            } else {
                probability.put(pointGroup[i], ((double) chance / pointTable.get(pointGroup[i])) * rate2);
                chance = 0;
            }
        }

        for (int i = 0; i < 4; i++) {
            ans[i] += probability.get(points2[i]);
        }
    }

    private static void refree(int[] points2, double rate2) {
        int[] cnt = {0,0,0,0};
        int cnt0=0,cnt1=0;
        for(int i=0;i<points2.length;i++){
            int at = points2[i];
            for(int j=0;j<points2.length;j++){
                if(at<points2[j] && i!=j){
                    cnt[i]++;
                }
            }
        }
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==0)
                cnt0++;
            if(cnt[i]==1)
                cnt1++;
        }
        for(int i=1;i<=cnt.length;i++){
            for(int j=0;j<cnt.length;j++){
                if(cnt0==i && cnt[j]==0){
                    ans[j] += rate2/i;
                }
                if(cnt1==i && cnt[j]==1){
                    ans[j] += rate2/i;
                }
            }
        }
    }
}