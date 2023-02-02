package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> arrayList;
    static int[] answer;
    static boolean[] isVisited;
    static Queue<Integer> queue;

    public void BFS(int n,int v){
        queue.offer(v);
        answer[v]=0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
                for (int a : arrayList.get(tmp)) {
                    if (!isVisited[a]) {
                        queue.offer(a);
                        isVisited[a] = true;
                        answer[a] = answer[tmp]+1;
                    }
                }
        }
        for (int i=2; i<=n; i++)
            System.out.println(answer[i]);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        answer = new int[n+1];
        isVisited = new boolean[n+1];
        queue = new LinkedList<>();

        for(int i=0; i<=n; i++)
            arrayList.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            StringTokenizer pair = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(pair.nextToken());
            int b = Integer.parseInt(pair.nextToken());
            arrayList.get(a).add(b);
        }

        main.BFS(n,1);
    }
}