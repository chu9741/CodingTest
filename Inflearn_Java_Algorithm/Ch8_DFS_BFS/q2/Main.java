package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    static boolean[] isVisited;
    static ArrayList<Integer> sumArray;

    public void DFS(int c,int index, int sum, ArrayList<Integer> arr){
        if(index>=arr.size())
            return;

        int tmp = arr.get(index);

        if(sum+tmp<=c && sum+tmp>sumArray.get(sumArray.size()-1))
            sumArray.add(sum+tmp);
        DFS(c,index+1,sum+tmp,arr);
        DFS(c,index+1,sum,arr);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++)
            arr.add(Integer.parseInt(br.readLine()));
        sumArray = new ArrayList<>();
        sumArray.add(0);
        main.DFS(c,0,sum,arr);

        sumArray.sort(Collections.reverseOrder());
        System.out.println(sumArray.get(0));
    }
}