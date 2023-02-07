package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited;
    static int[] printArr;

    public void DFS(int v,int n,int m,int s, int[] arr){
        if(v>m)
            return;
        if(v==m){
            for(int a : printArr)
                System.out.print(a+" ");
            System.out.println();
        }
        else {
            for(int i=s; i<n ;i++){
                if(!isVisited[i] && arr[i]!=0){
                    printArr[v]=arr[i];
                    isVisited[i]=true; //useless
                    DFS(v+1,n,m,s+1,arr);
                    isVisited[i]=false; //useless
                    s++; //useless
                }
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=i+1;
        }
        isVisited = new boolean[n];
        printArr = new int[m];

        main.DFS(0,n,m,0,arr);
    }
}