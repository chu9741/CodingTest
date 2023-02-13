package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q3;

import java.util.*;
import java.io.*;

class Wedding implements Comparable<Wedding>{
    int start;
    int end;
    public Wedding(int start, int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public int compareTo(Wedding w){
        if(this.end == w.end)
            return this.start-w.start;
        else return this.end-w.end;
    }
}

class Time implements Comparable<Time>{
    int time;
    char startOrEnd;
    public Time(int time, char c){
        this.time=time;
        this.startOrEnd=c;
    }

    @Override
    public int compareTo(Time t){
        if(this.time==t.time) return this.startOrEnd-t.startOrEnd;
        return this.time-t.time;
    }

}

public class Main {
    public void Solution(int n , ArrayList<Wedding> arrayList){
//        Collections.sort(arrayList);
        int st=arrayList.get(0).start,ed=arrayList.get(0).end;
        int max=0;
        for(int i=0; i<=72; i++){
            int cnt=0;
            for(Wedding friend : arrayList){
//            System.out.println(friend.start+" "+friend.end);
                if(friend.start<=i && friend.end>i)
                    cnt++;
            }
            max=Math.max(cnt,max);
        }
        System.out.println(max);
    }

    public void Solution2(int n, ArrayList<Wedding> arrayList){
        ArrayList<Time> timeArrayList = new ArrayList<>();
        int cnt=0;
        int max=0;
        for(Wedding w : arrayList){
            timeArrayList.add(new Time(w.start,'s'));
            timeArrayList.add(new Time(w.end,'e'));
        }

        Collections.sort(timeArrayList);

        for(Time t : timeArrayList){
            if(t.startOrEnd=='s'){
                max=Math.max(max,++cnt);
            }
            else cnt--;
        }
        System.out.println(max);
    }


    public static void main(String[] args)  throws Exception {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Wedding> friends = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            friends.add(new Wedding(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
//        main.Solution(n,friends);
        main.Solution2(n,friends);
    }
}
