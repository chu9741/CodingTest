package Inflearn_Java_Algorithm.Ch10_Dynamic_Programming.q4;

import java.io.*;
import java.util.*;

class Brick implements Comparable<Brick>{
    int size;
    int height;
    int weight;
    public Brick(int s, int h, int w){
        this.size=s;
        this.height=h;
        this.weight=w;
    }

    @Override
    public int compareTo(Brick b){
        return b.size-this.size;
    }
}

public class Main {
    static int[] count;
    static int[] sum;

    public void Solution(int n, ArrayList<Brick> arrayList){
        Collections.sort(arrayList);
        int max=0;
        for(int k=0; k<n; k++)
            sum[k]=arrayList.get(k).height;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arrayList.get(j).weight > arrayList.get(i).weight){
                    count[i]=Math.max(count[i],count[j]+1); // LIS 복습 , 이 문제에선 의미없음
                    sum[i]=Math.max(sum[i],sum[j]+arrayList.get(i).height);
                    //weight가 이전 값이 더 크면 지금까지 count[i]에서 최대 값에 하나를 더한다..
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Brick> arrayList=new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrayList.add(new Brick(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        count=new int[n];
        sum=new int[n];
        for(int j=0; j<n; j++)
            count[j]=1;

        main.Solution(n,arrayList);

        int answer=0;
        for(int a=0; a<n; a++){
            answer=Math.max(answer,sum[a]);
        }
        System.out.println(answer);
    }
}