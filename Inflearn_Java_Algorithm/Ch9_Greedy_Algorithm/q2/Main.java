package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    public Meeting(int start,int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public int compareTo(Meeting m){
        if(this.start-m.start <0)
            return -1;
        else if(this.start-m.start==0)
            return 0;
        else return 1;

        // 위 식은 아래와 같다.
        // return Integer.compare(this.start - m.start, 0);
    }
}

public class Main {
    public void Solution(int n, ArrayList<Meeting> meetings){
        int limit=0; // 최소 시작시간
        int index=0;
        int cnt=0;

        Collections.sort(meetings);

        for(int a=0; a<meetings.size(); a++){
            int notCount=0; //meeting size 체크하는 숫자
            // meeting size에 변화가 없으면 더이상 회의를 편성할 수 없음을 나타냄

            int min= Integer.MAX_VALUE; //최소 종료시간
            for(int i=0; i<meetings.size(); i++){
                if(meetings.get(i).start>=limit && meetings.get(i).end<min){
                    min=meetings.get(i).end;
                    index=i;
                }
                else notCount++;
            }

            if(notCount==meetings.size())
                break;

            limit=min;
            cnt++;
            meetings.remove(index);
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings=new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        main.Solution(n,meetings);
    }
}