package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> arrayList;
    static ArrayList<String> answer;
    static Boolean[] isVisited;
    public void DFS(int v, int n){
        int aSum=0,bSum=0;
        if(v==n){
            for(int i=0; i<n; i++) {
                if (isVisited[i])
                    aSum+=arrayList.get(i);
                if (!isVisited[i])
                    bSum+=arrayList.get(i);
            }
//            System.out.println(aSum+" "+bSum);
            if(aSum==bSum)
                answer.add("YES");
        }
        else {
            isVisited[v]=true;
            DFS(v+1,n);
            isVisited[v]=false;
            DFS(v+1,n);
        }
        answer.add("NO");
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arrayList = new ArrayList<>();
        answer=new ArrayList<>();
        isVisited=new Boolean[n];
        while(st.hasMoreTokens()){
            arrayList.add((Integer.parseInt(st.nextToken())));
        }

        main.DFS(0,n);
        if(answer.contains("YES"))
            System.out.println("YES");
        else System.out.println("NO");
    }
}