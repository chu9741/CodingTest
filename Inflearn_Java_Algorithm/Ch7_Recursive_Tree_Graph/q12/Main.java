package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q12;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited;
    static int cnt=0;
    public void DFS(int n,int v, int[][] arr){
        // 5, 9 , arr
        isVisited[v] = true;

        for(int j=1; j<arr.length; j++){
            if(arr[v][j] == 1 && !isVisited[j]){
                if(j==5){
                    cnt++;
                    isVisited = new boolean[n+1];
                    break;
                }
                DFS(n, j, arr);
                isVisited[j] = false; // ref
            }
        }
//        isVisited = new boolean[n+1];   ref
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        isVisited = new boolean[n+1];

        for(int i=0 ;i<m; i++){
            StringTokenizer tmp =new StringTokenizer(br.readLine());
            int a= Integer.parseInt(tmp.nextToken());
            int b= Integer.parseInt(tmp.nextToken());
            arr[a][b]=1;
        }

        main.DFS(n,1,arr);
        System.out.println(cnt);
    }
}