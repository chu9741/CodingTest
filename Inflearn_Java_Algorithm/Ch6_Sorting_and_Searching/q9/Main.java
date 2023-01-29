package Inflearn_Java_Algorithm.Ch6_Sorting_and_Searching.q9;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public int count(ArrayList<Integer> arr, int capacity){
        int cnt=1, sum=0;
        for(int x: arr){
            if(sum+x>capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }
        return cnt;
    }

    public int Solution(int n , int m, ArrayList<Integer> arr){
        int answer =0;
        int rt = arr.stream().mapToInt(elem -> elem).sum();
        int lt = arr.stream().mapToInt(elem -> elem).max().getAsInt();
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr,mid)<= m){
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr  =new ArrayList<>();

        while (st2.hasMoreTokens())
            arr.add(Integer.parseInt(st2.nextToken()));

        main.Solution(n,m,arr);
    }
}