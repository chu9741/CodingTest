package Inflearn_Java_Algorithm.Ch3_Pointers_and_Sliding_window.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> Solution(int n, int m, ArrayList<Integer> nArr, ArrayList<Integer> mArr){
        ArrayList<Integer> resArr = new ArrayList<>();
        for(int a=0; a<m; a++){
            if(nArr.contains(mArr.get(a)))
                resArr.add(mArr.get(a));
        }
        Collections.sort(resArr);
        return resArr;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> nArrayList = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            nArrayList.add(Integer.parseInt(st.nextToken()));
        }
        int m= Integer.parseInt(br.readLine());
        ArrayList<Integer> mArrayList = new ArrayList<>(m);
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while (st2.hasMoreTokens()){
            mArrayList.add(Integer.parseInt(st2.nextToken()));
        }

        for(int result : main.Solution(n,m,nArrayList,mArrayList)){
            System.out.print(result+" ");
        }
    }

}