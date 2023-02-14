package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    int start;
    int end;
    int weight;
    public Node(int s, int e, int w){
        this.start=s;
        this.end=e;
        this.weight=w;
    }
}

public class Main {
    static int[] answer;

    public void Solution(int n, int m, ArrayList<Node> arrayList){
        boolean[] isVisited = new boolean[n+1];

        for(int a=0; a<=n; a++)
            answer[a]=Integer.MAX_VALUE;

        for(Node node : arrayList){
            if(node.start==1 && node.weight<answer[node.end])
                answer[node.end]=node.weight;
        }

        isVisited[1]=true;

        for(int i=2; i<=n; i++){
            int min=Integer.MAX_VALUE;
            int index=1;
            for(int j=1; j<=n; j++){
                if(min>answer[j] && !isVisited[j]){
                    min=answer[j];
                    index=j;
                }
            }
            isVisited[index]=true;

            for(Node node : arrayList){
                if(node.start==index && answer[index] + node.weight < answer[node.end])
                    answer[node.end]=answer[index] + node.weight;
                    // 1에서 index까지 거리 + index에서 다른 점까지의 거리 < 1에서 다른점 까지의 거리 일때 업데이트함
                    // answer[index] + node.weight < answer [v]
            }

//            System.out.println(index+" "+answer[index]);
//            for(int x=1; x<=n; x++)
//                System.out.print(answer[x]+" ");
//            System.out.println();
        }
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<Node> arrayList =new ArrayList<>();

        for(int i=0; i<m; i++){
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            arrayList.add(new Node(Integer.parseInt(tmp.nextToken()), Integer.parseInt(tmp.nextToken()),Integer.parseInt(tmp.nextToken())));
        }
        answer = new int[n+1];

        main.Solution(n,m,arrayList);

        for(int i=2; i<=n; i++){
            if(answer[i]==Integer.MAX_VALUE)
                System.out.println(i+" : impossible");
            else System.out.println(i+" : "+answer[i]);
        }
    }
}