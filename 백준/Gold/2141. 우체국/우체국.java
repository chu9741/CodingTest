
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static long min = Long.MAX_VALUE;
    static long minIdx=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        long[] towns = new long[n];
        long[] people = new long[n];
        long peopleSum=0;
        TreeMap<Long,Long> map = new TreeMap<>(); // 마을 , 사람
        PriorityQueue<Long> keyList = new PriorityQueue<>(); // 마을

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            towns[i] = Long.parseLong(st.nextToken());
            people[i] = Long.parseLong(st.nextToken());
            peopleSum+=people[i];
            keyList.add(towns[i]);
            map.put(towns[i],people[i]);
        }

        Main m = new Main();
        long halfSum=0;
        long answer = 0;
//        long end=0;
        while(!keyList.isEmpty()){
            long tmp=keyList.poll();
            halfSum+=map.get(tmp);
            if(peopleSum <= halfSum*2){
                answer=tmp;
//                end=keyList.peek();
                break;
            }
        }


        System.out.println(answer);
    }

  
}
