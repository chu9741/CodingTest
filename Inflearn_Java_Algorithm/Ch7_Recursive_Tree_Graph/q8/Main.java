package Inflearn_Java_Algorithm.Ch7_Recursive_Tree_Graph.q8;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int val;
    int cnt;
    Node lt, mt, rt;
    public Node(int val, int cnt){
        this.val=val;
        this.cnt=cnt;
        lt = mt = rt = null;
    }
}

public class Main {
    public void Solution(int s, int e){
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(new Node(s,0));
        boolean[] isVisited = new boolean[10001];

        while (nodes.peek().val != e) {
            Node tmp = nodes.poll();
            isVisited[tmp.val] = true;

            if(!isVisited[tmp.val +1 ] &&(tmp.val+1 <= 10000) && (e-tmp.val) < 5)
                nodes.offer(tmp.lt= new Node(tmp.val+1, tmp.cnt+1));
            if(!isVisited[tmp.val +5 ] && (tmp.val+5 <= 10000))
                nodes.offer(tmp.rt = new Node(tmp.val+5, tmp.cnt+1));
            if(!isVisited[tmp.val -1] && (tmp.val-1 > 0) && (e-tmp.val) < 5)
                nodes.offer(tmp.mt = new Node(tmp.val-1,tmp.cnt+1));
        }
        if(!nodes.isEmpty())
            System.out.println(nodes.peek().cnt);
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        main.Solution(s,e);
    }

}
