package Inflearn_Java_Algorithm.Ch3_Pointers_and_Sliding_window.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int m, List<Integer> nList, List<Integer> mList){
        int i=0, j=0;
        while(i<n || j<m){
            if(i==n){
                System.out.print(mList.get(j)+" ");
                j++;
                continue;
            }
            if(j==m){
                System.out.print(nList.get(i)+" ");
                i++;
                continue;
            }
            if(nList.get(i) < mList.get(j)) {
                System.out.print(nList.get(i) + " ");
                i++;
            }
            else{
                System.out.print(mList.get(j)+" ");
                j++;
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nList = new ArrayList<>();
        while (st.hasMoreTokens()){
            nList.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> mList  = new ArrayList<>();
        while (st2.hasMoreTokens()){
            mList.add(Integer.parseInt(st2.nextToken()));
        }
        main.Solution(n,m,nList,mList);
    }

}