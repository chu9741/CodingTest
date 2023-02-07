package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] printArr;
    static int[] ch;
    public void Solution(int v, int n, int m, int[] arr){
        if(v>m)
            return;
        if(v==m){
//            for(int j: printArr){
//                int count=0;
//                for(int k=0; k<printArr.length; k++){
//                    if(j==printArr[k])
//                        count++;
//                }
//                if(count!=1)
//                    return;
//            }
            for(int l: printArr)
                System.out.print(l+" ");
            System.out.println();
        }
        else {
            for(int i=0; i<n; i++){
                if(ch[i]==0){
                    printArr[v] = arr[i];
                    ch[i]=1;
                }
                else continue;
                Solution(v+1,n,m,arr);
                ch[i]=0;
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
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i]=Integer.parseInt(st2.nextToken());
        printArr = new int[m];
        ch = new int[n];

        main.Solution(0,n,m,arr);
    }
}