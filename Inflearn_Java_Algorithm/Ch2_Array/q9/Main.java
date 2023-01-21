package Inflearn_Java_Algorithm.Ch2_Array.q9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void Solution(String[][] arr, int num){
        int max = 0;
        for(int i =0; i<num; i++){
            int sum1=0;
            int sum2=0;
            for(int j =0; j<num; j++){
                sum1 += Integer.parseInt(arr[i][j]);
                sum2 += Integer.parseInt(arr[j][i]);
            }
            if(sum1>max)
                max=sum1;
            if(sum2>max)
                max=sum2;
        }

        int sumCross1=0;
        int sumCross2=0;
        for(int i=0; i<num; i++){
            sumCross1+=Integer.parseInt(arr[i][i]);
            sumCross2+=Integer.parseInt(arr[i][num-1-i]);
        }
        if(sumCross1>max)
            max=sumCross1;
        if(sumCross2>max)
            max=sumCross2;

        System.out.println(max);


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        int num = Integer.parseInt(br.readLine());
        String[][] arr = new String[num][num];
        for(int i=0;i<num; i++){
            arr[i]= br.readLine().split(" ");
        }

        main.Solution(arr,num);

    }
}