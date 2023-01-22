package Inflearn_Java_Algorithm.Ch2_Array.q11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void Solution(int num, int[][] arr){
        String[] score = new String[num];
        for(int a=0; a<num; a++)
            score[a]=" ";
        int[] scoreIndex = new int[num];
        for(int i=0; i<5; i++){
            for(int j=0;j<num; j++){
                for(int k=0; k<num; k++){
                    String tmp = String.valueOf(k);
                    if(arr[k][i] == arr[j][i] && !score[j].contains(" "+tmp+" ")){
                        score[j] +=k+" ";
                        scoreIndex[j]++;
                    }
                }
            }
        }
        int max = 0;
        int resIndex =0;
        for(int l =0; l<num; l++)
            if(scoreIndex[l]>max){
                max=scoreIndex[l];
                resIndex=l;
            }
        System.out.println(resIndex+1);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] numArr = new int[num][5];
        for(int i =0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j =0;
            while(st.hasMoreTokens()){
                numArr[i][j]=Integer.parseInt(st.nextToken());
                j++;
            }
        }
        main.Solution(num,numArr);
    }
}
