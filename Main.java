import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> al = new ArrayList<>();
        long a = Long.parseLong(st.nextToken());
        ArrayList<Double> ct = new ArrayList<>();

        for (long i = 0; i < a; i++) {
            al.clear();
            double sum =0;
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                long num = Long.parseLong(st.nextToken());
                al.add(num);
                sum += num;
            }
            double avg = sum /al.size();
            double count =0;
            for(long score : al){
                if(score > avg){
                    count++;
                }
            }
            double answer = count/b;
            ct.add(answer);
        }
        for(double answer: ct){
            System.out.printf("%.3f%%\n", answer*100);
        }

    }
}




