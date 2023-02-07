package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isVisited;
    static int[] printArr;
    int answer=0;

    public void Solution(int[] arr){
        if(arr.length<1)
            return;
        if(arr.length==1)
            answer=arr[0];

        int[] tmp= new int[arr.length-1];
        for(int i=0; i<arr.length-1; i++){
            tmp[i]=arr[i]+arr[i+1];
        }
        Solution(tmp);
    }

    public void DFS(int v,int n, int f, int[] arr){
        //arr의 n개의 숫자가 -> m으로 변신
        if(v>n)
            return;
        if(v==n){
            Solution(printArr);
            if(answer==f)
                for(int j=0; j<n; j++){
                    System.out.print(printArr[j]+" ");
                }
            //method
        }
        else {
            for(int i=0; i<n; i++){
                if(!isVisited[i]){
                    printArr[v]=arr[i];
                    isVisited[i]=true;
                    DFS(v+1,n,f,arr);
                    isVisited[i]= false;
                    if(answer==f)
                        return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int f =Integer.parseInt(st.nextToken());
        int[] arr =new int[n];
        for(int i=0; i<n; i++)
            arr[i]=i+1;

        isVisited = new boolean[n];
        printArr = new int[n];

        main.DFS(0,n,f,arr);
    }
}
