package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public void Solution(int n, int m, ArrayList<Integer> arr){
        Collections.sort(arr);
        System.out.println(arr.indexOf(m)+1);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        while (st2.hasMoreTokens()){
            arr.add(Integer.parseInt(st2.nextToken()));
        }
        main.Solution(n,m,arr);
    }
}