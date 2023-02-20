package Inflearn_Java_Algorithm.Ch9_Greedy_Algorithm.q7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    int start;
    int end;
    int weight;
    public Node(int start, int end, int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
}

public class Main {
    static int[] cycle;

    // U&F : 서로 연결되는 점이 있는지 확인하고 찾는다
    // 인덱스와 밸류가 서로 같을 때까지 recur = find
    // 두 점을 서로 엮어주는 = union

    public static int find(int v){
        if(cycle[v]==v)
            return v;
        else return cycle[v]= find(cycle[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa!=fb){
            cycle[fa] = fb;
        }
    }

    public int Solution(int v, ArrayList<Node> arrayList){
        int sum=0;
        int cnt=0;
        while(true){
            int minWeight = Integer.MAX_VALUE;
            int minIndex=0;
            for(Node node : arrayList){
                if(node.weight<minWeight){
                    minWeight=node.weight;
                    minIndex = arrayList.indexOf(node);
                }
            }
            Node minNode = arrayList.get(minIndex);
            if(find(minNode.start) == find(minNode.end))
                arrayList.remove(minNode);
            else {
                union(minNode.start,minNode.end);
                sum+=minNode.weight;
                cnt++;
                arrayList.remove(minNode);

            }
            if(cnt==v-1)
                break;
        }
        return sum;

    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        cycle = new int[v+1];

        for(int a=0; a<v+1; a++)
            cycle[a]=a;

        ArrayList<Node> arrayList = new ArrayList<>();
        for(int i=0; i<e; i++){
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tmp.nextToken());
            int end = Integer.parseInt(tmp.nextToken());
            int weight = Integer.parseInt(tmp.nextToken());
            arrayList.add(new Node(start,end,weight));
        }
        System.out.println(main.Solution(v,arrayList));
//        for(int b=1; b<=v; b++)
//            System.out.print(cycle[b]+" ");
    }
}
