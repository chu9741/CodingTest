package Inflearn_Java_Algorithm.Ch2_Array.q8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public ArrayList<Integer> Solution(ArrayList<Integer> arr , int num){
        ArrayList<Integer> sortArr = (ArrayList<Integer>) arr.clone();
        ArrayList<Integer> gradeArr = new ArrayList<>(num);
        sortArr.sort(Collections.reverseOrder());

        for(int i =0; i<num; i++){
            gradeArr.add(sortArr.indexOf(arr.get(i))+1);
        };
        return gradeArr;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        while (st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        main.Solution(arr,num).forEach((grade)-> System.out.print(grade + " "));

    }
}