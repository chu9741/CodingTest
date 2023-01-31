package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isVisited;
    static int cnt;

    public void DFS(int n, int v , ArrayList<ArrayList<Integer>> arr){
        // 5 , 9
        isVisited[v]= true;

        if(v==n) cnt++;
        for(int i : arr.get(v)){
            if(!isVisited[i]){
                DFS(n,i,arr);
                isVisited[i]=false;
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for(int j=0; j<=n; j++)
            arrayList.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            StringTokenizer pair = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(pair.nextToken());
            int b = Integer.parseInt(pair.nextToken());
            arrayList.get(a).add(b);
        }

        isVisited = new boolean[n+1];

        main.DFS(n,1,arrayList);
        System.out.println(cnt);
    }

}