package Inflearn_Java_Algorithm.Ch2_Array.q10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void Solution(int num, String[][] arr){
        int[][] newArr = new int[num+2][num+2];
        for(int i =1; i<=num; i++){
            for(int j=1; j<=num; j++){
                newArr[i][j] = Integer.parseInt(arr[i-1][j-1]);
;            }
        }
        int count = 0;
        for(int a=1; a<=num; a++){
            for(int b=1; b<=num; b++){
                int tmp =newArr[a][b];
                if(tmp>newArr[a-1][b] && tmp>newArr[a][b+1]
                        && tmp>newArr[a+1][b] && tmp>newArr[a][b-1])
                    count++;

            }
        }
        System.out.println(count);
    }

    public static void main(String[] args)throws Exception{
        Main main = new Main();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[][] arr = new String[num][num];
        for(int i=0; i<num; i++){
            String[] tmp= br.readLine().split(" ");
            arr[i]= tmp;
        }
        main.Solution(num,arr);
    }
}
