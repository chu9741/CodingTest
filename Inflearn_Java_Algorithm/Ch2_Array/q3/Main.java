package Inflearn_Java_Algorithm.Ch2_Array.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public ArrayList<String> Solution(int cnt,ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<String> res = new ArrayList<>();

        for(int i=0; i<A.size(); i++){
            if(A.get(i).equals(B.get(i)))
                res.add("D");
            else if(A.get(i)-B.get(i) == 1 || A.get(i)-B.get(i) == -2)
                res.add("A");
            else
                res.add("B");
        }
        return res;
    }
     // 1<2 2<3 3<1
    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayListA = new ArrayList<>();
        ArrayList<Integer> arrayListB = new ArrayList<>();
        while(A.hasMoreTokens()) {
            arrayListA.add(Integer.parseInt(A.nextToken()));
        }

        while(B.hasMoreTokens()) {
            arrayListB.add(Integer.parseInt(B.nextToken()));
        }

        for(String result : main.Solution(cnt,arrayListA,arrayListB))
            System.out.println(result);
    }
}