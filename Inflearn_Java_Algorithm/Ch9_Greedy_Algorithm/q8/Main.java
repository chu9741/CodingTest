package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q8;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int start;
    int end;
    int weight;
    public Node(int s, int e, int w){
        this.start=s;
        this.end=e;
        this.weight=w;
    }

    @Override
    public int compareTo(Node node){
        return this.weight- node.weight;
    }
}

public class Main {
    public static int sum;
    public int cnt=0;

    public void Solution(int start, int v, ArrayList<Node> arrayList){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> vertexSet = new HashSet<>();
        vertexSet.add(start);
        while(cnt!=v-1){
            for(Node tmp : arrayList){
                if(vertexSet.contains(tmp.start) && !vertexSet.contains(tmp.end) && !pq.contains(tmp)){
                    pq.add(tmp);
                }
                if(vertexSet.contains(tmp.end) && !vertexSet.contains(tmp.start) && !pq.contains(tmp)){
                    pq.add(tmp);
                }
            }

            Node minNode = pq.poll();
            if(vertexSet.contains(minNode.start) && vertexSet.contains(minNode.end))
                continue;

            vertexSet.add(minNode.start);
            vertexSet.add(minNode.end);
            sum+=minNode.weight;
            cnt++;
            arrayList.remove(minNode);
        }
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Node> arrayList=new ArrayList<>();

        for(int i=0; i<e; i++){
            StringTokenizer tmp=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(tmp.nextToken());
            int end=Integer.parseInt(tmp.nextToken());
            int weight=Integer.parseInt(tmp.nextToken());
            arrayList.add(new Node(start,end,weight));
        }

        main.Solution(1,v,arrayList);

        System.out.println(sum);
    }
}