package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q9_q10;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.MAX_VALUE;

class Node{
    int val;
    int cnt;
    Node lt, rt;
    public Node(int val, int cnt){
        this.val=val;
        this.cnt=cnt;
        lt=rt=null;
    }
}

public class Main {
    public void BFS(int n){
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(new Node(1,0));
        int answer =0;

        while(nodes.peek().val<=n){
            Node tmp = nodes.poll();

            if(tmp.val*2+1 > n) {
                answer=tmp.cnt;
                break;
            }
            nodes.offer(new Node(tmp.val*2, ++tmp.cnt));
            nodes.offer(new Node(tmp.val*2+1,tmp.cnt));
        }
        System.out.println("BFS : " + answer);
    }

    static int max = MAX_VALUE;
    static int[] count = {max,max,max,max,max,max};
    public void DFS(int n){
        if(n*2+1>5 && n<=5){
            count[n] = n/2;
            return;
        }
        Node node = new Node(n, n/2);
//        if(n/2<min)
//            min=n/2;
//        int[] arr = new int[n];
        DFS(n*2);
        DFS(n*2+1);
    }


    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        main.BFS(n);
        main.DFS(1);
        int edge = MAX_VALUE;
        for(int a : count)
            if(a<edge)
                edge=a;
        System.out.println("DFS : "+edge);
    }
}