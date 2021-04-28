package sol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Family {
    static int N, M;
    static ArrayList<String> PEOPLE = new ArrayList<>();
    static String[][] names ;
    static HashMap<String, ArrayList<String>> hm = new HashMap<>();
    static ArrayList<String> ancestors = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        N = sc.nextInt();
        for(int i=0;i<N;i++){
            String name = sc.next();
            PEOPLE.add(name);
        }
        M = sc.nextInt();
        names = new String[M][2];
        for(int i=0;i<M;i++){
            String son = sc.next();
            String father = sc.next();
            names[i][0] = son;
            names[i][1] = father;
        }
        Collections.sort(PEOPLE);

        for(String name : PEOPLE){
            int cnt =0;
            for(int i=0;i<N;i++){
                if(name.equals(names[i][0])){
                    cnt+=1;
                }
            }
            if(cnt==0)
                ancestors.add(name);
        }
        for(int i=0;i<ancestors.size();i++){
            Queue<Node> pq = new LinkedList<>();
            String anc = ancestors.get(i);
            boolean[] visit = new boolean[M];
            pq.add(new Node(anc));
            while(!pq.isEmpty()){
                ArrayList<String> ans = new ArrayList<>();
                ArrayList<String> sons = new ArrayList<>();
                Node an = pq.poll();
                ans.add(an.name);
                for(int j=0;j<M;j++){
                    String l =names[j][0];
                    String r =names[j][1];

                    if((an.name).equals(r)){
                        visit[j] = true;
                        if(!validation(l, visit)){
                            sons.add(l);
                            pq.add(new Node(l));
                        }
                    }
                }
                Collections.sort(sons);
                hm.put(an.name, sons);
            }
        }
        
        System.out.println(ancestors.size());
        for(String name : ancestors){
            System.out.print(name+" ");
        }
        System.out.println();
        for(String name : PEOPLE){
            System.out.print(name+" "+hm.get(name).size()+" ");
            for(int j=0;j<hm.get(name).size();j++){
                System.out.print(hm.get(name).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static boolean validation(String son, boolean[] visit){
        for(int i=0;i<M;i++){
            if(names[i][0].equals(son) && !visit[i])
                return true;
        }
        return false;
    }
    
    static class Node{
        String name;

        public Node(String name){
            this.name = name;
        }
    }
}
