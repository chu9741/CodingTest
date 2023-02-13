package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture>{
    int money;
    int date;
    public Lecture(int m, int d){
        this.money=m;
        this.date=d;
    }

    @Override
    public int compareTo(Lecture l){
        if(this.date==l.date) return l.money-this.money;
        else return l.date-this.date;
    }
}


public class Main {
    public void Solution(int n, ArrayList<Lecture> arrayList){
        Collections.sort(arrayList);
        int sum=0;
        int totalDate = arrayList.get(0).date;
        int index=0;

        while(true){
            int max=0;

            for(int i=0; i<arrayList.size(); i++){

                if(arrayList.get(i).date>=totalDate && arrayList.get(i).money>max){
                    max=arrayList.get(i).money;
                    index=i;
                }
                if(arrayList.get(i).date<totalDate) {
                    break;
                }

            }
            sum+=max;
//            System.out.println("max = "+max +" "+index);
            if(max!=0)
                arrayList.remove(index);
            if(--totalDate==0)
                break;
        }
        System.out.println(sum);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        ArrayList<Lecture> arrayList =new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arrayList.add(new Lecture(m,d));
        }
        main.Solution(n,arrayList);
    }
}