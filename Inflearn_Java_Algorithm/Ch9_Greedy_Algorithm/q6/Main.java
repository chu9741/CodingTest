package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public int find(int v){
        int fv = answer[v];
        if(fv!=v){
            return answer[v] = find(answer[v]);
        }
        else return answer[v]; //fv , v
    }

    public void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa!=fb){
            answer[fa] = fb;
        }
    }

    static int[] answer;

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        answer = new int[n+1];
        for(int i=1; i<=n; i++)
            answer[i]=i; // init

        for(int i=0; i<m; i++){
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tmp.nextToken());
            int b = Integer.parseInt(tmp.nextToken());
            main.union(a,b);
        }

        StringTokenizer validation = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(validation.nextToken());
        int b = Integer.parseInt(validation.nextToken());

//        for(int x : answer)
//            System.out.print(x+" ");

        int fa = main.find(a);
        int fb = main.find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
