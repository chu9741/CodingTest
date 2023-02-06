package Inflearn_Java_Algorithm.Ch8_DFS_BFS.q3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    int score;
    int time;
    public Node(int score, int time){
        this.score=score;
        this.time=time;
    }
}

public class Main {
    static ArrayList<Integer> sumArray;
    static int answer=0;
    public void DFS(int v, int timeSum, int scoreSum, int m, ArrayList<Node> arr){
        if(v==arr.size()) {
            if(timeSum<=m)
                answer=Math.max(scoreSum, answer);
        }
        else {
            Node tmp = arr.get(v);
            if(timeSum>m)
                return;

            answer=Math.max(scoreSum, answer);

            DFS(v+1, timeSum+tmp.time, scoreSum+tmp.score, m, arr);
            DFS(v+1, timeSum, scoreSum, m, arr);
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node> arrayList = new ArrayList<>();
        sumArray= new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arrayList.add(new Node(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        main.DFS(0,0,0,m,arrayList);
        System.out.println(answer);
    }
}