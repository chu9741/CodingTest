package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public String Solution(int n, ArrayList<Integer> arrayList){
        Queue<Integer> queue = new LinkedList<>(arrayList);

        for(int i=0; i<n; i++){
            if(queue.contains(queue.poll())){
                return "D";
            }
        }
        return "U";
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(main.Solution(n,arrayList));
    }
}