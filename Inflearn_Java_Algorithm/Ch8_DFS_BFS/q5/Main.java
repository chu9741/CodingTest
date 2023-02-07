package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt=10000;
    public void Greedy(int v, int n, int m , int[] arr){
        //arr는 동전 타입
        if(m-arr[v]==0){
            cnt++;
            System.out.println(cnt);
        }
        else if (m-arr[v] < 0) {
            Greedy(v-1,n,m,arr);
        }
        else {
            cnt++;
            Greedy(v,n,m-arr[v],arr);
        }
    }

    public void DFS(int v, int n, int m ,int sum, int[] arr){
        if(sum>m) return;
        if(v>=cnt) return;
        if(sum==m){
            cnt=Math.min(cnt,v);
        }
        else {
            for(int i=n-1; i>=0; i--){
//                sum+=arr[i];
                DFS(v+1,n,m,sum+arr[i],arr);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i]=Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        main.DFS(0,n,m,0,arr);
        System.out.println(cnt);
    }
}